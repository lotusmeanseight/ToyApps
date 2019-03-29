package com.github.lotusmeanseight.entity.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(transactionManagerRef = "appTransactionManager",
        entityManagerFactoryRef = "appEntityManagerFactory",
        basePackages = "com.github.lotusmeanseight.entity.repository")
public class DatasourceConfig {

    private static final String APP_JPA_PROP = "app.jpa";
    private static final String APP_DATASOURCE = "app.datasource";
    private static final String APP_EM = "appEntityManager";
    private static final String APP_EM_FACTORY = "appEntityManagerFactory";
    private static final String APP_PUNIT = "appPersistenceUnit";
    private static final String APP_TXMANAGER = "appTransactionManager";

    @Bean(name = APP_JPA_PROP)
    @Primary
    @ConfigurationProperties(APP_JPA_PROP)
    public JpaProperties jpaProperties(){
        return new JpaProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = APP_DATASOURCE)
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = APP_DATASOURCE)
    @Primary
    public DataSource dataSource(){
        return dataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = APP_EM_FACTORY)
    @Primary
    public LocalContainerEntityManagerFactoryBean factory(EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource())
                .packages("com.github.lotusmeanseight.entity")
                .persistenceUnit(APP_PUNIT)
                .properties(jpaProperties().getProperties())
                .build();
    }

    @Bean(name = APP_EM)
    @Primary
    public EntityManager entityManager(@Qualifier(APP_EM_FACTORY) EntityManagerFactory factory){
        return factory.createEntityManager();
    }

    @Bean(name = APP_TXMANAGER)
    @Primary
    public PlatformTransactionManager platformTransactionManager(@Qualifier(APP_EM_FACTORY) EntityManagerFactory factory){
        return new JpaTransactionManager(factory);
    }

}
