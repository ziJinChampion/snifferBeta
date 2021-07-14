/**
 * @ClassName TaskService
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/13 15:27
 */
package com.wit.service.Impl;

import com.wit.config.beanCopier.BeanCopierCache;
import com.wit.dao.TaskDAO;
import com.wit.dto.taskMgr.CreateTaskQueryDTO;
import com.wit.dto.taskMgr.TaskDTO;
import com.wit.dto.taskMgr.TaskQueryDTO;
import com.wit.service.TaskService;
import com.wit.core.taskMgr.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDAO taskDao;

    @Override
    public boolean createTask(CreateTaskQueryDTO createTaskQueryDTO) {
        boolean q = false;
        try {
            q = taskDao.createTask(createTaskQueryDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return q;
    }

    @Override
    public Object getData(TaskQueryDTO taskQueryDto) {
        return null;
    }

    @Override
    public Object exportTaskReport(TaskQueryDTO taskQueryDto) {
        return null;
    }

    @Override
    public boolean startTask(TaskQueryDTO taskQueryDto) {
        return false;
    }

    @Override
    public boolean endTask(TaskQueryDTO taskQueryDto) {
        return false;
    }

    @Override
    public boolean notice(TaskQueryDTO taskQueryDto) {
        return false;
    }

    @Override
    public List<TaskDTO> queryTasks(TaskQueryDTO taskQueryDto) {
        List<Task> tasks = taskDao.queryTasks(taskQueryDto);
        List<TaskDTO> taskDtoList = BeanCopierCache.copyList(tasks, TaskDTO::new);
        taskDtoList.sort((o1, o2) -> {
            if (o1.getTaskState().equals(o2.getTaskState())) {
                return o1.getExpectedStartTime().compareTo(o2.getExpectedStartTime());
            }
            return o2.getTaskState().getPriority() - o1.getTaskState().getPriority();
        });
        return taskDtoList;
    }

}
