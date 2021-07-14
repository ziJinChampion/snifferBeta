
package com.wit.port.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName Response
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/16 22:19
 */

@ApiModel(value = "Response", description = "响应类")
public class Response<T> {

    @ApiModelProperty(value = "响应码")
    private Integer code = 100;

    @ApiModelProperty(value = "响应主体")
    private T data;

    @ApiModelProperty(value = "响应消息")
    private String msg = "ok";

    public Response() {

    }

    public Response(T data) {
        this.data = data;
    }

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(ExceptionMsg exceptionMsg) {
        this.code = exceptionMsg.getExceptionCode();
        this.msg = exceptionMsg.getExceptionMsg();
    }

    public Integer getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setExpMsg(ExceptionMsg expMsg) {
        this.code = expMsg.getExceptionCode();
        this.msg = expMsg.getExceptionMsg();
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
