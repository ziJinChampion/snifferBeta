package com.wit.service.Impl;

import com.wit.config.beanCopier.BeanCopierCache;
import com.wit.core.devMgr.CustomDevice;
import com.wit.core.thingsBoard.TbDeviceToken;
import com.wit.dao.CustomDeviceDAO;
import com.wit.dto.devMgr.CustomDeviceDTO;
import com.wit.query.devMgr.DeviceQuery;
import com.wit.query.devMgr.DeviceRegisterQuery;
import com.wit.service.DeviceService;
import com.wit.tbDao.TbDeviceDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thingsboard.rest.client.RestClient;
import org.thingsboard.server.common.data.Device;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DeviceServiceImpl
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/17 10:54
 * @Version 1.0
 **/
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private CustomDeviceDAO customTbDeviceDAO;

    @Autowired
    private TbDeviceDAO tbDeviceDAO;

    @Autowired
    private RestClient client;

    @Override
    public List<String> getDeviceNameList() {
        return customTbDeviceDAO.getDeviceNames();
    }

    @Override
    public boolean delDeviceById(String deviceId) {
        return customTbDeviceDAO.delDeviceById(deviceId);
    }

    @Override
    public List<CustomDeviceDTO> queryDevices(DeviceQuery deviceQuery) {
        List<CustomDevice> customDeviceList = customTbDeviceDAO.queryDevices(deviceQuery);
        return BeanCopierCache.copyList(customDeviceList, CustomDeviceDTO::new);
    }

    @Override
    public List<CustomDeviceDTO> deviceRegister(DeviceRegisterQuery registerQuery) {
        int n = registerQuery.getNumber();
        List<String> deviceIds = new ArrayList<>();
        List<CustomDeviceDTO> customDeviceDtoList = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            Device device = new Device();
            String deviceName = registerQuery.getDeviceName() + String.format("%02d", i);
            device.setName(deviceName);
            device.setType(registerQuery.getDeviceType());
            device = client.saveDevice(device);
            deviceIds.add(device.getId().toString());
            CustomDeviceDTO customDeviceDto = new CustomDeviceDTO();
            customDeviceDto.setDeviceId(device.getId().toString());
            customDeviceDto.setDeviceName(deviceName);
            customDeviceDto.setDeviceType(registerQuery.getDeviceType());
            customDeviceDtoList.add(customDeviceDto);
        }
        List<TbDeviceToken> tbDeviceTokens = tbDeviceDAO.getDeviceTokenById(deviceIds);
        Map<String, String> map = new HashMap<>(tbDeviceTokens.size());
        for (TbDeviceToken tbDeviceToken : tbDeviceTokens) {
            map.put(tbDeviceToken.getDeviceId(), tbDeviceToken.getAccessToken());
        }
        for (CustomDeviceDTO customDeviceDTO : customDeviceDtoList) {
            customDeviceDTO.setAccessToken(map.get(customDeviceDTO.getDeviceId()));
        }
        return customDeviceDtoList;
    }
}
