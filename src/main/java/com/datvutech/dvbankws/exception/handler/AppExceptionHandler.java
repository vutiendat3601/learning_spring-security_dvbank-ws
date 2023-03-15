package com.datvutech.dvbankws.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.datvutech.dvbankws.exception.UserServiceException;
import com.datvutech.dvbankws.exception.response.ErrorResponse;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<ErrorResponse> handleExceptions(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(new ErrorResponse(
                        exception.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        LocalDateTime.now()));
    }

    @ExceptionHandler({ UserServiceException.class })
    public ResponseEntity<ErrorResponse> handleUserServiceException(
            UserServiceException userServiceException) {
        return ResponseEntity.status(userServiceException.getStatus())
                .body(new ErrorResponse(
                        userServiceException.getMessage(),
                        userServiceException.getStatus(),
                        LocalDateTime.now()));
    }
}
