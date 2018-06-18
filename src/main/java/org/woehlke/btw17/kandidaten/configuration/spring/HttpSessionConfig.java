package org.woehlke.btw17.kandidaten.configuration.spring;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;

@Configuration
@EnableRedisHttpSession
@EnableConfigurationProperties({
    KandidatenProperties.class,
    OtherProperties.class,
    SpringProperties.class
})
@EnableRedisRepositories(
    basePackages = {
        "org.woehlke.btw17.kandidaten.oodm.keyvalue.repositories"
    }
)
public class HttpSessionConfig extends RedisHttpSessionConfiguration {

    @Bean
    public ErrorAttributes errorAttributes(){
        return new DefaultErrorAttributes();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object>  template = new RedisTemplate();
        // explicitly enable transaction support
        boolean enableTransactionSupport = true;
        template.setEnableTransactionSupport(enableTransactionSupport);
        return template;
    }
}
