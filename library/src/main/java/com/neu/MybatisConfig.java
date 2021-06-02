package com.neu;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

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

        // 注册分页插件（拦截器）
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        interceptor.setProperties(properties);

        // 作为插件加入sessionFactory
        factoryBean.setPlugins(new Interceptor[]{interceptor});

        return factoryBean.getObject();
    }

    // 注册分页插件（拦截器）


}
