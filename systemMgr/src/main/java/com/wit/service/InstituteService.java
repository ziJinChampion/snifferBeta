package com.wit.service;

import com.wit.core.sysMgr.Institute;
import com.wit.dto.sysMgr.InstituteDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName InstituteService
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/30 12:13
 * @Version 1.0
 **/
public interface InstituteService {
    /**
     * 查询所有业主单位
     * @return List<InstituteQuery>
     */
    List<InstituteDTO> queryInstitutes();

    /**
     * 添加业主单位业主单位
     * @return InstituteDTO
     */
    InstituteDTO createInstitute(String institute);

    InstituteDTO containsValue(String instituteName);
}
