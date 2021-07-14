/**
 * @ClassName ThingsBoardProperties
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/24 18:29
 */
package com.wit.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "thingsboard")
public class ThingsBoardProperties {

    private String username;

    private String password;

    private String url;

}
