package org.woehlke.btw17.kandidaten.frontend.controller;

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
@RequestMapping("/datenschutz")
public class DatenschutzController {


    @RequestMapping
    public String getAll(HttpSession session, Model model) {
        String pageTitle = "Datenschutz";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.DATENSCHUTZ.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/datenschutz";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.WAHLZETTEL_BRIEFWAHL;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "imprint/datenschutz";
    }


    private final KandidatenProperties kandidatenProperties;

    private final SessionHandler sessionHandler;

    @Autowired
    public DatenschutzController(KandidatenProperties kandidatenProperties, SessionHandler sessionHandler) {
        this.kandidatenProperties = kandidatenProperties;
        this.sessionHandler = sessionHandler;
    }
}
