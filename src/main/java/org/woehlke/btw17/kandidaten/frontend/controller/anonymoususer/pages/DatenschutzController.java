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
@RequestMapping("/datenschutz")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class DatenschutzController extends AbstractController {


    @RequestMapping
    public String getAll(Model model) {
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
        return "imprint/datenschutz";
    }

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public DatenschutzController(SessionHandler sessionHandler, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.kandidatenProperties = kandidatenProperties;
    }
}
