package com.cloudcode.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableFeignClients
@SpringBootApplication
public class SpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApplication.class, args);
    }

    @GetMapping("/health")
    public Map<String, Object> health(@Value("${spring.application.name}") String name) {
        Map<String, Object> healthMap = new HashMap<>();
        healthMap.put("name", name);
        healthMap.put("localDateTime", LocalDateTime.now());
        return healthMap;
    }
}
