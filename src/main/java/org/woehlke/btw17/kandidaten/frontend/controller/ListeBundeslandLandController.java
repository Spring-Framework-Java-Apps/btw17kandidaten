package org.woehlke.btw17.kandidaten.frontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/listebundesland")
public class ListeBundeslandLandController {


    @RequestMapping("/{id}")
    public String getLandesliste(
            @PageableDefault(
                value = FIRST_PAGE_NUMBER,
                size = PAGE_SIZE,
                sort = "listePlatz",
                direction= Sort.Direction.DESC
            ) Pageable pageable,
            @PathVariable("id") Kandidat kandidat, Model model
    ) {
        if(kandidat == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = "Landesliste: ";
            if(kandidat.getListePartei() != null){
                pageTitle += " "+ kandidat.getListePartei().getListePartei();
            }
            if(kandidat.getListeBundeslandLand() != null){
                pageTitle += " in ";
            } else {
                pageTitle += " ";
            }
            if(kandidat.getListeBundeslandLand() != null){
                if(kandidat.getListeBundeslandLand().getBundeslandLang() != null){
                    pageTitle += kandidat.getListeBundeslandLand().getBundeslandLang();
                }
                pageTitle += " ("+kandidat.getListeBundeslandLand().getBundesland()+")";
            }
            String pageSubTitle = "Kandidaten der btw17";
            String pageSymbol = PageSymbol.BUNDESLAND.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/listebundesland/"+kandidat.getId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
            model.addAttribute("pageContent",pageContent);

            Bundesland listeBundeslandLand = kandidat.getListeBundeslandLand();
            ListePartei listePartei = kandidat.getListePartei();
            Page<Kandidat> kandidatenPage  = kandidatService.findByListeBundeslandLandAndListePartei(listeBundeslandLand,listePartei,pageable);
            model.addAttribute("kandidaten",kandidatenPage);

            model.addAttribute("kandidat",kandidat);
            model.addAttribute("bundeslandIdTarget","listebundesland");
            return "listebundesland/id";
        }
    }

    @RequestMapping("/all")
    public String getUserForListeBundeslandLand(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "ListeBundesLänder ";
        String pageSubTitle = "Kandidaten der btw17";
        String pageSymbol = PageSymbol.BUNDESLAND.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/listebundesland/all";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        Page<Bundesland> listebundeslandPage  = kandidatService.findByListeBundeslandLandAll(pageable);
        model.addAttribute("bundeslaender",listebundeslandPage);
        model.addAttribute("bundeslandIdTarget","listebundesland");
        return "listebundesland/all";
    }

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public ListeBundeslandLandController(KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
