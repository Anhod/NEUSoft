package com.neu.utils;

import com.neu.po.Dept;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy // 开启切面代理
@Component
@Aspect   // 切面
public class AOPUtil {
    // 切点（切入点）：加入相同代码的一组关注点（连接点）
    @Pointcut("execution(* com.neu.mapper.*.*(..))")
    public void pointcut(){
    }

    @Before("pointcut()")
    public void before(){
        SimpleDateFormat format = new SimpleDateFormat();
        String time = format.format(new Date());
        System.out.println("开始执行时间："+time);
    }

    @AfterReturning("pointcut()")
    public void afterReturning(){
        SimpleDateFormat format = new SimpleDateFormat();
        String time = format.format(new Date());
        System.out.println("开始执行时间："+time);
    }

    // 异常通知
    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        SimpleDateFormat format = new SimpleDateFormat();
        String time = format.format(new Date());
        System.out.println("抛出异常："+time);

    }

    // 最终通知
    @After("pointcut()")
    public void after(){
        SimpleDateFormat format = new SimpleDateFormat();
        String time = format.format(new Date());
        System.out.println("方法最终结束时间："+time);

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.nanoTime();

        // 调用代理的方法
        Object p = point.proceed();

        long m = System.nanoTime() - start;

        System.out.println(m);
        return p;
    }
}
