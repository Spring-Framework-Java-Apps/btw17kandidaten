package org.woehlke.btw17.kandidaten.oodm.model;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;
import org.woehlke.btw17.kandidaten.oodm.model.listener.WebseiteCmsListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.parts.Webseite
 * @see org.woehlke.btw17.kandidaten.oodm.model.parts.WebseiteEmbedded
 *
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Entity
@Table(
    name = "cms",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_cms",columnNames = {"cms"})
    },
    indexes = {
        @Index(name = "idx_cms_technology_stack", columnList = "technology_stack"),
        @Index(name = "idx_cms_hersteller", columnList = "hersteller"),
        @Index(name = "idx_cms_product_info_page", columnList = "product_info_page"),
        @Index(name = "idx_cms_product_demo_page", columnList = "product_demo_page")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "WebseiteCms.getAll",
        query = "select o from WebseiteCms as o order by o.cms"
    ),
    @NamedQuery(
        name = "WebseiteCms.getAllCount",
        query = "select count(o) from WebseiteCms as o"
    ),
    @NamedQuery(
        name = "WebseiteCms.findByCms",
        query = "select o from WebseiteCms as o where o.cms=:cms"
    )
})
@EntityListeners(WebseiteCmsListener.class)
public class WebseiteCms implements DomainObject,AdresseEmbedded,OnlineStrategieEmbedded,GeoPositionEmbedded,CommonFieldsEmbedded {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @SafeHtml
    @NotNull
    @Column
    private String cms;

    @SafeHtml
    @Column(name="technology_stack")
    private String technologyStack;

    @SafeHtml
    @Column
    private String hersteller;

    @URL
    @Column(name="product_info_page")
    private String productInfoPage;

    @URL
    @Column(name="product_demo_page")
    private String productDemoPage;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    private Adresse adresse = new Adresse();

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Transient
    @Override
    public String getName() {
        return cms;
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCms() {
        return cms;
    }

    public void setCms(String cms) {
        this.cms = cms;
    }

    public String getTechnologyStack() {
        return technologyStack;
    }

    public void setTechnologyStack(String technologyStack) {
        this.technologyStack = technologyStack;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    @Override
    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    @Override
    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }

    @Override
    public CommonFields getCommonFields() {
        return commonFields;
    }

    @Override
    public void setCommonFields(CommonFields commonFields) {
        this.commonFields = commonFields;
    }

    @Override
    public Adresse getAdresse() {
        return adresse;
    }

    @Override
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    @Override
    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public String getProductInfoPage() {
        return productInfoPage;
    }

    public void setProductInfoPage(String productInfoPage) {
        this.productInfoPage = productInfoPage;
    }

    public String getProductDemoPage() {
        return productDemoPage;
    }

    public void setProductDemoPage(String productDemoPage) {
        this.productDemoPage = productDemoPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebseiteCms)) return false;

        WebseiteCms that = (WebseiteCms) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cms != null ? !cms.equals(that.cms) : that.cms != null) return false;
        if (technologyStack != null ? !technologyStack.equals(that.technologyStack) : that.technologyStack != null)
            return false;
        if (hersteller != null ? !hersteller.equals(that.hersteller) : that.hersteller != null) return false;
        if (productInfoPage != null ? !productInfoPage.equals(that.productInfoPage) : that.productInfoPage != null)
            return false;
        if (productDemoPage != null ? !productDemoPage.equals(that.productDemoPage) : that.productDemoPage != null)
            return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(that.onlineStrategie) : that.onlineStrategie != null)
            return false;
        if (commonFields != null ? !commonFields.equals(that.commonFields) : that.commonFields != null) return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        return geoPosition != null ? geoPosition.equals(that.geoPosition) : that.geoPosition == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cms != null ? cms.hashCode() : 0);
        result = 31 * result + (technologyStack != null ? technologyStack.hashCode() : 0);
        result = 31 * result + (hersteller != null ? hersteller.hashCode() : 0);
        result = 31 * result + (productInfoPage != null ? productInfoPage.hashCode() : 0);
        result = 31 * result + (productDemoPage != null ? productDemoPage.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WebseiteCms{" +
                "id=" + id +
                ", cms='" + cms + '\'' +
                ", technologyStack='" + technologyStack + '\'' +
                ", hersteller='" + hersteller + '\'' +
                ", productInfoPage='" + productInfoPage + '\'' +
                ", productDemoPage='" + productDemoPage + '\'' +
                ", onlineStrategie=" + onlineStrategie +
                ", commonFields=" + commonFields +
                ", adresse=" + adresse +
                ", geoPosition=" + geoPosition +
                '}';
    }
}