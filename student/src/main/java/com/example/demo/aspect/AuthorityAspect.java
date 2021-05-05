package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Slf4j
@Aspect
@Component
public class AuthorityAspect {

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void checkAuthority() {
        log.info(">>>>>HIJACKED");
    }

    @Before("execution(* com.example.demo.controller.HomeConroller.getHome(..))")
    public void checkAuthority2() {
        log.info(">>>>>HIJACKED");
    }
}
