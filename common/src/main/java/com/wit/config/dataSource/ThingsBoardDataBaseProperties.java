package com.wit.config.dataSource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Sonrisa
 * @ClassName ThingsBoardDataBaseConfiguration
 * @Description TODO
 * @Date 2021/1/25 22:27
 */

@Data
@ConfigurationProperties(prefix = "thingsboard.database")
public class ThingsBoardDataBaseProperties {

    private String mapperLocations;

    private String typeAliasesPackage;

    private String url;

    private String username;

    private String password;

    private String driverClassName;

}
