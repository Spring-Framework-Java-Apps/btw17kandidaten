package org.woehlke.btw17.kandidaten.frontend.controller.redaktion.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.WebseiteAgenturService;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur
 */
@Controller
@RequestMapping("/redaktion/webseite/agentur")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class WebseiteAgenturRedaktionController extends AbstractController {


    @RequestMapping("/all")
    public String all(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "agentur"
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Web Agenturen";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.WOHNORT.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/redaktion/webseite/agentur/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);
        Page<WebseiteAgentur> allWebseiteAgenturPage =  webseiteAgenturService.getAll(pageable);
        model.addAttribute("allWebseiteAgenturPage", allWebseiteAgenturPage);
        return "webseite/agentur/all";
    }

    private final WebseiteAgenturService webseiteAgenturService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public WebseiteAgenturRedaktionController(KandidatService kandidatService, KandidatenProperties kandidatenProperties, SessionHandler sessionHandler, WebseiteAgenturService webseiteAgenturService) {
        super(sessionHandler);
        this.webseiteAgenturService = webseiteAgenturService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }

}
