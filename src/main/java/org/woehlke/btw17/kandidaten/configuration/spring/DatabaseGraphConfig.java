package org.woehlke.btw17.kandidaten.configuration.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.ogm.config.AutoIndexMode;
import org.neo4j.ogm.config.UsernamePasswordCredentials;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;

/*
@Configuration
@EnableTransactionManagement
@ComponentScan("org.woehlke.btw17.kandidaten.oodm.graph")
@EnableNeo4jRepositories(
    sessionFactoryRef = "graphSessionFactory",
    transactionManagerRef = "graphTransactionManager",
    basePackages = {
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.btw17",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.geographie",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.kandidaten",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.mdb",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.organisationen",
        "org.woehlke.btw17.kandidaten.oodm.graph.repositories.webseite"
    }
)
*/
public class DatabaseGraphConfig {
/*
    private static final Log log = LogFactory.getLog(DatabaseGraphConfig.class);

    @Autowired
    @Bean
    public SessionFactory graphSessionFactory(SpringProperties springProperties) {
        org.neo4j.ogm.config.Configuration conf = configuration(springProperties);
        log.info("getSessionFactory: configuration "+conf);
        return new SessionFactory(conf,
            "org.woehlke.btw17.kandidaten.oodm.graph.model.btw17",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.geographie",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.mdb",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.parts",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.webseite",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.enums",
            "org.woehlke.btw17.kandidaten.oodm.graph.model.commons"
        );
    }

    @Bean(name = "graphTransactionManager")
    public Neo4jTransactionManager graphTransactionManager(
        @Qualifier("graphSessionFactory")
            SessionFactory sessionFactory) {
        return new Neo4jTransactionManager(sessionFactory);
    }

    @Autowired
    @Bean
    @ConfigurationProperties(prefix = "spring.data.neo4j")
    public org.neo4j.ogm.config.Configuration configuration(SpringProperties springProperties) {
        //Integer connectionLivenessCheckTimeout = new Integer(1000);
        //Boolean verifyConnection = true;
        String uri = springProperties.getData().getNeo4j().getUri();
        String user = springProperties.getData().getNeo4j().getUsername();
        String password = springProperties.getData().getNeo4j().getPassword();
        //String uris[] = {"bolt+routing://localhost"};
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
            //.verifyConnection(verifyConnection)
            //.connectionPoolSize(120)
            //.connectionLivenessCheckTimeout(connectionLivenessCheckTimeout)
            .autoIndex(AutoIndexMode.ASSERT.getName())
            .uri(uri)
            //.uris(uris)
            .credentials(user, password)
            //.encryptionLevel(org.neo4j.driver.v1.Config.EncryptionLevel.NONE.name())
            //.trustStrategy(org.neo4j.driver.v1.Config.TrustStrategy.Strategy.TRUST_ALL_CERTIFICATES.name())
            //.neo4jHaPropertiesFile("neo4j_ha.properties")
            .build();
        UsernamePasswordCredentials c = (UsernamePasswordCredentials) configuration.getCredentials();
        log.info("###############################################################################################");
        log.info("  configuration.getDriverClassName                "+configuration.getDriverClassName());
        log.info("  configuration.getURI                            "+configuration.getURI());
        log.info("  configuration.getCredentials                    "+c.getUsername()+" "+c.getPassword());
        log.info("  configuration.getAutoIndex                      "+configuration.getAutoIndex().getName());
        log.info("  configuration.getVerifyConnection               "+configuration.getVerifyConnection());
        log.info("  configuration.getConnectionLivenessCheckTimeout "+configuration.getConnectionLivenessCheckTimeout());
        log.info("  configuration.getConnectionPoolSize             "+configuration.getConnectionPoolSize());
        log.info("  configuration.getDumpDir                        "+configuration.getDumpDir());
        log.info("  configuration.getDumpFilename                   "+configuration.getDumpFilename());
        log.info("  configuration.getTrustStrategy                  "+configuration.getTrustStrategy());
        log.info("  configuration.getEncryptionLevel                "+configuration.getEncryptionLevel());
        log.info("  configuration.getAutoIndex                      "+configuration.getAutoIndex().getName());
        log.info("  configuration.getNeo4jHaPropertiesFile          "+configuration.getNeo4jHaPropertiesFile());
        log.info("  configuration.getTrustCertFile                  "+configuration.getTrustCertFile());
        / *
        for(String myUri: configuration.getURIS()){
            log.info("  configuration.getURIS                           "+myUri);
        }
        * /
        log.info("###############################################################################################");
        return configuration;
    }

    */
}
