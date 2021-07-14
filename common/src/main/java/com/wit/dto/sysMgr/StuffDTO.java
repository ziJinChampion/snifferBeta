/**
 * @ClassName StuffDTO
 * @Description TODO
 * @Author Sonrisa
 * @Date 2021/1/17 14:59
 */
package com.wit.dto.sysMgr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuffDTO {

    private Integer stuffId;

    private String stuffName;

    private Long stuffTel;

}
