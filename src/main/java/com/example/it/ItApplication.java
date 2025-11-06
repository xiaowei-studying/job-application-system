package com.example.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * IT岗位求职记录系统主应用类
 */
@SpringBootApplication
@EntityScan("com.example.it.entity")
@EnableJpaRepositories("com.example.it.repository")
public class ItApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItApplication.class, args);
    }

}
