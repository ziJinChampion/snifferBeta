package com.wit.config.beanCopier;

import com.wit.core.taskMgr.Task;
import org.springframework.cglib.core.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Sonrisa
 * @ClassName DtoToVoConverter
 * @Description TODO
 * @Date 2021/2/1 13:41
 */
public class DtoToVoConverter implements Converter {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Object convert(Object o, Class aClass, Object o1) {
        if(o == null) {
            return null;
        }
        if(o instanceof Task.State) {
            return ((Task.State) o).getState();
        } else if(o instanceof LocalDateTime) {
            return DATE_FORMATTER.format((LocalDateTime) o);
        }
        return o;
    }
}
