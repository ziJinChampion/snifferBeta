/**
 * @ClassName DeviceVO
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/19 17:29
 */
package com.wit.vo.devMgr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "DeviceVO", description = "渲染设备列表")
@Data
public class DeviceListVO {

    @ApiModelProperty(value = "后端设备Id")
    private String deviceId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备序列号")
    private String deviceSerialNum;

    @ApiModelProperty(value = "设备状态")
    private String deviceState;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "设备可监测数据")
    private List<String> deviceDetectedParams;

}
