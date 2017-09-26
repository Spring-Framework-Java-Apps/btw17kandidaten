package org.woehlke.btw17.kandidaten.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.woehlke.btw17.kandidaten.frontend.content.ReportOverview;
import org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.service.KandidatFlatService;
import org.woehlke.btw17.kandidaten.oodm.service.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(StartupListener.class);

    private final SpringProperties springProperties;

    private final KandidatenProperties kandidatenProperties;

    private final BerufService berufService;

    private final BerufsgruppeService berufsgruppeService;

    private final BundeslandService bundeslandService;

    private final GeburtsortService geburtsortService;

    private final KandidatFlatService kandidatFlatService;

    private final KandidatService kandidatService;

    private final ListeParteiService listeParteiService;

    private final ParteiService parteiService;

    private final LandesListeService landesListeService;

    private final WahlkreisService wahlkreisService;

    private final WohnortService wohnortService;

    private final MinisteriumService ministeriumService;

    private final FraktionService fraktionService;

    private final AusschussService ausschussService;

    private final KandidatReportService kandidatReportService;

    private final WebseiteAgenturService webseiteAgenturService;

    private final WebseiteCmsService webseiteCmsService;

    @Autowired
    public StartupListener(SpringProperties springProperties, KandidatenProperties kandidatenProperties, BerufService berufService, BerufsgruppeService berufsgruppeService, BundeslandService bundeslandService, GeburtsortService geburtsortService, KandidatFlatService kandidatFlatService, KandidatService kandidatService, ListeParteiService listeParteiService, ParteiService parteiService, LandesListeService landesListeService, WahlkreisService wahlkreisService, WohnortService wohnortService, MinisteriumService ministeriumService, FraktionService fraktionService, AusschussService ausschussService, KandidatReportService kandidatReportService, WebseiteAgenturService webseiteAgenturService, WebseiteCmsService webseiteCmsService) {
        this.springProperties = springProperties;
        this.kandidatenProperties = kandidatenProperties;
        this.berufService = berufService;
        this.berufsgruppeService = berufsgruppeService;
        this.bundeslandService = bundeslandService;
        this.geburtsortService = geburtsortService;
        this.kandidatFlatService = kandidatFlatService;
        this.kandidatService = kandidatService;
        this.listeParteiService = listeParteiService;
        this.parteiService = parteiService;
        this.landesListeService = landesListeService;
        this.wahlkreisService = wahlkreisService;
        this.wohnortService = wohnortService;
        this.ministeriumService = ministeriumService;
        this.fraktionService = fraktionService;
        this.ausschussService = ausschussService;
        this.kandidatReportService = kandidatReportService;
        this.webseiteAgenturService = webseiteAgenturService;
        this.webseiteCmsService = webseiteCmsService;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        long databaseRows = kandidatFlatService.count();
        databaseRows += berufService.count();
        databaseRows += bundeslandService.countBundeslandAgentur();
        databaseRows += bundeslandService.count();
        databaseRows += geburtsortService.count();
        databaseRows += listeParteiService.count();
        databaseRows += parteiService.count();
        databaseRows += wahlkreisService.count();
        databaseRows += wohnortService.count();
        databaseRows += landesListeService.count();
        databaseRows += fraktionService.count();
        databaseRows += ministeriumService.count();
        databaseRows += ausschussService.count();
        databaseRows += webseiteCmsService.count();
        databaseRows += webseiteAgenturService.count();
        databaseRows += kandidatService.countKandidatAgentur();
        databaseRows += kandidatService.countKandidatAusschuss();
        databaseRows += kandidatService.countKandidatMinisterium();
        databaseRows += kandidatService.count();
        List<String> outputLines = new ArrayList<>();
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add("    ***  Bundestagswahl 2017 - Direkt Kandidaten  ***");
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        int i = 0;
        for(String path:kandidatenProperties.getWebSecurityConfigPublicPaths()){
            outputLines.add(" btw17.kandidaten.webSecurityConfigPublicPaths["+i+"] =   "+path);
            i++;
        }
        i = 0;
        for(String urlPrefix:kandidatenProperties.getUrlPrefixForKandidatFoto()){
            outputLines.add(" btw17.kandidaten.urlPrefixForKandidatFoto["+i+"] =        "+urlPrefix);
            i++;
        }
        outputLines.add(" btw17.kandidaten.pageSize =                           "+kandidatenProperties.getPageSize());
        outputLines.add(" btw17.kandidaten.loginUsername =                      "+kandidatenProperties.getLoginUsername());
        outputLines.add(" btw17.kandidaten.loginPassword =                      "+kandidatenProperties.getLoginPassword());
        outputLines.add(" btw17.kandidaten.googleMapsApiKey =                   "+kandidatenProperties.getGoogleMapsApiKey());
        outputLines.add(" btw17.kandidaten.googleAnalyticsKey =                 "+kandidatenProperties.getGoogleAnalyticsKey());
        outputLines.add(" btw17.kandidaten.googleSiteVerification =             "+kandidatenProperties.getGoogleSiteVerification());
        outputLines.add(" btw17.kandidaten.msvalidateKey =                      "+kandidatenProperties.getMsvalidateKey());
        outputLines.add(" btw17.kandidaten.twitterCardCreator =                 "+kandidatenProperties.getTwitterCardCreator());
        outputLines.add(" btw17.kandidaten.twitterCardSite =                    "+kandidatenProperties.getTwitterCardSite());
        outputLines.add(" btw17.kandidaten.facebookAppId =                      "+kandidatenProperties.getFacebookAppId());
        outputLines.add(" btw17.kandidaten.pageSubTitle =                       "+kandidatenProperties.getPageSubTitle());
        outputLines.add(" btw17.kandidaten.connTimeToLive =                     "+kandidatenProperties.getConnTimeToLive());
        outputLines.add(" btw17.kandidaten.maxIdleTime =                        "+kandidatenProperties.getMaxIdleTime());
        outputLines.add(" btw17.kandidaten.millisToWaitBetweenTwoApiCalls =     "+kandidatenProperties.getMillisToWaitBetweenTwoApiCalls());
        outputLines.add(" btw17.kandidaten.checkFotoUrl =                       "+kandidatenProperties.getCheckFotoUrl());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add(" spring.datasource.url = "+springProperties.getDatasource().getUrl());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        ReportOverview reportOverview = kandidatReportService.getOverview();
        outputLines.add("Mdb:                                 "+reportOverview.getCountMdb());
        outputLines.add(" Mdb without Abgeordnetenwatch:      "+reportOverview.getCountMdbWithoutAbgeordnetenwatch());
        outputLines.add(" Mdb without FotoUrl:                "+reportOverview.getCountMdbWithoutFotoUrl());
        outputLines.add(" Mdb without BundestagProfile:       "+reportOverview.getCountMdbWithoutBundestagProfile());
        outputLines.add(" Mdb without WikipediaArticle:       "+reportOverview.getCountMdbWithoutWikipediaArticle());
        outputLines.add(" Mdb without Twitter:                "+reportOverview.getCountMdbWithoutTwitter());
        outputLines.add(" Mdb without Facebook:               "+reportOverview.getCountMdbWithoutFacebook());
        outputLines.add(" Mdb without Webseite:               "+reportOverview.getCountMdbWithoutWebseite());
        outputLines.add("Kandidat:                            "+reportOverview.getCountKandidat());
        outputLines.add(" Kandidat without Abgeordnetenwatch: "+reportOverview.getCountKandidatWithoutAbgeordnetenwatch());
        outputLines.add(" Kandidat without FotoUrl:           "+reportOverview.getCountKandidatWithoutFotoUrl());
        outputLines.add(" Kandidat without Twitter:           "+reportOverview.getCountKandidatWithoutTwitter());
        outputLines.add(" Kandidat without Facebook:          "+reportOverview.getCountKandidatWithoutFacebook());
        outputLines.add(" Kandidat without Webseite:          "+reportOverview.getCountKandidatWithoutWebseite());
        outputLines.add(" Kandidat without LobbypediaUrl:     "+reportOverview.getCountKandidatWithoutLobbypediaUrl());
        outputLines.add(" Kandidat without Soundcloud:        "+reportOverview.getCountKandidatWithoutSoundcloud());
        outputLines.add(" Kandidat without Youtube:           "+reportOverview.getCountKandidatWithoutYoutube());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.bundeswahlleiter.model.KandidatFlat: "+kandidatFlatService.count());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Beruf:                "+berufService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe:         "+berufsgruppeService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Bundesland2Agentur:   "+bundeslandService.countBundeslandAgentur());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Bundesland:           "+bundeslandService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Geburtsort:           "+geburtsortService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.ListePartei:          "+listeParteiService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Partei:               "+parteiService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis:            "+wahlkreisService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Wohnort:              "+wohnortService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.LandesListe:          "+landesListeService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Fraktion:             "+fraktionService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Ministerium:          "+ministeriumService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Ausschuss:            "+ausschussService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.WebseiteCms:          "+webseiteCmsService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur:      "+webseiteAgenturService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Kandidat2Agentur:     "+kandidatService.countKandidatAgentur());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Kandidat2Ausschuss:   "+kandidatService.countKandidatAusschuss());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Kandidat2Ministerium: "+kandidatService.countKandidatMinisterium());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.model.Kandidat:             "+kandidatService.count());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add(" Database Rows: "+databaseRows);
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        for(String outputLine:outputLines){
            sb.append(outputLine);
            sb.append("\n");
        }
        log.info(sb.toString());
    }
}
