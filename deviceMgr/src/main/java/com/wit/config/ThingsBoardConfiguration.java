/**
 * @ClassName ThingsBoardConfiguration
 * @Description TODO
 * @author Sonrisa
 * @Date 2021/1/24 18:32
 */
package com.wit.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thingsboard.rest.client.RestClient;

@Configuration
@EnableConfigurationProperties(value = ThingsBoardProperties.class)
public class ThingsBoardConfiguration {

    private final String username;

    private final String password;

    private final String url;

    public ThingsBoardConfiguration(ThingsBoardProperties properties) {
        this.username = properties.getUsername();
        this.password = properties.getPassword();
        this.url = properties.getUrl();
    }

    @Bean
    public RestClient restClient() {
        RestClient client = new RestClient(url);
        client.login(username, password);
        return client;
    }

}
