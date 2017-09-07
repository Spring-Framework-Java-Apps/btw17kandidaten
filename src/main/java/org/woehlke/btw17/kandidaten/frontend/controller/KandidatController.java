package org.woehlke.btw17.kandidaten.frontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.content.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.SearchForKandidat;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/kandidat")
public class KandidatController {

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
        boolean showDebugInfos = false;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getAll(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
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
            boolean showDebugInfos = false;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,showDebugInfos);
            model.addAttribute("pageContent",pageContent);

            model.addAttribute("kandidat",kandidat);

            FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
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
            boolean showDebugInfos = false;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,showDebugInfos);
            model.addAttribute("pageContent",pageContent);

            model.addAttribute("kandidat",kandidat);

            FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
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

    private final KandidatenProperties kandidatenProperties;

    private final SessionHandler sessionHandler;

    @Autowired
    public KandidatController(KandidatService kandidatService, KandidatenProperties kandidatenProperties, SessionHandler sessionHandler) {
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
        this.sessionHandler = sessionHandler;
    }

}
