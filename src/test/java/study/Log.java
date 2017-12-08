package study;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Administrator on 2017/11/2.
 */
public class Log {
    Logger logger = Logger.getLogger(Log.class);


    @Test
    public void test(){
       logger.debug("asdddddddddddddddd");
    }


}
