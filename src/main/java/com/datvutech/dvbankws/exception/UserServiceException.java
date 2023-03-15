package com.datvutech.dvbankws.exception;

import org.springframework.http.HttpStatus;

public class UserServiceException extends RuntimeException {
    private int status;

    public int getStatus() {
        return status;
    }

    public UserServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status.value();
    }

}
