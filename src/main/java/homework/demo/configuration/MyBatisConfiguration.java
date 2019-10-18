package homework.demo.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan("homework.demo.repository")
public class MyBatisConfiguration {

    private DataSource ds;

    @Autowired
    public MyBatisConfiguration(DataSource dataSource) {
        this.ds = dataSource;
    }

    @Bean
    public DataSourceTransactionManager dts() {
        return new DataSourceTransactionManager(ds);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        return factoryBean;
    }

}
