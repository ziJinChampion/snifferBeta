
package com.wit.dao;

import com.wit.core.taskMgr.Task;
import com.wit.dto.taskMgr.CreateTaskQueryDTO;
import com.wit.dto.taskMgr.TaskQueryDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TaskDAO
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/14 16:24
 */
@Repository
public interface TaskDAO {
    /**
     * 创建任务
     * @param createTaskQueryDTO 任务信息
     * @return 任务创建是否成功
     */
    boolean createTask(CreateTaskQueryDTO createTaskQueryDTO);

    /**
     * 根据任务信息查找任务（联合查询）
     * @param taskQueryDto 任务信息
     * @return List<Task> 符合条件的任务列表
     */
    List<Task> queryTasks(TaskQueryDTO taskQueryDto);
}