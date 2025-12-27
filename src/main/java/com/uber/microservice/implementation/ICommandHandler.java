package com.uber.microservice.implementation;

import com.uber.microservice.repositories.PrescriptionRepository;
import com.uber.microservice.shared.kernel.domain.PrescriptionAggregateRoot;
import com.uber.microservice.shared.kernel.inteface.Command;
import com.uber.microservice.shared.kernel.inteface.ICommand;
import com.uber.microservice.shared.kernel.domain.Prescription;
import com.uber.microservice.shared.kernel.inteface.IEvent;
import com.uber.microservice.shared.kernel.inteface.PrescriptionCommand;
import com.uber.microservice.test.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class ICommandHandler implements ICommand {
    @Autowired
    public PrescriptionRepository prescriptionRepository;

    @Override
    public IEvent handle(Command command) {
        log.info("Processing prescription: {}", command);
        Prescription prescription = new PrescriptionAggregateRoot().createPrescription((PrescriptionCommand) command);
        prescriptionRepository.save(prescription);

        Random random = new Random();
      return new PrescriptionEvent(Math.abs(random.nextLong()), prescription);
    }
}
