package org.woehlke.btw17.kandidaten.oodm.model.parts;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteAgentur;
import org.woehlke.btw17.kandidaten.oodm.model.WebseiteCms;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.parts.WebseiteEmbedded
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Validated
@Embeddable
public class Webseite implements Serializable {

    @URL
    @Column(name="webseite")
    private String webseite;

    @ManyToOne(fetch=LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_webseite_cms")
    private WebseiteCms cms;

    @ManyToMany(fetch=LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<WebseiteAgentur> agenturen = new LinkedHashSet<>();

    public String getWebseite() {
        return webseite;
    }

    public void setWebseite(String webseite) {
        this.webseite = webseite;
    }

    public WebseiteCms getCms() {
        return cms;
    }

    public void setCms(WebseiteCms cms) {
        this.cms = cms;
    }

    public Set<WebseiteAgentur> getAgenturen() {
        return agenturen;
    }

    public void setAgenturen(Set<WebseiteAgentur> agenturen) {
        if(agenturen != null){
            this.agenturen = agenturen;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Webseite)) return false;

        Webseite webseite1 = (Webseite) o;

        if (webseite != null ? !webseite.equals(webseite1.webseite) : webseite1.webseite != null) return false;
        if (cms != null ? !cms.equals(webseite1.cms) : webseite1.cms != null) return false;
        return agenturen != null ? agenturen.equals(webseite1.agenturen) : webseite1.agenturen == null;
    }

    @Override
    public int hashCode() {
        int result = webseite != null ? webseite.hashCode() : 0;
        result = 31 * result + (cms != null ? cms.hashCode() : 0);
        result = 31 * result + (agenturen != null ? agenturen.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Webseite{" +
                "webseite='" + webseite + '\'' +
                ", cms=" + cms +
                ", agenturen=" + agenturen +
                '}';
    }
}
