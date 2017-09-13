package org.woehlke.btw17.kandidaten.oodm.model;

import org.woehlke.btw17.kandidaten.oodm.model.parts.DimensionFacetten;
import org.woehlke.btw17.kandidaten.oodm.model.parts.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DimensionKandidat;
import org.woehlke.btw17.kandidaten.oodm.model.parts.OnlineStrategie;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(
    name = "wohnort",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_wohnort",columnNames = {"wohnort"})
    },
    indexes = {
        @Index(name = "idx_wohnort_webseite", columnList = "webseite"),
        @Index(name = "idx_wohnort_facebook", columnList = "facebook"),
        @Index(name = "idx_wohnort_logo_url", columnList = "logo_url"),
        @Index(name = "idx_wohnort_wikipedia_article", columnList = "wikipedia_article"),
        @Index(name = "idx_wohnort_google_maps_url", columnList = "google_maps_url")
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Wohnort.getAllOrderById",
        query = "select o from Wohnort as o order by o.id"
    )
})
public class Wohnort implements DimensionKandidat {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    private String wohnort;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_bundesland", nullable = true, updatable = false)
    private Bundesland bundesland;

    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Valid
    @Embedded
    private DimensionFacetten dimensionFacetten = new DimensionFacetten();

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Transient
    public String getName() {
        return wohnort;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public Bundesland getBundesland() {
        return bundesland;
    }

    public void setBundesland(Bundesland bundesland) {
        this.bundesland = bundesland;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        this.onlineStrategie = onlineStrategie;
    }

    public DimensionFacetten getDimensionFacetten() {
        return dimensionFacetten;
    }

    public void setDimensionFacetten(DimensionFacetten dimensionFacetten) {
        this.dimensionFacetten = dimensionFacetten;
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
        if (!(o instanceof Wohnort)) return false;

        Wohnort wohnort1 = (Wohnort) o;

        if (id != null ? !id.equals(wohnort1.id) : wohnort1.id != null) return false;
        if (wohnort != null ? !wohnort.equals(wohnort1.wohnort) : wohnort1.wohnort != null) return false;
        if (bundesland != null ? !bundesland.equals(wohnort1.bundesland) : wohnort1.bundesland != null) return false;
        if (onlineStrategie != null ? !onlineStrategie.equals(wohnort1.onlineStrategie) : wohnort1.onlineStrategie != null)
            return false;
        if (dimensionFacetten != null ? !dimensionFacetten.equals(wohnort1.dimensionFacetten) : wohnort1.dimensionFacetten != null)
            return false;
        return geoPosition != null ? geoPosition.equals(wohnort1.geoPosition) : wohnort1.geoPosition == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wohnort != null ? wohnort.hashCode() : 0);
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        result = 31 * result + (dimensionFacetten != null ? dimensionFacetten.hashCode() : 0);
        result = 31 * result + (geoPosition != null ? geoPosition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wohnort{" +
                "id=" + id +
                ", wohnort='" + wohnort + '\'' +
                ", bundesland=" + bundesland +
                ", onlineStrategie=" + onlineStrategie +
                ", dimensionFacetten=" + dimensionFacetten +
                ", geoPosition=" + geoPosition +
                '}';
    }

    public String getSqlInsert() {

        String googleMapsUrl = geoPosition.getGoogleMapsUrl();
        String geoLongitude = geoPosition.getGeoLongitude();
        String geoLattitude = geoPosition.getGeoLattitude();
        String geoZoom = geoPosition.getGeoZoom();

        String facebook = onlineStrategie.getFacebook();
        String twitter = onlineStrategie.getTwitter();
        String webseite = onlineStrategie.getWebseite();
        String wikipediaArticle = onlineStrategie.getWikipediaArticle();
        String youtube = onlineStrategie.getYoutube();
        String bundestagAbgeordnete = onlineStrategie.getBundestagAbgeordnete();
        String abgeordnetenwatch = onlineStrategie.getAbgeordnetenwatch();
        String lobbypediaUrl = onlineStrategie.getLobbypediaUrl();
        String soundcloud = onlineStrategie.getSoundcloud();
        String googlePlus = onlineStrategie.getGooglePlus();
        String instagram = onlineStrategie.getInstagram();
        String flickr = onlineStrategie.getFlickr();
        String vimeo = onlineStrategie.getVimeo();
        String xing = onlineStrategie.getXing();
        String linkedIn = onlineStrategie.getLinkedIn();
        String stackoverflow = onlineStrategie.getStackoverflow();
        String github = onlineStrategie.getGithub();

        String logoUrl = dimensionFacetten.getLogoUrl();
        String symbolBild = dimensionFacetten.getSymbolBild();
        String beschreibungsText = dimensionFacetten.getBeschreibungsText();

        String columns[] = {
            "id","wohnort","webseite","wikipedia_article","facebook","logo_url",
            "google_maps_url","geo_longitude","geo_lattitude","geo_zoom", "soundcloud",
            "google_plus", "instagram", "flickr", "vimeo", "xing", "linked_in",
            "stackoverflow", "github", "symbol_bild", "beschreibungs_text"
        };
        Object fields[] = {
            id,wohnort,webseite,wikipediaArticle,facebook,logoUrl,
            googleMapsUrl,geoLongitude,geoLattitude,geoZoom, twitter,
            youtube,  bundestagAbgeordnete, abgeordnetenwatch, lobbypediaUrl, soundcloud,
            googlePlus, instagram, flickr, vimeo, xing, linkedIn,
            stackoverflow, github, symbolBild, beschreibungsText
        };
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO wohnort (");
        for(int i=0;i<columns.length; i++){
            sb.append(columns[i]);
            if((i+1)<columns.length){
                sb.append(",");
            }
        }
        sb.append(") VALUES (");
        for(int i=0;i<fields.length; i++){
            Object o = fields[i];
            if(o == null){
                sb.append("NULL");
            } else if(o instanceof Long){
                Long x = (Long) o;
                sb.append(x);
            }else if(o instanceof Integer){
                Integer x = (Integer) o;
                sb.append(x);
            } else if(o instanceof Double){
                Double x = (Double) o;
                sb.append(x);
            } else if(o instanceof String){
                String x = (String) o;
                sb.append("'");
                sb.append(x);
                sb.append("'");
            } else if(o instanceof DimensionKandidat){
                DimensionKandidat x = (DimensionKandidat) o;
                sb.append(x.getId());
            }
            if((i+1)<fields.length){
                sb.append(", ");
            }
        }
        sb.append(");");
        return sb.toString();
    }
}
