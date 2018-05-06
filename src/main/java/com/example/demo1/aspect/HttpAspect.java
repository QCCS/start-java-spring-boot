package com.example.demo1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//切面编程，与前端的层级拦截器一个道理
//需要添加依赖
//<dependency>
//  <groupId>org.springframework.boot</groupId>
//  <artifactId>spring-boot-starter-aop</artifactId>
//</dependency>
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);



    //加上下面的注解，代表拦截GirlController下面的方法
    @Pointcut("execution(public * com.example.demo1.database.controller.GirlController.*(..))")
    public void log() {
        logger.info("拦截到了");
    }

    //Before代表在方法执行之前就执行拦截
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //下面会依次输出拦截到的类容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("拦截到的类容");
        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("After方法执行之后的拦截");
        logger.info("222222222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }

}
