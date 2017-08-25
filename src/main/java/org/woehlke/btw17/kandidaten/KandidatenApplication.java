package org.woehlke.btw17.kandidaten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;


@SpringBootApplication
@EnableConfigurationProperties({
	KandidatenProperties.class
})
@EnableSpringDataWebSupport
public class KandidatenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KandidatenApplication.class, args);
	}
}
