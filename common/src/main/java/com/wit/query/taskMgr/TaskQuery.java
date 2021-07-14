/**
 * @ClassName TaskQuery
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/17 13:05
 */
package com.wit.query.taskMgr;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wit.config.annotation.ParseNullDeserializer;
import com.wit.config.annotation.ParseNumDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.util.List;

@ApiModel(value = "taskQuery", description = "任务查询参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskQuery {

    @ApiModelProperty(value = "任务名称")
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String taskName;

    @ApiModelProperty(value = "任务状态")
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String taskState;

    @ApiModelProperty(value = "任务地点")
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String areaName;

    @ApiModelProperty(value = "执行者 Id")
    @Min(value = 0, message = "执行者 id 不合法")
    @JsonDeserialize(using = ParseNumDeserializer.class)
    private Integer stuffId;

    @ApiModelProperty(value = "业主单位名称")
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String instituteName;

    @ApiModelProperty(value = "任务开始时间")
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String startTime;

    @ApiModelProperty(value = "任务结束时间")
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String endTime;

    @ApiModelProperty(value = "任务监测参数")
    private List<String> taskDetectedParams;

}
