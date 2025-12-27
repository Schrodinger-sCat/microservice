package com.uber.microservice;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = {
    "com.uber.microservice",
    "com.uber.microservice.shared-kernel" // package in shared-kernel
})
public class MicroserviceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceApplication.class, args);
  }

}
