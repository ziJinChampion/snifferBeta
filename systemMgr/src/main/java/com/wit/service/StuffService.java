package com.wit.service;

import com.wit.core.sysMgr.Stuff;
import com.wit.dto.sysMgr.StuffDTO;

import java.util.List;

public interface StuffService {

    /**
     * 查询所有工作人员信息
     * @return
     */
    List<StuffDTO> queryAll();
}
