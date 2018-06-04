package org.woehlke.btw17.kandidaten.frontend.controller.closed.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.woehlke.btw17.kandidaten.frontend.model.enums.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.model.enums.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.model.PageContent;
import org.woehlke.btw17.kandidaten.frontend.model.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.AusschussService;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService;

import static org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService.PAGE_SIZE;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.jpa.model.Ausschuss
 */
@Controller
@RequestMapping("/redaktion/ausschuss")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class AusschussRedaktionController extends AbstractController {

    @RequestMapping("/all")
    public String all(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "ausschuss"
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Ausschüsse";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.AUSSCHUSS.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/redaktion/ausschuss/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);

        Page<Ausschuss> pageAllAusschuss =  ausschussService.getAll(pageable);
        model.addAttribute("ausschuesse", pageAllAusschuss);
        return "ausschuss/all";
    }

    private final AusschussService ausschussService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;


    @Autowired
    public AusschussRedaktionController(SessionHandler sessionHandler, AusschussService ausschussService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.ausschussService = ausschussService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
