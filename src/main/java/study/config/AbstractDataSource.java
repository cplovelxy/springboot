package study.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by ping on 2018/1/27.
 */
public abstract class AbstractDataSource {

    abstract DataSource dataSource();

    abstract SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception;

    abstract DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource);

    abstract SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory);
}
