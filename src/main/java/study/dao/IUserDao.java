package study.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface IUserDao {

    @Select("select userName from user limit 1")
    String select();

    String getUserById();

    @Insert("insert into tasks (subject) values ('test')")
    void insert();
}
