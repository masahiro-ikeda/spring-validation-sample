package com.example.demo.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class SampleExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleBindException(
          BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

      BindingResult result = ex.getBindingResult();

      String message = "Validation Failed";
      List<ErrorDetail> details = result.getFieldErrors().stream()
              .map( (FieldError error) -> new ErrorDetail(
                      error.getField(),
                      error.getDefaultMessage() ) )
              .collect( Collectors.toList() );

      ErrorResponseEntity body = new ErrorResponseEntity(message ,details );
      return handleExceptionInternal( ex, body, headers, status, request );
  }
}

