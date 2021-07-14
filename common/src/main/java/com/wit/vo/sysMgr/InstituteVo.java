package com.wit.vo.sysMgr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sonrisa
 * @ClassName InstituteVo
 * @Description TODO
 * @Date 2021/1/30 17:21
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstituteVo {

    /**
     * 业主单位 ID
     */
    private Integer instituteId;

    /**
     * 业主单位名称
     */
    private String instituteName;


}
