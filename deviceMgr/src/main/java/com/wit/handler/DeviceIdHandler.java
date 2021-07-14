package com.wit.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.util.StringUtils;

import java.sql.*;

/**
 * @author Aegean
 * @ClassName DeviceIdHandler
 * @Description TODO
 * @Date 2021/1/25 23:02
 */
public class DeviceIdHandler implements TypeHandler<String> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        if(!StringUtils.isEmpty(parameter)) {
            StringBuilder deviceId = new StringBuilder();
            deviceId.append(parameter, 15, 18)
                    .append(parameter, 9, 13)
                    .append(parameter, 0, 8)
                    .append(parameter, 19, 23)
                    .append(parameter, 24, parameter.length());
            ps.setString(i, deviceId.toString());
        }
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        return getData(rs.getArray(columnName));
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        return getData(rs.getArray(columnIndex));
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getData(cs.getArray(columnIndex));
    }

    private String getData(Array array) {
        if (array == null) {
            return null;
        }
        try {
            String str = array.toString();
            StringBuilder sb = new StringBuilder();
            sb.append(str, 7, 15)
                    .append("-")
                    .append(str, 3, 7)
                    .append("-")
                    .append(str, 0, 1)
                    .append(str, 0, 3)
                    .append("-")
                    .append(str, 15, 19)
                    .append("-")
                    .append(str, 19, str.length());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DeviceHandler parse error");
        }
    }

}
