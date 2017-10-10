package org.woehlke.btw17.kandidaten.oodm.model;


import org.woehlke.btw17.kandidaten.oodm.model.enums.EditStatus;
import org.woehlke.btw17.kandidaten.oodm.model.listener.BerufListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;

import javax.persistence.*;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Entity
@Table(
    name = "beruf",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_beruf", columnNames = {"beruf"})
    }
)
@NamedQueries({
        @NamedQuery(
                name = "Beruf.getAllIds",
                query = "select o.id from Beruf as o order by o.beruf"
        ),
        @NamedQuery(
                name = "Beruf.getMaxId",
                query = "select max(o.id) from Beruf as o"
        )
})
@EntityListeners(BerufListener.class)
public class Beruf implements DomainObject {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "beruf")
    private String beruf;

    @Enumerated(EnumType.STRING)
    @Column(name = "edit_status")
    private EditStatus editStatus = EditStatus.UNTOUCHED;

    @Transient
    @Override
    public String getName() {
        return beruf;
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

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
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
        if (!(o instanceof Beruf)) return false;

        Beruf beruf1 = (Beruf) o;

        if (id != null ? !id.equals(beruf1.id) : beruf1.id != null) return false;
        if (beruf != null ? !beruf.equals(beruf1.beruf) : beruf1.beruf != null) return false;
        return editStatus == beruf1.editStatus;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (beruf != null ? beruf.hashCode() : 0);
        result = 31 * result + (editStatus != null ? editStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Beruf{" +
                "id=" + id +
                ", beruf='" + beruf + '\'' +
                ", editStatus=" + editStatus +
                '}';
    }
}
