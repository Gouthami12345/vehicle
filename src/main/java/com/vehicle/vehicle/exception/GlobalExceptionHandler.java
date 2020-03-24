package com.vehicle.vehicle.exception;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(VehicleException.class)
    public ResponseEntity<ExceptionResponse> vehicleExceptionHandler(VehicleException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setId(Optional.of(MDC.get("uuid")).orElse(""));
        exceptionResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> exception(VehicleException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setId(Optional.of(MDC.get("uuid")).orElse(""));
        exceptionResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
