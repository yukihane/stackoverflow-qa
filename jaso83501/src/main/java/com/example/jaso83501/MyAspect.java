package com.example.jaso83501;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspect {

    @Pointcut("execution(* methodOne(..))")
    public void myAspectOne() {
    }

    @Around("myAspectOne()")
    public Object log(final ProceedingJoinPoint pjp) throws Throwable {
        final Object ret = pjp.proceed();
        log.info("execute logging!!!");
        return ret;
    }
}
