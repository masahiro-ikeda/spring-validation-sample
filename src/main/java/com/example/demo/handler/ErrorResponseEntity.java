package com.example.demo.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class ErrorResponseEntity {
    @JsonProperty("message")
    private String message;

    @JsonProperty("errors")
    private List<ErrorDetail> errors;

    ErrorResponseEntity(String message, List<ErrorDetail> errors) {
        this.message = message;
        this.errors = errors;
    }
}
