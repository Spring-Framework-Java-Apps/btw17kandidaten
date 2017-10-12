package org.woehlke.btw17.kandidaten.frontend.controller.closed.data;

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
import org.woehlke.btw17.kandidaten.frontend.model.enums.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.model.enums.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.model.PageContent;
import org.woehlke.btw17.kandidaten.frontend.model.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.service.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 *
 * @see org.woehlke.btw17.kandidaten.frontend.controller.open.data.GeburtsjahrController
 * @see org.woehlke.btw17.kandidaten.frontend.controller.open.data.MdBController
 * @see org.woehlke.btw17.kandidaten.frontend.controller.closed.data.KandidatFlatController
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
    public Iterable<Ausschuss> addAusschuesse(Model model) {
        log.debug("addAusschuesse");
        Iterable<Ausschuss> ausschuesseList = ausschussService.getAll();
        return ausschuesseList;
    }

    @ModelAttribute("fraktionenList")
    public Iterable<Fraktion> addFraktionen(Model model) {
        log.debug("addFraktionen");
        Iterable<Fraktion> fraktionenList = fraktionService.getAll();
        return fraktionenList;
    }

    @ModelAttribute("ministerienList")
    public Iterable<Ministerium> addMinisterien(Model model) {
        log.debug("addMinisterien");
        Iterable<Ministerium> ministerienList = ministeriumService.getAll();
        return ministerienList;
    }

    @ModelAttribute("bundeslandList")
    public Iterable<Bundesland> addBundeslandList(Model model) {
        log.debug("addBbundeslandList");
        Iterable<Bundesland> bundeslandList = bundeslandService.getAll();
        return bundeslandList;
    }

    @ModelAttribute("parteiList")
    public Iterable<Partei> addParteiList(Model model) {
        log.debug("addParteiList");
        Iterable<Partei> parteiList = parteiService.getAll();
        return parteiList;
    }

    @ModelAttribute("landesListeList")
    public Iterable<LandesListe> addLandesListeList(Model model) {
        log.debug("addLandesListeList");
        Iterable<LandesListe> landesListeList = landesListeService.getAll();
        return landesListeList;
    }

    @ModelAttribute("cmsList")
    public Iterable<WebseiteCms> addWebseiteCmsList(Model model) {
        log.debug("addWebseiteCmsList");
        Iterable<WebseiteCms> addWebseiteCmsList = webseiteCmsService.getAll();
        return addWebseiteCmsList;
    }

    @ModelAttribute("agenturenList")
    public Iterable<WebseiteAgentur> addWebseiteAgenturList(Model model) {
        log.debug("addWebseiteAgenturList");
        Iterable<WebseiteAgentur> addWebseiteAgenturList = webseiteAgenturService.getAll();
        return addWebseiteAgenturList;
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
            logInfos("editGet",binding,kandidat);
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
            logInfos("editPost",binding,kandidat);
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
            logInfos("editPost",binding,kandidat);
            kandidat = kandidatService.update(kandidat);
            log.debug("saved: "+kandidat.getUniqueId());
            logInfos("editPost",binding,kandidat);
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

    private final ParteiService parteiService;

    private final LandesListeService landesListeService;

    private final WebseiteCmsService webseiteCmsService;

    private final WebseiteAgenturService webseiteAgenturService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public KandidatRedaktionController(SessionHandler sessionHandler, KandidatService kandidatService, AusschussService ausschussService, FraktionService fraktionService, MinisteriumService ministeriumService, BundeslandService bundeslandService, ParteiService parteiService, LandesListeService landesListeService, WebseiteCmsService webseiteCmsService, WebseiteAgenturService webseiteAgenturService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.kandidatService = kandidatService;
        this.ausschussService = ausschussService;
        this.fraktionService = fraktionService;
        this.ministeriumService = ministeriumService;
        this.bundeslandService = bundeslandService;
        this.parteiService = parteiService;
        this.landesListeService = landesListeService;
        this.webseiteCmsService = webseiteCmsService;
        this.webseiteAgenturService = webseiteAgenturService;
        this.kandidatenProperties = kandidatenProperties;
    }

    private void logInfos(String msg, BindingResult binding, Kandidat kandidat){
        log.debug(msg+"*****************************************");
        if(binding != null && binding.hasErrors()){
            log.debug("FieldErrors: ");
            for(FieldError fieldError :binding.getFieldErrors()){
                log.info(fieldError.getField()+" : rejected: "+fieldError.getRejectedValue()+" : "+fieldError.getCode()+" : "+fieldError.getDefaultMessage());
            }
            log.debug("-----------------------------------------");
            log.debug("ObjectErrors: ");
            for(ObjectError objectError:binding.getAllErrors()){
                log.info(objectError.getObjectName()+" : "+objectError.getCode()+" : "+objectError.getDefaultMessage());
            }
            log.debug("-----------------------------------------");
        }
        log.debug(msg+"Kandidat: ");
        log.debug(msg+kandidat.getName());
        log.debug(msg+kandidat.getUniqueId());
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Berufsgruppe:");
        if(kandidat.getBerufsgruppe() != null){
            log.debug(msg+kandidat.getBerufsgruppe().getName());
        } else {
            if(kandidat.getMdb() != null) {
                log.info(msg + "kandidat.getBerufsgruppe() == null " + kandidat.getUniqueId());
            } else {
                log.debug(msg + "kandidat.getBerufsgruppe() == null " + kandidat.getUniqueId());
            }
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Beruf:");
        if(kandidat.getBeruf() != null){
            log.debug(msg+kandidat.getBeruf().getName());
        } else {
            log.info(msg+"kandidat.getBeruf() == null "+kandidat.getUniqueId());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"CommonFields:");
        if(kandidat.getCommonFields() != null) {
            log.debug(msg+kandidat.getCommonFields().toString());
        } else {
            log.debug(msg+"kandidat.getCommonFields() == null "+kandidat.getUniqueId());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Geburtsort:");
        if(kandidat.getGeburtsort() != null){
            log.debug(msg+kandidat.getGeburtsort().getName());
        } else {
            log.info(msg+"kandidat.getGeburtsort() == null "+kandidat.getUniqueId());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Wohnort:");
        if(kandidat.getWohnort() != null){
            log.debug(msg+kandidat.getWohnort().getName());
        } else {
            log.info(msg+"kandidat.getWohnort() == null "+kandidat.getUniqueId());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Wahlkreis:");
        if(kandidat.getWahlkreis() != null){
            log.debug(msg+kandidat.getWahlkreis().getName());
        } else {
            log.info(msg+"kandidat.getWahlkreis() == null "+kandidat.getUniqueId());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Fraktion:");
        if(kandidat.getFraktion() != null){
            log.debug(msg+kandidat.getFraktion().getName());
        } else {
            if(kandidat.getMdb() != null){
                log.info(msg+"kandidat.getFraktion() == null "+kandidat.getUniqueId());
            } else {
                log.debug(msg+"kandidat.getFraktion() == null "+kandidat.getUniqueId());
            }
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Webseite:");
        if(kandidat.getWebseite() != null){
            log.debug(msg+kandidat.getWebseite().getWebseite());
        } else {
            log.debug(msg+"kandidat.getWebseite() == null "+kandidat.getUniqueId());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Adresse.BundeslandEnum:");
        if(kandidat.getAdresse() != null && kandidat.getAdresse().getBundesland() != null){
            log.debug(msg+kandidat.getAdresse().getBundesland().getName());
        } else {
            log.info(msg+"kandidat.getAdresse().getBundesland() == null "+kandidat.getUniqueId());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Adresse:");
        if(kandidat.getAdresse() != null){
            log.debug(msg+kandidat.getAdresse().toString());
        } else {
            log.info(msg+"kandidat.getAdresse() == null "+kandidat.getUniqueId());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Ministerien:");
        for(Ministerium ministerium:kandidat.getMinisterien()){
            log.debug(msg+ministerium.getName());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"Ausschuesse:");
        for(Ausschuss ausschuss:kandidat.getAusschuesse()){
            log.debug(msg+ausschuss.getName());
        }
        log.debug(msg+"-----------------------------------------");
        log.debug(msg+"kandidat.toString():");
        log.debug(msg+kandidat.toString());
        log.debug(msg+"*****************************************");
    }
}