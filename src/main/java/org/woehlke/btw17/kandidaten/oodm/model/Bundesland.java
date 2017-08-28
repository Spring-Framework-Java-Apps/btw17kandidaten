package org.woehlke.btw17.kandidaten.oodm.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(
        name = "bundesland"
)
public class Bundesland implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String bundesland;

    @Column(name="bundesland_lang",nullable = true)
    private String bundeslandLang;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public String getBundeslandLang() {
        return bundeslandLang;
    }

    public void setBundeslandLang(String bundeslandLang) {
        this.bundeslandLang = bundeslandLang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bundesland)) return false;

        Bundesland that = (Bundesland) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bundesland != null ? !bundesland.equals(that.bundesland) : that.bundesland != null) return false;
        return bundeslandLang != null ? bundeslandLang.equals(that.bundeslandLang) : that.bundeslandLang == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (bundeslandLang != null ? bundeslandLang.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bundesland{" +
                "id=" + id +
                ", bundesland='" + bundesland + '\'' +
                ", bundeslandLang='" + bundeslandLang + '\'' +
                '}';
    }
}
