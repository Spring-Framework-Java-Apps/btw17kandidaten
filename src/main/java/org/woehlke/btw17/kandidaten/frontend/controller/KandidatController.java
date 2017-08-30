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
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/kandidat")
public class KandidatController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Kandidaten";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/kandidat/all";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getAll(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);
        return "kandidat/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") Kandidat kandidat, Model model
    ) {
        if(kandidat == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = kandidat.getVorname()+" "+kandidat.getNachname();
            if(kandidat.getListePartei() != null){
                pageTitle += ", "+kandidat.getListePartei().getListePartei();
            } else if (kandidat.getPartei() != null){
                pageTitle += ", "+kandidat.getPartei().getPartei();
            }
            String pageSubTitle = "Kandidaten der btw17";
            String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/kandidat/"+kandidat.getId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
            model.addAttribute("pageContent",pageContent);

            model.addAttribute("kandidat",kandidat);
            return "kandidat/id";
        }
    }

    @RequestMapping("/geburtsjahr/all")
    public String getUserForGeburtsjahrAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Geburtsjahre ";
        String pageSubTitle = "Kandidaten der btw17";
        String pageSymbol = PageSymbol.GEBURTSJAHR.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/kandidat/geburtsjahr/all";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        Page<Integer> geburtsjahrPage  = kandidatService.findByGeburtsjahrAll(pageable);
        model.addAttribute("geburtsjahrPage",geburtsjahrPage);

        return "kandidat/geburtsjahr/all";
    }

    @RequestMapping("/geburtsjahr/{id}")
    public String getUserForGeburtsjahr(
            @PathVariable("id") Kandidat kandidat, Model model
    ) {
        if(kandidat == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = "Geburtsjahr "+kandidat.getGeburtsjahr();
            String pageSubTitle = "Kandidaten der btw17";
            String pageSymbol = PageSymbol.GEBURTSJAHR.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/kandidat/geburtsjahr/"+kandidat.getId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
            model.addAttribute("pageContent",pageContent);

            model.addAttribute("kandidat",kandidat);
            return "kandidat/geburtsjahr/id";
        }
    }

    @RequestMapping("/listebundesland/{id}")
    public String getUserForListeBundeslandLand(
            @PathVariable("id") Kandidat kandidat, Model model
    ) {
        if(kandidat == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = "ListeBundesland "+kandidat.getListeBundeslandLand();
            String pageSubTitle = "Kandidaten der btw17";
            String pageSymbol = PageSymbol.BUNDESLAND.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/kandidat/listebundesland/"+kandidat.getId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
            model.addAttribute("pageContent",pageContent);

            model.addAttribute("kandidat",kandidat);
            return "kandidat/listebundesland/id";
        }
    }

    @RequestMapping("/listebundesland/all")
    public String getUserForListeBundeslandLand(Model model) {

        String pageTitle = "ListeBundesLänder ";
        String pageSubTitle = "Kandidaten der btw17";
        String pageSymbol = PageSymbol.BUNDESLAND.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/kandidat/listebundesland/all";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        return "kandidat/listebundesland/all";
    }

    @RequestMapping("/mdb")
    public String getUserwhoAreMdB(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "MdB";
        String pageSubTitle = "Kandidaten der btw17";
        String pageSymbol = PageSymbol.MDB.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/kandidat/mdb/";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> kandidatenPage  = kandidatService.findByMdB(pageable);
        model.addAttribute("kandidaten",kandidatenPage);

        return "kandidat/mdb";
    }

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public KandidatController(KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }

}
