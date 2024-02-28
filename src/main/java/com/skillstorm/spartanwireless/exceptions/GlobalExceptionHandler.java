package com.skillstorm.spartanwireless.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PhonePlanNotPurchasedException.class) 
    public ResponseEntity<String> handlePhonePlanNotPurchasedException(PhonePlanNotPurchasedException e) {
        return new ResponseEntity<>("Customer did not purchase this phone plan.", HttpStatus.NOT_FOUND);
    }
}