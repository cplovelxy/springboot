package study.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/9/22.
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
public class DataSourceConfiguration {

    @Value("${datasource.url}")
    private String url;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.driver-class-name}")
    private String driver;
    @Value("${datasource.maxActive}")
    private Integer maxActive;
    @Value("${datasource.minIdle}")
    private Integer minIdle;
    @Value("${datasource.initialSize}")
    private Integer initialSize;
    @Value("${datasource.maxWait}")
    private Integer maxWait;


    @Bean
    public DataSource configuration() {
        final DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driver);
        dataSource.setInitialSize(this.initialSize);
        dataSource.setMaxActive(this.maxActive);
        dataSource.setMinIdle(this.minIdle);
        dataSource.setPassword(this.password);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setMaxWait(maxWait);

        return dataSource;
    }
}
