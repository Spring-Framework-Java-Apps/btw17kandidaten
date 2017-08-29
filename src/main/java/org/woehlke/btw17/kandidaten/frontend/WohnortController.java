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
import org.woehlke.btw17.kandidaten.oodm.model.Wohnort;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.WohnortService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/wohnort")
public class WohnortController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "wohnort"
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Wohnorte";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.WOHNORT.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey);
        model.addAttribute("pageContent",pageContent);

        Page<Wohnort> allWohnortPage =  wohnortService.getAll(pageable);
        model.addAttribute("wohnorte", allWohnortPage);
        return "wohnort/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") Wohnort wohnort, Model model
    ) {
        if(wohnort == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = wohnort.getWohnort();
            String pageSubTitle = "Wohnorte der btw17 Kandidaten";
            String pageSymbol = PageSymbol.WOHNORT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey);
            model.addAttribute("pageContent",pageContent);

            model.addAttribute("wohnort",wohnort);
            return "wohnort/id";
        }
    }

    private final WohnortService wohnortService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public WohnortController(WohnortService wohnortService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.wohnortService = wohnortService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
