package com.uber.microservice.shared.kernel.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PrescriptionAggregateRoot {
  private List<Medicine> medicineList = new ArrayList<>();
  private Doctor doctor;
}
