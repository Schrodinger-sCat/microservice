package com.uber.microservice.test;

import com.uber.microservice.shared.kernel.inteface.Command;
import com.uber.microservice.shared.kernel.inteface.ICommand;
import com.uber.microservice.shared.kernel.domain.Prescription;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Consumer {

    private final ICommand iCommand;

    @RabbitListener(queues = "loki.prescription.queue")
    public void receive(Prescription prescription) {
        log.info("Received prescription: {}", prescription);
        //iCommand.handle(prescription);
    }

    @RabbitListener(queues = "loki.prescription.generate.queue")
    public void generatePrescription(Command command) {
        log.info("Received prescription: {}", command);
        iCommand.handle(command);
    }

}
