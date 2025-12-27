package com.uber.microservice.implementation;

import com.uber.microservice.shared.kernel.domain.Prescription;
import com.uber.microservice.shared.kernel.inteface.IEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PrescriptionEvent extends IEvent {
  private long eventId;
  private Prescription prescription;

  public PrescriptionEvent (long eventId, Prescription prescription) {
    this.eventId = eventId;
    this.prescription = prescription;
  }
}
