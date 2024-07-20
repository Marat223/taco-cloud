package com.example.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class TacocloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacocloudApplication.class, args);
    }

}
