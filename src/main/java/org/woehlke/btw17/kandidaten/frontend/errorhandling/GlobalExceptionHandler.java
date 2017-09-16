package org.woehlke.btw17.kandidaten.frontend.errorhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.woehlke.btw17.kandidaten.configuration.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler extends SimpleMappingExceptionResolver {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView notFound(HttpServletRequest request, Exception ex) {
        log.warn("EntityNotFoundException occured :: URL=" + request.getRequestURL());
        log.warn(ex.getMessage());
        return getTemplate(request, ex, HttpStatus.NOT_FOUND);
    }

/*
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView exception(final HttpServletRequest request, final Throwable throwable, final Model model) {
        log.error("Exception during execution of SpringMVC application", throwable);
        ModelAndView mav = new ModelAndView();
        String pageTitle = HttpStatus.INTERNAL_SERVER_ERROR.toString() + " Throwable";
        String pageSubTitle = throwable.getMessage();
        String pageSymbol = PageSymbol.EXCEPTION.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = request.getRequestURL().toString();
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        mav.addObject("pageContent",pageContent);
        mav.addObject("exception", throwable);
        mav.setViewName("exceptionhandler/exceptionhandler");
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        mav.addObject("errorMessage", errorMessage);
        return mav;
    }
*/

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleIllegalArgumentException(HttpServletRequest request, Exception ex) {
        log.warn("IllegalArgumentException occured :: URL=" + request.getRequestURL());
        log.warn(ex.getMessage());
        return getTemplate(request, ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleIOException(HttpServletRequest request, Exception ex) {
        log.warn("IOException occured :: URL=" + request.getRequestURL());
        log.warn(ex.getMessage());
        return getTemplate(request, ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleNullPointerException(HttpServletRequest request, Exception ex) {
        log.warn("NullPointerException occured :: URL=" + request.getRequestURL());
        log.warn(ex.getMessage());
        return getTemplate(request, ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SpelEvaluationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleSpelEvaluationException(HttpServletRequest request, Exception ex) {
        log.warn("SpelEvaluationException occured :: URL=" + request.getRequestURL());
        log.warn(ex.getMessage());
        return getTemplate(request, ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TemplateProcessingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleTemplateProcessingException(HttpServletRequest request, Exception ex) {
        log.warn("TemplateProcessingException occured :: URL=" + request.getRequestURL());
        log.warn(ex.getMessage());
        return getTemplate(request, ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ModelAndView getTemplate(HttpServletRequest request, Exception ex, HttpStatus httpStatus) {
        ModelAndView mav = new ModelAndView();
        String pageTitle = httpStatus.toString() +" Exception";
        String pageSubTitle = ex.getMessage();
        String pageSymbol = PageSymbol.EXCEPTION.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = request.getRequestURL().toString();
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        mav.addObject("pageContent",pageContent);
        mav.addObject("exception", ex);
        mav.setViewName("exceptionhandler/exceptionhandler");
        return mav;
    }

    @Autowired
    public GlobalExceptionHandler(KandidatenProperties kandidatenProperties) {
        this.kandidatenProperties = kandidatenProperties;
    }

    private final KandidatenProperties kandidatenProperties;

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
}
