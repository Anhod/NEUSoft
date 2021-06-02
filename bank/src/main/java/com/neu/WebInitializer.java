package com.neu;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 创建spring容器
        AnnotationConfigWebApplicationContext c = new AnnotationConfigWebApplicationContext();

        // 注册配置类
        c.register(DBConfig.class);
        c.register(MybatisConfig.class);
        c.register(MyBatisMapperScannerConfig.class);

        // 把spring容器的引用方法ServletContext中
        servletContext.addListener(new ContextLoaderListener(c));

        // 创建springMVC组件的容器（子容器，可以访问父容器）
        AnnotationConfigWebApplicationContext childContext = new AnnotationConfigWebApplicationContext();
        childContext.register(SpringMVCConfig.class);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(childContext));

        servlet.addMapping("/");

        // 在启动Web服务器的时候直接创建这个前端控制器
        servlet.setLoadOnStartup(1);

        // 注册编码过滤器
        FilterRegistration.Dynamic filter = servletContext.addFilter("charsetFilter",new CharacterEncodingFilter("utf-8"));
        filter.addMappingForUrlPatterns(null,false,"/*");
    }
}
