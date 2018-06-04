package org.woehlke.btw17.kandidaten.configuration.spring;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories({
    "org.woehlke.btw17.kandidaten.oodm.jpa.repositories"
})
@EnableNeo4jRepositories({
    "org.woehlke.btw17.kandidaten.oodm.graph.repositories"
})
@EnableRedisRepositories({
    "org.woehlke.btw17.kandidaten.oodm.keyvalue.repositories"
})
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
