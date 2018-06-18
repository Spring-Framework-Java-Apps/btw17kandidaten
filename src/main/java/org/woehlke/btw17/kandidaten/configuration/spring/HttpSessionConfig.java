package org.woehlke.btw17.kandidaten.configuration.spring;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.lang.NonNull;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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

/*
    @Bean
    public HttpSessionIdResolver httpSessionIdResolver() {
        return HeaderHttpSessionIdResolver.xAuthToken();
    }
*/

    @Bean
    public ErrorAttributes errorAttributes(){
        return new DefaultErrorAttributes();
    }

    /*
    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object>  template = new RedisTemplate();
        // explicitly enable transaction support
        boolean enableTransactionSupport = true;
        template.setEnableTransactionSupport(enableTransactionSupport);
        return template;
    }
    */
}
