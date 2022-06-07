package com.lgk.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "producer")
public interface  ProducerFeignService {

    @GetMapping("/food/{name}")
    public String getFood(@PathVariable(value = "name") String name);
}
