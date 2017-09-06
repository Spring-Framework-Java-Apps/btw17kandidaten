package org.woehlke.btw17.kandidaten.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.PageSymbol;
import org.woehlke.btw17.kandidaten.frontend.content.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.content.PageContent;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;
import org.woehlke.btw17.kandidaten.oodm.model.Kandidat;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.servlet.http.HttpSession;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/report")
public class ReportController {

    @RequestMapping("/overview")
    public String overview(
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Übersicht";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/report/mdb/bundestag";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = true;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator, showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "report/overview";
    }


    @RequestMapping("/mdb/bundestag")
    public String getMdbWithoutBundestagProfile(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ) {
        String pageTitle = "Alle MdB ohne Bundestags Profil";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/report/mdb/bundestag";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = true;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator, showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getMdbWithoutBundestagProfile(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "report/mdb/bundestag";
    }


    @RequestMapping("/mdb/abgeordnetenwatch")
    public String getMdbWithoutAbgeordnetenwatch(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ){
        String pageTitle = "Alle MdB ohne Abgeordnetenwatch";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/report/mdb/abgeordnetenwatch";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = true;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator, showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getMdbWithoutAbgeordnetenwatch(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "report/mdb/abgeordnetenwatch";
    }

    @RequestMapping("/mdb/wikipedia")
    public String getMdbWithoutWikipediaArticle(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ){
        String pageTitle = "Alle MdB ohne Wikipedia";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/report/mdb/wikipedia";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = true;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator, showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getMdbWithoutWikipediaArticle(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "report/mdb/wikipedia";
    }

    @RequestMapping("/mdb/webseite")
    public String getMdbWithoutWebseite(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ){
        String pageTitle = "Alle MdB ohne Webseitel";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/report/mdb/webseite";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = true;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator, showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getMdbWithoutWebseite(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "report/mdb/webseite";
    }

    @RequestMapping("/mdb/facebook")
    public String getMdbWithoutFacebook(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ){
        String pageTitle = "Alle MdB ohne Facebook";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/report/mdb/facebook";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = true;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator, showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getMdbWithoutFacebook(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "report/mdb/facebook";
    }

    @RequestMapping("/mdb/twitter")
    public String getMdbWithoutTwitter(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ){
        String pageTitle = "Alle MdB ohne Twitter";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/report/mdb/twitter";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = true;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator, showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getMdbWithoutTwitter(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "report/mdb/twitter";
    }

    @RequestMapping("/kandidat/webseite")
    public String getKandidatWithoutWebseite(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ){
        String pageTitle = "Kandidat ohne Webseite";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/report/kandidat/webseite";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = true;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator, showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getKandidatWithoutWebseite(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "report/kandidat/webseite";
    }

    @RequestMapping("/kandidat/facebook")
    public String getKandidatWithoutFacebook(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ){
        String pageTitle = "Kandidat ohne Facebook";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/report/kandidat/facebook";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = true;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator, showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getKandidatWithoutFacebook(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "report/kandidat/facebook";
    }

    @RequestMapping("/kandidat/twitter")
    public String getKandidatWithoutTwitter(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            HttpSession session,
            Model model
    ){
        String pageTitle = "Kandidat ohne Twitter";
        String pageSubTitle = kandidatenProperties.getPageSubTitle();
        String pageSymbol = PageSymbol.STARTSEITE.getSymbolHtml();
        String googleMapsApiKey = kandidatenProperties.getGoogleMapsApiKey();
        String googleAnalyticsKey = kandidatenProperties.getGoogleAnalyticsKey();
        String pagerUrl = "/report/kandidat/twitter";
        String twitterCardSite = kandidatenProperties.getTwitterCardSite();
        String twitterCardCreator = kandidatenProperties.getTwitterCardCreator();
        boolean showDebugInfos = true;
        PageContent pageContent = new PageContent(pageTitle, pageSubTitle, pageSymbol, googleMapsApiKey, googleAnalyticsKey, pagerUrl,twitterCardSite,twitterCardCreator, showDebugInfos);
        model.addAttribute("pageContent",pageContent);

        Page<Kandidat> allKandidatenPage =  kandidatService.getKandidatWithoutTwitter(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);

        FreitextSucheFormular suchformularFreitext = sessionHandler.setSession(session,model);
        return "report/kandidat/twitter";
    }



    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    private final SessionHandler sessionHandler;


    @Autowired
    public ReportController(KandidatService kandidatService, KandidatenProperties kandidatenProperties, SessionHandler sessionHandler) {
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
        this.sessionHandler = sessionHandler;
    }
}
