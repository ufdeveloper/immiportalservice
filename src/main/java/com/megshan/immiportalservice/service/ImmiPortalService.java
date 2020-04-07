package com.megshan.immiportalservice.service;

import com.megshan.immiportalservice.domain.UserData;

public interface ImmiPortalService {

    UserData getEmploymentHistory(String userId);
}
