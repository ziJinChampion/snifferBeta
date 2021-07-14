/**
 * @ClassName CustomDeviceDTO
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/20 15:59
 */
package com.wit.dto.devMgr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomDeviceDTO {

    private String deviceId;

    private String deviceName;

    private String deviceSerialNum;

    private String areaName;

    private String deviceState;

    private String deviceType;

    private List<String> deviceDetectedParams;

    private String accessToken;

}
