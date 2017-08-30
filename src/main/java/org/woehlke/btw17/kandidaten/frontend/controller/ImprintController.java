package org.woehlke.btw17.kandidaten.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;

@Controller
@RequestMapping("/imprint")
public class ImprintController {


    @RequestMapping
    public String getAll(Model model) {
        String pageTitle = "Impressum";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.IMPRESSUM.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/imprint";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        return "imprint/imprint";
    }


    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public ImprintController(KandidatenProperties kandidatenProperties) {
        this.kandidatenProperties = kandidatenProperties;
    }
}
