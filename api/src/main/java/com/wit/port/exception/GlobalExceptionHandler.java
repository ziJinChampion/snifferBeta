package com.wit.port.exception;

import com.wit.port.result.ExceptionMsg;
import com.wit.port.result.Response;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * @author Sonrisa
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Date 2021/1/30 17:03
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response<Object> isBlankExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        ObjectError error = allErrors.get(0);
        return new Response<>(ExceptionMsg.paramsExp.getExceptionCode(), error.getDefaultMessage());
    }

    @ExceptionHandler(value = DateTimeParseException.class)
    public Response<Object> dateTimeParseExceptionHandler() {
        return new Response<>(ExceptionMsg.IllegalDateTime);
    }

    @ExceptionHandler(value = Exception.class)
    public Response<Object> unhandledException() {
        return new Response<>(ExceptionMsg.unhandledException);
    }
}
