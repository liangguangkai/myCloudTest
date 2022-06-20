package com.lgk.producerb.service;

import com.lgk.producerb.aop.annotation.TestAopAnnotation;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    @TestAopAnnotation
    public String useAop() {
        System.out.println("I use aop !");
        return null;
    }
}
