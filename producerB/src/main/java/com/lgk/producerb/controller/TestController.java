package com.lgk.producerb.controller;

import com.lgk.producerb.aop.annotation.TestAopAnnotation;
import com.lgk.producerb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
@Controller
public class TestController {
    @Autowired
    TestService testService;


    @GetMapping("aop")
    public String testAop(){
        testService.useAop();
        return "success";
    }

}
