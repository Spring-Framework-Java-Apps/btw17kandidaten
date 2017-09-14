package org.woehlke.btw17.kandidaten.oodm.model.parts;

import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;
import org.woehlke.btw17.kandidaten.configuration.MySerializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Validated
@Embeddable
public class CommonFields implements MySerializable {

    @URL
    @Column(name="logo_url")
    private String logoUrl;

    @URL
    @Column(name="symbol_bild")
    private String symbolBild;

    @Column(name="beschreibungs_text",columnDefinition = "TEXT")
    private String beschreibungsText;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getSymbolBild() {
        return symbolBild;
    }

    public void setSymbolBild(String symbolBild) {
        this.symbolBild = symbolBild;
    }

    public String getBeschreibungsText() {
        return beschreibungsText;
    }

    public void setBeschreibungsText(String beschreibungsText) {
        this.beschreibungsText = beschreibungsText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonFields)) return false;

        CommonFields that = (CommonFields) o;

        if (logoUrl != null ? !logoUrl.equals(that.logoUrl) : that.logoUrl != null) return false;
        if (symbolBild != null ? !symbolBild.equals(that.symbolBild) : that.symbolBild != null) return false;
        return beschreibungsText != null ? beschreibungsText.equals(that.beschreibungsText) : that.beschreibungsText == null;
    }

    @Override
    public int hashCode() {
        int result = logoUrl != null ? logoUrl.hashCode() : 0;
        result = 31 * result + (symbolBild != null ? symbolBild.hashCode() : 0);
        result = 31 * result + (beschreibungsText != null ? beschreibungsText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DimensionFacetten{" +
                "logoUrl='" + logoUrl + '\'' +
                ", symbolBild='" + symbolBild + '\'' +
                ", beschreibungsText='" + beschreibungsText + '\'' +
                '}';
    }
}
