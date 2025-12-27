package com.uber.microservice.test;

import com.uber.microservice.dependency.Prescription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private final Producer producer;

  public TestController(Producer producer) {
    this.producer = producer;
  }

  @GetMapping("/test")
  public String test() {
    producer.send("Shanto");
    return "OK";
  }

  @GetMapping("/prescription")
  public ResponseEntity<String> prescription() {
      producer.sendPrescription(new Prescription(100, "Prescription-1"));
    return ResponseEntity.ok("Okay");
  }
}
