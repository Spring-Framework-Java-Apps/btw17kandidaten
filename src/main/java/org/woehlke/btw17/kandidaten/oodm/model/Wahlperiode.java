package org.woehlke.btw17.kandidaten.oodm.model;


import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.enums.Mandatsart;
import org.woehlke.btw17.kandidaten.oodm.model.listener.WahlperiodeListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;
import org.woehlke.btw17.kandidaten.oodm.model.parts.Institution;
import org.woehlke.btw17.kandidaten.oodm.model.parts.InstitutionEmbedded;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;

@Entity
@Table(
    name = "wahlperiode"
)
@NamedQueries({
    @NamedQuery(
        name = "Wahlperiode.getAllIds",
        query = "select o.id from Wahlperiode as o order by o.wahlperiode"
    ),
    @NamedQuery(
        name = "Wahlperiode.getMaxId",
        query = "select max(o.id) from Wahlperiode as o"
    )
})
@EntityListeners(WahlperiodeListener.class)
public class Wahlperiode implements DomainObject,InstitutionEmbedded {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "wp")
    private Long wahlperiode;

    @Temporal(TemporalType.DATE)
    @Column(name = "mdbwpvon")
    private Date mdbWahlperiodeVon;

    @Temporal(TemporalType.DATE)
    @Column(name = "mdbwpbis")
    private Date mdbWahlperiodeBis;

    @Enumerated(EnumType.STRING)
    @Column(name = "liste")
    private BundeslandEnum bundeslandLandesListe;

    @Enumerated(EnumType.STRING)
    @Column(name = "mandatsart")
    private Mandatsart mandatsArt;

    @ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="fk_wahlkreis")
    private Wahlkreis wahlkreis;

    @Valid
    @Embedded
    private Institution institution = new Institution();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wahlperiode.toString();
    }

    @Override
    public String getUniqueId() {
        return wahlperiode.toString();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWahlperiode() {
        return wahlperiode;
    }

    public void setWahlperiode(Long wahlperiode) {
        this.wahlperiode = wahlperiode;
    }

    public Date getMdbWahlperiodeVon() {
        return mdbWahlperiodeVon;
    }

    public void setMdbWahlperiodeVon(Date mdbWahlperiodeVon) {
        this.mdbWahlperiodeVon = mdbWahlperiodeVon;
    }

    public Date getMdbWahlperiodeBis() {
        return mdbWahlperiodeBis;
    }

    public void setMdbWahlperiodeBis(Date mdbWahlperiodeBis) {
        this.mdbWahlperiodeBis = mdbWahlperiodeBis;
    }

    public BundeslandEnum getBundeslandLandesListe() {
        return bundeslandLandesListe;
    }

    public void setBundeslandLandesListe(BundeslandEnum bundeslandLandesListe) {
        this.bundeslandLandesListe = bundeslandLandesListe;
    }

    public Mandatsart getMandatsArt() {
        return mandatsArt;
    }

    public void setMandatsArt(Mandatsart mandatsArt) {
        this.mandatsArt = mandatsArt;
    }

    public Wahlkreis getWahlkreis() {
        return wahlkreis;
    }

    public void setWahlkreis(Wahlkreis wahlkreis) {
        this.wahlkreis = wahlkreis;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wahlperiode)) return false;

        Wahlperiode that = (Wahlperiode) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (wahlperiode != null ? !wahlperiode.equals(that.wahlperiode) : that.wahlperiode != null) return false;
        if (mdbWahlperiodeVon != null ? !mdbWahlperiodeVon.equals(that.mdbWahlperiodeVon) : that.mdbWahlperiodeVon != null)
            return false;
        if (mdbWahlperiodeBis != null ? !mdbWahlperiodeBis.equals(that.mdbWahlperiodeBis) : that.mdbWahlperiodeBis != null)
            return false;
        if (bundeslandLandesListe != that.bundeslandLandesListe) return false;
        if (mandatsArt != that.mandatsArt) return false;
        if (wahlkreis != null ? !wahlkreis.equals(that.wahlkreis) : that.wahlkreis != null) return false;
        return institution != null ? institution.equals(that.institution) : that.institution == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wahlperiode != null ? wahlperiode.hashCode() : 0);
        result = 31 * result + (mdbWahlperiodeVon != null ? mdbWahlperiodeVon.hashCode() : 0);
        result = 31 * result + (mdbWahlperiodeBis != null ? mdbWahlperiodeBis.hashCode() : 0);
        result = 31 * result + (bundeslandLandesListe != null ? bundeslandLandesListe.hashCode() : 0);
        result = 31 * result + (mandatsArt != null ? mandatsArt.hashCode() : 0);
        result = 31 * result + (wahlkreis != null ? wahlkreis.hashCode() : 0);
        result = 31 * result + (institution != null ? institution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wahlperiode{" +
                "id=" + id +
                ", wahlperiode=" + wahlperiode +
                ", mdbWahlperiodeVon=" + mdbWahlperiodeVon +
                ", mdbWahlperiodeBis=" + mdbWahlperiodeBis +
                ", bundeslandLandesListe=" + bundeslandLandesListe +
                ", mandatsArt=" + mandatsArt +
                ", wahlkreis=" + wahlkreis +
                ", institution=" + institution +
                '}';
    }
}
