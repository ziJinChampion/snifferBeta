package com.wit.core.sysMgr;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName AreaVO
 * @Description TODO
 * @Author Aegean
 * @Date 2021/1/28 16:01
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "area", description = "区域树")
public class Area {

    /**
     * 区域 ID
     */
    private Integer value;

    /**
     * 区域名
     */
    private String label;

    /**
     * 子区域
     */
    private List<Area> children;

}
