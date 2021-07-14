package com.wit.query.taskMgr;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wit.config.annotation.ParseNullDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Sonrisa
 * @ClassName CreateTaskQuery
 * @Description TODO
 * @Date 2021/1/30 12:36
 */

@ApiModel(value = "createTaskQuery", description = "创建任务参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskQuery {

    @ApiModelProperty(value = "任务名称", required = true)
    @NotBlank(message = "任务名称为空")
    private String taskName;

    @ApiModelProperty(value = "任务类型", required = true)
    @NotBlank(message = "任务类型为空")
    private String taskType;

    @ApiModelProperty(value = "业主单位名称", required = true)
    @NotBlank(message = "业主单位名称为空")
    private String instituteName;

    @ApiModelProperty(value = "任务预期开始时间", required = true)
    @NotBlank(message = "任务预期开始时间为空")
    private String expectedStartTime;

    @ApiModelProperty("任务备注")
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String taskRemarks;

    @ApiModelProperty(value = "任务区域", required = true)
    @NotBlank(message = "任务区域为空")
    private String areaName;

    @ApiModelProperty(value = "详细地址", required = true)
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String detailsAddress;

    @ApiModelProperty(value = "经度", required = true)
    @NotNull(message = "经度为空")
    private Double longitude;

    @ApiModelProperty(value = "纬度", required = true)
    @NotNull(message = "纬度为空")
    private Double latitude;

    @ApiModelProperty(value = "执行者 id", required = true)
    @NotNull(message = "执行者 id 为空")
    @Min(value = 0, message = "执行者 id 不合法")
    private Integer stuffId;

    @ApiModelProperty(value = "执行者姓名", required = true)
    @NotBlank(message = "执行者姓名为空")
    private String stuffName;

    @ApiModelProperty(value = "所需监测参数列表", notes = "列表为空（不是 null) 则默认监测全部参数")
    @NotNull
    private List<String> taskDetectedParams;

    @ApiModelProperty(value = "智嗅设备 id", required = true)
    @NotBlank(message = "智嗅设备 id 为空")
    private String deviceId;

    @ApiModelProperty(value = "智嗅设备名称", required = true)
    @NotBlank(message = "智嗅设备名称为空")
    private String deviceName;

}
