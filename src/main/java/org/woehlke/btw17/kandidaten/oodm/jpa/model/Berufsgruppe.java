package org.woehlke.btw17.kandidaten.oodm.jpa.model;

import org.woehlke.btw17.kandidaten.oodm.jpa.model.commons.JpaDomainObject;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.EditStatus;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.listener.BerufsgruppeListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.jpa.model.Kandidat
 */
@Entity
@Table(
    name = "berufsgruppe",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_berufsgruppe",columnNames = {"berufsgruppe"})
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Berufsgruppe.getAllIds",
        query = "select o.id from Berufsgruppe as o order by o.berufsgruppe"
    ),
    @NamedQuery(
        name = "Berufsgruppe.getMaxId",
        query = "select max(o.id) from Berufsgruppe as o"
    )
})
@EntityListeners(BerufsgruppeListener.class)
public class Berufsgruppe implements JpaDomainObject {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @NotNull
    @Column(name = "berufsgruppe",unique = true, nullable = false)
    private String berufsgruppe;

    @Enumerated(EnumType.STRING)
    @Column(name = "edit_status")
    private EditStatus editStatus = EditStatus.UNTOUCHED;

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

    public EditStatus getEditStatus() {
        return editStatus;
    }

    public void setEditStatus(EditStatus editStatus) {
        this.editStatus = editStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Berufsgruppe)) return false;

        Berufsgruppe that = (Berufsgruppe) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (berufsgruppe != null ? !berufsgruppe.equals(that.berufsgruppe) : that.berufsgruppe != null) return false;
        return editStatus == that.editStatus;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (berufsgruppe != null ? berufsgruppe.hashCode() : 0);
        result = 31 * result + (editStatus != null ? editStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Berufsgruppe{" +
                "id=" + id +
                ", berufsgruppe='" + berufsgruppe + '\'' +
                ", editStatus=" + editStatus +
                '}';
    }
}
