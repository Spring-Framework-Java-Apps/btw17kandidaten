package org.woehlke.btw17.kandidaten.frontend.content;

import org.woehlke.btw17.kandidaten.oodm.model.*;

import java.io.Serializable;

public class SearchForKandidat implements Serializable {

    private String nachname;

    private String vorname;

    private String geschlecht;

    private String geburtsjahr;

    private String wohnort;

    private String geburtsort;

    private String beruf;

    private Berufsgruppe berufsgruppe;

    private Bundesland bundesland;

    private Wahlkreis wahlkreis;

    private Partei partei;

    private LandesListe landesListe;

    private String twitter;

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(String geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

    public Berufsgruppe getBerufsgruppe() {
        return berufsgruppe;
    }

    public void setBerufsgruppe(Berufsgruppe berufsgruppe) {
        this.berufsgruppe = berufsgruppe;
    }

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        this.bundesland = bundesland;
    }

    public Wahlkreis getWahlkreis() {
        return wahlkreis;
    }

    public void setWahlkreis(Wahlkreis wahlkreis) {
        this.wahlkreis = wahlkreis;
    }

    public Partei getPartei() {
        return partei;
    }

    public void setPartei(Partei partei) {
        this.partei = partei;
    }

    public LandesListe getLandesListe() {
        return landesListe;
    }

    public void setLandesListe(LandesListe landesListe) {
        this.landesListe = landesListe;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
