package com.joseluisestevez.ms.app.answers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceAnswersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAnswersApplication.class, args);
    }

}
