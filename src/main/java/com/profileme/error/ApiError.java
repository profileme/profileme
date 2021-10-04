package com.profileme.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError extends Exception {

    private HttpStatus status;
    private String message;

}
