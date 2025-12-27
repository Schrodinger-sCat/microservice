package com.uber.microservice.shared.kernel.inteface;

import com.uber.microservice.shared.kernel.inteface.domain.Prescription;

public interface ICommand {
    void handle(Prescription prescription);
}
