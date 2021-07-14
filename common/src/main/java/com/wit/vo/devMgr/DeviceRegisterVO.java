/**
 * @ClassName DeviceRegisterVO
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/19 17:42
 */
package com.wit.vo.devMgr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "deviceRegisterVO", description = "设备登记列表")
@Data
public class DeviceRegisterVO {

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "设备Id")
    private String deviceId;

    @ApiModelProperty(value = "设备序列号")
    private String deviceSerialNum;

    @ApiModelProperty(value = "设备令牌")
    private String accessToken;

}
