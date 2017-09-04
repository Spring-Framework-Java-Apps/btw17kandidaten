package org.woehlke.btw17.kandidaten.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @RequestMapping
    public String getAll(Model model) {
        String pageTitle = "Bundestagswahl 2017";
        String pageSubTitle = "Alle 2559 Direktkandidaten";
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/welcome";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        return "welcome/welcome";
    }


    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public WelcomeController(KandidatenProperties kandidatenProperties) {
        this.kandidatenProperties = kandidatenProperties;
    }
}
