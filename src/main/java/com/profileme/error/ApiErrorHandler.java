package com.profileme.error;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
@Slf4j
public class ApiErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ApiError.class)
    public ResponseEntity<String> profileNotFound(ApiError error,WebRequest request) {
        log.info("--------------------------------------------------inside handler *********************************************");
        log.info(error.getStatus().toString());
        log.info(error.getMessage());

        return ResponseEntity.status(error.getStatus()).body(error.getMessage());

    }
}