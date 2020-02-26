package com.example.demo;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * テスト用のフォーム
 */
public class SampleForm {

  /**
   * 文字列Validationテスト
   */
  @NotEmpty
  @Size(max = 10)
  private String sample;

  /**
   * 数値Validationテスト
   */
  @Max(value = 100)
  private int sampleNumber;

  public String getSample() {
    return sample;
  }

  public void setSample(String sample) {
    this.sample = sample;
  }

  public int getSampleNumber() {
    return sampleNumber;
  }

  public void setSampleNumber(int sampleNumber) {
    this.sampleNumber = sampleNumber;
  }
}
