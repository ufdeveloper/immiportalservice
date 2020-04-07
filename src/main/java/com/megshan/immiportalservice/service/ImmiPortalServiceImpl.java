package com.megshan.immiportalservice.service;

import com.megshan.immiportalservice.data.UserDataRepository;
import com.megshan.immiportalservice.domain.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImmiPortalServiceImpl implements ImmiPortalService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    public UserData getEmploymentHistory(String userId) {
        UserData userData = null;
        Optional<UserData> userDataOptional = userDataRepository.findById(userId);
        if(userDataOptional.isPresent()) {
            userData = userDataOptional.get();
            System.out.println("found userData=" + userData);
        } else {
            System.out.println("no userData found");
        }

        return userData;
    }
}
