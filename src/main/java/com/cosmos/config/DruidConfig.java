package com.cosmos.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class DruidConfig {
    @Value("${spring.datasource.publicKey}")//获取公钥
    private String publicKey;
    //明文密码+私钥(privateKey)加密=加密密码
    //加密密码+公钥(publicKey)解密=明文密码
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setFilters("config");
        druidDataSource.setConnectionProperties("config.decrypt=true;config.decrypt.key=" + publicKey);
        return druidDataSource;
    }
}
