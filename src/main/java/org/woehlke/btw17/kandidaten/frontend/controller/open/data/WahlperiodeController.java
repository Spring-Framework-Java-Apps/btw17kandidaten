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
import org.woehlke.btw17.kandidaten.frontend.model.enums.PageSymbol;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.model.PageContent;
import org.woehlke.btw17.kandidaten.frontend.model.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.WahlperiodeService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import static org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService.PAGE_SIZE;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlkreis
 */
@Controller
@RequestMapping("/wahlperiode")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class WahlperiodeController extends AbstractController {


    @RequestMapping("/all")
    public String all(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "wp",
                    direction= Sort.Direction.ASC
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Wahlperioden";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.WAHLKREIS.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/wahlperiode/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);
        Page<Wahlperiode> allWahlperiodePage =  wahlperiodeService.getAll(pageable);
        model.addAttribute("wahlperioden", allWahlperiodePage);
        model.addAttribute("pageTitle","Wahlkreise");
        return "wahlperiode/all";
    }

    @RequestMapping("/{id}")
    public String id(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") Wahlperiode wahlperiode,
            Model model
    ) {
        if(wahlperiode == null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            String msg = "url: "+ request.getRequestURL().toString() +" in WahlperiodeController.id";
            throw new EntityNotFoundException(msg);
        } else {
            String pageTitle = wahlperiode.getMdbWahlperiodeBis() + ": " +  wahlperiode.getMdbWahlperiodeVon();
            String pageSubTitle = "Wahlkreise der Bundestagswahl 2017 Direktkandidaten";
            String pageSymbol = PageSymbol.WAHLKREIS.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/wahlperiode/"+wahlperiode.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            String msvalidateKey = kandidatenProperties.getMsvalidateKey();
            String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
            String facebookAppId = kandidatenProperties.getFacebookAppId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss,msvalidateKey,googleSiteVerification,facebookAppId);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("wahlperiode",wahlperiode);
            Page<Kandidat> kandidatenPage  = kandidatService.findByWahlperiode(wahlperiode,pageable);
            model.addAttribute("kandidaten",kandidatenPage);
            return "wahlperiode/id";
        }
    }


    private final WahlperiodeService wahlperiodeService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public WahlperiodeController(SessionHandler sessionHandler, WahlperiodeService wahlperiodeService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.wahlperiodeService = wahlperiodeService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
