package com.epw.store.exception;

import java.time.Instant;

import lombok.Getter;

@Getter
public class ApiError {
    
    private String code;
    private String message;
    private Instant timestamp;
    private String path;

    public ApiError(String code, String message, Instant timestap, String path) {
        this.code = code;
        this.message = message;
        this.path = path;
        this.timestamp = timestap;
    }

}
