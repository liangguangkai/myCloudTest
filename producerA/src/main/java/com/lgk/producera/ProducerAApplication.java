package com.lgk.producera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//@EnableHystrix
@SpringBootApplication
public class ProducerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerAApplication.class, args);
    }

}
