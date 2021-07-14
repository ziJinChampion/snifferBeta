package com.wit.config.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @ClassName SmartSnifferDataSourceConfig
 * @Description 连接智嗅数据库的数据源配置类
 * @author Sonrisa
 * @Date 2021/1/25 15:24
 */
@Configuration
@MapperScan(basePackages = SmartSnifferDataBaseConfiguration.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
@EnableConfigurationProperties(value = SmartSnifferDataBaseProperties.class)
public class SmartSnifferDataBaseConfiguration {

    static final String PACKAGE = "com.wit.dao";

    private final String mapperLocations;

    private final String typeAliasesPackage;

    private final String url;

    private final String username;

    private final String password;

    private final String driverClassName;

    public SmartSnifferDataBaseConfiguration(SmartSnifferDataBaseProperties smartSnifferDataBaseProperties) {
        this.mapperLocations = smartSnifferDataBaseProperties.getMapperLocations();
        this.typeAliasesPackage = smartSnifferDataBaseProperties.getTypeAliasesPackage();
        this.url = smartSnifferDataBaseProperties.getUrl();
        this.username = smartSnifferDataBaseProperties.getUsername();
        this.password = smartSnifferDataBaseProperties.getPassword();
        this.driverClassName = smartSnifferDataBaseProperties.getDriverClassName();
    }

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource")DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(mapperLocations));
        sessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactoryBean.getObject();
    }

}
