package com.task.btstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.task.btstest")
@EnableJpaRepositories
public class BtsTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BtsTestTaskApplication.class, args);
    }

}
