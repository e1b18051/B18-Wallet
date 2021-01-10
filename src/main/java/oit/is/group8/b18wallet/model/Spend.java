package oit.is.group8.b18wallet.model;

public class Spend {
  int id;
  String user_id;
  String date;
  int money;
  String memo;

  public Spend() {
  }

  public Spend(int id2, String date2, int money2, String memo2) {
    this.id = id2;
    //this.user_id = user_id2;
    this.date = date2;
    this.money = money2;
    this.memo = memo2;
  }

  // Thymeleafでフィールドを扱うためにはgetter/setterが必ず必要
  // vscodeのソースコード右クリック->ソースアクションでsetter/getterを簡単に追加できる
  public String getUser_id() {
    return user_id;
  }

  public void setUser(String user_id) {
    this.user_id = user_id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
