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
import oit.is.group8.b18wallet.model.Income;
import oit.is.group8.b18wallet.model.IncomeMapper;
import org.springframework.transaction.annotation.Transactional;

@Controller
@RequestMapping("/income")
public class IncomeController {
  @Autowired
  IncomeMapper incomeMapper;
  /**
   * sample21というGETリクエストがあったら，sample21()を呼び出して，sample21.htmlを返すメソッド
   *
   * @return
   */

  @GetMapping("step1")
  public String income(){
    return "income.html";
  }

  @PostMapping("step2")
  @Transactional
  public String income(@RequestParam String Date, @RequestParam Integer Money, @RequestParam String Memo, Principal prin, ModelMap model) {
    Income income1 = new Income();
    String loginUser = prin.getName();
    income1.setUser(loginUser);
    income1.setDate(Date);
    income1.setMoney(Money);
    income1.setMemo(Memo);
    incomeMapper.insertIncome(income1);
    model.addAttribute("income1", income1);
    return "income.html";
  }


}
