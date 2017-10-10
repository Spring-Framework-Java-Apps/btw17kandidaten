package org.woehlke.btw17.kandidaten.oodm.model.parts;


import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.parts.OnlineStrategieEmbedded
 */
@Validated
@Embeddable
public class Institution implements Serializable {

    @Column(name = "insartlang")
    private String institutionArtLang;

    @Column(name = "inslang")
    private String institutionLang;

    @Column(name = "mdbinsvon")
    private String mdbInstitutionVon;

    @Column(name = "mdbinsbis")
    private String mdbInstitutionBis;

    @Column(name = "fktlang")
    private String funktionLang;

    @Column(name = "fktinsvon")
    private String funktionInstitutionVon;

    @Column(name = "fktinsbis")
    private String funktionInstitutionBis;

    public String getInstitutionArtLang() {
        return institutionArtLang;
    }

    public void setInstitutionArtLang(String institutionArtLang) {
        this.institutionArtLang = institutionArtLang;
    }

    public String getInstitutionLang() {
        return institutionLang;
    }

    public void setInstitutionLang(String institutionLang) {
        this.institutionLang = institutionLang;
    }

    public String getMdbInstitutionVon() {
        return mdbInstitutionVon;
    }

    public void setMdbInstitutionVon(String mdbInstitutionVon) {
        this.mdbInstitutionVon = mdbInstitutionVon;
    }

    public String getMdbInstitutionBis() {
        return mdbInstitutionBis;
    }

    public void setMdbInstitutionBis(String mdbInstitutionBis) {
        this.mdbInstitutionBis = mdbInstitutionBis;
    }

    public String getFunktionLang() {
        return funktionLang;
    }

    public void setFunktionLang(String funktionLang) {
        this.funktionLang = funktionLang;
    }

    public String getFunktionInstitutionVon() {
        return funktionInstitutionVon;
    }

    public void setFunktionInstitutionVon(String funktionInstitutionVon) {
        this.funktionInstitutionVon = funktionInstitutionVon;
    }

    public String getFunktionInstitutionBis() {
        return funktionInstitutionBis;
    }

    public void setFunktionInstitutionBis(String funktionInstitutionBis) {
        this.funktionInstitutionBis = funktionInstitutionBis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Institution)) return false;

        Institution that = (Institution) o;

        if (institutionArtLang != null ? !institutionArtLang.equals(that.institutionArtLang) : that.institutionArtLang != null)
            return false;
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
                "institutionArtLang='" + institutionArtLang + '\'' +
                ", institutionLang='" + institutionLang + '\'' +
                ", mdbInstitutionVon='" + mdbInstitutionVon + '\'' +
                ", mdbInstitutionBis='" + mdbInstitutionBis + '\'' +
                ", funktionLang='" + funktionLang + '\'' +
                ", funktionInstitutionVon='" + funktionInstitutionVon + '\'' +
                ", funktionInstitutionBis='" + funktionInstitutionBis + '\'' +
                '}';
    }
}
