package com.megshan.immiportalservice.controllers;

import com.megshan.immiportalservice.domain.UserData;
import com.megshan.immiportalservice.domain.employment.Employer;
import com.megshan.immiportalservice.domain.employment.Employment;
import com.megshan.immiportalservice.service.ImmiPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for all user data
 */

@RestController
@RequestMapping("portal")
public class ImmigrationController {

    @Autowired
    private ImmiPortalService immiPortalService;

    @RequestMapping(method = RequestMethod.GET, path = "{userId}/employment")
    public Employment getEmploymentHistory(@PathVariable String userId) {
        return immiPortalService.getEmploymentHistory(userId);
    }

    @RequestMapping(method = RequestMethod.POST, path = "{userId}/employment")
    public void addEmployment(@PathVariable String userId, @RequestBody Employer employer) {
        immiPortalService.addEmployment(userId, employer);
    }
}
