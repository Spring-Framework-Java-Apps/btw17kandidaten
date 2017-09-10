package org.woehlke.btw17.kandidaten.frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.woehlke.btw17.kandidaten.configuration.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.frontend.content.SearchForKandidat;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping(value ="/suche")
public class SucheController {

    @RequestMapping(value = "/formular", method = RequestMethod.GET)
    public String suchFormularAnzeigenGet(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Suche";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.SUCHE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/suche/formular";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_INNEN_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);

        SearchForKandidat suchformular = (SearchForKandidat) session.getAttribute("suchformular");

        if (suchformular == null) {
            suchformular = new SearchForKandidat();
            log.info(suchformular.toString());
            session.setAttribute("suchformular", suchformular);
        } else {
            log.info(suchformular.toString());
            Page<Kandidat> kandidatPage = sucheService.suchePerFormular(suchformular,pageable);
            model.addAttribute("kandidaten",kandidatPage);
        }
        model.addAttribute("suchformular",suchformular);
        model.addAttribute("berufsgruppen",berufsgruppeService.getAll());
        model.addAttribute("bundeslaender",bundeslandService.getAll());
        model.addAttribute("landesListen",landesListeService.getAll());
        model.addAttribute("parteien",parteiService.getAll());
        model.addAttribute("geburtsjahre",kandidatService.getAllGeburtsjahre());
        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "suche/formular";
    }

    @RequestMapping(value = "/formular", method = RequestMethod.POST)
    public String suchFormularPost(
            @Valid @ModelAttribute("suchformular") SearchForKandidat suchformular,
            BindingResult binding,
            RedirectAttributes attr,
            HttpSession session
    ) {
        log.info(suchformular.toString());
        if (binding.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.register", binding);
            attr.addFlashAttribute("suchformular", suchformular);
        } else {
            session.setAttribute("suchformular", suchformular);
        }
        return "redirect:/suche/formular";
    }


    @RequestMapping(value = "/freitext/formular", method = RequestMethod.GET)
    public String tretextsucheFormularAnzeigenGet(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Freitext Suche";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.SUCHE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/suche/freitext/formular";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_INNEN_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);
        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        if((suchformularFreitext.getSearchTerm()!=null)&&(!suchformularFreitext.getSearchTerm().isEmpty())){
            Page<Kandidat> kandidatPage = sucheService.suchePerFreitextFormular(suchformularFreitext,pageable);
            model.addAttribute("kandidaten",kandidatPage);
        }
        model.addAttribute("berufsgruppen",berufsgruppeService.getAll());
        model.addAttribute("bundeslaender",bundeslandService.getAll());
        model.addAttribute("landesListen",landesListeService.getAll());
        model.addAttribute("parteien",parteiService.getAll());
        model.addAttribute("geburtsjahre",kandidatService.getAllGeburtsjahre());
        return "suche/freitext";
    }

    @RequestMapping(value = "/freitext/formular", method = RequestMethod.POST)
    public String suchFormularPost(
            @Valid @ModelAttribute("suchformular") FreitextSucheFormular suchformularFreitext,
            BindingResult binding,
            RedirectAttributes attr,
            HttpSession session
    ) {
        log.info(suchformularFreitext.toString());
        if (binding.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.register", binding);
            attr.addFlashAttribute("suchformularFreitext", suchformularFreitext);
        } else {
            session.setAttribute("suchformularFreitext", suchformularFreitext);
        }
        return "redirect:/suche/freitext/formular";
    }

    @Autowired
    public SucheController(SucheService sucheService, KandidatService kandidatService, BerufsgruppeService berufsgruppeService, BundeslandService bundeslandService, LandesListeService landesListeService, ParteiService parteiService, KandidatenProperties kandidatenProperties, SessionHandler sessionHandler) {
        this.sucheService = sucheService;
        this.kandidatService = kandidatService;
        this.berufsgruppeService = berufsgruppeService;
        this.bundeslandService = bundeslandService;
        this.landesListeService = landesListeService;
        this.parteiService = parteiService;
        this.kandidatenProperties = kandidatenProperties;
        this.sessionHandler = sessionHandler;
    }

    private final SucheService sucheService;

    private final KandidatService kandidatService;

    private final BerufsgruppeService berufsgruppeService;

    private final BundeslandService bundeslandService;

    private final LandesListeService landesListeService;

    private final ParteiService parteiService;

    private final KandidatenProperties kandidatenProperties;

    private final SessionHandler sessionHandler;

    private static final Logger log = LoggerFactory.getLogger(SucheController.class);
}
