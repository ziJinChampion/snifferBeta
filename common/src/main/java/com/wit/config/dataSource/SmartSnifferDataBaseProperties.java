package com.wit.config.dataSource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Sonrisa
 * @ClassName SmartSnifferDataSourceProperties
 * @Description TODO
 * @Date 2021/1/25 22:06
 */

@Data
@ConfigurationProperties(prefix = "smartsniffer.database")
public class SmartSnifferDataBaseProperties {

    private String mapperLocations;

    private String typeAliasesPackage;

    private String url;

    private String username;

    private String password;

    private String driverClassName;

}
