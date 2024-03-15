package com.skillstorm.spartanwireless.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PhonePlanNotPurchasedException.class)
    public ResponseEntity<String> handlePhonePlanNotPurchasedException(PhonePlanNotPurchasedException e) {
        return new ResponseEntity<>("You have not purchased this phone plan yet.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsernameIsTakenException.class)
    public ResponseEntity<String> handleUsernameIsTakenException(UsernameIsTakenException e) {
        return new ResponseEntity<>("The username you entered is already taken. Please try again.", HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

}