package com.wit.dao;

import com.wit.core.sysMgr.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName AreaDAO
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/28 11:59
 * @Version 1.0
 **/
@Repository
public interface AreaDAO {

    /**
     * 查询所有区域
     * @return
     */
    List<Area> queryAreas();
    /**
     * 查询所有在这片区域下的小区名
     * @return
     */
    List<String> getVillageNamesByCountyId(@Param("countyId") Integer countyId);
    /**
     * 新增在这片区域下的小区
     * @return
     */
    boolean createVillage(@Param("areaName") String villageName, @Param("countyId") Integer countyId);
}
