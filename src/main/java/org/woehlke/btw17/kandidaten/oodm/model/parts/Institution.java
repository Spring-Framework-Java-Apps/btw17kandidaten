package org.woehlke.btw17.kandidaten.oodm.model.parts;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;
import org.woehlke.btw17.kandidaten.oodm.model.enums.InstitutionArt;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.parts.InstitutionEmbedded
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Validated
@Embeddable
public class Institution implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "insartlang")
    private InstitutionArt institutionArtLang;

    @Column(name = "inslang")
    private String institutionLang;

    @Column(name = "mdbinsvon")
    private LocalDate mdbInstitutionVon;

    @Column(name = "mdbinsbis")
    private LocalDate mdbInstitutionBis;

    @Column(name = "fktlang")
    private String funktionLang;

    @Column(name = "fktinsvon")
    private LocalDate funktionInstitutionVon;

    @Column(name = "fktinsbis")
    private LocalDate funktionInstitutionBis;

    public InstitutionArt getInstitutionArtLang() {
        return institutionArtLang;
    }

    public void setInstitutionArtLang(InstitutionArt institutionArtLang) {
        this.institutionArtLang = institutionArtLang;
    }

    public String getInstitutionLang() {
        return institutionLang;
    }

    public void setInstitutionLang(String institutionLang) {
        this.institutionLang = institutionLang;
    }

    public LocalDate getMdbInstitutionVon() {
        return mdbInstitutionVon;
    }

    public void setMdbInstitutionVon(LocalDate mdbInstitutionVon) {
        this.mdbInstitutionVon = mdbInstitutionVon;
    }

    public LocalDate getMdbInstitutionBis() {
        return mdbInstitutionBis;
    }

    public void setMdbInstitutionBis(LocalDate mdbInstitutionBis) {
        this.mdbInstitutionBis = mdbInstitutionBis;
    }

    public String getFunktionLang() {
        return funktionLang;
    }

    public void setFunktionLang(String funktionLang) {
        this.funktionLang = funktionLang;
    }

    public LocalDate getFunktionInstitutionVon() {
        return funktionInstitutionVon;
    }

    public void setFunktionInstitutionVon(LocalDate funktionInstitutionVon) {
        this.funktionInstitutionVon = funktionInstitutionVon;
    }

    public LocalDate getFunktionInstitutionBis() {
        return funktionInstitutionBis;
    }

    public void setFunktionInstitutionBis(LocalDate funktionInstitutionBis) {
        this.funktionInstitutionBis = funktionInstitutionBis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Institution)) return false;

        Institution that = (Institution) o;

        if (institutionArtLang != that.institutionArtLang) return false;
        if (institutionLang != null ? !institutionLang.equals(that.institutionLang) : that.institutionLang != null)
            return false;
        if (mdbInstitutionVon != null ? !mdbInstitutionVon.equals(that.mdbInstitutionVon) : that.mdbInstitutionVon != null)
            return false;
        if (mdbInstitutionBis != null ? !mdbInstitutionBis.equals(that.mdbInstitutionBis) : that.mdbInstitutionBis != null)
            return false;
        if (funktionLang != null ? !funktionLang.equals(that.funktionLang) : that.funktionLang != null) return false;
        if (funktionInstitutionVon != null ? !funktionInstitutionVon.equals(that.funktionInstitutionVon) : that.funktionInstitutionVon != null)
            return false;
        return funktionInstitutionBis != null ? funktionInstitutionBis.equals(that.funktionInstitutionBis) : that.funktionInstitutionBis == null;
    }

    @Override
    public int hashCode() {
        int result = institutionArtLang != null ? institutionArtLang.hashCode() : 0;
        result = 31 * result + (institutionLang != null ? institutionLang.hashCode() : 0);
        result = 31 * result + (mdbInstitutionVon != null ? mdbInstitutionVon.hashCode() : 0);
        result = 31 * result + (mdbInstitutionBis != null ? mdbInstitutionBis.hashCode() : 0);
        result = 31 * result + (funktionLang != null ? funktionLang.hashCode() : 0);
        result = 31 * result + (funktionInstitutionVon != null ? funktionInstitutionVon.hashCode() : 0);
        result = 31 * result + (funktionInstitutionBis != null ? funktionInstitutionBis.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "institutionArtLang=" + institutionArtLang +
                ", institutionLang='" + institutionLang + '\'' +
                ", mdbInstitutionVon=" + mdbInstitutionVon +
                ", mdbInstitutionBis=" + mdbInstitutionBis +
                ", funktionLang='" + funktionLang + '\'' +
                ", funktionInstitutionVon=" + funktionInstitutionVon +
                ", funktionInstitutionBis=" + funktionInstitutionBis +
                '}';
    }
}
