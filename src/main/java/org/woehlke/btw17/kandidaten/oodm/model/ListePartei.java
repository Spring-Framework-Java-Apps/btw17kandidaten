package org.woehlke.btw17.kandidaten.oodm.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "liste_partei",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_liste_partei",columnNames = {"liste_partei"})
    },
    indexes = {
        @Index(name = "idx_liste_partei_liste_partei_lang", columnList = "liste_partei_lang")
    }
)
public class ListePartei implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="liste_partei")
    private String listePartei;

    @Column(name="liste_partei_lang")
    private String listeParteiLang;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListePartei)) return false;

        ListePartei that = (ListePartei) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (listePartei != null ? !listePartei.equals(that.listePartei) : that.listePartei != null) return false;
        return listeParteiLang != null ? listeParteiLang.equals(that.listeParteiLang) : that.listeParteiLang == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (listePartei != null ? listePartei.hashCode() : 0);
        result = 31 * result + (listeParteiLang != null ? listeParteiLang.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ListePartei{" +
                "id=" + id +
                ", listePartei='" + listePartei + '\'' +
                ", listeParteiLang='" + listeParteiLang + '\'' +
                '}';
    }
}
