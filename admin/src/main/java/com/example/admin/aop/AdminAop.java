package com.example.admin.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class AdminAop {

    @Pointcut("execution(* com.example.admin.controller.AdminDataController.*(..))") // Controller.*이 모든 메서드를 지칭한다
    public void cut() {
    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        if (session.getAttribute("id") == null) { //로그인 안 했을때
            return "redirect:/login";
        } else { //로그인 했을 때
            return joinPoint.proceed(); //원래 가던대로 가는거임
        }
    }
}
