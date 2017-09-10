package org.woehlke.btw17.kandidaten.oodm.model;



import org.woehlke.btw17.kandidaten.oodm.model.parts.OnlineStrategie;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(
    name = "ausschuss",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_ausschuss",columnNames = {"ausschuss"})
    }
)

@NamedQueries({
    @NamedQuery(
        name = "Ausschuss.getAll",
        query = "select o from Ausschuss as o order by id"
    ),
    @NamedQuery(
        name = "Ausschuss.getAllCount",
        query = "select count(o) from Ausschuss as o"
    )
})
public class Ausschuss implements KandidatDimension {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String ausschuss;

    @Column(name="ausschuss_lang")
    private String ausschussLang;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Override
    public Long getId() {
        return id;
    }

    @Transient
    @Override
    public String getName() {
        return ausschuss;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAusschuss() {
        return ausschuss;
    }

    public void setAusschuss(String ausschuss) {
        this.ausschuss = ausschuss;
    }

    public String getAusschussLang() {
        return ausschussLang;
    }

    public void setAusschussLang(String ausschussLang) {
        this.ausschussLang = ausschussLang;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ausschuss)) return false;

        Ausschuss ausschuss1 = (Ausschuss) o;

        if (id != null ? !id.equals(ausschuss1.id) : ausschuss1.id != null) return false;
        if (ausschuss != null ? !ausschuss.equals(ausschuss1.ausschuss) : ausschuss1.ausschuss != null) return false;
        if (ausschussLang != null ? !ausschussLang.equals(ausschuss1.ausschussLang) : ausschuss1.ausschussLang != null)
            return false;
        return onlineStrategie != null ? onlineStrategie.equals(ausschuss1.onlineStrategie) : ausschuss1.onlineStrategie == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ausschuss != null ? ausschuss.hashCode() : 0);
        result = 31 * result + (ausschussLang != null ? ausschussLang.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ausschuss{" +
                "id=" + id +
                ", ausschuss='" + ausschuss + '\'' +
                ", ausschussLang='" + ausschussLang + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                '}';
    }
}
