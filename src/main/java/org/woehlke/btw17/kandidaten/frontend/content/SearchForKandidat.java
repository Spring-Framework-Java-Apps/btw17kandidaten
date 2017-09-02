package org.woehlke.btw17.kandidaten.frontend.content;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.validation.annotation.Validated;
import org.woehlke.btw17.kandidaten.oodm.model.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Validated
public class SearchForKandidat implements Serializable {

    @SafeHtml
    private String nachname;

    @SafeHtml
    private String vorname;

    @SafeHtml
    private String geschlecht;

    @Digits(integer=4,fraction = 0)
    @DecimalMin("1936")
    @DecimalMax("2017")
    private String minGeburtsjahr;

    @Digits(integer=4,fraction = 0)
    @DecimalMin("1936")
    @DecimalMax("2017")
    private String maxGeburtsjahr;

    @SafeHtml
    private String wohnort;

    @SafeHtml
    private String geburtsort;

    @SafeHtml
    private String beruf;

    private Berufsgruppe berufsgruppe;

    private Bundesland bundesland;

    private Wahlkreis wahlkreis;

    private Partei partei;

    private LandesListe landesListe;

    @Pattern(regexp="[a-zA-Z0-9_]*")
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

    public String getMinGeburtsjahr() {
        return minGeburtsjahr;
    }

    public void setMinGeburtsjahr(String minGeburtsjahr) {
        this.minGeburtsjahr = minGeburtsjahr;
    }

    public String getMaxGeburtsjahr() {
        return maxGeburtsjahr;
    }

    public void setMaxGeburtsjahr(String maxGeburtsjahr) {
        this.maxGeburtsjahr = maxGeburtsjahr;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchForKandidat)) return false;

        SearchForKandidat that = (SearchForKandidat) o;

        if (nachname != null ? !nachname.equals(that.nachname) : that.nachname != null) return false;
        if (vorname != null ? !vorname.equals(that.vorname) : that.vorname != null) return false;
        if (geschlecht != null ? !geschlecht.equals(that.geschlecht) : that.geschlecht != null) return false;
        if (minGeburtsjahr != null ? !minGeburtsjahr.equals(that.minGeburtsjahr) : that.minGeburtsjahr != null)
            return false;
        if (maxGeburtsjahr != null ? !maxGeburtsjahr.equals(that.maxGeburtsjahr) : that.maxGeburtsjahr != null)
            return false;
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
        result = 31 * result + (minGeburtsjahr != null ? minGeburtsjahr.hashCode() : 0);
        result = 31 * result + (maxGeburtsjahr != null ? maxGeburtsjahr.hashCode() : 0);
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
                ", minGeburtsjahr='" + minGeburtsjahr + '\'' +
                ", maxGeburtsjahr='" + maxGeburtsjahr + '\'' +
                ", wohnort='" + wohnort + '\'' +
                ", geburtsort='" + geburtsort + '\'' +
                ", beruf='" + beruf + '\'' +
                ", berufsgruppe=" + berufsgruppe +
                ", bundesland=" + bundesland +
                ", wahlkreis=" + wahlkreis +
                ", partei=" + partei +
                ", landesListe=" + landesListe +
                ", twitter='" + twitter + '\'' +
                '}';
    }
}
