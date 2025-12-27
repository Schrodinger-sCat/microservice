package com.uber.microservice.shared.kernel.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(doNotUseGetters = true)
public class Doctor {
  private long id;
  private String name;
}
