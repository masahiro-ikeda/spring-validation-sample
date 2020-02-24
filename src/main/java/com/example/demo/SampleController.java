package com.example.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  /**
   * 施設の選択.
   *
   * @param sampleForm フォーム
   * @return
   */
  @GetMapping("sample")
  public String selectFacility(@ModelAttribute("SampleForm") @Validated SampleForm sampleForm) {

    return "Success";
  }
}
