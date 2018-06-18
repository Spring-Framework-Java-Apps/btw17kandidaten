package org.woehlke.btw17.kandidaten.configuration.spring;


import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.ogm.config.AutoIndexMode;
import org.neo4j.ogm.driver.Driver;
import org.neo4j.ogm.drivers.bolt.driver.BoltDriver;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;



@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(
    basePackages = {
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.commons",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.kandidaten",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.mdb",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.online",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.organisationen",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite"
    },
    transactionManagerRef = "neo4jTransactionManager"
)
@EnableJpaRepositories(
    basePackages = {
        "org.woehlke.btw17.kandidaten.oodm.jpa.repositories",
        "org.woehlke.btw17.kandidaten.oodm.jpa.repositories.commons",
        "org.woehlke.btw17.kandidaten.oodm.jpa.repositories.impl"
    },
    transactionManagerRef = "jpaTransactionManager"
)
@EnableRedisRepositories(
    basePackages = {
        "org.woehlke.btw17.kandidaten.oodm.keyvalue.repositories"
    }
)
@EnableConfigurationProperties({
    KandidatenProperties.class,
    OtherProperties.class,
    SpringProperties.class
})
//@ComponentScan("org.woehlke.btw17.kandidaten.oodm.jpa")
public class Neo4jConfiguration {

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        org.neo4j.ogm.config.Configuration.Builder builder = new org.neo4j.ogm.config.Configuration.Builder();
        builder.uri("bolt://127.0.0.1:7687");
        builder.credentials("neo4j","secret");
        builder.autoIndex(AutoIndexMode.NONE.getName());
        return builder.build();
    }

    @Bean
    public SessionFactory sessionFactory(
       final org.neo4j.ogm.config.Configuration configuration
    ) {
        String[] packages = {
            "org.woehlke.btw17.kandidaten.oodm.graph.model.btw17",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.commons",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.enums",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.geographie",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.mdb",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.online",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.parts",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.webseite",
            "org.woehlke.btw17.kandidaten.oodm.all.model.commons"
        };
        Driver driver = new BoltDriver();
        SessionFactory sessionFactory = new SessionFactory(driver, packages);
        return sessionFactory;
    }

    @Bean
    public Neo4jTransactionManager neo4jTransactionManager(
        final SessionFactory sessionFactory
    ) {
        return new Neo4jTransactionManager(sessionFactory);
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager(
        final EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }


    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
        final Neo4jTransactionManager neo4jTransactionManager,
        final JpaTransactionManager jpaTransactionManager
    ) {
        log.info("Initializing platform transaction manager: ");
        return new ChainedTransactionManager(jpaTransactionManager, neo4jTransactionManager);
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {

        return new JedisConnectionFactory();
    }

    private static final Log log = LogFactory.getLog(Neo4jConfiguration.class);

}
