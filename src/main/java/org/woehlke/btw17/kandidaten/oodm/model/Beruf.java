package org.woehlke.btw17.kandidaten.oodm.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
    name = "beruf",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_beruf",columnNames = {"beruf"})
    }
)
public class Beruf implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String beruf;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beruf)) return false;

        Beruf beruf1 = (Beruf) o;

        if (id != null ? !id.equals(beruf1.id) : beruf1.id != null) return false;
        return beruf != null ? beruf.equals(beruf1.beruf) : beruf1.beruf == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (beruf != null ? beruf.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Beruf{" +
                "id=" + id +
                ", beruf='" + beruf + '\'' +
                '}';
    }
}
