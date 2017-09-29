--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.5
-- Dumped by pg_dump version 9.6.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- Data for Name: fraktion; Type: TABLE DATA; Schema: public; Owner: kandidaten
--

INSERT INTO fraktion (id, beschreibungs_text, logo_url, symbol_bild, fraktion, fraktion_lang, abgeordnetenwatch, amazon, bing_suche, bundestag, delicious, digg, facebook, flickr, foursquare, github, google_plus, google_suche, hacker_news, imdb, instagram, lastfm, linked_in, lobbycontrol, lobbypedia_url, meetup, netzpolitik_org, paypal, pinterest, scribd, skype, slack, slideshare, snapchat, soundcloud, spotify, stackoverflow, transparency, tumblr, twitter, url500px, viadeo, vimeo, whatsapp, wikipedia_article, wordpress, xing, yahoo, yelp, yoast, youtube, webseite, fk_webseite_cms) VALUES (1, NULL, 'https://www.cducsu.de/themes/cducsu/static/res/img/logo.jpg', 'http://www.bundestag.de/blob/12558/877a2d10c8e3205c9b41be408f070318/fraktion_cdu_banner-data.jpg', 'CDU/CSU-Fraktion im Deutschen Bundestag', 'CDU/CSU-Fraktion im Deutschen Bundestag', NULL, NULL, NULL, 'https://www.bundestag.de/parlament/fraktionen/cducsu/cducsu/245192', NULL, NULL, 'https://www.facebook.com/cducsubundestagsfraktion', NULL, NULL, NULL, 'https://plus.google.com/+CDU-CSU-Fraktion', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://twitter.com/cducsubt', NULL, NULL, NULL, NULL, 'https://de.wikipedia.org/wiki/CDU/CSU-Bundestagsfraktion', NULL, NULL, NULL, NULL, NULL, 'https://www.youtube.com/user/cducsu', 'https://www.cducsu.de/', NULL);
INSERT INTO fraktion (id, beschreibungs_text, logo_url, symbol_bild, fraktion, fraktion_lang, abgeordnetenwatch, amazon, bing_suche, bundestag, delicious, digg, facebook, flickr, foursquare, github, google_plus, google_suche, hacker_news, imdb, instagram, lastfm, linked_in, lobbycontrol, lobbypedia_url, meetup, netzpolitik_org, paypal, pinterest, scribd, skype, slack, slideshare, snapchat, soundcloud, spotify, stackoverflow, transparency, tumblr, twitter, url500px, viadeo, vimeo, whatsapp, wikipedia_article, wordpress, xing, yahoo, yelp, yoast, youtube, webseite, fk_webseite_cms) VALUES (2, NULL, 'https://btw17-kandidaten.herokuapp.com/img/fraktion/fraktion-spd.png', 'http://www.bundestag.de/blob/12540/ad764b92b47e22c1cc98a79907807f66/fraktion_spd_banner-data.png', 'SPD-Fraktion', 'SPD-Bundestagsfraktion', NULL, NULL, NULL, 'https://www.bundestag.de/parlament/fraktionen/spd/spd/245190', NULL, NULL, 'https://www.facebook.com/spdbundestagsfraktion', NULL, NULL, NULL, 'https://plus.google.com/+SPD-Bundestagsfraktion', NULL, NULL, NULL, 'https://www.flickr.com/photos/spdbundestagsfraktion', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://soundcloud.com/spdfraktion', NULL, NULL, NULL, NULL, 'https://twitter.com/spdbt', NULL, NULL, NULL, NULL, 'https://de.wikipedia.org/wiki/SPD-Bundestagsfraktion', NULL, NULL, NULL, NULL, NULL, 'https://www.youtube.com/user/spdfraktion', 'http://www.spdfraktion.de/', NULL);
INSERT INTO fraktion (id, beschreibungs_text, logo_url, symbol_bild, fraktion, fraktion_lang, abgeordnetenwatch, amazon, bing_suche, bundestag, delicious, digg, facebook, flickr, foursquare, github, google_plus, google_suche, hacker_news, imdb, instagram, lastfm, linked_in, lobbycontrol, lobbypedia_url, meetup, netzpolitik_org, paypal, pinterest, scribd, skype, slack, slideshare, snapchat, soundcloud, spotify, stackoverflow, transparency, tumblr, twitter, url500px, viadeo, vimeo, whatsapp, wikipedia_article, wordpress, xing, yahoo, yelp, yoast, youtube, webseite, fk_webseite_cms) VALUES (3, NULL, 'https://btw17-kandidaten.herokuapp.com/img/fraktion/fraktion-die-gruenen.png', 'http://www.bundestag.de/blob/12560/e2d6a9a15366afffe06bb2d52fc9ae67/fraktion_diegruene_banner-data.jpg', 'Fraktion Bündnis 90/ Die Grünen', 'Bundestagsfraktion Bündnis 90/Die Grünen', NULL, NULL, NULL, 'https://www.bundestag.de/parlament/fraktionen/gruene/gruene/245196', NULL, NULL, 'https://www.facebook.com/Gruene.im.Bundestag', 'https://www.flickr.com/photos/gruene-bundestag/', NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.instagram.com/gruenebundestag/', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://twitter.com/gruenebundestag', NULL, NULL, NULL, NULL, 'https://de.wikipedia.org/wiki/Bundestagsfraktion_B%C3%BCndnis_90/Die_Gr%C3%BCnen', NULL, NULL, NULL, NULL, NULL, 'https://www.youtube.com/user/GRUENE', 'https://www.gruene-bundestag.de/', NULL);
INSERT INTO fraktion (id, beschreibungs_text, logo_url, symbol_bild, fraktion, fraktion_lang, abgeordnetenwatch, amazon, bing_suche, bundestag, delicious, digg, facebook, flickr, foursquare, github, google_plus, google_suche, hacker_news, imdb, instagram, lastfm, linked_in, lobbycontrol, lobbypedia_url, meetup, netzpolitik_org, paypal, pinterest, scribd, skype, slack, slideshare, snapchat, soundcloud, spotify, stackoverflow, transparency, tumblr, twitter, url500px, viadeo, vimeo, whatsapp, wikipedia_article, wordpress, xing, yahoo, yelp, yoast, youtube, webseite, fk_webseite_cms) VALUES (4, NULL, 'https://www.linksfraktion.de/typo3conf/ext/bootstrap_package_linksfraktionbt/Resources/Public/Images/linksfraktion-logo.png', 'https://www.bundestag.de/blob/12550/daed5c21483e8d02bf12297383ebffe9/fraktion_dielinke_banner-data.jpg', 'Fraktion Die Linke', 'Fraktion Die Linke im Bundestag', NULL, NULL, NULL, 'https://www.bundestag.de/parlament/fraktionen/linke/linke/245198', NULL, NULL, 'https://www.facebook.com/linksfraktion', NULL, NULL, NULL, 'https://plus.google.com/115837798532207149258', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://twitter.com/linksfraktion', NULL, NULL, NULL, NULL, 'https://de.wikipedia.org/wiki/Linksfraktion', NULL, NULL, NULL, NULL, NULL, 'https://www.youtube.com/user/linksfraktion', 'https://www.linksfraktion.de/', NULL);


--
-- PostgreSQL database dump complete
--

