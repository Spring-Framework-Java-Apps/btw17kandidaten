package org.woehlke.btw17.kandidaten.configuration.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@Slf4j
@Configuration
@EnableSpringDataWebSupport
@SuppressWarnings("deprecation")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

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
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }

    @Bean
    MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
