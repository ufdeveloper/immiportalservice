package com.megshan.immiportalservice.data;

import com.megshan.immiportalservice.domain.travel.TravelHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends MongoRepository<TravelHistory, String> {
}
