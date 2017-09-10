package org.woehlke.btw17.kandidaten.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.oodm.model.Fraktion;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.FraktionService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/fraktion")
public class FraktionController {



    @RequestMapping("/all")
    public String getAllFraktion(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "fraktion"
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Fraktionen";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.FRAKTION.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/fraktion/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);

        Page<Fraktion> pageAllFraktion =  fraktionService.getAll(pageable);
        model.addAttribute("fraktionen", pageAllFraktion);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "fraktion/all";
    }

    @RequestMapping("/{id}")
    public String getFraktionForId(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") Fraktion fraktion, HttpSession session, Model model
    ) {
        if(fraktion == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = fraktion.getFraktion();
            String pageSubTitle = kandidatenProperties.getPageSubTitle();
            String pageSymbol = PageSymbol.FRAKTION.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/fraktion/"+fraktion.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("fraktion",fraktion);

            Page<Kandidat> kandidatenPage  = kandidatService.findByFraktion(fraktion,pageable);
            model.addAttribute("kandidaten",kandidatenPage);
            FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);

            return "fraktion/id";
        }
    }

    private final FraktionService fraktionService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    private final SessionHandler sessionHandler;


    @Autowired
    public FraktionController(FraktionService fraktionService, KandidatService kandidatService, KandidatenProperties kandidatenProperties, SessionHandler sessionHandler) {
        this.fraktionService = fraktionService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
        this.sessionHandler = sessionHandler;
    }
}
