package com.megshan.immiportalservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for employment history of user
 */

@RestController
public class EmploymentController {

    @RequestMapping(path = "employment")
    public String helloWorld() {
        return "Hello World";
    }
}
