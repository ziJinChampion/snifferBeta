/**
 * @ClassName BeanCopierCache
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/20 18:08
 */
package com.wit.config.beanCopier;

import com.wit.dto.taskMgr.CreateTaskQueryDTO;
import com.wit.dto.taskMgr.TaskDTO;
import com.wit.dto.taskMgr.TaskQueryDTO;
import com.wit.query.taskMgr.CreateTaskQuery;
import com.wit.query.taskMgr.TaskQuery;
import com.wit.vo.taskMgr.TaskVO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;


public class BeanCopierCache {

    static final Map<String, Pair<BeanCopier, Converter>> BEAN_COPIERS = new ConcurrentHashMap<>();

    static {
        register(TaskQuery.class, TaskQueryDTO.class, QueryToDtoConverter.class);
        register(TaskDTO.class, TaskVO.class, DtoToVoConverter.class);
        register(CreateTaskQuery.class, CreateTaskQueryDTO.class, QueryToDtoConverter.class);
    }

    public static void copy(Object srcObj, Object destObj) {
        if(srcObj == null || destObj == null) {
            return;
        }
        String key = getKey(srcObj.getClass(), destObj.getClass());
        BeanCopier copier;
        Converter converter = null;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), false);
            BEAN_COPIERS.put(key, Pair.pair(copier, null));
        } else {
            Pair<BeanCopier, Converter> p = BEAN_COPIERS.get(key);
            copier = p.first;
            converter = p.second;
        }
        copier.copy(srcObj, destObj, converter);
    }

    static void register(Class<?> srcClazz, Class<?> destClazz, Class<? extends Converter> converterClazz) {
        String key = getKey(srcClazz, destClazz);
        try {
            BEAN_COPIERS.put(key, Pair.pair(BeanCopier.create(srcClazz, destClazz, true), converterClazz.getDeclaredConstructor().newInstance()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String getKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }

    public static <T> List<T> copyList(List<?> srcList, Supplier<T> supplier) {
        if(srcList == null) {
            return null;
        }
        List<T> list = new ArrayList<>();
        for (Object o1 : srcList) {
            T o2 = supplier.get();
            copy(o1, o2);
            list.add(o2);
        }
        return list;
    }

}
