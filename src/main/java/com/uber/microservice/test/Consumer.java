package com.uber.microservice.test;

import com.uber.microservice.dependency.Prescription;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @RabbitListener(queues = "loky.prescription.queue")
    public void receive(Prescription prescription) {
        System.out.println("Received: " + prescription);
  }

}
