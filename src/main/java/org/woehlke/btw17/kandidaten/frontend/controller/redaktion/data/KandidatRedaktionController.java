package org.woehlke.btw17.kandidaten.frontend.controller.redaktion.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.woehlke.btw17.kandidaten.configuration.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
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

import javax.servlet.http.HttpSession;

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
        String pagerUrl = "/redaktion/kandidat/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);
        Page<Kandidat> allKandidatenPage =  kandidatService.getAll(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);
        return "kandidat/all";
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

    private static final Logger log = LoggerFactory.getLogger(KandidatRedaktionController.class);

    private final KandidatService kandidatService;

    private final AusschussService ausschussService;

    private final FraktionService fraktionService;

    private final MinisteriumService ministeriumService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public KandidatRedaktionController(SessionHandler sessionHandler, KandidatService kandidatService, AusschussService ausschussService, FraktionService fraktionService, MinisteriumService ministeriumService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.kandidatService = kandidatService;
        this.ausschussService = ausschussService;
        this.fraktionService = fraktionService;
        this.ministeriumService = ministeriumService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
