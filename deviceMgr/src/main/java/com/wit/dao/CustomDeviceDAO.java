package com.wit.dao;

import com.wit.core.devMgr.CustomDevice;
import com.wit.query.devMgr.DeviceQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomDeviceDAO {

    /**
     * 获取设备名称列表
     * @return List<String>
     */
    List<String> getDeviceNames();

    /**
     * 删除指定设备
     * @param deviceId 设备 id 号
     * @return boolean
     */
    boolean delDeviceById(@Param("deviceId") String deviceId);

    /**
     * 查询符合条件的设备
     * @param deviceQuery 设备查询参数
     * @return List<CustomDevice>
     */
    List<CustomDevice> queryDevices(DeviceQuery deviceQuery);
}
