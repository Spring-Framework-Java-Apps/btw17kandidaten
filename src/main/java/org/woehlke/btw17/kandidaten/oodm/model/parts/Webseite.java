package org.woehlke.btw17.kandidaten.oodm.model.parts;

import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteCms;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.parts.WebseiteEmbedded
 */
@Validated
@Embeddable
public class Webseite {

    @URL
    @Column(name="webseite")
    private String webseite;

    @ManyToOne(fetch=EAGER,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_webseite_cms")
    private WebseiteCms webseiteCms;

    @ManyToMany(fetch=EAGER,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<WebseiteAgentur> webseiteAgentur = new LinkedHashSet<>();

    public String getWebseite() {
        return webseite;
    }

    public void setWebseite(String webseite) {
        this.webseite = webseite;
    }

    public WebseiteCms getWebseiteCms() {
        return webseiteCms;
    }

    public void setWebseiteCms(WebseiteCms webseiteCms) {
        this.webseiteCms = webseiteCms;
    }

    public Set<WebseiteAgentur> getWebseiteAgentur() {
        return webseiteAgentur;
    }

    public void setWebseiteAgentur(Set<WebseiteAgentur> webseiteAgentur) {
        this.webseiteAgentur = webseiteAgentur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Webseite)) return false;

        Webseite webseite1 = (Webseite) o;

        if (webseite != null ? !webseite.equals(webseite1.webseite) : webseite1.webseite != null) return false;
        if (webseiteCms != null ? !webseiteCms.equals(webseite1.webseiteCms) : webseite1.webseiteCms != null)
            return false;
        return webseiteAgentur != null ? webseiteAgentur.equals(webseite1.webseiteAgentur) : webseite1.webseiteAgentur == null;
    }

    @Override
    public int hashCode() {
        int result = webseite != null ? webseite.hashCode() : 0;
        result = 31 * result + (webseiteCms != null ? webseiteCms.hashCode() : 0);
        result = 31 * result + (webseiteAgentur != null ? webseiteAgentur.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Webseite{" +
                "webseite='" + webseite + '\'' +
                ", webseiteCms=" + webseiteCms +
                ", webseiteAgentur=" + webseiteAgentur +
                '}';
    }
}
