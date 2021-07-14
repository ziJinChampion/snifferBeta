package com.wit.dao;

import com.wit.core.sysMgr.SystemConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemConfigDAO {
    /**
     * 根据所属模块名和配置项名称查询系统配置
     * @param attributeName 配置项名称
     * @return
     */
    List<SystemConfig> queryAllByName(@Param("attributeName") String attributeName);

    /**
     * 查询所有监测参数的名称，为新建任务服务
     * @return
     */
    List<String> getDetectedParamNames();
}
