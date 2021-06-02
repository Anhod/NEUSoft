package com.neu;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

//@ContextConfiguration(classes = {DBConfig.class})
@Configuration   // 配置类
@ComponentScan(basePackages = {"com.neu.mapper","com.neu.service","com.neu.utils"})  // dao层不用了
public class MybatisConfig {
    @Resource
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);

        return factoryBean.getObject();
    }
}
