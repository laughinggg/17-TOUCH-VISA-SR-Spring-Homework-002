package homework.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatebaseConfiguration {

    @Bean
    @Profile("production")
    public DataSource dataSource() {
        DriverManagerDataSource dmd = new DriverManagerDataSource();
        dmd.setDriverClassName("org.postgresql.Driver");
        dmd.setUrl("jdbc:postgresql://localhost:5432/practice");
        dmd.setUsername("postgres");
        dmd.setPassword("098098");
        return dmd;
    }

    @Bean
    @Profile("development")
    public DataSource development() {
        EmbeddedDatabaseBuilder db = new EmbeddedDatabaseBuilder();
        db.setType(EmbeddedDatabaseType.H2);
        db.addScript("sql/table.sql");
        db.addScript("sql/insert.sql");
        return db.build();
    }
}
