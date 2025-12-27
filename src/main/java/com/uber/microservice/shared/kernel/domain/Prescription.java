package com.uber.microservice.shared.kernel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(doNotUseGetters = true)
public class Prescription {
    private long id;
    private String name;
    private List<Medicine> medicineList;
    private Patient patient;
    private Doctor doctor;
}
