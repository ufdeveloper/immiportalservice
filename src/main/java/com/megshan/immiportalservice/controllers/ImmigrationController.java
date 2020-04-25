package com.megshan.immiportalservice.controllers;

import com.megshan.immiportalservice.domain.employment.Employer;
import com.megshan.immiportalservice.domain.employment.Employment;
import com.megshan.immiportalservice.service.ImmiPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for all user data
 */

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("portal")
public class ImmigrationController {

    @Autowired
    private ImmiPortalService immiPortalService;

    @RequestMapping(method = RequestMethod.GET, path = "{userId}/employment")
    public Employment getEmploymentHistory(@PathVariable String userId) {
        return immiPortalService.getEmploymentHistory(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, path = "{userId}/employment")
    public void addEmployer(@PathVariable String userId, @RequestBody Employer employer) {
        immiPortalService.addEmployer(userId, employer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT, path = "{userId}/employment")
    public void updateEmployer(@PathVariable String userId, @RequestBody Employer employer) {
        immiPortalService.updateEmployer(userId, employer);
    }
}
