package com.megshan.immiportalservice.data;

import com.megshan.immiportalservice.domain.employment.Employment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentRepository extends MongoRepository<Employment, String> {
}
