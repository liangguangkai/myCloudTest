package com.lgk.producerb.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("food")
public class FoodController {


    @GetMapping("{name}")
    @HystrixCommand(fallbackMethod = "hystrixGet",// 服务降级方法
            // 使用commandProperties 可以配置熔断的一些细节信息
            commandProperties = {

                    // 类似kv形式
                    //这里这个参数意思是熔断超时时间2s，表示过了多长时间还没结束就进行熔断
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
            }
    )
    public String getFood(@PathVariable(value = "name") String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "food "+name+" coming, provided by B";
    }


    public String hystrixGet(@PathVariable(value = "name") String name){
        return "error";
    }
}
