package com.wit.dao;

import com.wit.core.sysMgr.Stuff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuffDAO {
    /**
     * 查询所有工作人员信息
     * @return
     */
    List<Stuff> queryAll();
}
