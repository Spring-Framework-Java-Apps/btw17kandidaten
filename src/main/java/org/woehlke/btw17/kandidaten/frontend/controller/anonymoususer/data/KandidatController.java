package org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
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
            HttpServletRequest request,
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
            @PathVariable("id") Kandidat kandidat,
            HttpSession session,
            HttpServletRequest request,
            Model model
    ) {
        if(kandidat == null){
            String msg = "url: "+ request.getRequestURL().toString() +" in KandidatController.getKandidatForId";
            throw new EntityNotFoundException(msg);
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

    @ModelAttribute("ausschuesse")
    public List<Ausschuss> addAusschuesse(HttpSession session, Model model) {
        log.debug("addAusschuesse");
        List<Ausschuss> ausschuesse = ausschussService.getAll();
        return ausschuesse;
    }

    @ModelAttribute("fraktionen")
    public List<Fraktion> addFraktionen(HttpSession session, Model model) {
        log.debug("addFraktionen");
        List<Fraktion> fraktionen = fraktionService.getAll();
        return fraktionen;
    }

    @ModelAttribute("ministerien")
    public List<Ministerium> addMinisterien(HttpSession session, Model model) {
        log.debug("addMinisterien");
        List<Ministerium> ministerien = ministeriumService.getAll();
        return ministerien;
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editKandidatForIdGet(
            @PathVariable ("id") Kandidat kandidat,
            HttpServletRequest request,
            HttpSession session,
            Model model
    ) {
        long id = kandidat.getId();
        BindingResult binding = null;
        if(model.containsAttribute("kandidat")){
            kandidat = (Kandidat) model.asMap().get("kandidat");
        }
        if(model.containsAttribute("binding")){
            binding = (BindingResult) model.asMap().get("binding");
        }
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
            String pagerUrl = "/kandidat/"+id;
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("kandidat",kandidat);
            return "kandidat/edit";
        }
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String editKandidatForIdPost(
            @PathVariable("id") Long id,
            @Valid Kandidat kandidat,
            BindingResult binding,
            RedirectAttributes attr,
            HttpSession session,
            Model model
    ) {
        if (binding.hasErrors()) {
            for(ObjectError objectError:binding.getAllErrors()){
                log.info("ObjectError: "+objectError.getObjectName()+" - "+objectError.toString());
            }
            for(FieldError fieldError:binding.getFieldErrors()){
                log.info("FieldError: "+fieldError.getField()+" - "+fieldError.getRejectedValue());
            }
            log.info("OK-1");
            attr.addFlashAttribute("org.springframework.validation.BindingResult.kandidat", binding);
            //attr.addFlashAttribute("binding", binding);
            log.info("OK-2");
            attr.addFlashAttribute("kandidat", kandidat);
            log.info("OK-3");
            //attr.addAttribute("org.springframework.validation.BindingResult.register", binding);
            attr.addAttribute("kandidat", kandidat);
            log.info("OK-4");
            //attr.addAttribute("org.springframework.validation.BindingResult.kandidat", binding);
            log.info("OK-5");
        } else {
            kandidat = kandidatService.update(kandidat);
            log.info("saved: "+kandidat);
            session.setAttribute("kandidat", kandidat);
        }
        log.info("OK - DONE");
        return "redirect:/kandidat/edit/"+id;
    }

    private static final Logger log = LoggerFactory.getLogger(KandidatController.class);

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
