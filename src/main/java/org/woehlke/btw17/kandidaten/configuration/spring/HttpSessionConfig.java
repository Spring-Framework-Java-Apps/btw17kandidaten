package org.woehlke.btw17.kandidaten.configuration.spring;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
//import org.springframework.session.jdbc.config.annotation.web.http.JdbcHttpSessionConfiguration;

@Slf4j
@Configuration
@EnableJdbcHttpSession
@EnableJpaRepositories({
    "org.woehlke.btw17.kandidaten.oodm.repositories"
})
public class HttpSessionConfig /*extends JdbcHttpSessionConfiguration*/ {

    @Bean
    public ErrorAttributes errorAttributes(){
        return new DefaultErrorAttributes();
    }

}
