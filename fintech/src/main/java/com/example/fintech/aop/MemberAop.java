package com.example.fintech.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class MemberAop {

    @Pointcut("execution(* com.example.fintech.controller.MemberController.*(..))")
    public void cut(){

    }

    @Around("cut()")
    public void beforeParameterLog(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("======= method name = {} =======", method.getName());

        Object[] args = joinPoint.getArgs();
        if(args.length == 0){
            log.info("no parameter");
        }
        for (Object arg:
             args) {
            log.info("parameter type = {}", args.getClass().getSimpleName());
            log.info("parameter value = {}", arg);
        }


    }
}
