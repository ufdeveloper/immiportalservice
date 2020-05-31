package com.megshan.immiportalservice.service;

import com.megshan.immiportalservice.data.EmploymentRepository;
import com.megshan.immiportalservice.data.TravelRepository;
import com.megshan.immiportalservice.domain.employment.Employer;
import com.megshan.immiportalservice.domain.employment.Employment;
import com.megshan.immiportalservice.domain.travel.Travel;
import com.megshan.immiportalservice.domain.travel.TravelHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class ImmiPortalServiceImpl implements ImmiPortalService {

    @Autowired
    private EmploymentRepository employmentRepository;

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public void addEmployer(String userId, Employer employer) {

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
    public void updateEmployer(String userId, Employer employer) {

    }

    @Override
    public Employment getEmploymentHistory(String userId) {
        log.info("received request to get employment history");
        Employment employment = employmentRepository.findById(userId).orElse(null);
        log.info("successfully fetched employment history, employmentHistory={}", employment);
        return employment;
    }

    @Override
    public void addTravel(String userId, Travel travel) {
        log.info("received request to add travel to travel history");
        TravelHistory travelHistory = getTravelHistory(userId);
        if(travelHistory == null) {
            travelHistory = new TravelHistory();
            travelHistory.setUserId(userId);
        }
        if(travelHistory.getTravelHistory() == null) {
            travelHistory.setTravelHistory(new ArrayList<>());
        }
        travelHistory.getTravelHistory().add(travel);
        travelRepository.save(travelHistory);
        log.info("successfully added travel to travel history");
    }

    @Override
    public void updateTravel(String userId, Travel travel) {

    }

    @Override
    public TravelHistory getTravelHistory(String userId) {
        log.info("received request to get travel history");
        TravelHistory travelHistory = travelRepository.findById(userId).orElse(null);
        log.info("successfully fetched travel history, travelHistory={}", travelHistory);
        return travelHistory;
    }
}
