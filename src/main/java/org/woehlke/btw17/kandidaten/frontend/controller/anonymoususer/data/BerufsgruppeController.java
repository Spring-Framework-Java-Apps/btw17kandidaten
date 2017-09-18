package org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.woehlke.btw17.kandidaten.configuration.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.BerufsgruppeService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe
 */
@Controller
@RequestMapping("/berufsgruppe")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class BerufsgruppeController extends AbstractController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "berufsgruppe"
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Berufsgruppe";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.BERUFSGRUPPE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/berufsgruppe/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);

        Page<Berufsgruppe> allBerufsgruppePage =  berufsgruppeService.getAll(pageable);
        model.addAttribute("berufsgruppen", allBerufsgruppePage);
        return "berufsgruppe/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") Berufsgruppe berufsgruppe, HttpSession session, Model model
    ) {
        if(berufsgruppe == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = berufsgruppe.getBerufsgruppe();
            String pageSubTitle = "Berufsgruppen der Bundestagswahl 2017 Direktkandidaten";
            String pageSymbol = PageSymbol.BERUFSGRUPPE.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/berufsgruppe/"+berufsgruppe.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("berufsgruppe",berufsgruppe);

            Page<Kandidat> kandidatenPage  = kandidatService.findByBerufsgruppe(berufsgruppe,pageable);
            model.addAttribute("kandidaten",kandidatenPage);
            return "berufsgruppe/id";
        }
    }

    private final BerufsgruppeService berufsgruppeService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public BerufsgruppeController(SessionHandler sessionHandler, BerufsgruppeService berufsgruppeService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.berufsgruppeService = berufsgruppeService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}