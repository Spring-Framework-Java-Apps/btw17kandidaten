package org.woehlke.btw17.kandidaten.oodm.graph.model.parts;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.Column;

//TODO: Pro Online Profil ein Node
@Setter
@Getter
@NodeEntity
public class OnlineStrategie implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return " name ";
    }

    @Override
    public String getUniqueId() {
        return ""+id;
    }

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
}
