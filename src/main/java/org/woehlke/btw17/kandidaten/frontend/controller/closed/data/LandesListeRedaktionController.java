package org.woehlke.btw17.kandidaten.frontend.controller.closed.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.woehlke.btw17.kandidaten.frontend.model.enums.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.model.enums.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.model.PageContent;
import org.woehlke.btw17.kandidaten.frontend.model.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.db.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.db.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.db.service.LandesListeService;


import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.db.service.KandidatService.PAGE_SIZE;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.db.model.LandesListe
 */
@Controller
@RequestMapping("/redaktion/landesliste")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class LandesListeRedaktionController extends AbstractController {

    @RequestMapping("/bundesland/all")
    public String bundeslandAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Bundesländer der LandesListen";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/redaktion/landesliste/bundesland/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);
        Page<Bundesland> allBundeslandPage =  landesListeService.getAllBundesland(pageable);
        model.addAttribute("bundeslaender", allBundeslandPage);
        model.addAttribute("bundeslandIdTarget","landesliste/bundesland");
        return "landesliste/bundesland/all";
    }

    @RequestMapping("/listepartei/all")
    public String listeparteiAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Partei Listen der LandesListen";
        String pageSubTitle = "btw17 Kandidaten";
        String pageSymbol = PageSymbol.LANDESLISTE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/redaktion/landesliste/listepartei/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);
        Page<ListePartei> allListeParteiPage = landesListeService.getAllListePartei(pageable);
        model.addAttribute("listeparteien", allListeParteiPage);
        return "landesliste/listepartei/all";
    }

    private final LandesListeService landesListeService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public LandesListeRedaktionController(SessionHandler sessionHandler, LandesListeService landesListeService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.landesListeService = landesListeService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
