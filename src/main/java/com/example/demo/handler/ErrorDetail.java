package com.example.demo.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

class ErrorDetail {

    @JsonProperty("field")
    private String field;

    @JsonProperty("errorMessage")
    private String errorMessage;

    ErrorDetail(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }
}
