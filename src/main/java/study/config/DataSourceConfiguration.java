package study.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Name;
import javax.sql.DataSource;

/**
 * Created by cp on 2017/9/22.
 */
@Configuration
@MapperScan(basePackages = DataSourceConfiguration.DEFAULTPACK, sqlSessionTemplateRef = DataSourceConfiguration.SQLSESSIONTEMPLATEREF)
public class DataSourceConfiguration extends AbstractDataSource {
    public static final String SQLSESSIONTEMPLATEREF = "defaultSqlSessionTemplate";
    public static final String DEFAULTPACK = "study.dao.defaultDao";
    public static final String DEFAULTMAPPER = "classpath:mapper/default/*.xml";

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

    @Bean(name = "defaultDataSource")
    public DataSource dataSource() {
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
    @Transactional
    @Bean(name = "defaultSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "defaultDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConfiguration.DEFAULTMAPPER));

        return factoryBean.getObject();
    }

    @Bean(name = "defaultTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier(value = "defaultDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "defaultSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(value = "defaultSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
