package org.woehlke.btw17.kandidaten.oodm.model;


import org.woehlke.btw17.kandidaten.oodm.model.parts.DimensionKandidat;
import org.woehlke.btw17.kandidaten.oodm.model.parts.GeoPosition;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(
    name = "geburtsort",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_geburtsort",columnNames = {"geburtsort"})
    }
)
public class Geburtsort implements DimensionKandidat {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @Column
    private String geburtsort;

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Transient
    public String getName() {
        return geburtsort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geburtsort)) return false;

        Geburtsort that = (Geburtsort) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (geburtsort != null ? !geburtsort.equals(that.geburtsort) : that.geburtsort != null) return false;
        return geoPosition != null ? geoPosition.equals(that.geoPosition) : that.geoPosition == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (geburtsort != null ? geburtsort.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Geburtsort{" +
                "id=" + id +
                ", geburtsort='" + geburtsort + '\'' +
                ", geoPosition=" + geoPosition +
                '}';
    }
}
