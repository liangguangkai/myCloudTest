package com.lgk.producerb.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect implements Ordered {
    @Pointcut("@annotation(com.lgk.producerb.aop.annotation.TestAopAnnotation)")
    private void pointCut(){};

    @Before("pointCut()")
    public void before(){
        System.out.println("in .... before");
    }


    @Override
    public int getOrder() {
        return 9;
    }
}
