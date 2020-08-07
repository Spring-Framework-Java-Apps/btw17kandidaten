package org.woehlke.btw17.kandidaten.oodm.model.parts;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;
import org.woehlke.btw17.kandidaten.oodm.model.enums.EditStatus;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.parts.CommonFieldsEmbedded
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Validated
@Embeddable
public class CommonFields implements Serializable {

    @URL
    @Column(name="logo_url")
    private String logoUrl;

    @URL
    @Column(name="symbol_bild")
    private String symbolBild;

    @Column(name="beschreibungs_text",columnDefinition = "TEXT")
    private String beschreibungsText;

    @Enumerated(EnumType.STRING)
    @Column(name = "edit_status")
    private EditStatus editStatus = EditStatus.UNTOUCHED;

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

    public EditStatus getEditStatus() {
        return editStatus;
    }

    public void setEditStatus(EditStatus editStatus) {
        this.editStatus = editStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonFields)) return false;

        CommonFields that = (CommonFields) o;

        if (logoUrl != null ? !logoUrl.equals(that.logoUrl) : that.logoUrl != null) return false;
        if (symbolBild != null ? !symbolBild.equals(that.symbolBild) : that.symbolBild != null) return false;
        if (beschreibungsText != null ? !beschreibungsText.equals(that.beschreibungsText) : that.beschreibungsText != null)
            return false;
        return editStatus == that.editStatus;
    }

    @Override
    public int hashCode() {
        int result = logoUrl != null ? logoUrl.hashCode() : 0;
        result = 31 * result + (symbolBild != null ? symbolBild.hashCode() : 0);
        result = 31 * result + (beschreibungsText != null ? beschreibungsText.hashCode() : 0);
        result = 31 * result + (editStatus != null ? editStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CommonFields{" +
                "logoUrl='" + logoUrl + '\'' +
                ", symbolBild='" + symbolBild + '\'' +
                ", beschreibungsText='" + beschreibungsText + '\'' +
                ", editStatus=" + editStatus +
                '}';
    }
}
