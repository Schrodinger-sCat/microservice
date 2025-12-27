package com.uber.microservice.test;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Consumer {
  @RabbitListener(queues = "test.queue")
  public void receive(String message) {
    System.out.println("Received: " + message);
  }

}
