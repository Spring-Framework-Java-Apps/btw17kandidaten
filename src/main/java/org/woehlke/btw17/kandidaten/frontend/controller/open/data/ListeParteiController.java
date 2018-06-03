package org.woehlke.btw17.kandidaten.frontend.controller.open.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.woehlke.btw17.kandidaten.frontend.model.enums.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.model.PageContent;
import org.woehlke.btw17.kandidaten.frontend.model.enums.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.model.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.db.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.db.service.ListeParteiService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.PAGE_SIZE;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.db.model.ListePartei
 */
@Controller
@RequestMapping("/listepartei")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class ListeParteiController extends AbstractController {

    @RequestMapping("/all")
    public String all(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "listePartei",
                    direction= Sort.Direction.ASC
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "ListePartei";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/listepartei/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);
        Page<ListePartei> allListeParteiPage =  listeParteiService.getAll(pageable);
        model.addAttribute("listeparteien", allListeParteiPage);
        return "listepartei/all";
    }

    @RequestMapping("/{id}")
    public String id(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") ListePartei listePartei,
            Model model
    ) {
        if(listePartei == null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            String msg = "url: " + request.getRequestURL().toString() +" in ListeParteiController.getUserForId";
            throw new EntityNotFoundException(msg);
        } else {
            String pageTitle = listePartei.getListePartei();
            String pageSubTitle = listePartei.getListeParteiLang();
            String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/listepartei/"+listePartei.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            String msvalidateKey = kandidatenProperties.getMsvalidateKey();
            String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
            String facebookAppId = kandidatenProperties.getFacebookAppId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("listePartei",listePartei);
            Page<Kandidat> pageKandidat = kandidatService.findByListePartei(listePartei,pageable);
            model.addAttribute("kandidaten",pageKandidat);
            return "listepartei/id";
        }
    }

    private final ListeParteiService listeParteiService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public ListeParteiController(SessionHandler sessionHandler, ListeParteiService listeParteiService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.listeParteiService = listeParteiService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
