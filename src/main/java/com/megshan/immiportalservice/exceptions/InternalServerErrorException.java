package com.megshan.immiportalservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;

import java.util.function.Predicate;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InternalServerErrorException extends HttpServerErrorException {
    public InternalServerErrorException(HttpStatus statusCode) {
        super(statusCode);
    }

    public InternalServerErrorException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
