package com.uber.microservice.shared.kernel.inteface;

import com.uber.microservice.shared.kernel.domain.Prescription;

public interface ICommand {
    IEvent handle(Command command);
}
