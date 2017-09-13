package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.parts.DimensionKandidat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(
    name = "landesliste",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_liste_partei",columnNames = {"fk_bundesland","fk_liste_partei"})
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
        query = "select o from LandesListe as o order by id"
    )
})
public class LandesListe implements DimensionKandidat {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_bundesland", nullable = false, updatable = false)
    private Bundesland bundesland;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_liste_partei", nullable = false, updatable = false)
    private ListePartei listePartei;

    @Transient
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LandesListe)) return false;

        LandesListe that = (LandesListe) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bundesland != null ? !bundesland.equals(that.bundesland) : that.bundesland != null) return false;
        return listePartei != null ? listePartei.equals(that.listePartei) : that.listePartei == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (listePartei != null ? listePartei.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LandesListe{" +
                "id=" + id +
                ", bundesland=" + bundesland +
                ", listePartei=" + listePartei +
                '}';
    }

    public String getSqlInsert(){
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO landesliste (id, fk_bundesland, fk_liste_partei) VALUES (");
        sql.append(id);
        sql.append(",");
        sql.append(bundesland.getId());
        sql.append(",");
        sql.append(listePartei.getId());
        sql.append(");");
        return sql.toString();
    }
}
