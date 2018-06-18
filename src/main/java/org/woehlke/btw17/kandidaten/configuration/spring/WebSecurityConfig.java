package org.woehlke.btw17.kandidaten.configuration.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;

/*
@Configuration
@EnableWebSecurity
@EnableRedisWebSession
@EnableRedisHttpSession
@EnableSpringDataWebSupport
*/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

}
