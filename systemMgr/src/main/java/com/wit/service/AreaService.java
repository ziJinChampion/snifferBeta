package com.wit.service;

import com.wit.core.sysMgr.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AreaService
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/28 16:31
 * @Version 1.0
 **/
public interface AreaService {
    /**
     * 查询所有区域
     * @return
     */
    List<Area> queryAreas();
    /**
     * 查询所有在这片区域下的小区名
     * @return
     */
    List<String> getVillageNamesByCountyId(Integer countyId);
    /**
     * 新增在这片区域下的小区
     * @return
     */
    boolean createVillage(String villageName, Integer countyId);
}
