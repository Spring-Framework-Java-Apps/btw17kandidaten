package org.woehlke.btw17.kandidaten.frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session, Model model) {
        log.info("-----------------------------------------");
        String pageTitle = "Login";
        String pageSubTitle = "Geben Sie Ihre Zugangsdaten ein:";
        String pageSymbol = PageSymbol.LOGIN.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/login";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_INNEN_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);
        log.info("-----------------------------------------");
        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "login/login";
    }

    @Autowired
    public LoginController(KandidatenProperties kandidatenProperties, SessionHandler sessionHandler) {
        this.kandidatenProperties = kandidatenProperties;
        this.sessionHandler = sessionHandler;
    }

    private final KandidatenProperties kandidatenProperties;

    private final SessionHandler sessionHandler;

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

}
