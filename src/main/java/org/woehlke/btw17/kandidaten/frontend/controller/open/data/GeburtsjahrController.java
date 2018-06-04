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
import org.woehlke.btw17.kandidaten.frontend.model.enums.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.model.PageContent;
import org.woehlke.btw17.kandidaten.frontend.model.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import java.time.LocalDate;

import static org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.jpa.service.KandidatService.PAGE_SIZE;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.jpa.model.Kandidat#geburtsjahr
 */
@Controller
@RequestMapping("/geburtsjahr")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class GeburtsjahrController extends AbstractController {

    @RequestMapping("/all")
    public String all(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT,
                    direction= Sort.Direction.ASC
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Geburtsjahre ";
        String pageSubTitle = "Kandidaten der Bundestagswahl 2017 Direktkandidaten";
        String pageSymbol = PageSymbol.GEBURTSJAHR.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/geburtsjahr/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);
        Page<Integer> geburtsjahrPage  = kandidatService.findByGeburtsjahrAll(pageable);
        model.addAttribute("geburtsjahrPage",geburtsjahrPage);
        return "geburtsjahr/all";
    }

    @RequestMapping("/{geburtsjahr}")
    public String geburtsjahr(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("geburtsjahr") Integer geburtsjahr,
            Model model
    ) {
        if(geburtsjahr == null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            String msg = "url: "+ request.getRequestURL().toString() + " in GeburtsjahrController.geburtsjahr";
            throw new EntityNotFoundException(msg);
        } else {
            int mindestalter = 18;
            int todayYear = LocalDate.now().getYear() - mindestalter;
            if(geburtsjahr.intValue() < 1900 || geburtsjahr.intValue() > todayYear){
                String msg = "/geburtsjahr" + geburtsjahr + " in GeburtsjahrController.geburtsjahr";
                throw new EntityNotFoundException(msg);
            }
            String pageTitle = "Geburtsjahr: "+geburtsjahr;
            String pageSubTitle = kandidatenProperties.getPageSubTitle();
            String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/geburtsjahr/"+geburtsjahr;
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            String msvalidateKey = kandidatenProperties.getMsvalidateKey();
            String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
            String facebookAppId = kandidatenProperties.getFacebookAppId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
            model.addAttribute("pageContent",pageContent);
            Page<Kandidat> kandidatenPage  = kandidatService.findByGeburtsjahr(geburtsjahr,pageable);
            model.addAttribute("kandidaten",kandidatenPage);
            model.addAttribute("geburtsjahr",geburtsjahr);
            return "geburtsjahr/id";
        }
    }

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;


    @Autowired
    public GeburtsjahrController(SessionHandler sessionHandler, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
