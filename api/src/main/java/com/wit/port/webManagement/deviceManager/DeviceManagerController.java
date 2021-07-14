/**
 * @ClassName DeviceListController
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/19 17:00
 */
package com.wit.port.webManagement.deviceManager;

import com.wit.config.beanCopier.BeanCopierCache;
import com.wit.dto.devMgr.CustomDeviceDTO;
import com.wit.port.result.ExceptionMsg;
import com.wit.port.result.Response;
import com.wit.query.devMgr.DeviceQuery;
import com.wit.query.devMgr.DeviceRegisterQuery;
import com.wit.service.DeviceService;
import com.wit.vo.devMgr.DeviceListVO;
import com.wit.vo.devMgr.DeviceRegisterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "DeviceManagerController", tags = "设备管理")
@CrossOrigin
@RestController
@RequestMapping("/api/webMgr/deviceManager")
public class DeviceManagerController {

    @Autowired
    private DeviceService deviceService;

    @ApiOperation(value = "获取设备名称列表")
    @RequestMapping(value = "getDeviceNameList", method = RequestMethod.GET)
    public Response<List<String>> getDeviceNameList() {
        List<String> list = deviceService.getDeviceNameList();
        return new Response<>(list);
    }

    @ApiOperation(value = "获取设备列表")
    @RequestMapping(value = "getDevices", method = RequestMethod.POST)
    public Response<List<DeviceListVO>> getDevices(@ApiParam(value = "deviceParams", name = "设备查询参数") @RequestBody @Valid DeviceQuery deviceQuery) {
        List<CustomDeviceDTO> deviceDtoList = deviceService.queryDevices(deviceQuery);
        List<DeviceListVO> list = BeanCopierCache.copyList(deviceDtoList, DeviceListVO::new);
        return new Response<>(list);
    }

    @ApiOperation(value = "移除设备")
    @RequestMapping(value = "delDeviceById", method = RequestMethod.POST)
    public Response<Object> delDevice(@ApiParam(value = "deviceId", name = "设备 id 号") @RequestParam("deviceId") String deviceId) {
        Response<Object> response = new Response<>();
        boolean q = deviceService.delDeviceById(deviceId);
        if(!q) {
            response.setExpMsg(ExceptionMsg.FailedToDelDevice);
        }
        return response;
    }

    @ApiOperation(value = "设备登记")
    @RequestMapping(value = "deviceRegister", method = RequestMethod.POST)
    public Response<List<DeviceRegisterVO>> deviceRegister(@ApiParam(value = "registerParams", name = "设备登记参数") @RequestBody @Valid DeviceRegisterQuery registerQuery) {
        List<CustomDeviceDTO> deviceDtoList = deviceService.deviceRegister(registerQuery);
        List<DeviceRegisterVO> deviceRegisterVoList = BeanCopierCache.copyList(deviceDtoList, DeviceRegisterVO::new);
        return new Response<>(deviceRegisterVoList);
    }

    @ApiOperation(value = "导出设备列表")
    @RequestMapping(value = "exportDeviceList", method = RequestMethod.GET)
    public Response<List<CustomDeviceDTO>> exportDeviceList() {
        return null;
    }

}
