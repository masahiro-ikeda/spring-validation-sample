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

/**
 * RestControllerの例外ハンドリングを行う
 */
@RestControllerAdvice
public class SampleExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * BeanValidationの例外ハンドリング.
   * 任意のレスポンスメッセージを返却できるようオーバーライド
   *
   * @param ex
   * @param headers
   * @param status
   * @param request
   * @return
   */
  @Override
  protected ResponseEntity<Object> handleBindException(
      BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

    String message = "Validation Failed";

    BindingResult result = ex.getBindingResult();
    List<ErrorDetail> errors = result.getFieldErrors().stream()
        .map( (FieldError error) -> new ErrorDetail(
            error.getField(),
            error.getDefaultMessage() ) )
        .collect( Collectors.toList() );

    ErrorResponseEntity body = new ErrorResponseEntity( message, errors );
    return handleExceptionInternal( ex, body, headers, status, request );
  }
}

