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
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.LandesListeService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/landesliste")
public class LandesListeController {


    @RequestMapping("/{id}")
    public String getLandesListeForId(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") LandesListe landesListe, HttpSession session, Model model
    ) {
        if(landesListe == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = landesListe.getName();
            String pageSubTitle = "LandesListe der btw17 Kandidaten";
            String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/landesliste/"+landesListe.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            boolean showDebugInfos = false;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,showDebugInfos);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("landesListe",landesListe);

            Page<Kandidat> kandidatenPage  = kandidatService.findByLandesListe(landesListe,pageable);
            model.addAttribute("kandidaten",kandidatenPage);
            FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);

            return "landesliste/id";
        }
    }

    @RequestMapping("/bundesland/{id}")
    public String getLandesListeForBundesland(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") Bundesland bundesland, HttpSession session, Model model
    ) {
        if(bundesland == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = "LandesListen in "+ bundesland.getName();
            String pageSubTitle = "btw17 Kandidaten";
            String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/landesliste/bundesland/"+bundesland.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            boolean showDebugInfos = false;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,showDebugInfos);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("bundesland",bundesland);


            Page<LandesListe> landeslistePage  = landesListeService.findByBundesland(bundesland,pageable);
            model.addAttribute("landeslistePage",landeslistePage);
            model.addAttribute("bundeslandIdTarget","landesliste");
            FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);

            return "landesliste/bundesland/id";
        }
    }

    @RequestMapping("/listepartei/{id}")
    public String getLandesListeForListePartei(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") ListePartei listePartei,HttpSession session,  Model model
    ) {
        if(listePartei == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = "LandesListen der "+ listePartei.getListePartei();
            String pageSubTitle = "btw17 Kandidaten";
            String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/landesliste/listepartei/"+listePartei.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            boolean showDebugInfos = false;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,showDebugInfos);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("listePartei",listePartei);

            Page<LandesListe> landeslistePage  = landesListeService.findByListePartei(listePartei,pageable);
            model.addAttribute("landeslistePage",landeslistePage);
            model.addAttribute("bundeslandIdTarget","landesliste");

            FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
            return "landesliste/listepartei/id";
        }
    }

    @RequestMapping("/bundesland/all")
    public String getLandesListeForBundeslandAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Bundesländer der LandesListen";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/landesliste/bundesland/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = false;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Bundesland> allBundeslandPage =  landesListeService.getAllBundesland(pageable);
        model.addAttribute("bundeslaender", allBundeslandPage);
        model.addAttribute("bundeslandIdTarget","landesliste/bundesland");
        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "landesliste/bundesland/all";
    }

    @RequestMapping("/listepartei/all")
    public String getLandesListeForListeParteiAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Partei Listen der LandesListen";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/landesliste/listepartei/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = false;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<ListePartei> allListeParteiPage = landesListeService.getAllListePartei(pageable);
        model.addAttribute("listeparteien", allListeParteiPage);
        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "landesliste/listepartei/all";
    }

    private final LandesListeService landesListeService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    private final SessionHandler sessionHandler;

    @Autowired
    public LandesListeController(LandesListeService landesListeService, KandidatService kandidatService, KandidatenProperties kandidatenProperties, SessionHandler sessionHandler) {
        this.landesListeService = landesListeService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
        this.sessionHandler = sessionHandler;
    }
}
