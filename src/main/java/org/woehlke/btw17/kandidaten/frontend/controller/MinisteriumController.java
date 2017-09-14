package org.woehlke.btw17.kandidaten.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.JumbotronImage;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.model.Ministerium;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.MinisteriumService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/ministerium")
public class MinisteriumController {


    @RequestMapping("/all")
    public String getAllMinisterium(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "partei"
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Ministerien";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.MINISTERIUM.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/ministerium/all";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
        model.addAttribute("pageContent",pageContent);

        Page<Ministerium> pageAllMinisterium =  ministeriumService.getAll(pageable);
        model.addAttribute("ministerien", pageAllMinisterium);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "ministerium/all";
    }

    @RequestMapping("/{id}")
    public String getMinisteriumForId(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            @PathVariable("id") Ministerium ministerium, HttpSession session, Model model
    ) {
        if(ministerium == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = ministerium.getMinisterium();
            String pageSubTitle = ministerium.getMinisteriumLang();
            String pageSymbol = PageSymbol.MINISTERIUM.getSymbolHtml();
            String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
            String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
            String pagerUrl = "/ministerium/"+ministerium.getId();
            String twitterCardSite = kandidatenProperties.getTwitterCardSite();
            String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
            JumbotronImage imageCss =  JumbotronImage.REICHSTAG_01;
            PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator,imageCss);
            model.addAttribute("pageContent",pageContent);
            model.addAttribute("ministerium",ministerium);

            Page<Kandidat> kandidatenPage  = kandidatService.findByMinisterium(ministerium,pageable);
            model.addAttribute("kandidaten",kandidatenPage);

            //List<Kandidat> kandidatenList  = new ArrayList<>();
            //Page<Kandidat> kandidatenPage  = new PageImpl<Kandidat>(kandidatenList,pageable,0L);
            //model.addAttribute("kandidaten",kandidatenPage);
            FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);

            return "ministerium/id";
        }
    }

    private final MinisteriumService ministeriumService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    private final SessionHandler sessionHandler;


    @Autowired
    public MinisteriumController(MinisteriumService ministeriumService, KandidatService kandidatService, KandidatenProperties kandidatenProperties, SessionHandler sessionHandler) {
        this.ministeriumService = ministeriumService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
        this.sessionHandler = sessionHandler;
    }
}
