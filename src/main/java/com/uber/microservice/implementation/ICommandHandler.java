package com.uber.microservice.implementation;

import com.uber.microservice.shared.kernel.inteface.ICommand;
import com.uber.microservice.shared.kernel.domain.Prescription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ICommandHandler implements ICommand {

    @Override
    public void handle(Prescription prescription) {
        log.info("Processing prescription: {}", prescription);
    }
}
