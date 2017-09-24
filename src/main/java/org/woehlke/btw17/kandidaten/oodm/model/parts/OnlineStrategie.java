package org.woehlke.btw17.kandidaten.oodm.model.parts;

import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;
import org.woehlke.btw17.kandidaten.configuration.MySerializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @see org.woehlke.btw17.kandidaten.oodm.model.parts.OnlineStrategieEmbedded
 */
@Validated
@Embeddable
public class OnlineStrategie implements MySerializable {

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

    public String getStackoverflow() {
        return stackoverflow;
    }

    public void setStackoverflow(String stackoverflow) {
        this.stackoverflow = stackoverflow;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
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

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getWordpress() {
        return wordpress;
    }

    public void setWordpress(String wordpress) {
        this.wordpress = wordpress;
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    public String getSnapchat() {
        return snapchat;
    }

    public void setSnapchat(String snapchat) {
        this.snapchat = snapchat;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getSlack() {
        return slack;
    }

    public void setSlack(String slack) {
        this.slack = slack;
    }

    public String getSlideshare() {
        return slideshare;
    }

    public void setSlideshare(String slideshare) {
        this.slideshare = slideshare;
    }

    public String getPinterest() {
        return pinterest;
    }

    public void setPinterest(String pinterest) {
        this.pinterest = pinterest;
    }

    public String getPaypal() {
        return paypal;
    }

    public void setPaypal(String paypal) {
        this.paypal = paypal;
    }

    public String getMeetup() {
        return meetup;
    }

    public void setMeetup(String meetup) {
        this.meetup = meetup;
    }

    public String getLastfm() {
        return lastfm;
    }

    public void setLastfm(String lastfm) {
        this.lastfm = lastfm;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getFoursquare() {
        return foursquare;
    }

    public void setFoursquare(String foursquare) {
        this.foursquare = foursquare;
    }

    public String getDigg() {
        return digg;
    }

    public void setDigg(String digg) {
        this.digg = digg;
    }

    public String getDelicious() {
        return delicious;
    }

    public void setDelicious(String delicious) {
        this.delicious = delicious;
    }

    public String getUrl500px() {
        return url500px;
    }

    public void setUrl500px(String url500px) {
        this.url500px = url500px;
    }

    public String getAmazon() {
        return amazon;
    }

    public void setAmazon(String amazon) {
        this.amazon = amazon;
    }

    public String getHackerNews() {
        return hackerNews;
    }

    public void setHackerNews(String hackerNews) {
        this.hackerNews = hackerNews;
    }

    public String getScribd() {
        return scribd;
    }

    public void setScribd(String scribd) {
        this.scribd = scribd;
    }

    public String getTumblr() {
        return tumblr;
    }

    public void setTumblr(String tumblr) {
        this.tumblr = tumblr;
    }

    public String getViadeo() {
        return viadeo;
    }

    public void setViadeo(String viadeo) {
        this.viadeo = viadeo;
    }

    public String getYahoo() {
        return yahoo;
    }

    public void setYahoo(String yahoo) {
        this.yahoo = yahoo;
    }

    public String getYoast() {
        return yoast;
    }

    public void setYoast(String yoast) {
        this.yoast = yoast;
    }

    public String getYelp() {
        return yelp;
    }

    public void setYelp(String yelp) {
        this.yelp = yelp;
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
        if (vimeo != null ? !vimeo.equals(that.vimeo) : that.vimeo != null) return false;
        if (xing != null ? !xing.equals(that.xing) : that.xing != null) return false;
        if (linkedIn != null ? !linkedIn.equals(that.linkedIn) : that.linkedIn != null) return false;
        if (stackoverflow != null ? !stackoverflow.equals(that.stackoverflow) : that.stackoverflow != null)
            return false;
        if (github != null ? !github.equals(that.github) : that.github != null) return false;
        if (whatsapp != null ? !whatsapp.equals(that.whatsapp) : that.whatsapp != null) return false;
        if (wordpress != null ? !wordpress.equals(that.wordpress) : that.wordpress != null) return false;
        if (spotify != null ? !spotify.equals(that.spotify) : that.spotify != null) return false;
        if (snapchat != null ? !snapchat.equals(that.snapchat) : that.snapchat != null) return false;
        if (skype != null ? !skype.equals(that.skype) : that.skype != null) return false;
        if (slack != null ? !slack.equals(that.slack) : that.slack != null) return false;
        if (slideshare != null ? !slideshare.equals(that.slideshare) : that.slideshare != null) return false;
        if (pinterest != null ? !pinterest.equals(that.pinterest) : that.pinterest != null) return false;
        if (paypal != null ? !paypal.equals(that.paypal) : that.paypal != null) return false;
        if (meetup != null ? !meetup.equals(that.meetup) : that.meetup != null) return false;
        if (lastfm != null ? !lastfm.equals(that.lastfm) : that.lastfm != null) return false;
        if (imdb != null ? !imdb.equals(that.imdb) : that.imdb != null) return false;
        if (foursquare != null ? !foursquare.equals(that.foursquare) : that.foursquare != null) return false;
        if (digg != null ? !digg.equals(that.digg) : that.digg != null) return false;
        if (delicious != null ? !delicious.equals(that.delicious) : that.delicious != null) return false;
        if (url500px != null ? !url500px.equals(that.url500px) : that.url500px != null) return false;
        if (amazon != null ? !amazon.equals(that.amazon) : that.amazon != null) return false;
        if (hackerNews != null ? !hackerNews.equals(that.hackerNews) : that.hackerNews != null) return false;
        if (scribd != null ? !scribd.equals(that.scribd) : that.scribd != null) return false;
        if (tumblr != null ? !tumblr.equals(that.tumblr) : that.tumblr != null) return false;
        if (viadeo != null ? !viadeo.equals(that.viadeo) : that.viadeo != null) return false;
        if (yahoo != null ? !yahoo.equals(that.yahoo) : that.yahoo != null) return false;
        if (yoast != null ? !yoast.equals(that.yoast) : that.yoast != null) return false;
        return yelp != null ? yelp.equals(that.yelp) : that.yelp == null;
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
        result = 31 * result + (xing != null ? xing.hashCode() : 0);
        result = 31 * result + (linkedIn != null ? linkedIn.hashCode() : 0);
        result = 31 * result + (stackoverflow != null ? stackoverflow.hashCode() : 0);
        result = 31 * result + (github != null ? github.hashCode() : 0);
        result = 31 * result + (whatsapp != null ? whatsapp.hashCode() : 0);
        result = 31 * result + (wordpress != null ? wordpress.hashCode() : 0);
        result = 31 * result + (spotify != null ? spotify.hashCode() : 0);
        result = 31 * result + (snapchat != null ? snapchat.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (slack != null ? slack.hashCode() : 0);
        result = 31 * result + (slideshare != null ? slideshare.hashCode() : 0);
        result = 31 * result + (pinterest != null ? pinterest.hashCode() : 0);
        result = 31 * result + (paypal != null ? paypal.hashCode() : 0);
        result = 31 * result + (meetup != null ? meetup.hashCode() : 0);
        result = 31 * result + (lastfm != null ? lastfm.hashCode() : 0);
        result = 31 * result + (imdb != null ? imdb.hashCode() : 0);
        result = 31 * result + (foursquare != null ? foursquare.hashCode() : 0);
        result = 31 * result + (digg != null ? digg.hashCode() : 0);
        result = 31 * result + (delicious != null ? delicious.hashCode() : 0);
        result = 31 * result + (url500px != null ? url500px.hashCode() : 0);
        result = 31 * result + (amazon != null ? amazon.hashCode() : 0);
        result = 31 * result + (hackerNews != null ? hackerNews.hashCode() : 0);
        result = 31 * result + (scribd != null ? scribd.hashCode() : 0);
        result = 31 * result + (tumblr != null ? tumblr.hashCode() : 0);
        result = 31 * result + (viadeo != null ? viadeo.hashCode() : 0);
        result = 31 * result + (yahoo != null ? yahoo.hashCode() : 0);
        result = 31 * result + (yoast != null ? yoast.hashCode() : 0);
        result = 31 * result + (yelp != null ? yelp.hashCode() : 0);
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
                ", xing='" + xing + '\'' +
                ", linkedIn='" + linkedIn + '\'' +
                ", stackoverflow='" + stackoverflow + '\'' +
                ", github='" + github + '\'' +
                ", whatsapp='" + whatsapp + '\'' +
                ", wordpress='" + wordpress + '\'' +
                ", spotify='" + spotify + '\'' +
                ", snapchat='" + snapchat + '\'' +
                ", skype='" + skype + '\'' +
                ", slack='" + slack + '\'' +
                ", slideshare='" + slideshare + '\'' +
                ", pinterest='" + pinterest + '\'' +
                ", paypal='" + paypal + '\'' +
                ", meetup='" + meetup + '\'' +
                ", lastfm='" + lastfm + '\'' +
                ", imdb='" + imdb + '\'' +
                ", foursquare='" + foursquare + '\'' +
                ", digg='" + digg + '\'' +
                ", delicious='" + delicious + '\'' +
                ", url500px='" + url500px + '\'' +
                ", amazon='" + amazon + '\'' +
                ", hackerNews='" + hackerNews + '\'' +
                ", scribd='" + scribd + '\'' +
                ", tumblr='" + tumblr + '\'' +
                ", viadeo='" + viadeo + '\'' +
                ", yahoo='" + yahoo + '\'' +
                ", yoast='" + yoast + '\'' +
                ", yelp='" + yelp + '\'' +
                '}';
    }
}
