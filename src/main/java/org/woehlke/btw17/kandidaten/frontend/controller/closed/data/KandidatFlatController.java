package org.woehlke.btw17.kandidaten.frontend.controller.closed.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.woehlke.btw17.kandidaten.frontend.model.enums.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.frontend.model.PageContent;
import org.woehlke.btw17.kandidaten.frontend.model.enums.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.model.SessionHandler;
import org.woehlke.btw17.kandidaten.frontend.controller.common.AbstractController;
import org.woehlke.btw17.kandidaten.oodm.model.Btw17KandidatFlat;
import org.woehlke.btw17.kandidaten.oodm.service.Btw17KandidatFlatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Slf4j
@Controller
@RequestMapping("/kandidatflat")
@SessionAttributes({"suchformular","suchformularFreitext"})
public class KandidatFlatController extends AbstractController {


    @RequestMapping("/all")
    public String all(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            Model model
    ) {
        String pageTitle = "Kandidaten";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/kandidatflat/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        String msvalidateKey = kandidatenProperties.getMsvalidateKey();
        String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
        String facebookAppId = kandidatenProperties.getFacebookAppId();
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
        model.addAttribute("pageContent",pageContent);
        Page<Btw17KandidatFlat> allKandidatenPage =  btw17KandidatFlatService.getAll(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);
        return "kandidatflat/all";
    }

    @RequestMapping("/{id}")
    public String id(
            @PathVariable("id") Btw17KandidatFlat btw17KandidatFlat, Model model
    ) {
        if(btw17KandidatFlat == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = btw17KandidatFlat.getVorname()+" "+ btw17KandidatFlat.getNachname();
            if(btw17KandidatFlat.getListePartei() != null){
                pageTitle += ", "+ btw17KandidatFlat.getListePartei();
            } else if (btw17KandidatFlat.getPartei() != null){
                pageTitle += ", "+ btw17KandidatFlat.getPartei();
            }
            String pageSubTitle = "Kandidaten der btw17";
            String pageSymbol = PageSymbol.KANDIDAT.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/kandidatflat/"+ btw17KandidatFlat.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            String msvalidateKey = kandidatenProperties.getMsvalidateKey();
            String googleSiteVerification = kandidatenProperties.getGoogleSiteVerification();
            String facebookAppId = kandidatenProperties.getFacebookAppId();
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss, msvalidateKey,googleSiteVerification,facebookAppId);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("kandidat", btw17KandidatFlat);
            return "kandidatflat/id";
        }
    }

    private final Btw17KandidatFlatService btw17KandidatFlatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public KandidatFlatController(SessionHandler sessionHandler, Btw17KandidatFlatService btw17KandidatFlatService, KandidatenProperties kandidatenProperties) {
        super(sessionHandler);
        this.btw17KandidatFlatService = btw17KandidatFlatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
