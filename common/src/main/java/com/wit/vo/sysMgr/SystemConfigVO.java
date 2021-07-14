package com.wit.vo.sysMgr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SystemConfigVO
 * @Description TODO
 * @Author Aegean
 * @Date 2021/2/1 11:07
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemConfigVO {
    /**
     * 配置项内容
     */
    private String value;
}
