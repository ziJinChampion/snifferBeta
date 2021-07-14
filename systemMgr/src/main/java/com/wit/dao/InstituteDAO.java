package com.wit.dao;

import com.wit.core.sysMgr.Institute;
import com.wit.dto.sysMgr.InstituteDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName InstituteDAO
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/30 11:37
 * @Version 1.0
 **/
@Repository
public interface InstituteDAO {
    /**
     * 查询所有业主单位
     * @return
     */
    List<Institute> queryInstitutes();
    /**
     * 添加业主单位业主单位
     * @return
     */
    Institute createInstitute(String institute);

    Institute containsValue(@Param("instituteName") String instituteName);
}
