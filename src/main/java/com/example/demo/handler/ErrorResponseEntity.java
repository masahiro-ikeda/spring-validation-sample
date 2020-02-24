package com.example.demo.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * APIのエラーレスポンスを返却するためのクラス
 */
class ErrorResponseEntity {

  /* メッセージ */
  @JsonProperty("message")
  private String message;

  /* エラー詳細情報 */
  @JsonProperty("errors")
  private List<ErrorDetail> errors;

  /**
   * コンストラクタ
   *
   * @param message
   * @param errors
   */
  ErrorResponseEntity(String message, List<ErrorDetail> errors) {
    this.message = message;
    this.errors = errors;
  }
}
