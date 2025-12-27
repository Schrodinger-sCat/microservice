package com.uber.microservice.test;

import com.uber.microservice.shared.kernel.domain.Prescription;
import com.uber.microservice.shared.kernel.inteface.Command;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class Producer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public Producer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(String msg) {
        rabbitTemplate.convertAndSend("test.exchange", "test.key", msg);
    }

    public void sendPrescription(Prescription prescription) {
        rabbitTemplate.convertAndSend(
                "loki.prescription.exchange",
                "loki.prescription.key",
                prescription
        );

    }

    public void publishPrescription(Prescription prescription) {
        rabbitTemplate.convertAndSend(
            "loki.prescription.exchange",
            "loki.prescription.key",
            prescription
        );

    }

}
