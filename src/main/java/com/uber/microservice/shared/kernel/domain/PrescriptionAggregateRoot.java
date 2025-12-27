package com.uber.microservice.shared.kernel.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrescriptionAggregateRoot {
  private List<Medicine> medicineList = new ArrayList<>();
  private Doctor doctor;
  private Patient patient;

  public void addMedicine(Medicine medicine) {
    medicineList.add(medicine);
  }

  public void addMedicineList(List<Medicine> medicineList) {
    medicineList.addAll(medicineList);
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public void setPatient(Patient patient) {
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
