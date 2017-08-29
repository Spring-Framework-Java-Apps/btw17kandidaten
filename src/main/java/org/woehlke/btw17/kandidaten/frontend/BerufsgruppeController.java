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
import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.service.BerufsgruppeService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/berufsgruppe")
public class BerufsgruppeController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "berufsgruppe"
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Berufsgruppe";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.BERUFSGRUPPE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey);
        model.addAttribute("pageContent",pageContent);

        Page<Berufsgruppe> allBerufsgruppePage =  berufsgruppeService.getAll(pageable);
        model.addAttribute("berufsgruppen", allBerufsgruppePage);
        return "berufsgruppe/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") Berufsgruppe berufsgruppe, Model model
    ) {
        if(berufsgruppe == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = berufsgruppe.getBerufsgruppe();
            String pageSubTitle = "Berufsgruppen der btw17 Kandidaten";
            String pageSymbol = PageSymbol.BERUFSGRUPPE.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("berufsgruppe",berufsgruppe);
            return "berufsgruppe/id";
        }
    }

    private final BerufsgruppeService berufsgruppeService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;



    @Autowired
    public BerufsgruppeController(BerufsgruppeService berufsgruppeService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.berufsgruppeService = berufsgruppeService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
