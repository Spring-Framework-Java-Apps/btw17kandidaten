package org.woehlke.btw17.kandidaten.frontend.controller;


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
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.model.Ausschuss;
import org.woehlke.btw17.kandidaten.oodm.model.Fraktion;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.model.Ministerium;
import org.woehlke.btw17.kandidaten.oodm.service.AusschussService;
import org.woehlke.btw17.kandidaten.oodm.service.FraktionService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.MinisteriumService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/kandidat")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class KandidatController extends AbstractController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Alle Kandidaten";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/kandidat/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);
        Page<Kandidat> allKandidatenPage =  kandidatService.getAll(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);
        return "kandidat/all";
    }

    @RequestMapping("/{id}")
    public String getKandidatForId(
            @PathVariable("id") Kandidat kandidat, HttpSession session, Model model
    ) {
        if(kandidat == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = kandidat.getVorname()+" "+kandidat.getNachname();
            String pageSubTitle = "Kandidaten der btw17";
            if (kandidat.getPartei() != null){
                pageSubTitle = kandidat.getPartei().getName();
            }
            String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/kandidat/"+kandidat.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_INNEN_01;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("kandidat",kandidat);
            return "kandidat/id";
        }
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editKandidatForIdGet(
            @PathVariable("id") Kandidat kandidat, HttpSession session, Model model
    ) {
        if(kandidat == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = kandidat.getVorname()+" "+kandidat.getNachname();
            String pageSubTitle = kandidatenProperties.getPageSubTitle();
            if (kandidat.getPartei() != null){
                pageSubTitle = kandidat.getPartei().getName();
            }
            String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/kandidat/"+kandidat.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("kandidat",kandidat);
            List<Ausschuss> ausschuesse = ausschussService.getAll();
            model.addAttribute("ausschuesse",ausschuesse);
            List<Fraktion> fraktionen = fraktionService.getAll();
            model.addAttribute("fraktionen",fraktionen);
            List<Ministerium> ministerien = ministeriumService.getAll();
            model.addAttribute("ministerien",ministerien);
            return "kandidat/edit";
        }
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String editKandidatForIdPost(
            @Valid @ModelAttribute("kandidat") Kandidat kandidat,
            @PathVariable Long id,
            BindingResult binding,
            RedirectAttributes attr,
            HttpSession session,
            Model model
    ) {
        if (binding.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.register", binding);
            attr.addFlashAttribute("kandidat", kandidat);
        } else {
            kandidat= kandidatService.update(kandidat);
            session.setAttribute("kandidat", kandidat);
        }
        return "redirect:/kandidat/edit/"+id;
    }

    private final KandidatService kandidatService;

    private final AusschussService ausschussService;

    private final FraktionService fraktionService;

    private final MinisteriumService ministeriumService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public KandidatController(SessionHandler sessionHandler, KandidatService kandidatService, AusschussService ausschussService, FraktionService fraktionService, MinisteriumService ministeriumService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.kandidatService = kandidatService;
        this.ausschussService = ausschussService;
        this.fraktionService = fraktionService;
        this.ministeriumService = ministeriumService;
        this.kandidatenProperties = kandidatenProperties;
    }

}
