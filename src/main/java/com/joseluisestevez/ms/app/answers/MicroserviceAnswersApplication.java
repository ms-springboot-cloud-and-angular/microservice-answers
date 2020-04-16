package com.joseluisestevez.ms.app.answers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.joseluisestevez.ms.app.answers.models.entity", "com.joseluisestevez.ms.commons.exams.models.entity" })
public class MicroserviceAnswersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAnswersApplication.class, args);
    }

}
