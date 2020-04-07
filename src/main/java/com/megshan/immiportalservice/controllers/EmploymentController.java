package com.megshan.immiportalservice.controllers;

import com.megshan.immiportalservice.domain.UserData;
import com.megshan.immiportalservice.service.ImmiPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for employment history of user
 */

@RestController
public class EmploymentController {

    @Autowired
    private ImmiPortalService immiPortalService;

    @RequestMapping(path = "employment")
    public UserData helloWorld() {
        return immiPortalService.getEmploymentHistory("10006546");
    }
}
