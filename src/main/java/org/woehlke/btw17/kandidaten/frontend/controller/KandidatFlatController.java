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
import org.woehlke.btw17.kandidaten.oodm.model.KandidatFlat;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatFlatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/kandidatflat")
public class KandidatFlatController {


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
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/kandidatflat/all";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        Page<KandidatFlat> allKandidatenPage =  kandidatFlatService.getAll(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);
        return "kandidatflat/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") KandidatFlat kandidatFlat, Model model
    ) {
        if(kandidatFlat == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = kandidatFlat.getVorname()+" "+kandidatFlat.getNachname();
            if(kandidatFlat.getListePartei() != null){
                pageTitle += ", "+kandidatFlat.getListePartei();
            } else if (kandidatFlat.getPartei() != null){
                pageTitle += ", "+kandidatFlat.getPartei();
            }
            String pageSubTitle = "Kandidaten der btw17";
            String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/kandidatflat/"+kandidatFlat.getId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
            model.addAttribute("pageContent",pageContent);

            model.addAttribute("kandidat",kandidatFlat);
            return "kandidatflat/id";
        }
    }

    private final KandidatFlatService kandidatFlatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public KandidatFlatController(KandidatFlatService kandidatFlatService, KandidatenProperties kandidatenProperties) {
        this.kandidatFlatService = kandidatFlatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
