package oit.is.group8.b18wallet.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SpendMapper {

  @Select("SELECT * from spend")
  ArrayList<Spend> getAllSpend();

  @Select("SELECT * from spend WHERE ID = #{id}")
  Spend selectById(int id);

  @Select("SELECT count (*) from spend")
  int countSpend();

  @Select("SELECT Sum(money) from spend")
  int sumSpend();

  @Select("SELECT * from spend WHERE date = #{date}")
  ArrayList<Spend> getAllByDate(String date);

  @Insert("INSERT INTO spend (user_id, date, money, memo) VALUES (#{user_id},#{date},#{money},#{memo});")
  void insertSpend(Spend spend);

  /**
   * @param id
   * @return
   */
  @Delete("DELETE FROM spend WHERE id =#{id}")
  boolean deleteById(int id);

  /**
   *
   * @param spend
   */
  @Update("UPDATE SPEND SET DATE=#{date}, MONEY=#{money}, MEMO=#{memo} WHERE ID = #{id}")
  void updateById(Spend spend);
}
