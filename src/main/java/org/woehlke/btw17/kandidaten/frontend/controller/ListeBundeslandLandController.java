package org.woehlke.btw17.kandidaten.frontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/listebundesland")
public class ListeBundeslandLandController {


    @RequestMapping("/{id}")
    public String getUserForListeBundeslandLand(
            @PageableDefault(
                value = FIRST_PAGE_NUMBER,
                size = PAGE_SIZE,
                sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
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
        String pagerUrl = "/kandidat/listebundesland/all";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

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
