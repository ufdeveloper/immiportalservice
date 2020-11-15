package com.megshan.immiportalservice.service;

import com.megshan.immiportalservice.domain.employment.Employer;
import com.megshan.immiportalservice.domain.employment.Employment;
import com.megshan.immiportalservice.domain.travel.Travel;
import com.megshan.immiportalservice.domain.travel.TravelHistory;

public interface ImmiPortalService {

    void addEmployer(String userId, Employer employer);
    void updateEmployer(String userId, Employer employer);
    Employment getEmploymentHistory(String userId);
    void deleteEmployer(String userId, String employerId);

    void addTravel(String userId, Travel travel);
    void updateTravel(String userId, Travel travel);
    TravelHistory getTravelHistory(String userId);
    void deleteTravel(String userId, String travelId);
}
