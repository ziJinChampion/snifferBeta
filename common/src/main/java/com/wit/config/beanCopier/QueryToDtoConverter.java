package com.wit.config.beanCopier;

import com.wit.core.taskMgr.Task;
import org.springframework.cglib.core.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author Sonrisa
 * @ClassName VOToDTO
 * @Description VO 层转 DTO
 * @Date 2021/2/1 13:39
 */
public class QueryToDtoConverter implements Converter {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Object convert(Object value, Class target, Object context) {
        if(value == null) {
            return null;
        }
        if(target.equals(Task.State.class)) {
            return Task.State.stateMap.get(value);
        } else if(target.equals(LocalDateTime.class)) {
            LocalDate localDate = LocalDate.parse((String)value, DATE_FORMATTER);
            LocalTime localTime = LocalTime.of(0, 0, 0);
            return LocalDateTime.of(localDate, localTime);
        }
        return value;
    }
}
