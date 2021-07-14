package com.wit.port.result;

/**
 * @Decription 返回给前端的异常信息枚举类
 * @author sonrisa
 */

public enum ExceptionMsg {

    /**
     *  100 成功
     *  1xx 通用的失败码
     *  2xx 任务管理的失败码
     *  3xx 设备管理的失败码
     *  4xx 系统管理的失败码
     */

    unhandledException(101, "未处理的异常"),

    paramsExp(110, "请求参数不正确"),

    IllegalStartTime(111, "非法的开始时间，时间早于当前"),

    IllegalEndTime(112, "非法的截止时间，时间晚于当前"),

    IllegalDateTime(113, "非法的日期格式"),

    /**
     * 任务管理
     */
    FailedToCreateTask(201, "创建任务失败"),

    IllegalTaskId(202, "任务 id 号不合法"),

    /**
     * 设备管理
     */
    FailedToDelDevice(301, "设备移除失败，该设备可能不存在"),

    /**
     * 系统管理
     */
    FailedToAddInstitute(401, "添加业主单位失败"),

    FailedToAddVillage(402, "添加小区失败"),

    END(1000, "END");

    /**
     * 异常code
     */
    private final Integer exceptionCode;

    /**
     * 异常信息
     */
    private final String exceptionMsg;

    private ExceptionMsg(Integer exceptionCode, String exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }

    public Integer getExceptionCode() {
        return this.exceptionCode;
    }

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }
}
