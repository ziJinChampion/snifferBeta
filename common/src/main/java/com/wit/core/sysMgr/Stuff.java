
package com.wit.core.sysMgr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @ClassName Stuff
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/13 15:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stuff {
    /**
     * 员工 ID
     */
    private Integer stuffId;
    /**
     * 员工名
     */
    private String stuffName;
    /**
     * 员工电话
     */
    private String stuffTel;
}
