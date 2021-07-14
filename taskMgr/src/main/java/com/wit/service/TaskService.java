package com.wit.service;

import com.wit.dto.taskMgr.CreateTaskQueryDTO;
import com.wit.dto.taskMgr.TaskDTO;
import com.wit.dto.taskMgr.TaskQueryDTO;

import java.util.List;


/**
 * @author sonrisa
 */
public interface TaskService {

    /**
     * 创建任务
     * @param createTaskQueryDTO 任务信息
     * @return 创建任务是否成功
     */
    boolean createTask(CreateTaskQueryDTO createTaskQueryDTO);

    /**
     * 返回任务监测的传感数据
     * @param taskQueryDto 任务信息
     * @return 传感数据
     */
    Object getData(TaskQueryDTO taskQueryDto);

    /**
     * 导出任务报告
     * @param taskQueryDto 任务信息
     * @return 任务报告
     */
    Object exportTaskReport(TaskQueryDTO taskQueryDto);

    /**
     * 开始任务
     * @param taskQueryDto 任务信息
     * @return 开始任务是否成功
     */
    boolean startTask(TaskQueryDTO taskQueryDto);

    /**
     * 结束任务
     * @param taskQueryDto 任务信息
     * @return 结束任务是否成功
     */
    boolean endTask(TaskQueryDTO taskQueryDto);

    /**
     * 通知任务
     * @param taskQueryDto 任务信息
     * @return 通知任务是否成功
     */
    boolean notice(TaskQueryDTO taskQueryDto);

    /**
     * 根据任务信息查找任务（联合查询）
     * @param taskQueryDto 任务信息
     * @return List<TaskQueryDTO> 符合条件的任务列表
     */
    List<TaskDTO> queryTasks(TaskQueryDTO taskQueryDto);
}
