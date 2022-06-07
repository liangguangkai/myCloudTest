package com.lgk.consumer.controller;

import com.lgk.consumer.feign.ProducerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    ProducerFeignService producerFeignService;

    @GetMapping("{name}")
    public String getFood(@PathVariable(value = "name") String name){
        return producerFeignService.getFood(name);
    }
}
