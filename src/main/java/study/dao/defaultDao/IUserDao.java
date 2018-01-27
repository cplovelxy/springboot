package study.dao.defaultDao;

import org.apache.ibatis.annotations.Select;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface IUserDao {

    @Select("select name from user limit 1")
    String select();
}
