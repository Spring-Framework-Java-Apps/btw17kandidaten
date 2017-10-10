package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.listener.LandesListeListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.model.parts.CommonFieldsEmbedded;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.repositories.LandesListeRepository
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Entity
@Table(
    name = "landesliste",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_landesliste",columnNames = {"fk_bundesland","fk_listepartei"})
    },
    indexes = {
        @Index(name = "idx_landesliste_common_fields", columnList = "logo_url,symbol_bild"),
    }
)
@NamedQueries({
    @NamedQuery(
        name = "LandesListe.getAllBundesland",
        query = "select DISTINCT o.bundesland from LandesListe as o"
    ),
    @NamedQuery(
        name = "LandesListe.getAllListePartei",
        query = "select DISTINCT o.listePartei from LandesListe as o"
    ),
    @NamedQuery(
        name = "LandesListe.findByBundesland",
        query = "select o from LandesListe as o where o.bundesland=:bundesland"
    ),
    @NamedQuery(
        name = "LandesListe.findByListePartei",
        query = "select o from LandesListe as o where o.listePartei=:listePartei"
    ),
    @NamedQuery(
        name = "LandesListe.getAllOrOrderById",
        query = "select o from LandesListe as o order by o.listePartei.listePartei"
    ),
    @NamedQuery(
        name = "LandesListe.getAllIds",
        query = "select o.id from LandesListe as o"
    ),
    @NamedQuery(
        name = "LandesListe.getMaxId",
        query = "select max(o.id) from LandesListe as o"
    )
})
@EntityListeners(LandesListeListener.class)
public class LandesListe implements DomainObject,CommonFieldsEmbedded {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_bundesland", nullable = false, updatable = false)
    private Bundesland bundesland;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_listepartei", nullable = false, updatable = false)
    private ListePartei listePartei;

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Transient
    @Override
    public String getName(){
        StringBuffer name = new StringBuffer();
        name.append(listePartei.getListePartei());
        name.append(" in ");
        name.append(bundesland.getBundeslandLang());
        name.append(" (");
        name.append(bundesland.getBundesland());
        name.append(")");
        return name.toString();
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        this.bundesland = bundesland;
    }

    public ListePartei getListePartei() {
        return listePartei;
    }

    public void setListePartei(ListePartei listePartei) {
        this.listePartei = listePartei;
    }

    public CommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(CommonFields commonFields) {
        if(commonFields != null){
            this.commonFields = commonFields;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LandesListe)) return false;

        LandesListe that = (LandesListe) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bundesland != null ? !bundesland.equals(that.bundesland) : that.bundesland != null) return false;
        if (listePartei != null ? !listePartei.equals(that.listePartei) : that.listePartei != null) return false;
        if (commonFields != null ? !commonFields.equals(that.commonFields) : that.commonFields != null)
            return false;
        return commonFields != null ? commonFields.equals(that.commonFields) : that.commonFields == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (listePartei != null ? listePartei.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LandesListe{" +
                "id=" + id +
                ", bundesland=" + bundesland +
                ", listePartei=" + listePartei +
                ", commonFields=" + commonFields +
                '}';
    }

}
