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
import org.woehlke.btw17.kandidaten.oodm.model.Geburtsort;
import org.woehlke.btw17.kandidaten.oodm.service.GeburtsortService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/geburtsort")
public class GeburtsortController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "geburtsort"
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Geburtsort";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.GEBURTSORT.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey);
        model.addAttribute("pageContent",pageContent);

        Page<Geburtsort> allGeburtsortPage =  geburtsortService.getAll(pageable);
        model.addAttribute("geburtsorte", allGeburtsortPage);
        model.addAttribute("pageTitle","Geburtsorte");
        return "geburtsort/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") Geburtsort geburtsort, Model model
    ) {
        if(geburtsort == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = geburtsort.getGeburtsort();
            String pageSubTitle = "Geburtsorte der btw17 Kandidaten";
            String pageSymbol = PageSymbol.GEBURTSORT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("geburtsort",geburtsort);
            return "geburtsort/id";
        }
    }

    private final GeburtsortService geburtsortService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public GeburtsortController(GeburtsortService geburtsortService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.geburtsortService = geburtsortService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
