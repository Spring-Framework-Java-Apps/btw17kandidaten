package org.woehlke.btw17.kandidaten.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.woehlke.btw17.kandidaten.configuration.properties.KandidatenProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.OtherProperties;
import org.woehlke.btw17.kandidaten.configuration.properties.SpringProperties;
import org.woehlke.btw17.kandidaten.frontend.model.ReportOverview;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.Btw17MdbService;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.Btw17WahlperiodeService;
import org.woehlke.btw17.kandidaten.oodm.jpa.service.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(StartupListener.class);

    private final SpringProperties springProperties;

    private final KandidatenProperties kandidatenProperties;

    private final OtherProperties otherProperties;

    private final BerufService berufService;

    private final BerufsgruppeService berufsgruppeService;

    private final BundeslandService bundeslandService;

    private final GeburtsortService geburtsortService;

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

    private final WahlperiodeService wahlperiodeService;

    private final WebseiteCmsService webseiteCmsService;

    private final Btw17ErgebnisService btw17ErgebnisService;

    private final Btw17StrukturdatenService btw17StrukturdatenService;

    private final Btw17WahlbewerberService btw17WahlbewerberService;

    private final Btw17WahlkreisService btw17WahlkreisService;

    private final Btw17KandidatFlatService btw17KandidatFlatService;

    private final Btw17MdbService btw17MdbService;

    private final Btw17WahlperiodeService btw17WahlperiodeService;

    @Autowired
    public StartupListener(SpringProperties springProperties, KandidatenProperties kandidatenProperties, OtherProperties otherProperties, BerufService berufService, BerufsgruppeService berufsgruppeService, BundeslandService bundeslandService, GeburtsortService geburtsortService, Btw17KandidatFlatService btw17KandidatFlatService, KandidatService kandidatService, ListeParteiService listeParteiService, ParteiService parteiService, LandesListeService landesListeService, WahlkreisService wahlkreisService, WohnortService wohnortService, MinisteriumService ministeriumService, FraktionService fraktionService, AusschussService ausschussService, KandidatReportService kandidatReportService, WebseiteAgenturService webseiteAgenturService, WahlperiodeService wahlperiodeService, WebseiteCmsService webseiteCmsService, Btw17ErgebnisService btw17ErgebnisService, Btw17StrukturdatenService btw17StrukturdatenService, Btw17WahlbewerberService btw17WahlbewerberService, Btw17WahlkreisService btw17WahlkreisService, Btw17MdbService btw17MdbService, Btw17WahlperiodeService btw17WahlperiodeService) {
        this.springProperties = springProperties;
        this.kandidatenProperties = kandidatenProperties;
        this.otherProperties = otherProperties;
        this.berufService = berufService;
        this.berufsgruppeService = berufsgruppeService;
        this.bundeslandService = bundeslandService;
        this.geburtsortService = geburtsortService;
        this.btw17KandidatFlatService = btw17KandidatFlatService;
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
        this.wahlperiodeService = wahlperiodeService;
        this.webseiteCmsService = webseiteCmsService;
        this.btw17ErgebnisService = btw17ErgebnisService;
        this.btw17StrukturdatenService = btw17StrukturdatenService;
        this.btw17WahlbewerberService = btw17WahlbewerberService;
        this.btw17WahlkreisService = btw17WahlkreisService;
        this.btw17MdbService = btw17MdbService;
        this.btw17WahlperiodeService = btw17WahlperiodeService;
    }

    private long getDatabaseRows(){
        long databaseRows = btw17KandidatFlatService.count();
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
        databaseRows += btw17ErgebnisService.count();
        databaseRows += btw17StrukturdatenService.count();
        databaseRows += btw17WahlbewerberService.count();
        databaseRows += btw17WahlkreisService.count();
        databaseRows += btw17KandidatFlatService.count();
        databaseRows += btw17MdbService.count();
        databaseRows += btw17WahlperiodeService.count();
        databaseRows += btw17MdbService.countBtw17Mdb2Wahlperiode();
        return databaseRows;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        String regex="\\n\\n";
        String replacement="\n";
        List<String> outputLines = new ArrayList<>();
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add("    ***  Bundestagswahl 2017 - Direkt Kandidaten  ***");
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add(kandidatenProperties.toString());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add(springProperties.toString());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add(otherProperties.toString());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        ReportOverview reportOverview = kandidatReportService.getOverview();
        outputLines.add(reportOverview.toString());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Beruf:                "+berufService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Berufsgruppe:         "+berufsgruppeService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Bundesland2Agentur:   "+bundeslandService.countBundeslandAgentur());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Bundesland:           "+bundeslandService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Geburtsort:           "+geburtsortService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.ListePartei:          "+listeParteiService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Partei:               "+parteiService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Wahlkreis:            "+wahlkreisService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Ort:              "+wohnortService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.ListeParteiBundesland:          "+landesListeService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Fraktion:             "+fraktionService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Ministerium:          "+ministeriumService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Ausschuss:            "+ausschussService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Wahlperiode           "+wahlperiodeService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Cms:          "+webseiteCmsService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Dienstleister:      "+webseiteAgenturService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat2Agentur:     "+kandidatService.countKandidatAgentur());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat2Ausschuss:   "+kandidatService.countKandidatAusschuss());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat2Ministerium: "+kandidatService.countKandidatMinisterium());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat:             "+kandidatService.count());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Ergebnis:        "+btw17ErgebnisService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Strukturdaten:   "+btw17StrukturdatenService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlbewerber:    "+btw17WahlbewerberService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlkreis:       "+btw17WahlkreisService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Btw17KandidatFlat:    "+btw17KandidatFlatService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Mdb:             "+btw17MdbService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlperiode:     "+btw17WahlperiodeService.count());
        outputLines.add(" org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Mdb2Wahlperiode: "+btw17MdbService.countBtw17Mdb2Wahlperiode());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        outputLines.add(" Database Rows: "+getDatabaseRows());
        outputLines.add("--------------------------------------------------------------------------------------------------------------");
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        for(String outputLine:outputLines){
            sb.append(outputLine);
            sb.append("\n");
        }
        log.info(sb.toString().replaceAll(regex,replacement));
    }
}
