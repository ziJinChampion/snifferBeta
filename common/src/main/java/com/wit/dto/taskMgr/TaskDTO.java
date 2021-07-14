/**
 * @ClassName TaskDTO
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/17 14:11
 */
package com.wit.dto.taskMgr;

import com.wit.core.taskMgr.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Integer taskId;

    private String taskName;

    private String deviceName;

    private String stuffName;

    private String areaName;

    private String taskType;

    private String instituteName;

    private Task.State taskState;

    private LocalDateTime expectedStartTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String detailsAddress;

    private String taskRemarks;

    private List<String> taskDetectedParams;
}
