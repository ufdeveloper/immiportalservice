package com.megshan.immiportalservice.service;

import com.megshan.immiportalservice.data.EmploymentRepository;
import com.megshan.immiportalservice.domain.employment.Employer;
import com.megshan.immiportalservice.domain.employment.Employment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class ImmiPortalServiceImpl implements ImmiPortalService {

    @Autowired
    private EmploymentRepository employmentRepository;

    @Override
    public void addEmployment(String userId, Employer employer) {

        log.info("received request to add employer to employment history");
        Employment employment = getEmploymentHistory(userId);
        if(employment == null) {
            employment = new Employment();
            employment.setUserId(userId);
        }
        if(employment.getEmployers() == null) {
            employment.setEmployers(new ArrayList<>());
        }
        employment.getEmployers().add(employer);
        employmentRepository.save(employment);
        log.info("successfully added employer to employment history");
    }

    @Override
    public void updateEmployment(String userId, Employer employer) {

    }

    @Override
    public Employment getEmploymentHistory(String userId) {
        log.info("received request to get employment history");
        Employment employment = employmentRepository.findById(userId).orElse(null);
        log.info("successfully fetched employment history");
        return employment;
    }
}
