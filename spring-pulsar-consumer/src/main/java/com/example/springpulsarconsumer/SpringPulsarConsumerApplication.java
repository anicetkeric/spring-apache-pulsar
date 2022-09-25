package com.example.springpulsarconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringPulsarConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPulsarConsumerApplication.class, args);
    }

}
