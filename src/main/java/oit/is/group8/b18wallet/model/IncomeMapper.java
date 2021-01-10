package oit.is.group8.b18wallet.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IncomeMapper {

  @Select("SELECT * from income")
  ArrayList<Income> getAllIncome();

  @Select("SELECT * from income WHERE ID = #{id}")
  Income selectById(int id);

  @Select("SELECT count (*) from income")
  int countIncome();

  @Select("SELECT Sum(money) from income")
  int sumIncome();

  @Select("SELECT * from income WHERE date = #{date}")
  ArrayList<Income> getAllByDate(String date);

  @Insert("INSERT INTO income (user_id, date, money, memo) VALUES (#{user_id},#{date},#{money},#{memo});")
  void insertIncome(Income income);

  /**
   * @param id
   * @return
   */
  @Delete("DELETE FROM income WHERE id =#{id}")
  boolean deleteById(int id);

  /**
   *
   * @param income
   */
  @Update("UPDATE INCOME SET DATE=#{date}, MONEY=#{money}, MEMO=#{memo} WHERE ID = #{id}")
  void updateById(Income income);
}
