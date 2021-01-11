package oit.is.group8.b18wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.security.Principal;
import oit.is.group8.b18wallet.model.Spend;
import oit.is.group8.b18wallet.model.SpendMapper;
import org.springframework.transaction.annotation.Transactional;

@Controller
@RequestMapping("/spend")
public class SpendController {

  @Autowired
  SpendMapper spendMapper;

  /**
   * sample21というGETリクエストがあったら，sample21()を呼び出して，sample21.htmlを返すメソッド
   *
   * @return
   */

  @GetMapping("step1")
  public String spend(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    model.addAttribute("login_user", loginUser);
    return "spend.html";
  }

  @PostMapping("step2")
  @Transactional
  public String spend(@RequestParam String Date, @RequestParam Integer Money, @RequestParam String Memo, Principal prin,
      ModelMap model) {
    Spend spend1 = new Spend();
    String loginUser = prin.getName();
    spend1.setUser(loginUser);
    spend1.setDate(Date);
    spend1.setMoney(Money);
    spend1.setMemo(Memo);
    spendMapper.insertSpend(spend1);
    model.addAttribute("spend1", spend1);
    return "spend.html";
  }
}
