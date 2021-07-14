/**
 * @ClassName DeviceRegisterQuery
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/19 17:41
 */
package com.wit.query.devMgr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "DeviceRegisterQuery", description = "设备登记参数")
@Data
public class DeviceRegisterQuery {

    @ApiModelProperty(value = "设备名称", required = true)
    @NotBlank(message = "设备名为空")
    private String deviceName;

    @ApiModelProperty(value = "设备类型", required = true)
    @NotBlank(message = "设备类型为空")
    private String deviceType;

    @ApiModelProperty(value = "设备登记数量", required = true)
    @NotNull(message = "设备登记数量为空")
    @Min(value = 0, message = "设备登记数量不合法")
    private Integer number;

}
