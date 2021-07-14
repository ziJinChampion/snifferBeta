package com.wit.config.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author Sonrisa
 * @ClassName ThingsBoardDataSourceConfig
 * @Description 连接 thingsBoard 数据库的数据源配置类
 * @Date 2021/1/25 17:47
 */
@Configuration
@MapperScan(basePackages = ThingsBoardDataBaseConfiguration.PACKAGE, sqlSessionFactoryRef = "tbSqlSessionFactory")
@EnableConfigurationProperties(value = ThingsBoardDataBaseProperties.class)
public class ThingsBoardDataBaseConfiguration {

    static final String PACKAGE = "com.wit.tbDao";

    private final String mapperLocations;

    private final String typeAliasesPackage;

    private final String url;

    private final String username;

    private final String password;

    private final String driverClassName;

    public ThingsBoardDataBaseConfiguration(ThingsBoardDataBaseProperties thingsBoardDataBaseProperties) {
        this.mapperLocations = thingsBoardDataBaseProperties.getMapperLocations();
        this.typeAliasesPackage = thingsBoardDataBaseProperties.getTypeAliasesPackage();
        this.url = thingsBoardDataBaseProperties.getUrl();
        this.username = thingsBoardDataBaseProperties.getUsername();
        this.password = thingsBoardDataBaseProperties.getPassword();
        this.driverClassName = thingsBoardDataBaseProperties.getDriverClassName();
    }

    @Bean(name = "tbDataSource")
    public DataSource masterDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "tbSqlSessionFactory")
    public SqlSessionFactory tbSqlSessionFactory(@Qualifier("tbDataSource")DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(mapperLocations));
        sessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactoryBean.getObject();
    }

}

