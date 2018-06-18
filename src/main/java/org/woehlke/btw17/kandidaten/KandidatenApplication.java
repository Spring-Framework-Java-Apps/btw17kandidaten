package org.woehlke.btw17.kandidaten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;


@SpringBootApplication
@EnableConfigurationProperties({
	KandidatenProperties.class,
    OtherProperties.class,
    SpringProperties.class
})
public class KandidatenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KandidatenApplication.class, args);
	}
}
