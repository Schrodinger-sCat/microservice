package com.uber.microservice.test;

import com.uber.microservice.shared.kernel.domain.Prescription;
import com.uber.microservice.shared.kernel.inteface.Command;
import com.uber.microservice.shared.kernel.inteface.ICommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private final Producer producer;
  private final ICommand iCommand;

  public TestController(Producer producer, ICommand iCommand) {
    this.producer = producer;
    this.iCommand = iCommand;
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

  @PostMapping("/generate-prescription")
  public ResponseEntity<String> generatePrescription(@RequestBody Command command) {
    iCommand.handle(command);
    return ResponseEntity.ok("Okay");
  }
}
