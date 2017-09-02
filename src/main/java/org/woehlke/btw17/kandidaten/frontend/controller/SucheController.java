package org.woehlke.btw17.kandidaten.frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.frontend.content.SearchForKandidat;
import org.woehlke.btw17.kandidaten.oodm.service.BerufsgruppeService;
import org.woehlke.btw17.kandidaten.oodm.service.BundeslandService;
import org.woehlke.btw17.kandidaten.oodm.service.LandesListeService;
import org.woehlke.btw17.kandidaten.oodm.service.ParteiService;

@Controller
@RequestMapping("/suche")
public class SucheController {


    @GetMapping("/formular")
    public String suchFormularGet(Model model) {
        String pageTitle = "Suche";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.SUCHE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/suche/formular";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);
        SearchForKandidat formular = new SearchForKandidat();
        model.addAttribute("formular",formular);
        model.addAttribute("berufsgruppen",berufsgruppeService.getAll());
        model.addAttribute("bundeslaender",bundeslandService.getAll());
        model.addAttribute("landesListen",landesListeService.getAll());
        model.addAttribute("parteien",parteiService.getAll());
        return "suche/formular";
    }

    @PostMapping("/formular")
    public String suchFormularPost(
            @ModelAttribute SearchForKandidat formular,
            Model model
    ) {
        String pageTitle = "Suche";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.SUCHE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/suche/formular";
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl);
        model.addAttribute("pageContent",pageContent);
        model.addAttribute("formular",formular);
        model.addAttribute("berufsgruppen",berufsgruppeService.getAll());
        model.addAttribute("bundeslaender",bundeslandService.getAll());
        model.addAttribute("landesListen",landesListeService.getAll());
        model.addAttribute("parteien",parteiService.getAll());
        return "suche/formular";
    }

    @Autowired
    public SucheController(BerufsgruppeService berufsgruppeService, BundeslandService bundeslandService, LandesListeService landesListeService, ParteiService parteiService, KandidatenProperties kandidatenProperties) {
        this.berufsgruppeService = berufsgruppeService;
        this.bundeslandService = bundeslandService;
        this.landesListeService = landesListeService;
        this.parteiService = parteiService;
        this.kandidatenProperties = kandidatenProperties;
    }

    private final BerufsgruppeService berufsgruppeService;

    private final BundeslandService bundeslandService;

    private final LandesListeService landesListeService;

    private final ParteiService parteiService;

    private final KandidatenProperties kandidatenProperties;

    private static final Logger log = LoggerFactory.getLogger(SucheController.class);
}
