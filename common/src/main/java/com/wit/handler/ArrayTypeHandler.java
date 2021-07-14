
package com.wit.handler;

import com.wit.utils.HumpUtils;
import io.swagger.models.auth.In;
import org.apache.ibatis.type.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArrayTypeHandler
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/15 12:48
 */
/**
 * 对于 PostgresSQL 数组类型 mybatis 接收为 null
 * 将 PostgresSQL 自定义的枚举数组或基本数据类型数组(integer[]、boolean[]、bigint[]...)
 * 转为对应JavaBean基本数据类型的List列表
 * 其枚举数组会自动被转为 String[]，而其它 PostgresSQL 的基本数据类型数组会自动转为对应 JavaBean 数组
 *
 * @param <T> JavaBean数据类型
 */
public class ArrayTypeHandler<T> extends BaseTypeHandler<List<T>> {

    private static final String TYPE_NAME_VARCHAR = "varchar";
    private static final String TYPE_NAME_INTEGER = "integer";
    private static final String TYPE_NAME_BOOLEAN = "boolean";
    private static final String TYPE_NAME_NUMERIC = "numeric";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<T> parameter, JdbcType jdbcType) throws SQLException {
        if(parameter != null && parameter.get(0) != null) {
            /**
             * 将类名转为 PostgresSQL 对应类型（驼峰转下划线）
             */
            String typeName = parameter.get(0).getClass().getName().replaceAll("\\$","");
            int index = typeName.lastIndexOf(".");
            String columnType;
            if (parameter.get(0) instanceof Integer) {
                columnType = TYPE_NAME_INTEGER;
            } else if (parameter.get(0) instanceof String) {
                columnType = TYPE_NAME_VARCHAR;
            } else if (parameter.get(0) instanceof Boolean) {
                columnType = TYPE_NAME_BOOLEAN;
            } else if (parameter.get(0) instanceof Double) {
                columnType = TYPE_NAME_NUMERIC;
            } else {
                columnType = HumpUtils.humpToLine(typeName.substring(index + 1));
            }
            Connection conn = ps.getConnection();
            Array array = conn.createArrayOf(columnType, parameter.toArray());
            ps.setArray(i, array);
        }
    }

    @Override
    public List<T> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getList(rs.getArray(columnName));
    }

    @Override
    public List<T> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getList(rs.getArray(columnIndex));
    }

    @Override
    public List<T> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getList(cs.getArray(columnIndex));
    }

    private List<T> getList(Array array) {
        if(array == null) {
            return null;
        }
        try {
            /**
             * PostgresSQL 属于基本数据类型的，elements 为对应 JavaBean 数组
             * 而对应 PostgresSQL 属于枚举数组的，elements 为 String[]
             * 将该数组转为 List 列表
             */
            Object[] elements = (Object[]) array.getArray();
            List<T> list = new ArrayList<>();
            for (Object element : elements) {
                list.add((T) element);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ArrayTypeHandler parse error");
        }
    }
}
