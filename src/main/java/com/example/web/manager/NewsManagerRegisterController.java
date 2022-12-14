package com.example.web.manager;

import com.example.dto.NewsDto;
import com.example.exception.BusinessException;
import com.example.service.NewsService;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/** お知らせ登録画面のコントローラクラス. */
@Controller
@RequestMapping("manager/news/register")
@SessionAttributes({"roleIdMap"})
public class NewsManagerRegisterController {

  /** ロガー */
  private static final Logger logger = LoggerFactory.getLogger(NewsManagerRegisterController.class);

  /** お知らせ機能のサービスクラス */
  @Autowired private NewsService service;

  /**
   * 権限のコンボボックスを初期化します.
   *
   * @return
   */
  @ModelAttribute("roleIdMap")
  public Map<String, String> setupRoleIdMap() {
    return service.retrieveRoleIdMap();
  }

  /**
   * 「重要なお知らせ」入力画面を表示します.
   *
   * @param form : お知らせForm
   * @param model : モデル
   * @return
   */
  @RequestMapping(params = "input")
  public String input(NewsForm form, Model model) {
    return "/manager/news/register/newsRegisterInput";
  }

  /**
   * 「重要なお知らせ」確認画面を表示します.
   *
   * @param form : お知らせForm
   * @param result : バリデーション結果
   * @param roleIdMap : 権限のマップ
   * @param model : モデル
   * @return
   */
  @PostMapping(params = "confirm")
  public String confirm(
      @Validated NewsForm form,
      BindingResult result,
      @ModelAttribute("roleIdMap") Map<String, String> roleIdMap,
      Model model) {

    // 権限名を設定
    form.setRoleNm(roleIdMap.get(form.getRoleId()));
    model.addAttribute("newsForm", form);

    // エラーチェック
    if (result.hasErrors()) {
      return "/manager/news/register/newsRegisterInput";
    }
    // 業務チェック
    NewsDto dto = new NewsDto();
    BeanUtils.copyProperties(form, dto);
    try {
      service.validateNews(dto);
    } catch (BusinessException e) {
      model.addAttribute("messageList", e.getMessageList());
      return "/manager/news/register/newsRegisterInput";
    }

    return "/manager/news/register/newsRegisterConfirm";
  }

  /**
   * 「重要なお知らせ」確認画面から入力画面に遷移します.
   *
   * @param form : お知らせForm
   * @param result : バリデーション結果
   * @param model : モデル
   * @return
   */
  @PostMapping(params = "back")
  public String backToInput(@Validated NewsForm form, BindingResult result, Model model) {

    return "/manager/news/register/newsRegisterInput";
  }

  /**
   * 「重要なお知らせ」完了画面を表示します.
   *
   * @param form : お知らせForm
   * @param result : バリデーション結果
   * @param model : モデル
   * @return
   */
  @PostMapping(params = "register")
  public String register(
      @Validated NewsForm form,
      BindingResult result,
      Model model,
      RedirectAttributes redirectAttributes) {

    // フラッシュスコープに登録
    redirectAttributes.addFlashAttribute(form);
    // 再度エラーチェック
    if (result.hasErrors()) {
      throw new RuntimeException("不正な入力変更");
    }
    // 業務チェック
    NewsDto dto = new NewsDto();
    BeanUtils.copyProperties(form, dto);
    service.validateNews(dto);

    // 登録
    service.addNews(dto);

    return "redirect:/manager/news/register?complete";
  }

  /**
   * 「重要なお知らせ」完了画面を表示します.
   *
   * @param form : お知らせForm
   * @param model : モデル
   * @return
   */
  @GetMapping(params = "complete")
  public String complete(NewsForm form, Model model) {

    return "/manager/news/register/newsRegisterComplete";
  }
}
