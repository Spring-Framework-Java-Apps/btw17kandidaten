package org.woehlke.btw17.kandidaten.frontend.controller.open.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.woehlke.btw17.kandidaten.frontend.model.enums.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.model.PageContent;
import org.woehlke.btw17.kandidaten.frontend.model.enums.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.model.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.db.model.Geburtsort;
import org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.db.service.GeburtsortService;
import org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.PAGE_SIZE;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.db.model.Geburtsort
 */
@Controller
@RequestMapping("/geburtsort")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class GeburtsortController extends AbstractController {

    @RequestMapping("/all")
    public String all(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "geburtsort",
                    direction= Sort.Direction.ASC
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Geburtsort";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.GEBURTSORT.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/geburtsort/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);
        Page<Geburtsort> allGeburtsortPage =  geburtsortService.getAll(pageable);
        model.addAttribute("geburtsorte", allGeburtsortPage);
        model.addAttribute("pageTitle","Geburtsorte");
        return "geburtsort/all";
    }

    @RequestMapping("/{id}")
    public String id(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") Geburtsort geburtsort,
            Model model
    ) {
        if(geburtsort == null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            String msg = "url: "+ request.getRequestURL().toString() +" in GeburtsortController.id";
            throw new EntityNotFoundException(msg);
        } else {
            String pageTitle = geburtsort.getGeburtsort();
            String pageSubTitle = "Geburtsorte der Bundestagswahl 2017 Direktkandidaten";
            String pageSymbol = PageSymbol.GEBURTSORT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/geburtsort/"+geburtsort.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            String msvalidateKey = kandidatenProperties.getMsvalidateKey();
            String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
            String facebookAppId = kandidatenProperties.getFacebookAppId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("geburtsort",geburtsort);
            Page<Kandidat> kandidatenPage  = kandidatService.findByGeburtsort(geburtsort,pageable);
            model.addAttribute("kandidaten",kandidatenPage);
            return "geburtsort/id";
        }
    }

    private final GeburtsortService geburtsortService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public GeburtsortController(SessionHandler sessionHandler, GeburtsortService geburtsortService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.geburtsortService = geburtsortService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
