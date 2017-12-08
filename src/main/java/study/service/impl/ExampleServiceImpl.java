package study.service.impl;

import org.springframework.stereotype.Service;
import study.service.ExampleService;

/**
 * Created by Administrator on 2017/8/18.
 */
@Service
public class ExampleServiceImpl implements ExampleService {
    @Override
    public void test() {
        System.out.println("test ...");
    }
}
