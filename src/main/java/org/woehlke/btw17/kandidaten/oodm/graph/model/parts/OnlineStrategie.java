package org.woehlke.btw17.kandidaten.oodm.graph.model.parts;


import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;


//TODO: Pro Online Profil ein Node
@NodeEntity
public class OnlineStrategie extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index
    @Property(name="twitter")
    private String twitter;

   @Index
    @Property(name="facebook")
    private String facebook;

   @Index
    @Property(name="youtube")
    private String youtube;

   @Index
    @Property(name="soundcloud")
    private String soundcloud;

   @Index
    @Property(name="wikipedia_article")
    private String wikipediaArticle;

   @Index
    @Property(name="bundestag")
    private String bundestagAbgeordnete;

   @Index
    @Property(name="abgeordnetenwatch")
    private String abgeordnetenwatch;

   @Index
    @Property(name="lobbypedia_url")
    private String lobbypediaUrl;

   @Index
    @Property(name="lobbycontrol")
    private String lobbycontrol;

   @Index
    @Property(name="transparency")
    private String transparency;

   @Index
    @Property(name="netzpolitik_org")
    private String netzpolitikOrg;

   @Index
    @Property(name = "google_plus")
    private String googlePlus;

   @Index
    @Property(name = "google_suche")
    private String googleSuche;

   @Index
    @Property(name = "bing_suche")
    private String bingSuche;

   @Index
    @Property(name = "instagram")
    private String instagram;

   @Index
    @Property(name = "flickr")
    private String flickr;

   @Index
    @Property(name = "vimeo")
    private String vimeo;


   @Index
    @Property(name = "xing")
    private String xing;

   @Index
    @Property(name = "linked_in")
    private String linkedIn;

       /*
   @Index
    @Property(name = "stackoverflow")
    private String stackoverflow;

   @Index
    @Property(name = "github")
    private String github;

   @Index
    @Property(name = "whatsapp")
    private String whatsapp;

   @Index
    @Property(name = "wordpress")
    private String wordpress;

   @Index
    @Property(name = "spotify")
    private String spotify;

   @Index
    @Property(name = "snapchat")
    private String snapchat;

   @Index
    @Property(name = "skype")
    private String skype;

   @Index
    @Property(name = "slack")
    private String slack;

   @Index
    @Property(name = "slideshare")
    private String slideshare;

   @Index
    @Property(name = "pinterest")
    private String pinterest;

   @Index
    @Property(name = "paypal")
    private String paypal;

   @Index
    @Property(name = "meetup")
    private String meetup;

   @Index
    @Property(name = "lastfm")
    private String lastfm;

   @Index
    @Property(name = "imdb")
    private String imdb;

   @Index
    @Property(name = "foursquare")
    private String foursquare;

   @Index
    @Property(name = "digg")
    private String digg;

   @Index
    @Property(name = "delicious")
    private String delicious;

   @Index
    @Property(name = "url500px")
    private String url500px;

   @Index
    @Property(name = "amazon")
    private String amazon;

   @Index
    @Property(name = "hacker_news")
    private String hackerNews;

   @Index
    @Property(name = "scribd")
    private String scribd;

   @Index
    @Property(name = "tumblr")
    private String tumblr;

   @Index
    @Property(name = "viadeo")
    private String viadeo;

   @Index
    @Property(name = "yahoo")
    private String yahoo;

   @Index
    @Property(name = "yoast")
    private String yoast;

   @Index
    @Property(name = "yelp")
    private String yelp;
    */

    public OnlineStrategie() {
    }

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

    public String getLobbycontrol() {
        return lobbycontrol;
    }

    public void setLobbycontrol(String lobbycontrol) {
        this.lobbycontrol = lobbycontrol;
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

    public String getGooglePlus() {
        return googlePlus;
    }

    public void setGooglePlus(String googlePlus) {
        this.googlePlus = googlePlus;
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

    public String getXing() {
        return xing;
    }

    public void setXing(String xing) {
        this.xing = xing;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }
}
