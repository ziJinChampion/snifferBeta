package com.wit.service;

import com.wit.dto.devMgr.CustomDeviceDTO;
import com.wit.query.devMgr.DeviceQuery;
import com.wit.query.devMgr.DeviceRegisterQuery;

import java.util.List;

public interface DeviceService {

    /**
     * 返回设备名称列表
     * @return List<String>
     */
    List<String> getDeviceNameList();

    /**
     * 移除设备
     * @param deviceId 设备 id 号
     * @return boolean
     */
    boolean delDeviceById(String deviceId);

    /**
     * 返回满足条件的设备列表
     * @param deviceQuery 设备查询参数
     * @return List<CustomDevice>
     */
    List<CustomDeviceDTO> queryDevices(DeviceQuery deviceQuery);

    /**
     * 返回此次设备登记的列表
     * @param registerQuery 设备登记参数
     * @return List<CustomDeviceDTO>
     */
    List<CustomDeviceDTO> deviceRegister(DeviceRegisterQuery registerQuery);

}
