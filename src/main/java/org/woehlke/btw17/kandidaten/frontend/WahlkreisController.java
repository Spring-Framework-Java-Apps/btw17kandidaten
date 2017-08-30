package org.woehlke.btw17.kandidaten.frontend;

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
import org.woehlke.btw17.kandidaten.frontend.content.PageSymbol;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.WahlkreisService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/wahlkreis")
public class WahlkreisController {


    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "wahlkreisName"
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Wahlkreise";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.WAHLKREIS.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/wahlkreis/all";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);

        Page<Wahlkreis> allWahlkreisPage =  wahlkreisService.getAll(pageable);
        model.addAttribute("wahlkreise", allWahlkreisPage);
        model.addAttribute("pageTitle","Wahlkreise");
        return "wahlkreis/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") Wahlkreis wahlkreis, Model model
    ) {
        if(wahlkreis == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = wahlkreis.getWahlkreisId() + ": " + wahlkreis.getWahlkreisName();
            String pageSubTitle = "Wahlkreise der btw17 Kandidaten";
            String pageSymbol = PageSymbol.WAHLKREIS.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/wahlkreis/"+wahlkreis.getId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("wahlkreis",wahlkreis);

            Page<Kandidat> kandidatenPage  = kandidatService.findByWahlkreis(wahlkreis,pageable);
            model.addAttribute("kandidaten",kandidatenPage);

            return "wahlkreis/id";
        }
    }


    private final WahlkreisService wahlkreisService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public WahlkreisController(WahlkreisService wahlkreisService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.wahlkreisService = wahlkreisService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
