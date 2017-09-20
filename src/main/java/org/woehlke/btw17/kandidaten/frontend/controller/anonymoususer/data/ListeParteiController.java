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
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.ListeParteiService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.ListePartei
 */
@Controller
@RequestMapping("/listepartei")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class ListeParteiController extends AbstractController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "listePartei"
            ) Pageable pageable,
            HttpSession session,
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
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);
        Page<ListePartei> allListeParteiPage =  listeParteiService.getAll(pageable);
        model.addAttribute("listeparteien", allListeParteiPage);
        return "listepartei/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") ListePartei listePartei,
            HttpSession session,
            HttpServletRequest request,
            Model model
    ) {
        if(listePartei == null){
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
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
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
