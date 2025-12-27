package com.uber.microservice.shared.kernel.domain;


import com.uber.microservice.shared.kernel.inteface.Command;
import com.uber.microservice.shared.kernel.inteface.PrescriptionCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PrescriptionAggregateRoot {
  private List<Medicine> medicineList = new ArrayList<>();
  private Doctor doctor;
  private Patient patient;

  public Prescription createPrescription(PrescriptionCommand command) {
    addMedicineList(command.getMedicineList());
    setDoctor(command.getDoctor());
    setPatient(command.getPatient());
    return generatePrescription();
  }

  public void addMedicine(Medicine medicine) {
    this.medicineList.add(medicine);
  }

  public void addMedicineList(List<Medicine> medicineList) {
    if (Objects.isNull(medicineList) || medicineList.isEmpty()) {
      throw new RuntimeException("A Prescription must contain medicine");
    }

    this.medicineList.addAll(medicineList);
  }

  public void setDoctor(Doctor doctor) {
    if (Objects.isNull(doctor)) {
      throw new RuntimeException("A doctor must approve this prescription");
    }
    this.doctor = doctor;
  }

  public void setPatient(Patient patient) {
    if (Objects.isNull(patient)) {
      throw new RuntimeException("A prescription must be point to a patient");
    }
    this.patient = patient;
  }

  public Prescription generatePrescription() {
    Random random = new Random();
    Prescription prescription = new Prescription(
        Math.abs(random.nextLong()),
        "Prescription of: " + this.patient.getName(),
        medicineList,
        patient,
        doctor
    );

    return prescription;
  }
}
