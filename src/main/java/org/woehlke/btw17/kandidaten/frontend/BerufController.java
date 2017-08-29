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
import org.woehlke.btw17.kandidaten.oodm.model.Beruf;
import org.woehlke.btw17.kandidaten.oodm.service.BerufService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/beruf")
public class BerufController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "beruf"
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Berufe";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.BERUF.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey);
        model.addAttribute("pageContent",pageContent);
        Page<Beruf> allBerufPage =  berufService.getAll(pageable);
        model.addAttribute("berufe", allBerufPage);
        return "beruf/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") Beruf beruf, Model model
    ) {
        if(beruf == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = beruf.getBeruf();
            String pageSubTitle = "Berufe der btw17 Kandidaten";
            String pageSymbol = PageSymbol.BERUF.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("beruf",beruf);
            return "beruf/id";
        }
    }

    private final KandidatService kandidatService;

    private final BerufService berufService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public BerufController(KandidatService kandidatService, BerufService berufService, KandidatenProperties kandidatenProperties) {
        this.kandidatService = kandidatService;
        this.berufService = berufService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
