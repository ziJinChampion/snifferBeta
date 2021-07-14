/**
 * @ClassName DeviceQuery
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/19 17:27
 */
package com.wit.query.devMgr;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wit.config.annotation.ParseNullDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "deviceQuery", description = "设备查询参数")
@Data
public class DeviceQuery {

    @ApiModelProperty(value = "设备名称")
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String deviceName;

    @ApiModelProperty(value = "设备状态")
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String deviceState;

    @ApiModelProperty(value = "部署方式")
    @JsonDeserialize(using = ParseNullDeserializer.class)
    private String deviceType;

    @ApiModelProperty(value = "监测参数")
    private List<String> deviceDetectedParams;

}
