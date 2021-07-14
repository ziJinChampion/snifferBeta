package com.wit.core.sysMgr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Institute 业主单位实体类
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/30 11:39
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institute {
    /**
     * 业主单位 ID
     */
    private Integer instituteId;

    /**
     * 业主单位名称
     */
    private String instituteName;
}
