package com.lgk.producerb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
@EnableAspectJAutoProxy
public class ProducerBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerBApplication.class, args);
    }

}
