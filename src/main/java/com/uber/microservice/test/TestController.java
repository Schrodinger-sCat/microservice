package com.uber.microservice.test;

import com.uber.microservice.shared.kernel.inteface.domain.Prescription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/prescription")
    public ResponseEntity<String> prescription(@RequestBody Prescription prescription) {
        producer.sendPrescription(prescription);
    return ResponseEntity.ok("Okay");
  }
}
