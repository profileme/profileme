package com.profileme.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
@Slf4j
public class ApiErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<String> profileNotFound(ApiError error) {
        log.info("--------------------------------------------------inside handler *********************************************");
        log.info(error.getStatus().toString());
        log.info(error.getMessage());

        return ResponseEntity.status(error.getStatus()).body(error.getMessage());

    }
}