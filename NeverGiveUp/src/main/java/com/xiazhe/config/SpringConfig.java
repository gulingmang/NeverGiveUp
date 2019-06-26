package com.xiazhe.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration

@ComponentScan(basePackages = "com.xiazhe")
public class SpringConfig {


    @Bean
    public DataSource dataSource() throws IOException {
        DruidDataSource druidDataSource = new DruidDataSource();
        Properties properties = new Properties();
        InputStream inputStream = SpringConfig.class.getClassLoader().getResourceAsStream("druid.properties"); //加载的是你创建的配置文件
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        druidDataSource.setConnectProperties(properties);

        return druidDataSource;

    }

    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.xiazhe.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        return mapperScannerConfigurer;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
