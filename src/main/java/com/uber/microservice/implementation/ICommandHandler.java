package com.uber.microservice.implementation;

import com.uber.microservice.repositories.PrescriptionRepository;
import com.uber.microservice.shared.kernel.domain.PrescriptionAggregateRoot;
import com.uber.microservice.shared.kernel.inteface.Command;
import com.uber.microservice.shared.kernel.inteface.ICommand;
import com.uber.microservice.shared.kernel.domain.Prescription;
import com.uber.microservice.test.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ICommandHandler implements ICommand {
    @Autowired
    public Producer producer;
    @Autowired
    public PrescriptionRepository prescriptionRepository;

    @Override
    public void handle(Command command) {
        log.info("Processing prescription: {}", command);
        Prescription prescription = new PrescriptionAggregateRoot().createPrescription(command);
        prescriptionRepository.save(prescription);
        producer.publishPrescription(prescription);
    }
}
