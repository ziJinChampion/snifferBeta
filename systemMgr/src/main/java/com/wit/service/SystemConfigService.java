package com.wit.service;

import com.wit.core.sysMgr.SystemConfig;
import com.wit.dto.sysMgr.SystemConfigDTO;
import com.wit.vo.sysMgr.SystemConfigVO;

import java.util.List;

public interface SystemConfigService {
    /**
     * 根据所属模块名和配置项名称查询系统配置
     *
     * @param attributeName 配置项名称
     * @return
     */
    List<? extends Object> queryAllByName(String attributeName);

    /**
     * 查询所有监测参数的名称，为新建任务服务
     *
     * @return
     */
    List<String> getDetectedParamNames();
}
