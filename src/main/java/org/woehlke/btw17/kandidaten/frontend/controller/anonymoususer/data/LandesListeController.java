package org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.woehlke.btw17.kandidaten.configuration.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.model.*;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.LandesListeService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.LandesListe
 */
@Controller
@RequestMapping("/landesliste")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class LandesListeController extends AbstractController {


    @RequestMapping("/{id}")
    public String getLandesListeForId(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") LandesListe landesListe,
            HttpSession session,
            HttpRequest request,
            Model model
    ) {
        if(landesListe == null){
            String msg = "";
            throw new EntityNotFoundException(msg);
        } else {
            String pageTitle = landesListe.getName();
            String pageSubTitle = "LandesListe der btw17 Kandidaten";
            String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/landesliste/"+landesListe.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("landesListe",landesListe);
            Page<Kandidat> kandidatenPage  = kandidatService.findByLandesListe(landesListe,pageable);
            model.addAttribute("kandidaten",kandidatenPage);
            return "landesliste/id";
        }
    }

    @RequestMapping("/bundesland/{id}")
    public String getLandesListeForBundesland(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") Bundesland bundesland,
            HttpSession session,
            HttpRequest request,
            Model model
    ) {
        if(bundesland == null){
            String msg = "url: "+request.getURI().toString()+" in LandesListeController.getLandesListeForBundesland";
            throw new EntityNotFoundException(msg);
        } else {
            String pageTitle = "LandesListen in "+ bundesland.getName();
            String pageSubTitle = "btw17 Kandidaten";
            String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/landesliste/bundesland/"+bundesland.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("bundesland",bundesland);
            Page<LandesListe> landeslistePage  = landesListeService.findByBundesland(bundesland,pageable);
            model.addAttribute("landeslistePage",landeslistePage);
            model.addAttribute("bundeslandIdTarget","landesliste");
            return "landesliste/bundesland/id";
        }
    }

    @RequestMapping("/listepartei/{id}")
    public String getLandesListeForListePartei(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") ListePartei listePartei,
            HttpSession session,
            HttpRequest request,
            Model model
    ) {
        if(listePartei == null){
            String msg = "url: "+request.getURI().toString()+" in LandesListeController.getLandesListeForBundesland";
            throw new EntityNotFoundException(msg);
        } else {
            String pageTitle = "LandesListen der "+ listePartei.getListePartei();
            String pageSubTitle = "btw17 Kandidaten";
            String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/landesliste/listepartei/"+listePartei.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("listePartei",listePartei);
            Page<LandesListe> landeslistePage  = landesListeService.findByListePartei(listePartei,pageable);
            model.addAttribute("landeslistePage",landeslistePage);
            model.addAttribute("bundeslandIdTarget","landesliste");
            return "landesliste/listepartei/id";
        }
    }

    @RequestMapping("/bundesland/all")
    public String getLandesListeForBundeslandAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Bundesländer der LandesListen";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/landesliste/bundesland/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);
        Page<Bundesland> allBundeslandPage =  landesListeService.getAllBundesland(pageable);
        model.addAttribute("bundeslaender", allBundeslandPage);
        model.addAttribute("bundeslandIdTarget","landesliste/bundesland");
        return "landesliste/bundesland/all";
    }

    @RequestMapping("/listepartei/all")
    public String getLandesListeForListeParteiAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Partei Listen der LandesListen";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/landesliste/listepartei/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);
        Page<ListePartei> allListeParteiPage = landesListeService.getAllListePartei(pageable);
        model.addAttribute("listeparteien", allListeParteiPage);
        return "landesliste/listepartei/all";
    }

    private final LandesListeService landesListeService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public LandesListeController(SessionHandler sessionHandler, LandesListeService landesListeService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.landesListeService = landesListeService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
