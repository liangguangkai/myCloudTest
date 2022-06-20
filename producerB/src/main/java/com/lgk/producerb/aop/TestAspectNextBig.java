package com.lgk.producerb.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspectNextBig implements Ordered {

    @Pointcut ("execution(* com.lgk.producerb.service..*.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before(){
        System.out.println("in .... before next big");
    }


    @Override
    public int getOrder() {
        return 3;
    }
}
