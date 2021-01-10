package oit.is.group8.b18wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.ArrayList;

@Controller
@RequestMapping("/home")
public class B18WalletController {

  /**
   * sample21というGETリクエストがあったら，sample21()を呼び出して，sample21.htmlを返すメソッド
   *
   * @return
   */

  @GetMapping("step1")
  public String home(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    model.addAttribute("login_user", loginUser);
    return "home.html";
  }

}
