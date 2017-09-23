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
import org.woehlke.btw17.kandidaten.oodm.model.Geburtsort;
import org.woehlke.btw17.kandidaten.oodm.service.GeburtsortService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Geburtsort
 */
@Controller
@RequestMapping("/redaktion/geburtsort")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class GeburtsortRedaktionController extends AbstractController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "geburtsort"
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Geburtsort";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.GEBURTSORT.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/redaktion/geburtsort/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);
        Page<Geburtsort> allGeburtsortPage =  geburtsortService.getAll(pageable);
        model.addAttribute("geburtsorte", allGeburtsortPage);
        model.addAttribute("pageTitle","Geburtsorte");
        return "geburtsort/all";
    }

    private final GeburtsortService geburtsortService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public GeburtsortRedaktionController(SessionHandler sessionHandler, GeburtsortService geburtsortService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.geburtsortService = geburtsortService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
