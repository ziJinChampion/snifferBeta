
package com.wit.core.devMgr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Sonrisa
 * @ClassName CustomDevice
 * @Description TODO
 * @Date 2021/1/13 15:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomDevice {
    /**
     * 设备 ID
     */
    private String deviceId;
    /**
     * 设备序列号
     */
    private String deviceSerialNum;
    /**
     * 租户 ID
     */
    private String tenantId;
    /**
     * 区域名
     */
    private String areaName;
    /**
     * 设备名
     */
    private String deviceName;
    /**
     * 设备状态
     */
    private String deviceState;
    /**
     * 设备类型
     */
    private String deviceType;
    /**
     * 设备监测参数
     */
    private List<String> deviceDetectedParams;
    /**
     * 设备令牌
     */
    private String accessToken;
}
