package com.wit.service.Impl;

import com.wit.core.sysMgr.Area;
import com.wit.dao.AreaDAO;
import com.wit.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AreaServiceImpl
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/28 16:32
 * @Version 1.0
 **/
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDAO areaDao;

    @Override
    public List<Area> queryAreas() {
        return areaDao.queryAreas();
    }

    @Override
    public List<String> getVillageNamesByCountyId(Integer countyId) {
        return areaDao.getVillageNamesByCountyId(countyId);
    }

    @Override
    public boolean createVillage(String villageName, Integer countyId) {
        boolean q = true;
        try {
            areaDao.createVillage(villageName, countyId);
        } catch (Exception e) {
            q = false;
            e.printStackTrace();
        }
        return q;
    }
}
