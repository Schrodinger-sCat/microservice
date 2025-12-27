package com.uber.microservice.shared.kernel.inteface;

import com.uber.microservice.shared.kernel.domain.Doctor;
import com.uber.microservice.shared.kernel.domain.Medicine;
import com.uber.microservice.shared.kernel.domain.Patient;

import java.util.List;
import java.util.Objects;

public class PrescriptionCommand extends Command {
  private final List<Medicine> medicineList;
  private final Doctor doctor;
  private final Patient patient;

  public PrescriptionCommand(
      List<Medicine> medicineList,
      Doctor doctor,
      Patient patient
  ) {
    this.medicineList = List.copyOf(
        Objects.requireNonNull(medicineList, "medicineList must not be null")
    );
    this.doctor = Objects.requireNonNull(doctor, "doctor must not be null");
    this.patient = Objects.requireNonNull(patient, "patient must not be null");
  }

  public List<Medicine> getMedicineList() {
    return medicineList;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public Patient getPatient() {
    return patient;
  }
}
