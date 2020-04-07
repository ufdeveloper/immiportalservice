package com.megshan.immiportalservice.service;

import com.megshan.immiportalservice.domain.employment.Employer;
import com.megshan.immiportalservice.domain.employment.Employment;

public interface ImmiPortalService {

    void addEmployer(String userId, Employer employer);
    void updateEmployer(String userId, Employer employer);
    Employment getEmploymentHistory(String userId);
}
