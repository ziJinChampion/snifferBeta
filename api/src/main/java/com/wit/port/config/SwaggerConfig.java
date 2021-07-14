package com.wit.port.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createCommonManageApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo1())
                .groupName("Web Application")
                .select()
                // 方法需要有ApiOperation注解才能生存接口文档
                .apis(RequestHandlerSelectors.basePackage("com.wit.port.webApplication"))
                // 路径使用any风格
                .paths(PathSelectors.any())
                .build()
                ;
    }
    @Bean
    public Docket createDeviceMangeApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo1())
                .groupName("Web Management")
                .select()
                // 方法需要有ApiOperation注解才能生存接口文档
                .apis(RequestHandlerSelectors.basePackage("com.wit.port.webManagement"))
                // 路径使用any风格
                .paths(PathSelectors.any())
                .build()
                ;
    }
    @Bean
    public Docket createSystemMangeApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo1())
                .groupName("App")
                .select()
                // 方法需要有ApiOperation注解才能生存接口文档
                .apis(RequestHandlerSelectors.basePackage("com.wit.port.app"))
                // 路径使用any风格
                .paths(PathSelectors.any())
                .build()
                ;
    }



    /**
     * 接口文档详细信息
     *
     * @return
     */
    private ApiInfo apiInfo1() {
        return new ApiInfoBuilder()
                .title("智嗅项目后台swagger：智嗅后台")
                .description("智能空气监测项目-api接口")
                .termsOfServiceUrl("http://www.localhost:8080")
                .version("1.0.0")
                .build();
    }
}
