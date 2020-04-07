package com.megshan.immiportalservice.data;

import com.megshan.immiportalservice.domain.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends MongoRepository<UserData, String> {


}
