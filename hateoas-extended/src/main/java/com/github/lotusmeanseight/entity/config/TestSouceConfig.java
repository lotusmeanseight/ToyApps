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
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(transactionManagerRef = "testTransactionManager",
        entityManagerFactoryRef = "testEntityManagerFactory",
        basePackages = "com.github.lotusmeanseight.entity.repository")
@EnableTransactionManagement
public class TestSouceConfig {

    private static final String TEST_JPA_PROP = "test.jpa";
    private static final String TEST_DATASOURCE = "test.datasource";
    private static final String TEST_EM = "testEntityManager";
    private static final String TEST_EM_FACTORY = "testEntityManagerFactory";
    private static final String TEST_PUNIT = "testPersistenceUnit";
    private static final String TEST_TXMANAGER = "testTransactionManager";

    @Bean(name = TEST_JPA_PROP)
    @Primary
    @ConfigurationProperties(TEST_JPA_PROP)
    public JpaProperties jpaProperties(){
        return new JpaProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = TEST_DATASOURCE)
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = TEST_DATASOURCE)
    @Primary
    public DataSource dataSource(){
        return dataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = TEST_EM_FACTORY)
    @Primary
    public LocalContainerEntityManagerFactoryBean factory(EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource())
                .packages("com.github.lotusmeanseight.entity")
                .persistenceUnit(TEST_PUNIT)
                .properties(jpaProperties().getProperties())
                .build();
    }

    @Bean(name = TEST_EM)
    @Primary
    public EntityManager entityManager(@Qualifier(TEST_EM_FACTORY) EntityManagerFactory factory){
        return factory.createEntityManager();
    }

    @Bean(name = TEST_TXMANAGER)
    @Primary
    public PlatformTransactionManager platformTransactionManager(@Qualifier(TEST_EM_FACTORY) EntityManagerFactory factory){
        return new JpaTransactionManager(factory);
    }

}
