package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.listener.BerufsgruppeListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;

import javax.persistence.*;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Entity
@Table(
    name = "berufsgruppe",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_berufsgruppe",columnNames = {"berufsgruppe"})
    }
)
@EntityListeners(BerufsgruppeListener.class)
public class Berufsgruppe implements DomainObject {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "berufsgruppe")
    private String berufsgruppe;

    @Transient
    public String getName() {
        return berufsgruppe;
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

    public String getBerufsgruppe() {
        return berufsgruppe;
    }

    public void setBerufsgruppe(String berufsgruppe) {
        this.berufsgruppe = berufsgruppe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Berufsgruppe)) return false;

        Berufsgruppe that = (Berufsgruppe) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return berufsgruppe != null ? berufsgruppe.equals(that.berufsgruppe) : that.berufsgruppe == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (berufsgruppe != null ? berufsgruppe.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Berufsgruppe{" +
                "id=" + id +
                ", berufsgruppe='" + berufsgruppe + '\'' +
                '}';
    }
}
