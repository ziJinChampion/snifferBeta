package com.wit.core.thingsBoard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sonrisa
 * @ClassName TbDeviceToken
 * @Description TODO
 * @Date 2021/1/27 14:48
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDeviceToken {

    private String deviceId;

    private String accessToken;

}