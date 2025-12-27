package com.uber.microservice.shared.kernel.inteface;

import com.uber.microservice.shared.kernel.domain.Doctor;
import com.uber.microservice.shared.kernel.domain.Medicine;
import com.uber.microservice.shared.kernel.domain.Patient;

import java.util.List;

public abstract class Command {

  public List<Medicine> getMedicineList() {
    return null;
  }

  public Doctor getDoctor() {
    return null;
  }

  public Patient getPatient() {
    return null;
  }
}
