
package com.wit.port.webManagement.taskManager;

import com.wit.config.beanCopier.BeanCopierCache;
import com.wit.core.taskMgr.Task;
import com.wit.dto.sysMgr.InstituteDTO;
import com.wit.dto.sysMgr.StuffDTO;
import com.wit.dto.taskMgr.CreateTaskQueryDTO;
import com.wit.dto.taskMgr.TaskQueryDTO;
import com.wit.port.result.ExceptionMsg;
import com.wit.port.result.Response;
import com.wit.query.taskMgr.CreateTaskQuery;
import com.wit.query.taskMgr.TaskQuery;
import com.wit.service.*;
import com.wit.vo.sysMgr.TaskStuffVO;
import com.wit.vo.taskMgr.TaskVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @ClassName TaskController
 * @Description 管理端的任务管理 Controller
 * @Author Sonrisa
 * @Date 2021/1/16 21:47
 */


@Api(value = "TaskManagerController", tags = "任务管理")
@CrossOrigin
@RestController
@RequestMapping("/api/webMgr/taskManager")
public class TaskManagerController {
    
    @Autowired
    private TaskService taskService;

    @Autowired
    private StuffService stuffService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private SystemConfigService systemConfigService;

    @Autowired
    private InstituteService instituteService;

    @ApiOperation(value = "获取任务状态列表")
    @RequestMapping(value = "getTaskStates", method = RequestMethod.GET)
    public Response<Set<String>> getTaskStates() {
        return new Response<>(Task.State.stateMap.keySet());
    }

    @ApiOperation(value = "获取执行者列表")
    @RequestMapping(value = "getStuffs", method = RequestMethod.GET)
    public Response<List<TaskStuffVO>> getStuffs() {
        List<StuffDTO> stuffDtoList = stuffService.queryAll();
        List<TaskStuffVO> taskStuffVoList = BeanCopierCache.copyList(stuffDtoList, TaskStuffVO::new);
        return new Response<>(taskStuffVoList);
    }

    @ApiOperation(value = "查询任务", notes = "支持联合查询，将 UI 当前选项全部作为请求参数即可，无参数则默认查询全部任务")
    @RequestMapping(value = "queryTasks", method = RequestMethod.POST)
    public Response<List<TaskVO>> queryTasks(@ApiParam(name = "task", value = "任务查询的参数") @RequestBody @Valid TaskQuery taskQuery) {
        if(taskQuery == null) {
            taskQuery = new TaskQuery();
        }
        TaskQueryDTO taskQueryDto = new TaskQueryDTO();
        BeanCopierCache.copy(taskQuery, taskQueryDto);
        List<TaskVO> taskVoList = BeanCopierCache.copyList(taskService.queryTasks(taskQueryDto), TaskVO::new);
        return new Response<>(taskVoList);
    }

    @ApiIgnore
    @RequestMapping(value = "viewTaskDetails", method = RequestMethod.POST)
    @ApiOperation(value = "查询任务详情")
    public Response<Object> viewTaskDetails(@ApiParam(name = "taskId", value = "任务实际ID", required = true) @RequestParam("taskId") Integer taskId) {
        Response<Object> response = new Response<>();
        if(taskId < 0) {
            response.setExpMsg(ExceptionMsg.IllegalTaskId);
        }
        return response;
    }

    @ApiIgnore
    @ApiOperation(value = "导出任务报告")
    @RequestMapping(value = "exportTaskReport", method = RequestMethod.POST)
    public Response<Object> exportTaskReport(@ApiParam(name = "taskId", value = "任务实际ID", required = true) @RequestParam("taskId") Integer taskId) {
        Response<Object> response = new Response<>();
        if(taskId < 0) {
            response.setExpMsg(ExceptionMsg.IllegalTaskId);
        }
        return response;
    }

    @ApiOperation(value = "新建任务")
    @RequestMapping(value = "createTask", method = RequestMethod.POST)
    public Response<Object> createTask(@RequestBody @Valid CreateTaskQuery createTaskQuery) {
        CreateTaskQueryDTO createTaskQueryDTO = new CreateTaskQueryDTO();
        System.out.println(createTaskQuery);
        BeanCopierCache.copy(createTaskQuery, createTaskQueryDTO);
        if(createTaskQueryDTO.getExpectedStartTime().toLocalDate().isBefore(LocalDate.now())) {
            return new Response<>(ExceptionMsg.IllegalStartTime);
        }
        // InstituteDTO instituteDTO = instituteService.createInstitute(createTaskQueryDTO.getInstituteName());
        InstituteDTO instituteDTO = instituteService.containsValue(createTaskQueryDTO.getInstituteName());
        System.out.println(instituteDTO);
        if(instituteDTO == null) {
            instituteDTO = instituteService.createInstitute(createTaskQueryDTO.getInstituteName());
            if (instituteDTO == null) {
                return new Response<>(ExceptionMsg.FailedToAddInstitute);
            }
        }
        createTaskQueryDTO.setInstituteId(instituteDTO.getInstituteId());
        if(createTaskQueryDTO.getTaskDetectedParams() != null && createTaskQueryDTO.getTaskDetectedParams().size() == 0) {
            List<String> detectedParamNames = systemConfigService.getDetectedParamNames();
            if(detectedParamNames == null) {
                return new Response<>(ExceptionMsg.FailedToCreateTask);
            }
            createTaskQueryDTO.setTaskDetectedParams(detectedParamNames);
        }
        createTaskQueryDTO.setTaskState(Task.State.WAITING);
        boolean q = taskService.createTask(createTaskQueryDTO);
        if(!q) {
            return new Response<>(ExceptionMsg.FailedToCreateTask);
        }
        return new Response<>();
    }

}
