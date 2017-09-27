package org.woehlke.btw17.kandidaten.configuration.spring;


import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.jdbc.config.annotation.web.http.JdbcHttpSessionConfiguration;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories({
    "org.woehlke.btw17.kandidaten.oodm.repositories",
    "org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.repositories"
})
public class DataSourceConfig extends JdbcHttpSessionConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
