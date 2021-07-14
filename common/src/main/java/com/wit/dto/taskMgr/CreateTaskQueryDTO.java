package com.wit.dto.taskMgr;

import com.wit.core.taskMgr.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Sonrisa
 * @ClassName CreateTaskQueryDTO
 * @Description TODO
 * @Date 2021/2/1 10:06
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskQueryDTO {

    private String taskName;

    private String taskType;

    private Task.State taskState;

    private Integer instituteId;

    private String instituteName;

    private LocalDateTime expectedStartTime;

    private String taskRemarks;

    private String areaName;

    private String detailsAddress;

    private Double longitude;

    private Double latitude;

    private Integer stuffId;

    private String stuffName;

    private List<String> taskDetectedParams;

    private String deviceId;

    private String deviceName;

}
