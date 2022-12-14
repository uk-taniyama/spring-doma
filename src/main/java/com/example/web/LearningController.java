package com.example.web;

import com.example.security.LoginUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** ラーニング画面のコントローラ. */
@Controller
@RequestMapping("/learning")
public class LearningController {

  /** ロガー */
  private static final Logger logger = LoggerFactory.getLogger(LearningController.class);

  /**
   * ラーニング画面.
   *
   * @return ビュー名
   */
  @RequestMapping(method = RequestMethod.GET)
  public String top(Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {

    return "learning/learning";
  }
}
