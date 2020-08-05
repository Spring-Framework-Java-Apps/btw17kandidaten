package org.woehlke.btw17.kandidaten.frontend.controller.open.errors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.AbstractErrorController;
//import org.springframework.boot.autoconfigure.web.ErrorAttributes;
//import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.woehlke.btw17.kandidaten.frontend.model.enums.JumbotronImage;
import org.woehlke.btw17.kandidaten.frontend.model.enums.PageSymbol;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
//import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.frontend.model.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.model.PageContent;
import org.woehlke.btw17.kandidaten.frontend.model.SearchForKandidat;
import org.woehlke.btw17.kandidaten.frontend.model.SessionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("${server.error.path:/error}")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class ErrorController extends AbstractErrorController {

    @RequestMapping(produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request,
                                  HttpServletResponse response, Exception exception) {
        HttpStatus status = getStatus(request);
        boolean isIncludeStackTrace = true;
        Map<String, Object> model = getErrorAttributes(
                request, isIncludeStackTrace);
        response.setStatus(status.value());

        String msg = "url: "+ request.getRequestURL().toString();
        log.error(msg);
        String pageTitle = "Fehler";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.ERROR.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = request.getRequestURL().toString();
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.WAHLZETTEL_BRIEFWAHL;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.put("pageContent",pageContent);
        model.put("ex",exception);
        ModelAndView modelAndView = resolveErrorView(request, response, status, Collections.unmodifiableMap(model));
        modelAndView = (modelAndView == null ? new ModelAndView("exceptionhandler/error", Collections.unmodifiableMap(model)) : modelAndView);
        modelAndView.setViewName("exceptionhandler/error");
        return modelAndView;
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        boolean isIncludeStackTrace = false;
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace);
        HttpStatus status = getStatus(request);
        return new ResponseEntity<Map<String, Object>>(body, status);
    }

    @Autowired
    public ErrorController(ErrorAttributes errorAttributes, SessionHandler sessionHandler, KandidatenProperties kandidatenProperties) {
        this(errorAttributes,
                Collections.<ErrorViewResolver>emptyList(),sessionHandler,kandidatenProperties);
    }


    private ErrorController(ErrorAttributes errorAttributes, List<ErrorViewResolver> errorViewResolvers, SessionHandler sessionHandler, KandidatenProperties kandidatenProperties) {
        super(errorAttributes, errorViewResolvers);
        this.kandidatenProperties = kandidatenProperties;
        this.sessionHandler = sessionHandler;
    }

    @Override
    public String getErrorPath() {
        return "/error"; //otherProperties.getServer().getError().getPath();
    }

    @ModelAttribute("suchformularFreitext")
    public FreitextSucheFormular addSuchformularFreitext(HttpSession session, Model model) {
        log.debug("addSuchformularFreitext");
        FreitextSucheFormular suchformularFreitext = sessionHandler.fetchOrCreateFreitextSucheFormular(session,model);
        return suchformularFreitext;
    }

    @ModelAttribute("suchformular")
    public SearchForKandidat addSuchformular(HttpSession session, Model model) {
        log.debug("suchformular");
        SearchForKandidat suchformular = sessionHandler.fetchOrCreateSucheFormular(session,model);
        return suchformular;
    }

    private static final Logger log = LoggerFactory.getLogger(ErrorController.class);

    private final SessionHandler sessionHandler;

    private final KandidatenProperties kandidatenProperties;
}
