package com.uber.microservice.shared.kernel.domain;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(doNotUseGetters = true)
public class Prescription {
    private long id;
    private String name;
    @NonNull
    private List<Medicine> medicineList;
    @NonNull
    private Patient patient;
    @NonNull
    private Doctor doctor;
}
