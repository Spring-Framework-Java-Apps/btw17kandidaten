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
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import java.util.Date;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/geburtsjahr")
public class GeburtsjahrController {

    @RequestMapping("/all")
    public String getUserForGeburtsjahrAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Geburtsjahre ";
        String pageSubTitle = "Kandidaten der Bundestagswahl 2017 Direktkandidaten";
        String pageSymbol = PageSymbol.GEBURTSJAHR.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/geburtsjahr/all";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        Page<Integer> geburtsjahrPage  = kandidatService.findByGeburtsjahrAll(pageable);
        model.addAttribute("geburtsjahrPage",geburtsjahrPage);

        return "geburtsjahr/all";
    }

    @RequestMapping("/{geburtsjahr}")
    public String getKandidatenForGeburtsjahr(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("geburtsjahr") Integer geburtsjahr, Model model
    ) {
        if(geburtsjahr == null){
            throw new EntityNotFoundException();
        } else {
            int mindestalter = 18;
            int todayYear = (new Date()).getYear() + 1901 - mindestalter;
            if(geburtsjahr.intValue() < 1900 || geburtsjahr.intValue() > todayYear){
                throw new EntityNotFoundException();
            }
            String pageTitle = "Geburtsjahr: "+geburtsjahr;
            String pageSubTitle = kandidatenProperties.getPageSubTitle();
            String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/geburtsjahr/"+geburtsjahr;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
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
    public GeburtsjahrController(KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
