package com.megshan.immiportalservice.controllers;

import com.megshan.immiportalservice.domain.employment.Employer;
import com.megshan.immiportalservice.domain.employment.Employment;
import com.megshan.immiportalservice.domain.travel.Travel;
import com.megshan.immiportalservice.domain.travel.TravelHistory;
import com.megshan.immiportalservice.exceptions.InternalServerErrorException;
import com.megshan.immiportalservice.service.ImmiPortalService;
import com.okta.jwt.AccessTokenVerifier;
import com.okta.jwt.Jwt;
import com.okta.jwt.JwtVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for all user data
 */

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("portal")
public class ImmigrationController {

    @Autowired
    private ImmiPortalService immiPortalService;

    @Autowired
    private AccessTokenVerifier jwtVerifier;

    @RequestMapping(method = RequestMethod.GET, path = "{userId}/employment")
    public Employment getEmploymentHistory(@PathVariable String userId, HttpServletRequest request) {
        String tokenString = request.getHeader("Authorization");
        String token = tokenString.split("\\s+")[1];
        Jwt jwt;
        try {
             jwt = jwtVerifier.decode(token);
        } catch (JwtVerificationException jve) {
            log.error("error validating JWT token");
            throw new InternalServerErrorException(HttpStatus.UNAUTHORIZED);
        }
        String user = (String)jwt.getClaims().get("sub");
        log.info("user extracted from token={}", user);
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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, path = "{userId}/employment/{employerId}")
    public void deleteEmployer(@PathVariable String userId, @PathVariable String employerId) {
        immiPortalService.deleteEmployer(userId, employerId);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{userId}/travel")
    public TravelHistory getTravelHistory(@PathVariable String userId) {
        return immiPortalService.getTravelHistory(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, path = "{userId}/travel")
    public void addTravel(@PathVariable String userId, @RequestBody Travel travel) {
        immiPortalService.addTravel(userId, travel);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT, path = "{userId}/travel")
    public void updateTravel(@PathVariable String userId, @RequestBody Travel travel) {
        immiPortalService.updateTravel(userId, travel);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, path = "{userId}/travel/{travelId}")
    public void deleteTravel(@PathVariable String userId, @PathVariable String travelId) {
        immiPortalService.deleteTravel(userId, travelId);
    }
}
