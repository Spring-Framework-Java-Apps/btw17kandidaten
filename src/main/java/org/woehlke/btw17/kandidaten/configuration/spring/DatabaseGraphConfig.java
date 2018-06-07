package org.woehlke.btw17.kandidaten.configuration.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("org.woehlke.btw17.kandidaten.oodm.graph.repositories")
@EnableNeo4jRepositories(
    sessionFactoryRef = "getSessionFactory",
    transactionManagerRef = "graphTransactionManager",
    basePackages = "com.company.project.repository.graph")
public class DatabaseGraphConfig {

    private static final Log log = LogFactory.getLog(DatabaseGraphConfig.class);


    @Bean(name = "getSessionFactory")
    public SessionFactory graphSessionFactory() {
        return new SessionFactory(configuration(), 	"org.woehlke.btw17.kandidaten.oodm.graph");
    }

    @Bean(name = "graphTransactionManager")
    public Neo4jTransactionManager graphTransactionManager(
        @Qualifier("getSessionFactory")
            SessionFactory sessionFactory) {
        return new Neo4jTransactionManager(sessionFactory);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.data.neo4j")
    public org.neo4j.ogm.config.Configuration configuration() {
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
            .verifyConnection(true)
            .uri("bolt://localhost")
            .credentials("neo4j", "secret")
            .build();
        log.info("###############################################################################################");
        log.info("  configuration.getDriverClassName                "+configuration.getDriverClassName());
        log.info("  configuration.getURI                            "+configuration.getURI());
        log.info("  configuration.getCredentials                    "+configuration.getCredentials().toString());
        log.info("  configuration.getAutoIndex                      "+configuration.getAutoIndex().getName());
        log.info("  configuration.getVerifyConnection               "+configuration.getVerifyConnection());
        log.info("  configuration.getConnectionLivenessCheckTimeout "+configuration.getConnectionLivenessCheckTimeout());
        log.info("  configuration.getConnectionPoolSize             "+configuration.getConnectionPoolSize());
        log.info("  configuration.getDumpDir                        "+configuration.getDumpDir());
        log.info("  configuration.getDumpFilename                   "+configuration.getDumpFilename());
        log.info("###############################################################################################");
        return configuration;
    }
}
