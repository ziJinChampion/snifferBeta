package com.wit.service.Impl;

import com.wit.config.beanCopier.BeanCopierCache;
import com.wit.core.sysMgr.SystemConfig;
import com.wit.dao.SystemConfigDAO;
import com.wit.dto.sysMgr.SystemConfigDTO;
import com.wit.service.SystemConfigService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName SystemConfigServiceImpl
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/17 11:03
 * @Version 1.0
 **/
@Service
public class SystemConfigServiceImpl implements SystemConfigService {

    private static final String DetectedParams = "监测参数";

    @Autowired
    private SystemConfigDAO systemConfigDAO;

    public List<? extends Object> queryAllByName(String attributeName) {
        List<SystemConfigDTO> systemConfigDTOList = null;
        try {
            List<SystemConfig> systemConfigs = systemConfigDAO.queryAllByName(attributeName);
            systemConfigDTOList = BeanCopierCache.copyList(systemConfigs, SystemConfigDTO::new);
            if (Strings.isBlank(attributeName)) {
                Map<String, List<SystemConfigDTO>> map = new HashMap<>();
                for (SystemConfigDTO systemConfig : systemConfigDTOList) {
                    if (!map.containsKey(systemConfig.getAttributeName())) {
                        map.put(systemConfig.getAttributeName(), new ArrayList<SystemConfigDTO>());
                    }
                }
                for (SystemConfigDTO systemConfig : systemConfigDTOList) {
                    map.get(systemConfig.getAttributeName()).add(systemConfig);
                }
//                List<List<SystemConfigDTO>> systemConfigDTOLists = new ArrayList<>();
//                for(Map.Entry<String, List<SystemConfigDTO>> entry : map.entrySet()){
//                    systemConfigDTOLists.add(entry.getValue());
//                }
                return map.entrySet().stream().collect(Collectors.toList());
            }
            systemConfigDTOList = BeanCopierCache.copyList(systemConfigs, SystemConfigDTO::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return systemConfigDTOList;
    }

    @Override
    public List<String> getDetectedParamNames() {
        List<SystemConfigDTO> systemConfigDTOList = (List<SystemConfigDTO>) queryAllByName(DetectedParams);
        if (systemConfigDTOList == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        systemConfigDTOList.forEach((dto) -> {
            list.add(dto.getValue());
        });
        return list;
    }
}
