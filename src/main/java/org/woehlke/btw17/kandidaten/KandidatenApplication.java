package org.woehlke.btw17.kandidaten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;


@SpringBootApplication
@EnableConfigurationProperties({
	KandidatenProperties.class,
    OtherProperties.class,
    SpringProperties.class
})
@EnableJpaRepositories({
    "org.woehlke.btw17.kandidaten.oodm.jpa.repositories"
})
@EnableNeo4jRepositories({
    "org.woehlke.btw17.kandidaten.oodm.graph.repositories"
})
@EnableRedisRepositories({
    "org.woehlke.btw17.kandidaten.oodm.keyvalue.repositories"
})
@EnableSpringDataWebSupport
public class KandidatenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KandidatenApplication.class, args);
	}
}
