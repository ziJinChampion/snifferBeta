
package com.wit.vo.taskMgr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName TaskQueryDTO
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/16 22:49
 */

@ApiModel(value = "taskVO", description = "渲染任务列表")
@Data
public class TaskVO {

    @ApiModelProperty(value = "后端任务Id", notes = "当删除任务时，传入该 id 即可")
    private Integer taskId;

    @ApiModelProperty(value = "任务名")
    private String taskName;

    @ApiModelProperty(value = "执行者姓名")
    private String stuffName;

    @ApiModelProperty(value = "任务地点")
    private String areaName;

    @ApiModelProperty(value = "任务预计开始时间")
    private String expectedStartTime;

    @ApiModelProperty(value = "任务类型")
    private String taskType;

    @ApiModelProperty(value = "任务状态")
    private String taskState;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "业主单位名称")
    private String instituteName;

    @ApiModelProperty(value = "任务监测参数")
    private List<String> taskDetectedParams;

    @ApiModelProperty(value = "任务备注")
    private String taskRemarks;

    @ApiModelProperty(value = "任务详细地址")
    private String detailsAddress;

}
