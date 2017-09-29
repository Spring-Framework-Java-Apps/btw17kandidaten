package org.woehlke.btw17.kandidaten.frontend.controller.redaktion.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.woehlke.btw17.kandidaten.configuration.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.service.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Collections;
import java.util.List;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 *
 * @see org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.GeburtsjahrController
 * @see org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.MdBController
 * @see org.woehlke.btw17.kandidaten.frontend.controller.redaktion.data.KandidatFlatController
 */
@Controller
@RequestMapping("/redaktion/kandidat")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class KandidatRedaktionController extends AbstractController {

    @RequestMapping("/all")
    public String all(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT,
                    direction = Sort.Direction.ASC
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Alle Kandidaten";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/redaktion/kandidat/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);
        Page<Kandidat> allKandidatenPage =  kandidatService.getAll(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);
        return "kandidat/all";
    }

    @ModelAttribute("ausschuesseList")
    public List<Ausschuss> addAusschuesse(Model model) {
        log.debug("addAusschuesse");
        List<Ausschuss> ausschuesse = ausschussService.getAll();
        return ausschuesse;
    }

    @ModelAttribute("fraktionenList")
    public List<Fraktion> addFraktionen(Model model) {
        log.debug("addFraktionen");
        List<Fraktion> fraktionen = fraktionService.getAll();
        return fraktionen;
    }

    @ModelAttribute("ministerienList")
    public List<Ministerium> addMinisterien(Model model) {
        log.debug("addMinisterien");
        List<Ministerium> ministerien = ministeriumService.getAll();
        return ministerien;
    }

    @ModelAttribute("bundeslandList")
    public Iterable<Bundesland> addBundeslandList(Model model) {
        log.debug("addBbundeslandList");
        Iterable<Bundesland> ministerien = bundeslandService.getAll();
        return ministerien;
    }


    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editGet(
            @PathVariable("id") Kandidat kandidat,
            Model model
    ) {
        log.debug("editGet - BEGIN");
        BindingResult binding = null;
        if(model.containsAttribute("kandidat")){
            kandidat = (Kandidat) model.asMap().get("kandidat");
        }
        if(model.containsAttribute("binding")){
            binding = (BindingResult) model.asMap().get("binding");
        }
        if(model.containsAttribute("org.springframework.validation.BindingResult.kandidat")){
            binding = (BindingResult) model.asMap().get("org.springframework.validation.BindingResult.kandidat");
        }
        if(kandidat == null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            String msg = "url: "+ request.getRequestURL().toString() +" in KandidatRedaktionController.id";
            log.debug("editGet: "+msg);
            log.debug("editGet - END");
            throw new EntityNotFoundException(msg);
        } else {
            long id = kandidat.getId();
            String pageTitle = kandidat.getVorname()+" "+kandidat.getNachname();
            String pageSubTitle = kandidatenProperties.getPageSubTitle();
            if (kandidat.getPartei() != null){
                pageSubTitle = kandidat.getPartei().getName();
            }
            String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/redaktion/kandidat/edit/"+id;
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            String msvalidateKey = kandidatenProperties.getMsvalidateKey();
            String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
            String facebookAppId = kandidatenProperties.getFacebookAppId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("kandidat",kandidat);
            log.debug("############################");
            log.debug("############################");
            log.debug("############################");
            logInfos(binding,kandidat);
            log.debug("############################");
            log.debug("############################");
            log.debug("############################");
            log.debug("editGet - END");
            return "kandidat/edit";
        }
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String editPost(
            @PathVariable("id") Long id,
            @Valid Kandidat kandidat,
            BindingResult binding,
            RedirectAttributes attr,
            HttpSession session,
            Model model
    ) {
        log.debug("editPost - BEGIN");
        if (binding.hasErrors()) {
            log.debug("editPost - binding.hasErrors() == true");
            log.debug("############################");
            log.debug("############################");
            log.debug("############################");
            logInfos(binding,kandidat);
            log.debug("############################");
            log.debug("############################");
            log.debug("############################");
            log.debug("OK-1");
            attr.addFlashAttribute("org.springframework.validation.BindingResult.kandidat", binding);
            log.debug("OK-2");
            attr.addFlashAttribute("kandidat", kandidat);
            log.debug("OK-3");
            attr.addAttribute("kandidat", kandidat);
            log.debug("OK-4");
        } else {
            log.debug("editPost - binding.hasErrors() == false");
            log.debug("try to save: "+kandidat.getUniqueId());
            logInfos(binding,kandidat);
            kandidat = kandidatService.update(kandidat);
            log.debug("saved: "+kandidat.getUniqueId());
            logInfos(binding,kandidat);
            session.setAttribute("kandidat", kandidat);
        }
        log.debug("OK - DONE");
        log.debug("editPost - END");
        return "redirect:/redaktion/kandidat/edit/"+id;
    }

    private static final Logger log = LoggerFactory.getLogger(KandidatRedaktionController.class);

    private final KandidatService kandidatService;

    private final AusschussService ausschussService;

    private final FraktionService fraktionService;

    private final MinisteriumService ministeriumService;

    private final BundeslandService bundeslandService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public KandidatRedaktionController(SessionHandler sessionHandler, KandidatService kandidatService, AusschussService ausschussService, FraktionService fraktionService, MinisteriumService ministeriumService, BundeslandService bundeslandService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.kandidatService = kandidatService;
        this.ausschussService = ausschussService;
        this.fraktionService = fraktionService;
        this.ministeriumService = ministeriumService;
        this.bundeslandService = bundeslandService;
        this.kandidatenProperties = kandidatenProperties;
    }

    private void logInfos(BindingResult binding,Kandidat kandidat){
        log.debug("*****************************************");
        if(binding != null && binding.hasErrors()){
            log.debug("FieldErrors: ");
            for(FieldError fieldError :binding.getFieldErrors()){
                log.debug(fieldError.getField()+" : rejected: "+fieldError.getRejectedValue()+" : "+fieldError.getCode()+" : "+fieldError.getDefaultMessage());
            }
            log.debug("-----------------------------------------");
            log.debug("ObjectErrors: ");
            for(ObjectError objectError:binding.getAllErrors()){
                log.debug(objectError.getObjectName()+" : "+objectError.getCode()+" : "+objectError.getDefaultMessage());
            }
            log.debug("-----------------------------------------");
        }
        log.debug("Kandidat: ");
        log.debug(kandidat.getName());
        log.debug(kandidat.getUniqueId());
        log.debug("-----------------------------------------");
        log.debug("Berufsgruppe:");
        log.debug(kandidat.getBerufsgruppe().getName());
        log.debug("-----------------------------------------");
        log.debug("Beruf:");
        log.debug(kandidat.getBeruf().getName());
        log.debug("-----------------------------------------");
        log.debug("CommonFields:");
        if(kandidat.getCommonFields() != null) {
            log.debug(kandidat.getCommonFields().toString());
        } else {
            log.debug("kandidat.getCommonFields() == null");
        }
        log.debug("-----------------------------------------");
        log.debug("Geburtsort:");
        log.debug(kandidat.getGeburtsort().getName());
        log.debug("-----------------------------------------");
        log.debug("Wohnort:");
        log.debug(kandidat.getWohnort().getName());
        log.debug("-----------------------------------------");
        log.debug("Wahlkreis:");
        log.debug(kandidat.getWahlkreis().getName());
        log.debug("-----------------------------------------");
        log.debug("Fraktion:");
        if(kandidat.getFraktion() != null){
            log.debug(kandidat.getFraktion().getName());
        } else {
            log.debug("kandidat.getFraktion() == null");
        }
        log.debug("-----------------------------------------");
        log.debug("Webseite:");
        log.debug(kandidat.getWebseite().getWebseite());
        log.debug("-----------------------------------------");
        log.debug("Adresse.Bundesland:");
        log.debug(kandidat.getAdresse().getBundesland().getName());
        log.debug("-----------------------------------------");
        log.debug("Adresse:");
        log.debug(kandidat.getAdresse().toString());
        log.debug("-----------------------------------------");
        log.debug("Ministerien:");
        for(Ministerium ministerium:kandidat.getMinisterien()){
            log.debug(ministerium.getName());
        }
        log.debug("-----------------------------------------");
        log.debug("Ausschuesse:");
        for(Ausschuss ausschuss:kandidat.getAusschuesse()){
            log.debug(ausschuss.getName());
        }
        log.debug("-----------------------------------------");
        log.debug("kandidat.toString():");
        log.debug("*****************************************");
        log.debug(kandidat.toString());
    }
}
