/**
 * @ClassName TaskQueryDTO
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/17 11:04
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
public class TaskQueryDTO {

    private String taskName;

    private Task.State taskState;

    private String areaName;

    private Integer stuffId;

    private String instituteName;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private List<String> taskDetectedParams;
}
