package study.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import study.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface IUserDao {

    @Select("select name from user limit 1")
    String select();
}
