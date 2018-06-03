package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.listener.Btw17KandidatFlatListener;
import org.woehlke.btw17.kandidaten.common.JpaDomainObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Locale;

@Entity
@Table(
    name = "btw17_kandidat_flat",
    indexes = {
        @Index(name = "idx_kandidat_flat_kandidat_key",columnList = "kandidat_key"),
        @Index(name = "idx_kandidat_flat_titel", columnList = "titel"),
        @Index(name = "idx_kandidat_flat_namenszusatz", columnList = "namenszusatz"),
        @Index(name = "idx_kandidat_flat_nachname_ohne", columnList = "nachname_ohne"),
        @Index(name = "idx_kandidat_flat_nachname", columnList = "nachname"),
        @Index(name = "idx_kandidat_flat_geschlecht", columnList = "geschlecht"),
        @Index(name = "idx_kandidat_flat_geburtsjahr", columnList = "geburtsjahr"),
        @Index(name = "idx_kandidat_flat_alter", columnList = "alter"),
        @Index(name = "idx_kandidat_flat_liste_bundesland_land", columnList = "liste_bundesland_land"),
        @Index(name = "idx_kandidat_flat_liste_platz", columnList = "liste_platz"),
        @Index(name = "idx_kandidat_flat_mdb", columnList = "mdb"),
        @Index(name = "idx_kandidat_flat_id_eigen", columnList = "id_eigen"),
        @Index(name = "idx_kandidat_flat_foto", columnList = "foto"),
        @Index(name = "idx_kandidat_flat_wahlkreis_id", columnList = "wahlkreis_id"),
        @Index(name = "idx_kandidat_flat_wahlkreis_name", columnList = "wahlkreis_name"),
        @Index(name = "idx_kandidat_flat_partei", columnList = "partei"),
        @Index(name = "idx_kandidat_flat_partei_lang", columnList = "partei_lang"),
        @Index(name = "idx_kandidat_flat_liste_partei", columnList = "liste_partei"),
        @Index(name = "idx_kandidat_flat_liste_partei_lang", columnList = "liste_partei_lang"),
        @Index(name = "idx_kandidat_flat_bundesland", columnList = "bundesland"),
        @Index(name = "idx_kandidat_flat_berufsgruppe", columnList = "berufsgruppe"),
        @Index(name = "idx_kandidat_flat_beruf", columnList = "beruf"),
        @Index(name = "idx_kandidat_flat_geburtsort", columnList = "geburtsort"),
        @Index(name = "idx_kandidat_flat_wohnort", columnList = "wohnort"),
        @Index(name = "idx_kandidat_flat_alter", columnList = "alter")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Btw17KandidatFlat.getAllIdsWhereMdbIsNotNull",
        query = "select o.id from Btw17KandidatFlat as o where o.mdb is not null"
    ),
    @NamedQuery(
        name = "Btw17KandidatFlat.getAllOrderByNachname",
        query = "select o from Btw17KandidatFlat as o order by o.nachname"
    ),
    @NamedQuery(
        name = "Btw17KandidatFlat.getAllIds",
        query = "select o.id from Btw17KandidatFlat as o order by o.id"
    ),
    @NamedQuery(
        name = "Btw17KandidatFlat.getMaxId",
        query = "select max(o.id) from Btw17KandidatFlat as o"
    )
})
@EntityListeners(Btw17KandidatFlatListener.class)
public class Btw17KandidatFlat implements JpaDomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="kandidat_key")
    private String key;

    @Column(name="titel")
    private String titel;

    @Column(name="namenszusatz")
    private String namenszusatz;

    @Column(name="nachname_ohne")
    private String nachnameOhne;

    @Column
    private String nachname;

    @Column
    private String vorname;

    @Column
    private String geschlecht;

    @Column
    private Integer geburtsjahr;

    @Column
    private Integer alter;

    @Column
    private String wohnort;

    @Column
    private String geburtsort;

    @Column
    private String beruf;

    @Column
    private String berufsgruppe;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "bundesland", nullable=false)
    private BundeslandEnum bundesland;

    @Column(name="wahlkreis_id")
    private Integer wahlkreisId;

    @Column(name="wahlkreis_name")
    private String wahlkreisName;

    @Column
    private String partei;

    @Column(name="partei_lang")
    private String parteiLang;

    @Column(name="liste_bundesland_land")
    private String listeBundeslandLand;

    @Column(name="liste_partei")
    private String listePartei;

    @Column(name="liste_partei_lang")
    private String listeParteiLang;

    @Column(name="liste_platz")
    private Integer listePlatz;

    @Column
    private String mdb;

    @Column
    private Double lat;

    @Column
    private Double lng;

    @Column(name="id_eigen")
    private String idEigen;

    @Column
    private String foto;

    @Column(name="scatter_x")
    private Double scatterX;

    @Column(name="scatter_y")
    private Double scatterY;

    @Column
    private String color;

    @Transient
    public String getName() {
        return getTransientKey();
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getTransientKey()+":"+this.getVorname()+" "+this.getNachname();
    }

    @Transient
    public String getTransientKey(){
        Locale locale = Locale.GERMANY;
        String titel = this.getTitel();
        String vorname = this.getVorname();
        String nachname = this.getNachname();
        String namenszusatz = this.getNamenszusatz();
        String geschlecht = this.getGeschlecht();
        String geburtsort = this.getGeburtsort();
        Integer geburtsjahr = this.getGeburtsjahr();
        vorname = vorname.replaceAll("\\W","").toLowerCase(locale);
        nachname = nachname.replaceAll("\\W","").toLowerCase(locale);
        String newKandidatKey = vorname +"-"+nachname;
        if(namenszusatz!=null){
            namenszusatz = namenszusatz.replaceAll("\\W","").toLowerCase(locale);
            newKandidatKey =  namenszusatz +"-"+ newKandidatKey;
        }
        if(titel!=null){
            titel = titel.replaceAll("\\W","").toLowerCase(locale);
            newKandidatKey =  titel+"-"+ newKandidatKey;
        }
        if(geschlecht!=null){
            if(geschlecht.compareTo("M")==0){
                newKandidatKey = "herr-"+ newKandidatKey;
            }
            if(geschlecht.compareTo("W")==0){
                newKandidatKey = "frau-"+ newKandidatKey;
            }
        }
        if(geburtsjahr != null){
            newKandidatKey = newKandidatKey +"-geboren-"+geburtsjahr;
        }
        if(geburtsort != null){
            geburtsort = geburtsort.replaceAll("\\W","").toLowerCase(locale);
            newKandidatKey = newKandidatKey +"-in-"+geburtsort;
        }
        return newKandidatKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getNachnameOhne() {
        return nachnameOhne;
    }

    public void setNachnameOhne(String nachnameOhne) {
        this.nachnameOhne = nachnameOhne;
    }

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

    public Integer getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(Integer geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }

    public Integer getAlter() {
        return alter;
    }

    public void setAlter(Integer alter) {
        this.alter = alter;
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

    public BundeslandEnum getBundesland() {
        return bundesland;
    }

    public void setBundesland(BundeslandEnum bundesland) {
        this.bundesland = bundesland;
    }

    public Integer getWahlkreisId() {
        return wahlkreisId;
    }

    public void setWahlkreisId(Integer wahlkreisId) {
        this.wahlkreisId = wahlkreisId;
    }

    public String getWahlkreisName() {
        return wahlkreisName;
    }

    public void setWahlkreisName(String wahlkreisName) {
        this.wahlkreisName = wahlkreisName;
    }

    public String getPartei() {
        return partei;
    }

    public void setPartei(String partei) {
        this.partei = partei;
    }

    public String getParteiLang() {
        return parteiLang;
    }

    public void setParteiLang(String parteiLang) {
        this.parteiLang = parteiLang;
    }

    public String getListeBundeslandLand() {
        return listeBundeslandLand;
    }

    public void setListeBundeslandLand(String listeBundeslandLand) {
        this.listeBundeslandLand = listeBundeslandLand;
    }

    public String getListePartei() {
        return listePartei;
    }

    public void setListePartei(String listePartei) {
        this.listePartei = listePartei;
    }

    public String getListeParteiLang() {
        return listeParteiLang;
    }

    public void setListeParteiLang(String listeParteiLang) {
        this.listeParteiLang = listeParteiLang;
    }

    public Integer getListePlatz() {
        return listePlatz;
    }

    public void setListePlatz(Integer listePlatz) {
        this.listePlatz = listePlatz;
    }

    public String getMdb() {
        return mdb;
    }

    public void setMdb(String mdb) {
        this.mdb = mdb;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getIdEigen() {
        return idEigen;
    }

    public void setIdEigen(String idEigen) {
        this.idEigen = idEigen;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Double getScatterX() {
        return scatterX;
    }

    public void setScatterX(Double scatterX) {
        this.scatterX = scatterX;
    }

    public Double getScatterY() {
        return scatterY;
    }

    public void setScatterY(Double scatterY) {
        this.scatterY = scatterY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kandidat)) return false;

        Btw17KandidatFlat kandidat = (Btw17KandidatFlat) o;

        if (id != null ? !id.equals(kandidat.id) : kandidat.id != null) return false;
        if (key != null ? !key.equals(kandidat.key) : kandidat.key != null) return false;
        if (titel != null ? !titel.equals(kandidat.titel) : kandidat.titel != null) return false;
        if (namenszusatz != null ? !namenszusatz.equals(kandidat.namenszusatz) : kandidat.namenszusatz != null)
            return false;
        if (nachnameOhne != null ? !nachnameOhne.equals(kandidat.nachnameOhne) : kandidat.nachnameOhne != null)
            return false;
        if (nachname != null ? !nachname.equals(kandidat.nachname) : kandidat.nachname != null) return false;
        if (vorname != null ? !vorname.equals(kandidat.vorname) : kandidat.vorname != null) return false;
        if (geschlecht != null ? !geschlecht.equals(kandidat.geschlecht) : kandidat.geschlecht != null) return false;
        if (geburtsjahr != null ? !geburtsjahr.equals(kandidat.geburtsjahr) : kandidat.geburtsjahr != null)
            return false;
        if (alter != null ? !alter.equals(kandidat.alter) : kandidat.alter != null) return false;
        if (wohnort != null ? !wohnort.equals(kandidat.wohnort) : kandidat.wohnort != null) return false;
        if (geburtsort != null ? !geburtsort.equals(kandidat.geburtsort) : kandidat.geburtsort != null) return false;
        if (beruf != null ? !beruf.equals(kandidat.beruf) : kandidat.beruf != null) return false;
        if (berufsgruppe != null ? !berufsgruppe.equals(kandidat.berufsgruppe) : kandidat.berufsgruppe != null)
            return false;
        if (bundesland != null ? !bundesland.equals(kandidat.bundesland) : kandidat.bundesland != null) return false;
        if (wahlkreisId != null ? !wahlkreisId.equals(kandidat.wahlkreisId) : kandidat.wahlkreisId != null)
            return false;
        if (wahlkreisName != null ? !wahlkreisName.equals(kandidat.wahlkreisName) : kandidat.wahlkreisName != null)
            return false;
        if (partei != null ? !partei.equals(kandidat.partei) : kandidat.partei != null) return false;
        if (parteiLang != null ? !parteiLang.equals(kandidat.parteiLang) : kandidat.parteiLang != null) return false;
        if (listeBundeslandLand != null ? !listeBundeslandLand.equals(kandidat.listeBundeslandLand) : kandidat.listeBundeslandLand != null)
            return false;
        if (listePartei != null ? !listePartei.equals(kandidat.listePartei) : kandidat.listePartei != null)
            return false;
        if (listeParteiLang != null ? !listeParteiLang.equals(kandidat.listeParteiLang) : kandidat.listeParteiLang != null)
            return false;
        if (listePlatz != null ? !listePlatz.equals(kandidat.listePlatz) : kandidat.listePlatz != null) return false;
        if (mdb != null ? !mdb.equals(kandidat.mdb) : kandidat.mdb != null) return false;
        if (lat != null ? !lat.equals(kandidat.lat) : kandidat.lat != null) return false;
        if (lng != null ? !lng.equals(kandidat.lng) : kandidat.lng != null) return false;
        if (idEigen != null ? !idEigen.equals(kandidat.idEigen) : kandidat.idEigen != null) return false;
        if (foto != null ? !foto.equals(kandidat.foto) : kandidat.foto != null) return false;
        if (scatterX != null ? !scatterX.equals(kandidat.scatterX) : kandidat.scatterX != null) return false;
        if (scatterY != null ? !scatterY.equals(kandidat.scatterY) : kandidat.scatterY != null) return false;
        return color != null ? color.equals(kandidat.color) : kandidat.color == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (namenszusatz != null ? namenszusatz.hashCode() : 0);
        result = 31 * result + (nachnameOhne != null ? nachnameOhne.hashCode() : 0);
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + (vorname != null ? vorname.hashCode() : 0);
        result = 31 * result + (geschlecht != null ? geschlecht.hashCode() : 0);
        result = 31 * result + (geburtsjahr != null ? geburtsjahr.hashCode() : 0);
        result = 31 * result + (alter != null ? alter.hashCode() : 0);
        result = 31 * result + (wohnort != null ? wohnort.hashCode() : 0);
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        result = 31 * result + (beruf != null ? beruf.hashCode() : 0);
        result = 31 * result + (berufsgruppe != null ? berufsgruppe.hashCode() : 0);
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (wahlkreisId != null ? wahlkreisId.hashCode() : 0);
        result = 31 * result + (wahlkreisName != null ? wahlkreisName.hashCode() : 0);
        result = 31 * result + (partei != null ? partei.hashCode() : 0);
        result = 31 * result + (parteiLang != null ? parteiLang.hashCode() : 0);
        result = 31 * result + (listeBundeslandLand != null ? listeBundeslandLand.hashCode() : 0);
        result = 31 * result + (listePartei != null ? listePartei.hashCode() : 0);
        result = 31 * result + (listeParteiLang != null ? listeParteiLang.hashCode() : 0);
        result = 31 * result + (listePlatz != null ? listePlatz.hashCode() : 0);
        result = 31 * result + (mdb != null ? mdb.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (lng != null ? lng.hashCode() : 0);
        result = 31 * result + (idEigen != null ? idEigen.hashCode() : 0);
        result = 31 * result + (foto != null ? foto.hashCode() : 0);
        result = 31 * result + (scatterX != null ? scatterX.hashCode() : 0);
        result = 31 * result + (scatterY != null ? scatterY.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Kandidat{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", titel='" + titel + '\'' +
                ", namenszusatz='" + namenszusatz + '\'' +
                ", nachnameOhne='" + nachnameOhne + '\'' +
                ", nachname='" + nachname + '\'' +
                ", vorname='" + vorname + '\'' +
                ", geschlecht='" + geschlecht + '\'' +
                ", geburtsjahr=" + geburtsjahr +
                ", alter=" + alter +
                ", wohnort='" + wohnort + '\'' +
                ", geburtsort='" + geburtsort + '\'' +
                ", beruf='" + beruf + '\'' +
                ", berufsgruppe='" + berufsgruppe + '\'' +
                ", bundesland='" + bundesland + '\'' +
                ", wahlkreisId=" + wahlkreisId +
                ", wahlkreisName='" + wahlkreisName + '\'' +
                ", partei='" + partei + '\'' +
                ", parteiLang='" + parteiLang + '\'' +
                ", listeBundeslandLand='" + listeBundeslandLand + '\'' +
                ", listePartei='" + listePartei + '\'' +
                ", listeParteiLang='" + listeParteiLang + '\'' +
                ", listePlatz=" + listePlatz +
                ", mdb='" + mdb + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", idEigen='" + idEigen + '\'' +
                ", foto='" + foto + '\'' +
                ", scatterX=" + scatterX +
                ", scatterY=" + scatterY +
                ", color='" + color + '\'' +
                '}';
    }
}
