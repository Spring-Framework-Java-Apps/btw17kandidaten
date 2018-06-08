package org.woehlke.btw17.kandidaten.configuration.spring;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.woehlke.btw17.kandidaten.oodm.jpa")
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "postgresqlTransactionManager",
    basePackages = "org.woehlke.btw17.kandidaten.oodm.jpa.repositories"
)
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class DatabaseJpaConfig {

    private static final Log log = LogFactory.getLog(DatabaseJpaConfig.class);

    private final Environment env;

    public DatabaseJpaConfig(final Environment env) {
        this.env = env;
    }

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("dataSource") DataSource dataSource) {

        return builder
            .dataSource(dataSource)
            .packages("org.woehlke.btw17.kandidaten.oodm.jpa")
            .build();
    }

    @Primary
    @Bean(name = "postgresqlTransactionManager")
    public JpaTransactionManager postgresqlTransactionManager(
        @Qualifier("entityManagerFactory") 	LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }

    @Autowired
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(Neo4jTransactionManager graphTransactionManager,
                                                         JpaTransactionManager postgresqlTransactionManager) {
        log.debug("Initializing platform transaction manager");
        return new ChainedTransactionManager(postgresqlTransactionManager, graphTransactionManager);
    }
}
