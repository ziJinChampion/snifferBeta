package com.wit.dto.sysMgr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SystemConfigDTO
 * @Description TODO
 * @Author Aegean
 * @Date 2021/2/1 11:09
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemConfigDTO {
    /**
     * 所属模块名
     */
    private String groupName;
    /**
     * 配置项 ID
     */
    private String attributeId;
    /**
     * 配置项名称
     */
    private String attributeName;
    /**
     * 配置项内容
     */
    private String value;
    /**
     * 状态，true：开启，false：关闭
     */
    private boolean status;
    /**
     * 备注
     */
    private String remarks;
}
