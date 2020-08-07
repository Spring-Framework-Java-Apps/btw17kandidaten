package org.woehlke.btw17.kandidaten.configuration.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@Configuration
@EnableJpaRepositories({
    "org.woehlke.btw17.kandidaten.oodm.repositories"
})
public class JdbcDataSourceConfig {
}
