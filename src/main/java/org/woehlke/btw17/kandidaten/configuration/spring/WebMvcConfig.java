package org.woehlke.btw17.kandidaten.configuration.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;


@Configuration
@EnableWebMvc
@EnableWebSecurity
@EnableSpringDataWebSupport
@EnableConfigurationProperties({
    KandidatenProperties.class,
    OtherProperties.class,
    SpringProperties.class
})
public class WebMvcConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/welcome");
        registry.addViewController("/adm").setViewName("redirect:/report/overview");
        registry.addViewController("/regierung/kanzleramt").setViewName("redirect:/ministerium/15");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/*").addResourceLocations("classpath:/public/css/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/public/css/");
        registry.addResourceHandler("/icon/*").addResourceLocations("classpath:/public/icon/");
        registry.addResourceHandler("/icon/**").addResourceLocations("classpath:/public/icon/");
        registry.addResourceHandler("/img/*").addResourceLocations("classpath:/public/img/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/public/img/");
        registry.addResourceHandler("/js/*").addResourceLocations("classpath:/public/js/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/public/js/");
        registry.addResourceHandler("/map-icons/*").addResourceLocations("classpath:/public/map-icons/");
        registry.addResourceHandler("/map-icons/**").addResourceLocations("classpath:/public/map-icons/");
        registry.addResourceHandler("/webjars/*").addResourceLocations("/webjars/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(
                kandidatenProperties.getWebSecurityConfigPublicPathsAsArray()
            )
            .permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .failureForwardUrl("/login")
            .defaultSuccessUrl("/adm")
            .permitAll()
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/logout_success")
            .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String user = kandidatenProperties.getLoginUsername();
        String pwd = kandidatenProperties.getLoginPassword();
        String role = "USER";
        auth
            .inMemoryAuthentication()
            .withUser(user).password(pwd).roles(role);
    }


    @Autowired
    public WebMvcConfig(KandidatenProperties kandidatenProperties) {
        this.kandidatenProperties = kandidatenProperties;
    }

    private final KandidatenProperties kandidatenProperties;

}
