package com.uber.microservice.repositories;

import com.uber.microservice.shared.kernel.domain.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends MongoRepository<Prescription, String> {
}
