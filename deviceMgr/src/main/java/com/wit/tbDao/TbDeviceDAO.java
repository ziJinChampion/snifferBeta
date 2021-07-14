package com.wit.tbDao;

import com.wit.core.devMgr.CustomDevice;
import com.wit.core.thingsBoard.TbDeviceToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Sonrisa
 * @ClassName TbDeviceDAO
 * @Description TODO
 * @Date 2021/1/25 19:50
 */

@Repository
public interface TbDeviceDAO {

    /**
     * 通过设备 id 来获取设备令牌
     * @param deviceIds 设备 id 列表
     * @return List<Map<String, String>>
     */
    List<TbDeviceToken> getDeviceTokenById(@Param("deviceIds") List<String> deviceIds);

}
