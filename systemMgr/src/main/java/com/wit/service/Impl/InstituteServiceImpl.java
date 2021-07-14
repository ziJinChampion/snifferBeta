package com.wit.service.Impl;

import com.wit.config.beanCopier.BeanCopierCache;
import com.wit.core.sysMgr.Institute;
import com.wit.dao.InstituteDAO;
import com.wit.dto.sysMgr.InstituteDTO;
import com.wit.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName InstituteServiceImpl
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/30 12:14
 * @Version 1.0
 **/
@Service
public class InstituteServiceImpl implements InstituteService {

    @Autowired
    private InstituteDAO instituteDAO;

    @Override
    public List<InstituteDTO> queryInstitutes() {
        List<InstituteDTO> instituteDTOList = null;
        try {
            List<Institute> institutes = instituteDAO.queryInstitutes();
            instituteDTOList = BeanCopierCache.copyList(institutes, InstituteDTO::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instituteDTOList;
    }

    @Override
    public InstituteDTO createInstitute(String instituteName) {
        InstituteDTO instituteDto = null;
        try {
            Institute institute = instituteDAO.createInstitute(instituteName);
            instituteDto = new InstituteDTO();
            BeanCopierCache.copy(institute, instituteDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instituteDto;
    }

    @Override
    public InstituteDTO containsValue(String instituteName) {
        InstituteDTO instituteDto = null;
        try {
            Institute institute = instituteDAO.containsValue(instituteName);
            instituteDto = new InstituteDTO();
            BeanCopierCache.copy(institute, instituteDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instituteDto;
    }
}
