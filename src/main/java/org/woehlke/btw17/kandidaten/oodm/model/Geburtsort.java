package org.woehlke.btw17.kandidaten.oodm.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "geburtsort"
)
public class Geburtsort implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String geburtsort;


    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geburtsort)) return false;

        Geburtsort that = (Geburtsort) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return geburtsort != null ? geburtsort.equals(that.geburtsort) : that.geburtsort == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Geburtsort{" +
                "id=" + id +
                ", geburtsort='" + geburtsort + '\'' +
                '}';
    }
}
