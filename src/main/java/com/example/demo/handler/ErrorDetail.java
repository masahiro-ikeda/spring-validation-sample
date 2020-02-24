package com.example.demo.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * エラーの詳細を保持するレスポンス用クラス
 */
class ErrorDetail {

  /* フィールド名 */
  @JsonProperty("field")
  private String field;

  /* エラーメッセージ */
  @JsonProperty("errorMessage")
  private String errorMessage;

  /**
   * コンストラクタ
   *
   * @param field
   * @param errorMessage
   */
  ErrorDetail(String field, String errorMessage) {
    this.field = field;
    this.errorMessage = errorMessage;
  }
}
