package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.listener.Btw17WahlbewerberListener;
import org.woehlke.btw17.kandidaten.oodm.model.commons.JpaDomainObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(
    name = "btw17_wahlbewerber",
    indexes = {
        @Index(name = "idx_btw17_wahlbewerber_titel",columnList = "titel"),
        @Index(name = "idx_btw17_wahlbewerber_namenszusatz", columnList = "namenszusatz"),
        @Index(name = "idx_btw17_wahlbewerber_name", columnList = "name"),
        @Index(name = "idx_btw17_wahlbewerber_vorname", columnList = "vorname"),
        @Index(name = "idx_btw17_wahlbewerber_geschlecht", columnList = "geschlecht"),
        @Index(name = "idx_btw17_wahlbewerber_geburtsjahr", columnList = "geburtsjahr"),
        @Index(name = "idx_btw17_wahlbewerber_wohnort", columnList = "wohnort"),
        @Index(name = "idx_btw17_wahlbewerber_geburtsort", columnList = "geburtsort"),
        @Index(name = "idx_btw17_wahlbewerber_beruf", columnList = "beruf"),
        @Index(name = "idx_btw17_wahlbewerber_wahlkreis_land", columnList = "wahlkreis_land"),
        @Index(name = "idx_btw17_wahlbewerber_wahlkreis_nr", columnList = "wahlkreis_nr"),
        @Index(name = "idx_btw17_wahlbewerber_wahlkreis_bez", columnList = "wahlkreis_bez"),
        @Index(name = "idx_btw17_wahlbewerber_wahlkreis_partei_kurz", columnList = "wahlkreis_partei_kurz"),
        @Index(name = "idx_btw17_wahlbewerber_wahlkreis_partei", columnList = "wahlkreis_partei"),
        @Index(name = "idx_btw17_wahlbewerber_liste_land", columnList = "liste_land"),
        @Index(name = "idx_btw17_wahlbewerber_liste_partei_kurz", columnList = "liste_partei_kurz"),
        @Index(name = "idx_btw17_wahlbewerber_liste_partei", columnList = "liste_partei"),
        @Index(name = "idx_btw17_wahlbewerber_liste_platz", columnList = "liste_platz"),
        @Index(name = "idx_btw17_wahlbewerber_liste_partei_lang", columnList = "wiederkandidatur")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Btw17Wahlbewerber.getAllIds",
        query = "select o.id from Btw17Wahlbewerber as o order by o.id"
    ),
    @NamedQuery(
        name = "Btw17Wahlbewerber.getMaxId",
        query = "select max(o.id) from Btw17Wahlbewerber as o"
    )
})
@EntityListeners(Btw17WahlbewerberListener.class)
public class Btw17Wahlbewerber implements JpaDomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @Column(name = "titel", nullable=false)
    private String titel;

    @NotNull
    @Column(name = "namenszusatz", nullable=false)
    private String namenszusatz;

    @NotNull
    @Column(name = "name", nullable=false)
    private String name;

    @NotNull
    @Column(name = "vorname", nullable=false)
    private String vorname;

    @NotNull
    @Column(name = "geschlecht", nullable=false)
    private String geschlecht;

    @NotNull
    @Column(name = "geburtsjahr", nullable=false)
    private Integer geburtsjahr;

    @NotNull
    @Column(name = "wohnort", nullable=false)
    private String wohnort;

    @NotNull
    @Column(name = "geburtsort", nullable=false)
    private String geburtsort;

    @NotNull
    @Column(name = "beruf", nullable=false)
    private String beruf;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "wahlkreis_land", nullable=false)
    private BundeslandEnum wahlkreisLand;

    @NotNull
    @Column(name = "wahlkreis_nr", nullable=false)
    private Long wahlkreisNr;

    @NotNull
    @Column(name = "wahlkreis_bez", nullable=false)
    private String wahlkreisBez;

    @NotNull
    @Column(name = "wahlkreis_partei_kurz", nullable=false)
    private String wahlkreisParteiKurzBez;

    @NotNull
    @Column(name = "wahlkreis_partei", nullable=false)
    private String wahlkreisParteiBez;

    @NotNull
    @Column(name = "liste_land", nullable=false)
    private String listeLand;

    @NotNull
    @Column(name = "liste_partei_kurz", nullable=false)
    private String listeParteiKurzBez;

    @NotNull
    @Column(name = "liste_partei", nullable=false)
    private String listeParteiBez;

    @NotNull
    @Column(name = "liste_platz", nullable=false)
    private Integer listePlatz;

    @NotNull
    @Column(name = "wiederkandidatur", nullable=false)
    private Boolean wiederkandidatur;

    @Transient
    @Override
    public String getUniqueId() {
        return wahlkreisNr+":"+wahlkreisBez+":"+vorname+":"+name+":"+geburtsjahr+":"+geburtsort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getNamenszusatz() {
        return namenszusatz;
    }

    public void setNamenszusatz(String namenszusatz) {
        this.namenszusatz = namenszusatz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BundeslandEnum getWahlkreisLand() {
        return wahlkreisLand;
    }

    public void setWahlkreisLand(BundeslandEnum wahlkreisLand) {
        this.wahlkreisLand = wahlkreisLand;
    }

    public String getWahlkreisBez() {
        return wahlkreisBez;
    }

    public void setWahlkreisBez(String wahlkreisBez) {
        this.wahlkreisBez = wahlkreisBez;
    }

    public String getWahlkreisParteiKurzBez() {
        return wahlkreisParteiKurzBez;
    }

    public void setWahlkreisParteiKurzBez(String wahlkreisParteiKurzBez) {
        this.wahlkreisParteiKurzBez = wahlkreisParteiKurzBez;
    }

    public String getWahlkreisParteiBez() {
        return wahlkreisParteiBez;
    }

    public void setWahlkreisParteiBez(String wahlkreisParteiBez) {
        this.wahlkreisParteiBez = wahlkreisParteiBez;
    }

    public String getListeLand() {
        return listeLand;
    }

    public void setListeLand(String listeLand) {
        this.listeLand = listeLand;
    }

    public String getListeParteiKurzBez() {
        return listeParteiKurzBez;
    }

    public void setListeParteiKurzBez(String listeParteiKurzBez) {
        this.listeParteiKurzBez = listeParteiKurzBez;
    }

    public String getListeParteiBez() {
        return listeParteiBez;
    }

    public void setListeParteiBez(String listeParteiBez) {
        this.listeParteiBez = listeParteiBez;
    }

    public Integer getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(Integer geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }

    public Long getWahlkreisNr() {
        return wahlkreisNr;
    }

    public void setWahlkreisNr(Long wahlkreisNr) {
        this.wahlkreisNr = wahlkreisNr;
    }

    public Integer getListePlatz() {
        return listePlatz;
    }

    public void setListePlatz(Integer listePlatz) {
        this.listePlatz = listePlatz;
    }

    public Boolean getWiederkandidatur() {
        return wiederkandidatur;
    }

    public void setWiederkandidatur(Boolean wiederkandidatur) {
        this.wiederkandidatur = wiederkandidatur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Btw17Wahlbewerber)) return false;

        Btw17Wahlbewerber that = (Btw17Wahlbewerber) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (titel != null ? !titel.equals(that.titel) : that.titel != null) return false;
        if (namenszusatz != null ? !namenszusatz.equals(that.namenszusatz) : that.namenszusatz != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (vorname != null ? !vorname.equals(that.vorname) : that.vorname != null) return false;
        if (geschlecht != null ? !geschlecht.equals(that.geschlecht) : that.geschlecht != null) return false;
        if (geburtsjahr != null ? !geburtsjahr.equals(that.geburtsjahr) : that.geburtsjahr != null) return false;
        if (wohnort != null ? !wohnort.equals(that.wohnort) : that.wohnort != null) return false;
        if (geburtsort != null ? !geburtsort.equals(that.geburtsort) : that.geburtsort != null) return false;
        if (beruf != null ? !beruf.equals(that.beruf) : that.beruf != null) return false;
        if (wahlkreisLand != that.wahlkreisLand) return false;
        if (wahlkreisNr != null ? !wahlkreisNr.equals(that.wahlkreisNr) : that.wahlkreisNr != null) return false;
        if (wahlkreisBez != null ? !wahlkreisBez.equals(that.wahlkreisBez) : that.wahlkreisBez != null) return false;
        if (wahlkreisParteiKurzBez != null ? !wahlkreisParteiKurzBez.equals(that.wahlkreisParteiKurzBez) : that.wahlkreisParteiKurzBez != null)
            return false;
        if (wahlkreisParteiBez != null ? !wahlkreisParteiBez.equals(that.wahlkreisParteiBez) : that.wahlkreisParteiBez != null)
            return false;
        if (listeLand != null ? !listeLand.equals(that.listeLand) : that.listeLand != null) return false;
        if (listeParteiKurzBez != null ? !listeParteiKurzBez.equals(that.listeParteiKurzBez) : that.listeParteiKurzBez != null)
            return false;
        if (listeParteiBez != null ? !listeParteiBez.equals(that.listeParteiBez) : that.listeParteiBez != null)
            return false;
        if (listePlatz != null ? !listePlatz.equals(that.listePlatz) : that.listePlatz != null) return false;
        return wiederkandidatur != null ? wiederkandidatur.equals(that.wiederkandidatur) : that.wiederkandidatur == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (namenszusatz != null ? namenszusatz.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 31 * result + (geschlecht != null ? geschlecht.hashCode() : 0);
        result = 31 * result + (geburtsjahr != null ? geburtsjahr.hashCode() : 0);
        result = 31 * result + (wohnort != null ? wohnort.hashCode() : 0);
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        result = 31 * result + (beruf != null ? beruf.hashCode() : 0);
        result = 31 * result + (wahlkreisLand != null ? wahlkreisLand.hashCode() : 0);
        result = 31 * result + (wahlkreisNr != null ? wahlkreisNr.hashCode() : 0);
        result = 31 * result + (wahlkreisBez != null ? wahlkreisBez.hashCode() : 0);
        result = 31 * result + (wahlkreisParteiKurzBez != null ? wahlkreisParteiKurzBez.hashCode() : 0);
        result = 31 * result + (wahlkreisParteiBez != null ? wahlkreisParteiBez.hashCode() : 0);
        result = 31 * result + (listeLand != null ? listeLand.hashCode() : 0);
        result = 31 * result + (listeParteiKurzBez != null ? listeParteiKurzBez.hashCode() : 0);
        result = 31 * result + (listeParteiBez != null ? listeParteiBez.hashCode() : 0);
        result = 31 * result + (listePlatz != null ? listePlatz.hashCode() : 0);
        result = 31 * result + (wiederkandidatur != null ? wiederkandidatur.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Btw17Wahlbewerber{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", namenszusatz='" + namenszusatz + '\'' +
                ", name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", geschlecht='" + geschlecht + '\'' +
                ", geburtsjahr=" + geburtsjahr +
                ", wohnort='" + wohnort + '\'' +
                ", geburtsort='" + geburtsort + '\'' +
                ", beruf='" + beruf + '\'' +
                ", wahlkreisLand=" + wahlkreisLand +
                ", wahlkreisNr=" + wahlkreisNr +
                ", wahlkreisBez='" + wahlkreisBez + '\'' +
                ", wahlkreisParteiKurzBez='" + wahlkreisParteiKurzBez + '\'' +
                ", wahlkreisParteiBez='" + wahlkreisParteiBez + '\'' +
                ", listeLand='" + listeLand + '\'' +
                ", listeParteiKurzBez='" + listeParteiKurzBez + '\'' +
                ", listeParteiBez='" + listeParteiBez + '\'' +
                ", listePlatz=" + listePlatz +
                ", wiederkandidatur=" + wiederkandidatur +
                '}';
    }
}
