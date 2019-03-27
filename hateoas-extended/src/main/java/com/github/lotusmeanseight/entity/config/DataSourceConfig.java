package com.github.lotusmeanseight.entity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix="app.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "testDataSource")
    @ConfigurationProperties(prefix = "test.datasource")
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    @Autowired
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Autowired
    public DataSourceTransactionManager testTransactionManager(@Qualifier("testDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
