package com.wit.service.Impl;

import com.wit.config.beanCopier.BeanCopierCache;
import com.wit.core.sysMgr.Stuff;
import com.wit.dao.StuffDAO;
import com.wit.dto.sysMgr.StuffDTO;
import com.wit.service.StuffService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName StuffServiceImpl
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/17 10:56
 * @Version 1.0
 **/

@Service
public class StuffServiceImpl implements StuffService {

    @Autowired
    private StuffDAO stuffDao;

    @Override
    public List<StuffDTO> queryAll() {
        List<Stuff> stuffs = stuffDao.queryAll();
        return BeanCopierCache.copyList(stuffs, StuffDTO::new);
    }
}
