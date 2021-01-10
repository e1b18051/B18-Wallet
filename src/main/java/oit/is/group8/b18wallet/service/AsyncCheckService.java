package oit.is.group8.b18wallet.service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.group8.b18wallet.model.Income;
import oit.is.group8.b18wallet.model.IncomeMapper;
import oit.is.group8.b18wallet.model.Spend;
import oit.is.group8.b18wallet.model.SpendMapper;

@Service
public class AsyncCheckService {
  boolean dbUpdated = false;

  private final Logger logger = LoggerFactory.getLogger(AsyncCheckService.class);

  @Autowired
  IncomeMapper incomeMapper;
  @Autowired
  SpendMapper spendMapper;

  public ArrayList<Income> syncShowIncomeList() {
    return incomeMapper.getAllIncome();
  }

  public ArrayList<Spend> syncShowSpendList() {
    return spendMapper.getAllSpend();
  }

  /**
   * dbUpdatedがtrueのときのみブラウザにDBからフルーツリストを取得して送付する
   *
   * @param emitter
   */
  @Async
  public void asyncShowIncomeList(SseEmitter emitter) {
    dbUpdated = true;
    try {
      while (true) {
        if (false == dbUpdated) {
          TimeUnit.MILLISECONDS.sleep(500);
          continue;
        }
        ArrayList<Income> incomes2 = this.syncShowIncomeList();
        emitter.send(incomes2);
        TimeUnit.MILLISECONDS.sleep(1000);
        dbUpdated = false;
      }
    } catch (Exception e) {
      // 例外の名前とメッセージだけ表示する
      logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
    } finally {
      emitter.complete();
    }
  }

  /**
   * dbUpdatedがtrueのときのみブラウザにDBからフルーツリストを取得して送付する
   *
   * @param emitter
   */
  @Async
  public void asyncShowSpendList(SseEmitter emitter) {
    dbUpdated = true;
    try {
      while (true) {
        if (false == dbUpdated) {
          TimeUnit.MILLISECONDS.sleep(500);
          continue;
        }
        ArrayList<Spend> spends2 = this.syncShowSpendList();
        TimeUnit.MILLISECONDS.sleep(100);
        emitter.send(spends2);
        TimeUnit.MILLISECONDS.sleep(1000);
        dbUpdated = false;
      }
    } catch (Exception e) {
      // 例外の名前とメッセージだけ表示する
      logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
    } finally {
      emitter.complete();
    }
  }
}
