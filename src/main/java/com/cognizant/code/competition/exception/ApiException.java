package com.cognizant.code.competition.exception;

import org.apache.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException extends Exception {

    private final String message;
    private  HttpStatus httpStatus;
    private  ZonedDateTime timestamp;


    public ApiException(String message,
                        HttpStatus httpStatus,
                        ZonedDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
