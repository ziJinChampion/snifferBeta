/**
 * @ClassName TaskApplicationTests
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/14 16:08
 */
package com.wit;

import com.wit.config.beanCopier.BeanCopierCache;
import com.wit.core.devMgr.CustomDevice;
import com.wit.core.sysMgr.Area;
import com.wit.core.sysMgr.Institute;
import com.wit.core.taskMgr.Task;
import com.wit.core.thingsBoard.TbDeviceToken;
import com.wit.dao.AreaDAO;
import com.wit.dao.InstituteDAO;
import com.wit.dao.TaskDAO;
import com.wit.dto.devMgr.CustomDeviceDTO;
import com.wit.dto.taskMgr.CreateTaskQueryDTO;
import com.wit.dto.taskMgr.TaskQueryDTO;
import com.wit.query.devMgr.DeviceQuery;
import com.wit.query.taskMgr.TaskQuery;
import com.wit.service.DeviceService;
import com.wit.service.SystemConfigService;
import com.wit.service.TaskService;
import com.wit.tbDao.TbDeviceDAO;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
public class TaskApplicationTests {

    /**
     * 对比forEach与流效率
     */
    @Test
    public void test1() {
        CustomDevice customDevice = new CustomDevice("ABC", "111", "ABC", "ABC", "ABC", "ABC", "ABC"
        , null, "ABCDC");
        List<CustomDevice> list1 = new ArrayList<>();
        for(int i = 1; i <= 1000; i++) {
            CustomDevice d = new CustomDevice();
            d.setDeviceId(customDevice.getDeviceId());
            d.setDeviceSerialNum(customDevice.getDeviceSerialNum());
            d.setTenantId(customDevice.getTenantId());
            d.setAreaName(customDevice.getAreaName());
            d.setDeviceName(customDevice.getDeviceName());
            d.setDeviceState(customDevice.getDeviceState());
            d.setDeviceType(customDevice.getDeviceType());
            d.setDeviceDetectedParams(customDevice.getDeviceDetectedParams());
            d.setAccessToken(customDevice.getAccessToken());
            list1.add(d);
        }

        List<CustomDeviceDTO> list2 = new ArrayList<>();
        long startTime1 = System.nanoTime();
        for (CustomDevice customDevice1 : list1) {
            CustomDeviceDTO s = new CustomDeviceDTO();
            BeanCopierCache.copy(customDevice1, s);
            list2.add(s);
        }
        long endTime1 = System.nanoTime();
        System.out.println(endTime1 - startTime1);


        List<CustomDeviceDTO> list3 = new ArrayList<>();
        long startTime2 = System.nanoTime();
        for (CustomDevice customDevice1 : list1) {
            CustomDeviceDTO s = new CustomDeviceDTO();
            BeanCopierCache.copy(customDevice1, s);
            list3.add(s);
        }
        long endTime2 = System.nanoTime();
        System.out.println(endTime2 - startTime2);

        long startTime3 = System.nanoTime();
        List<CustomDeviceDTO> list4 = BeanCopierCache.copyList(list1, CustomDeviceDTO::new);
        long endTime3 = System.nanoTime();
        System.out.println(endTime3 - startTime3);
    }

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private TaskService taskService;

    /**
     * 测试查询 custom_device 数据
     */
    @Test
    public void test3() {
        DeviceQuery deviceQuery = new DeviceQuery();
        // deviceQuery.setDeviceName("测试机");
        // deviceQuery.setDeviceState("RUNNING");
        List<String> list = new ArrayList<>();
        list.add("CO2");
        list.add("O3");
        deviceQuery.setDeviceDetectedParams(list);
        for (CustomDeviceDTO customDeviceDTO : deviceService.queryDevices(deviceQuery)) {
            System.out.println(customDeviceDTO);
        }
    }

    /**
     * 测试连接thingsBoard，查询令牌
     */
    @Autowired
    private TbDeviceDAO tbDeviceDAO;
    @Test
    public void test4() {
        List<String> deviceIds = new ArrayList<>();
        deviceIds.add("80adce60-604b-11eb-ab8f-f579a62733da");
        List<TbDeviceToken> deviceTokenById = tbDeviceDAO.getDeviceTokenById(deviceIds);
        System.out.println(deviceTokenById);
    }

//    @org.junit.Test
//    public void test5() {
//        String s = "";
//        System.out.println(s == null);
//    }

    @Autowired
    private AreaDAO areaDAO;
    @Autowired
    private InstituteDAO instituteDAO;
    @Autowired
    private SystemConfigService systemConfigService;
    @Autowired
    private TaskDAO taskDAO;
    /**
     * 测试查询区域
     */
    @Test
    public void test6() {
        CreateTaskQueryDTO createTaskQueryDTO = new CreateTaskQueryDTO();
        createTaskQueryDTO.setAreaName("a");
        createTaskQueryDTO.setDetailsAddress("a");
        createTaskQueryDTO.setDeviceId("1001");
        createTaskQueryDTO.setDeviceName("测试机");
        createTaskQueryDTO.setExpectedStartTime(LocalDateTime.now());
        createTaskQueryDTO.setInstituteId(2);
        createTaskQueryDTO.setInstituteName("创业大厦");
        createTaskQueryDTO.setStuffId(1002);
        createTaskQueryDTO.setStuffName("申金鹏");
        createTaskQueryDTO.setTaskName("a");
        createTaskQueryDTO.setTaskState(Task.State.WAITING);
        createTaskQueryDTO.setTaskType("监测任务");
        createTaskQueryDTO.setLatitude(1.55);
        createTaskQueryDTO.setLongitude(2.55);
        List<String> list = new ArrayList<>();
        list.add("CO2");
        createTaskQueryDTO.setTaskDetectedParams(list);
        System.out.println(taskDAO.createTask(createTaskQueryDTO));
    }
}
