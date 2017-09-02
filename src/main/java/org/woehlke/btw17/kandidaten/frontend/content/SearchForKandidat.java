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

    private String berufsgruppe;

    private String bundesland;

    private String wahlkreis;

    private String partei;

    private String landesListe;

    //@Pattern(regexp="[a-zA-Z0-9_]*")
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

    public String getBerufsgruppe() {
        return berufsgruppe;
    }

    public void setBerufsgruppe(String berufsgruppe) {
        this.berufsgruppe = berufsgruppe;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public String getWahlkreis() {
        return wahlkreis;
    }

    public void setWahlkreis(String wahlkreis) {
        this.wahlkreis = wahlkreis;
    }

    public String getPartei() {
        return partei;
    }

    public void setPartei(String partei) {
        this.partei = partei;
    }

    public String getLandesListe() {
        return landesListe;
    }

    public void setLandesListe(String landesListe) {
        this.landesListe = landesListe;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchForKandidat)) return false;

        SearchForKandidat that = (SearchForKandidat) o;

        if (nachname != null ? !nachname.equals(that.nachname) : that.nachname != null) return false;
        if (vorname != null ? !vorname.equals(that.vorname) : that.vorname != null) return false;
        if (geschlecht != null ? !geschlecht.equals(that.geschlecht) : that.geschlecht != null) return false;
        if (geburtsjahr != null ? !geburtsjahr.equals(that.geburtsjahr) : that.geburtsjahr != null) return false;
        if (wohnort != null ? !wohnort.equals(that.wohnort) : that.wohnort != null) return false;
        if (geburtsort != null ? !geburtsort.equals(that.geburtsort) : that.geburtsort != null) return false;
        if (beruf != null ? !beruf.equals(that.beruf) : that.beruf != null) return false;
        if (berufsgruppe != null ? !berufsgruppe.equals(that.berufsgruppe) : that.berufsgruppe != null) return false;
        if (bundesland != null ? !bundesland.equals(that.bundesland) : that.bundesland != null) return false;
        if (wahlkreis != null ? !wahlkreis.equals(that.wahlkreis) : that.wahlkreis != null) return false;
        if (partei != null ? !partei.equals(that.partei) : that.partei != null) return false;
        if (landesListe != null ? !landesListe.equals(that.landesListe) : that.landesListe != null) return false;
        return twitter != null ? twitter.equals(that.twitter) : that.twitter == null;
    }

    @Override
    public int hashCode() {
        int result = nachname != null ? nachname.hashCode() : 0;
        result = 31 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 31 * result + (geschlecht != null ? geschlecht.hashCode() : 0);
        result = 31 * result + (geburtsjahr != null ? geburtsjahr.hashCode() : 0);
        result = 31 * result + (wohnort != null ? wohnort.hashCode() : 0);
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        result = 31 * result + (beruf != null ? beruf.hashCode() : 0);
        result = 31 * result + (berufsgruppe != null ? berufsgruppe.hashCode() : 0);
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (wahlkreis != null ? wahlkreis.hashCode() : 0);
        result = 31 * result + (partei != null ? partei.hashCode() : 0);
        result = 31 * result + (landesListe != null ? landesListe.hashCode() : 0);
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SearchForKandidat{" +
                "nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                ", geschlecht='" + geschlecht + '\'' +
                ", geburtsjahr='" + geburtsjahr + '\'' +
                ", wohnort='" + wohnort + '\'' +
                ", geburtsort='" + geburtsort + '\'' +
                ", beruf='" + beruf + '\'' +
                ", berufsgruppe='" + berufsgruppe + '\'' +
                ", bundesland='" + bundesland + '\'' +
                ", wahlkreis='" + wahlkreis + '\'' +
                ", partei='" + partei + '\'' +
                ", landesListe='" + landesListe + '\'' +
                ", twitter='" + twitter + '\'' +
                '}';
    }
}
