package org.woehlke.btw17.kandidaten.configuration.spring;

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
        org.neo4j.ogm.config.Configuration.Builder builder = new org.neo4j.ogm.config.Configuration.Builder();
        org.neo4j.ogm.config.Configuration configuration = builder.build();    // .setURI("http://neo4j:neo4j@localhost:7474");
        return configuration;
    }
}
