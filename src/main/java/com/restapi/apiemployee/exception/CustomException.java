package com.restapi.apiemployee.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;

import com.restapi.apiemployee.response.ErrorResponse;

@ControllerAdvice
public class CustomException {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
    
        LocalDateTime localDateTime=LocalDateTime.now();
        ErrorResponse errorResponse = new ErrorResponse(localDateTime, 400, "Required request body is missing");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
 
}
