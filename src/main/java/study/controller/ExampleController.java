package study.controller;

import org.apache.ibatis.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.dao.IUserDao;
import study.service.ExampleService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/15.
 */
@RestController
public class ExampleController {
    @Resource
    private ExampleService service;
    @Resource
    private JdbcTemplate JdbcTemplate;
    @Resource
    private IUserDao userDao;

    @RequestMapping(value = "/")
    public String  index(){
        return "forward:/static/home.html";
    }

    @RequestMapping(value = "/select")
    public String test(){
        String sql = "select name from user limit 1";
        LogFactory.useLog4JLogging();
        return JdbcTemplate.queryForObject(sql,new Object[]{},String.class);
    }

    @RequestMapping(value = "/annotion")
    public void testAnnotion(){
        service.test();
    }

    @RequestMapping(value = "/annotion_mybatis")
    public String annotionMybatis(){
        return userDao.select();
    }

}
