package com.example.demo.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timeStamp
) {
    public static ErrorResponse of(int status, String message) {
        return new ErrorResponse(status, message, LocalDateTime.now());
    }

    public static ResponseEntity<ErrorResponse> of(ErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getStatus())
                .body(of(errorCode.getStatus(), errorCode.getMessage()));
    }

    public static ResponseEntity<ErrorResponse> of(MethodArgumentNotValidException e) {
        final FieldError fieldError = e.getBindingResult().getFieldError();
        final int status = HttpStatus.BAD_REQUEST.value();
        final String message = fieldError != null ? fieldError.getDefaultMessage() : "Bad Request";

        return ResponseEntity
                .status(status)
                .body(of(status, message));
    }
}