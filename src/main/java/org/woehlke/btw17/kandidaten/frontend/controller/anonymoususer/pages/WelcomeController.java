package org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.woehlke.btw17.kandidaten.configuration.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;

@Controller
@RequestMapping("/welcome")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class WelcomeController extends AbstractController {

    @RequestMapping
    public String welcome(Model model) {
        String pageTitle = "Bundestagswahl 2017";
        String pageSubTitle = "Alle 2559 Direktkandidaten";
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/welcome";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);
        return "welcome/welcome";
    }


    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public WelcomeController(SessionHandler sessionHandler, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.kandidatenProperties = kandidatenProperties;
    }
}
