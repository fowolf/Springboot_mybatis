package com.myuserid.dao.retailX;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.myuserid.dao.retailx", sqlSessionTemplateRef = "retailSqlSessionTemplate")
public class RetailXDataSource {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.retailx-datasource")
    public DataSource retailxData() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory retailxSqlSessionFactory(@Qualifier("retailxData") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager retailxTransactionManager(@Qualifier("retailxData") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate retailxSqlSessionTemplate(@Qualifier("retailxSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}