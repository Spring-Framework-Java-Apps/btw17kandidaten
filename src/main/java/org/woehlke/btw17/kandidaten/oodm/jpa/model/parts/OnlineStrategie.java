package org.woehlke.btw17.kandidaten.oodm.jpa.model.parts;

import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.jpa.model.parts.OnlineStrategieEmbedded
 */
@Validated
@Embeddable
public class OnlineStrategie implements Serializable {

    @URL
    @Column(name="twitter")
    private String twitter;

    @URL
    @Column(name="facebook")
    private String facebook;

    @URL
    @Column(name="youtube")
    private String youtube;

    @URL
    @Column(name="soundcloud")
    private String soundcloud;

    @URL
    @Column(name="wikipedia_article")
    private String wikipediaArticle;

    @URL
    @Column(name="bundestag")
    private String bundestagAbgeordnete;

    @URL
    @Column(name="abgeordnetenwatch")
    private String abgeordnetenwatch;

    @URL
    @Column(name="lobbypedia_url")
    private String lobbypediaUrl;

    @URL
    @Column(name="lobbycontrol")
    private String lobbycontrol;

    @URL
    @Column(name="transparency")
    private String transparency;

    @URL
    @Column(name="netzpolitik_org")
    private String netzpolitikOrg;

    @URL
    @Column(name = "google_plus")
    private String googlePlus;

    @URL
    @Column(name = "google_suche")
    private String googleSuche;

    @URL
    @Column(name = "bing_suche")
    private String bingSuche;

    @URL
    @Column(name = "instagram")
    private String instagram;

    @URL
    @Column(name = "flickr")
    private String flickr;

    @URL
    @Column(name = "vimeo")
    private String vimeo;

    /*
    @URL
    @Column(name = "xing")
    private String xing;

    @URL
    @Column(name = "linked_in")
    private String linkedIn;

    @URL
    @Column(name = "stackoverflow")
    private String stackoverflow;

    @URL
    @Column(name = "github")
    private String github;

    @URL
    @Column(name = "whatsapp")
    private String whatsapp;

    @URL
    @Column(name = "wordpress")
    private String wordpress;

    @URL
    @Column(name = "spotify")
    private String spotify;

    @URL
    @Column(name = "snapchat")
    private String snapchat;

    @URL
    @Column(name = "skype")
    private String skype;

    @URL
    @Column(name = "slack")
    private String slack;

    @URL
    @Column(name = "slideshare")
    private String slideshare;

    @URL
    @Column(name = "pinterest")
    private String pinterest;

    @URL
    @Column(name = "paypal")
    private String paypal;

    @URL
    @Column(name = "meetup")
    private String meetup;

    @URL
    @Column(name = "lastfm")
    private String lastfm;

    @URL
    @Column(name = "imdb")
    private String imdb;

    @URL
    @Column(name = "foursquare")
    private String foursquare;

    @URL
    @Column(name = "digg")
    private String digg;

    @URL
    @Column(name = "delicious")
    private String delicious;

    @URL
    @Column(name = "url500px")
    private String url500px;

    @URL
    @Column(name = "amazon")
    private String amazon;

    @URL
    @Column(name = "hacker_news")
    private String hackerNews;

    @URL
    @Column(name = "scribd")
    private String scribd;

    @URL
    @Column(name = "tumblr")
    private String tumblr;

    @URL
    @Column(name = "viadeo")
    private String viadeo;

    @URL
    @Column(name = "yahoo")
    private String yahoo;

    @URL
    @Column(name = "yoast")
    private String yoast;

    @URL
    @Column(name = "yelp")
    private String yelp;
    */

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getSoundcloud() {
        return soundcloud;
    }

    public void setSoundcloud(String soundcloud) {
        this.soundcloud = soundcloud;
    }

    public String getWikipediaArticle() {
        return wikipediaArticle;
    }

    public void setWikipediaArticle(String wikipediaArticle) {
        this.wikipediaArticle = wikipediaArticle;
    }

    public String getBundestagAbgeordnete() {
        return bundestagAbgeordnete;
    }

    public void setBundestagAbgeordnete(String bundestagAbgeordnete) {
        this.bundestagAbgeordnete = bundestagAbgeordnete;
    }

    public String getAbgeordnetenwatch() {
        return abgeordnetenwatch;
    }

    public void setAbgeordnetenwatch(String abgeordnetenwatch) {
        this.abgeordnetenwatch = abgeordnetenwatch;
    }

    public String getLobbypediaUrl() {
        return lobbypediaUrl;
    }

    public void setLobbypediaUrl(String lobbypediaUrl) {
        this.lobbypediaUrl = lobbypediaUrl;
    }

    public String getGooglePlus() {
        return googlePlus;
    }

    public void setGooglePlus(String googlePlus) {
        this.googlePlus = googlePlus;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFlickr() {
        return flickr;
    }

    public void setFlickr(String flickr) {
        this.flickr = flickr;
    }

    public String getVimeo() {
        return vimeo;
    }

    public void setVimeo(String vimeo) {
        this.vimeo = vimeo;
    }

    public String getLobbycontrol() {
        return lobbycontrol;
    }

    public void setLobbycontrol(String lobbycontrol) {
        this.lobbycontrol = lobbycontrol;
    }

    public String getGoogleSuche() {
        return googleSuche;
    }

    public void setGoogleSuche(String googleSuche) {
        this.googleSuche = googleSuche;
    }

    public String getBingSuche() {
        return bingSuche;
    }

    public void setBingSuche(String bingSuche) {
        this.bingSuche = bingSuche;
    }

    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public String getNetzpolitikOrg() {
        return netzpolitikOrg;
    }

    public void setNetzpolitikOrg(String netzpolitikOrg) {
        this.netzpolitikOrg = netzpolitikOrg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OnlineStrategie)) return false;

        OnlineStrategie that = (OnlineStrategie) o;

        if (twitter != null ? !twitter.equals(that.twitter) : that.twitter != null) return false;
        if (facebook != null ? !facebook.equals(that.facebook) : that.facebook != null) return false;
        if (youtube != null ? !youtube.equals(that.youtube) : that.youtube != null) return false;
        if (soundcloud != null ? !soundcloud.equals(that.soundcloud) : that.soundcloud != null) return false;
        if (wikipediaArticle != null ? !wikipediaArticle.equals(that.wikipediaArticle) : that.wikipediaArticle != null)
            return false;
        if (bundestagAbgeordnete != null ? !bundestagAbgeordnete.equals(that.bundestagAbgeordnete) : that.bundestagAbgeordnete != null)
            return false;
        if (abgeordnetenwatch != null ? !abgeordnetenwatch.equals(that.abgeordnetenwatch) : that.abgeordnetenwatch != null)
            return false;
        if (lobbypediaUrl != null ? !lobbypediaUrl.equals(that.lobbypediaUrl) : that.lobbypediaUrl != null)
            return false;
        if (lobbycontrol != null ? !lobbycontrol.equals(that.lobbycontrol) : that.lobbycontrol != null) return false;
        if (transparency != null ? !transparency.equals(that.transparency) : that.transparency != null) return false;
        if (netzpolitikOrg != null ? !netzpolitikOrg.equals(that.netzpolitikOrg) : that.netzpolitikOrg != null)
            return false;
        if (googlePlus != null ? !googlePlus.equals(that.googlePlus) : that.googlePlus != null) return false;
        if (googleSuche != null ? !googleSuche.equals(that.googleSuche) : that.googleSuche != null) return false;
        if (bingSuche != null ? !bingSuche.equals(that.bingSuche) : that.bingSuche != null) return false;
        if (instagram != null ? !instagram.equals(that.instagram) : that.instagram != null) return false;
        if (flickr != null ? !flickr.equals(that.flickr) : that.flickr != null) return false;
        return vimeo != null ? vimeo.equals(that.vimeo) : that.vimeo == null;
    }

    @Override
    public int hashCode() {
        int result = twitter != null ? twitter.hashCode() : 0;
        result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
        result = 31 * result + (youtube != null ? youtube.hashCode() : 0);
        result = 31 * result + (soundcloud != null ? soundcloud.hashCode() : 0);
        result = 31 * result + (wikipediaArticle != null ? wikipediaArticle.hashCode() : 0);
        result = 31 * result + (bundestagAbgeordnete != null ? bundestagAbgeordnete.hashCode() : 0);
        result = 31 * result + (abgeordnetenwatch != null ? abgeordnetenwatch.hashCode() : 0);
        result = 31 * result + (lobbypediaUrl != null ? lobbypediaUrl.hashCode() : 0);
        result = 31 * result + (lobbycontrol != null ? lobbycontrol.hashCode() : 0);
        result = 31 * result + (transparency != null ? transparency.hashCode() : 0);
        result = 31 * result + (netzpolitikOrg != null ? netzpolitikOrg.hashCode() : 0);
        result = 31 * result + (googlePlus != null ? googlePlus.hashCode() : 0);
        result = 31 * result + (googleSuche != null ? googleSuche.hashCode() : 0);
        result = 31 * result + (bingSuche != null ? bingSuche.hashCode() : 0);
        result = 31 * result + (instagram != null ? instagram.hashCode() : 0);
        result = 31 * result + (flickr != null ? flickr.hashCode() : 0);
        result = 31 * result + (vimeo != null ? vimeo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OnlineStrategie{" +
                "twitter='" + twitter + '\'' +
                ", facebook='" + facebook + '\'' +
                ", youtube='" + youtube + '\'' +
                ", soundcloud='" + soundcloud + '\'' +
                ", wikipediaArticle='" + wikipediaArticle + '\'' +
                ", bundestagAbgeordnete='" + bundestagAbgeordnete + '\'' +
                ", abgeordnetenwatch='" + abgeordnetenwatch + '\'' +
                ", lobbypediaUrl='" + lobbypediaUrl + '\'' +
                ", lobbycontrol='" + lobbycontrol + '\'' +
                ", transparency='" + transparency + '\'' +
                ", netzpolitikOrg='" + netzpolitikOrg + '\'' +
                ", googlePlus='" + googlePlus + '\'' +
                ", googleSuche='" + googleSuche + '\'' +
                ", bingSuche='" + bingSuche + '\'' +
                ", instagram='" + instagram + '\'' +
                ", flickr='" + flickr + '\'' +
                ", vimeo='" + vimeo + '\'' +
                '}';
    }
}
