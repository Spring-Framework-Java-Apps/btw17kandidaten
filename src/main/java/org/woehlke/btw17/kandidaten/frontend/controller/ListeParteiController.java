package org.woehlke.btw17.kandidaten.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.content.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.LandesListeService;
import org.woehlke.btw17.kandidaten.oodm.service.ListeParteiService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/listepartei")
public class ListeParteiController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "listePartei"
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "ListePartei";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/listepartei/all";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        Page<ListePartei> allListeParteiPage =  listeParteiService.getAll(pageable);
        model.addAttribute("listeparteien", allListeParteiPage);
        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "listepartei/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") ListePartei listePartei, HttpSession session, Model model
    ) {
        if(listePartei == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = listePartei.getListePartei();
            String pageSubTitle = listePartei.getListeParteiLang();
            String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/listepartei/"+listePartei.getId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("listePartei",listePartei);

            Page<Kandidat> pageKandidat = kandidatService.findByListePartei(listePartei,pageable);
            model.addAttribute("kandidaten",pageKandidat);
            FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
            return "listepartei/id";
        }
    }

    private final ListeParteiService listeParteiService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    private final SessionHandler sessionHandler;

    @Autowired
    public ListeParteiController(ListeParteiService listeParteiService, KandidatService kandidatService, KandidatenProperties kandidatenProperties, SessionHandler sessionHandler) {
        this.listeParteiService = listeParteiService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
        this.sessionHandler = sessionHandler;
    }
}
