package com.wit.core.taskMgr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    private static final long serialVersionUID = 2021111L;
    /**
     * 任务编号
     */
    private Integer taskId;
    /**
     * 设备编号
     */
    private String deviceId;
    /**
     * 执行者编号
     */
    private Integer stuffId;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 执行者名称
     */
    private String stuffName;
    /**
     * 区域名称
     */
    private String areaName;
    /**
     * 任务类型
     */
    private String taskType;
    /**
     * 任务状态
     */
    private State taskState;
    /**
     * 任务预计开始时间
     */
    private LocalDateTime expectedStartTime;
    /**
     * 任务实际开始时间
     */
    private LocalDateTime startTime;
    /**
     * 任务结束时间
     */
    private LocalDateTime endTime;
    /**
     * 业主单位 ID
     */
    private Integer instituteId;
    /**
     * 业主单位名称
     */
    private String instituteName;
    /**
     * 详细地址
     */
    private String detailsAddress;
    /**
     * 任务备注
     */
    private String taskRemarks;
    /**
     * 任务监测参数
     */
    private List<String> taskDetectedParams;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 任务状态
     */
    public enum State {

        /**
         * 执行中
         */
        RUNNING("执行中", 4),

        /**
         * 逾期
         */
        OVERDUE("逾期", 3),

        /**
         * 待执行
         */
        WAITING("待执行", 2),

        /**
         * 已完成
         */
        ENDING("已完成", 1);

        private final String state;

        private final Integer priority;

        public static Map<String, State> stateMap = new HashMap<>();

        static {
            State[] values = State.values();
            for (State value : values) {
                stateMap.put(value.getState(), value);
            }
        }

        private State(String state, Integer priority) {
            this.state = state;
            this.priority = priority;
        }

        public String getState() {
            return this.state;
        }

        public Integer getPriority() {
            return this.priority;
        }
    }
}
