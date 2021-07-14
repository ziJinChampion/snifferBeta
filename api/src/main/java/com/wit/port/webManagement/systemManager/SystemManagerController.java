/**
 * @ClassName SystemManagerController
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/24 10:47
 */
package com.wit.port.webManagement.systemManager;

import com.wit.config.beanCopier.BeanCopierCache;
import com.wit.core.sysMgr.Area;
import com.wit.dto.sysMgr.InstituteDTO;
import com.wit.dto.sysMgr.SystemConfigDTO;
import com.wit.port.result.ExceptionMsg;
import com.wit.port.result.Response;
import com.wit.service.AreaService;
import com.wit.service.InstituteService;
import com.wit.service.SystemConfigService;
import com.wit.vo.sysMgr.InstituteVo;
import com.wit.vo.sysMgr.SystemConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "SystemManagerController", tags = "系统管理")
@CrossOrigin
@RestController
@RequestMapping("/api/webMgr/systemManager")
public class SystemManagerController {

    @Autowired
    private AreaService areaService;
    @Autowired
    private InstituteService instituteService;
    @Autowired
    private SystemConfigService systemConfigService;

//    @ApiOperation(value = "获取设备状态列表")
//    @RequestMapping(value = "getDeviceStates", method = RequestMethod.GET)
//    public Response<List<String>> getDeviceStates() {
//        return new Response<>();
//    }

    /*@ApiOperation(value = "获取设备部署方式列表")
    @RequestMapping(value = "getDeploymentWays", method = RequestMethod.GET)
    public Response<List<SystemConfigVO>> getDeploymentWays(@RequestParam("attributeName") String attributeName) {
        List<SystemConfigDTO> deploymentWaysDto = systemConfigService.queryAllByName(attributeName);
        List<SystemConfigVO> deploymentWaysVo = BeanCopierCache.copyList(deploymentWaysDto, SystemConfigVO::new);
        return new Response<>(deploymentWaysVo);
    }

    @ApiOperation(value = "获取任务类型列表")
    @RequestMapping(value = "getTaskTypes", method = RequestMethod.GET)
    public Response<List<SystemConfigVO>> getTaskTypes(@RequestParam("attributeName") String attributeName) {
        List<SystemConfigDTO> taskTypesDto = systemConfigService.queryAllByName(attributeName);
        List<SystemConfigVO> taskTypesVo = BeanCopierCache.copyList(taskTypesDto, SystemConfigVO::new);
        return new Response<>(taskTypesVo);
    }

    @ApiOperation(value = "获取监测参数列表")
    @RequestMapping(value = "getDetectedParams", method = RequestMethod.GET)
    public Response<List<SystemConfigVO>> getDetectedParams(@RequestParam("attributeName") String attributeName) {
        List<SystemConfigDTO> detectParamsDto = systemConfigService.queryAllByName(attributeName);
        List<SystemConfigVO> detectParamsVo = BeanCopierCache.copyList(detectParamsDto, SystemConfigVO::new);
        return new Response<>(detectParamsVo);
    }*/

    @ApiOperation(value = "获取系统配置", notes = "根据配置项名称 attributeName 的值查询系统配置，" +
            "attributeName 的取值为 {监测参数，设备部署方式，任务类型}，若 attributeName 为空，则查询所有系统配置项")
    @RequestMapping(value = "getDetectedParams", method = RequestMethod.POST)
    public Response<List<SystemConfigDTO>> getSystemConfigs(@RequestParam("attributeName") String attributeName) {
        List<SystemConfigDTO> detectParamsDto = (List<SystemConfigDTO>) systemConfigService.queryAllByName(attributeName);
        // List<SystemConfigVO> detectParamsVo = BeanCopierCache.copyList(detectParamsDto, SystemConfigVO::new);
        return new Response<>(detectParamsDto);
    }

    @ApiOperation(value = "获取业主单位名称列表")
    @RequestMapping(value = "getInstitutes", method = RequestMethod.GET)
    public Response<List<InstituteVo>> getInstitutes() {
        List<InstituteDTO> instituteDtoList = instituteService.queryInstitutes();
        List<InstituteVo> list = BeanCopierCache.copyList(instituteDtoList, InstituteVo::new);
        return new Response<>(list);
    }

//    @ApiOperation(value = "添加业主单位")
//    @RequestMapping(value = "createInstitute", method = RequestMethod.POST)
//    public Response<Object> createInstitute(@RequestParam("institute") String institute) {
//        Response<Object> response = new Response<>();
//        boolean flag = instituteService.createInstitute(institute);
//        if(!flag) {
//            response.setExpMsg(ExceptionMsg.FailedToAddInstitute);
//        }
//        return response;
//    }

    @ApiOperation(value = "获取区域")
    @RequestMapping(value = "getAreas", method = RequestMethod.GET)
    public Response<List<Area>> getAreas() {
        List<Area> areas = areaService.queryAreas();
        return new Response<>(areas);
    }
}
