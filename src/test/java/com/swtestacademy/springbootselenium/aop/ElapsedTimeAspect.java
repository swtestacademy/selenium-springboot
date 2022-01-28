package com.swtestacademy.springbootselenium.aop;

import com.swtestacademy.springbootselenium.annotations.ElapsedTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class ElapsedTimeAspect {
    @Around("@annotation(elapsedTime)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, ElapsedTime elapsedTime) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Elapsed time of {} is {}", proceedingJoinPoint.getSignature().getName(), timeTaken + " ms.");
        return obj;
    }
}
