package com.kalpit00.Fetch_Rewards;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String message = ex.getMostSpecificCause().getMessage();
        Map<String, String> error = new HashMap<>();
        // Check if the exception contains LocalDate or LocalTime specific errors
        if (message.contains("java.time.LocalDate")) {
            error.put("purchaseDate", "Invalid date format. Expected yyyy-MM-dd.");
        } else if (message.contains("java.time.LocalTime")) {
            error.put("purchaseTime", "Invalid time format. Expected HH:mm.");
        } else {
            // If neither LocalDate nor LocalTime, return a general message indicating both date and time formats are invalid
            error.put("error",
                    "Invalid date format. Expected yyyy-MM-dd. " +
                            "Invalid time format. Expected HH:mm.");
        }
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

