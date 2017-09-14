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
-- Data for Name: bundesland; Type: TABLE DATA; Schema: public; Owner: kandidaten
--

INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (2, 'SN', 'Sachsen', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.sachsen.de/', 'https://de.wikipedia.org/wiki/Sachsen', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (3, 'NW', 'Nordrhein-Westfalen', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.land.nrw/', 'https://de.wikipedia.org/wiki/Nordrhein-Westfalen', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (4, 'BY', 'Bayern', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'http://www.bayern.de/', 'https://de.wikipedia.org/wiki/Bayern', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (5, 'ST', 'Sachsen-Anhalt', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.sachsen-anhalt.de/', 'https://de.wikipedia.org/wiki/Sachsen-Anhalt', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (7, 'BE', 'Berlin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.berlin.de/', 'https://de.wikipedia.org/wiki/Berlin', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (8, 'NI', 'Niedersachsen', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.niedersachsen.de', 'https://de.wikipedia.org/wiki/Niedersachsen', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (9, 'SH', 'Schleswig-Holstein', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'http://www.schleswig-holstein.de/', 'https://de.wikipedia.org/wiki/Schleswig-Holstein', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (10, 'HE', 'Hessen', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.hessen.de/', 'https://de.wikipedia.org/wiki/Hessen', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (11, 'SL', 'Saarland', NULL, 'https://pbs.twimg.com/profile_images/436922082270539776/NyvdGBN5_400x400.png', NULL, NULL, NULL, 'https://www.facebook.com/saarland.de', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://twitter.com/saarland_de', NULL, 'https://www.saarland.de/', 'https://de.wikipedia.org/wiki/Saarland', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (12, 'BW', 'Baden-Württemberg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.baden-wuerttemberg.de', 'https://de.wikipedia.org/wiki/Baden-W%C3%BCrttemberg', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (13, 'MV', 'Mecklenburg-Vorpommern', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'http://www.mecklenburg-vorpommern.de/', 'https://de.wikipedia.org/wiki/Mecklenburg-Vorpommern', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (14, 'RP', 'Rheinland-Pfalz', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.rlp.de', 'https://de.wikipedia.org/wiki/Rheinland-Pfalz', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (15, 'HH', 'Hansestadt Hamburg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'http://www.hamburg.de/', 'https://de.wikipedia.org/wiki/Hamburg', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (16, 'TH', 'Thüringen', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thueringen.de/', 'https://de.wikipedia.org/wiki/Th%C3%BCringen', NULL, NULL);
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (6, 'HB', 'Hansestadt Bremen', NULL, 'https://pbs.twimg.com/profile_images/775320613741297665/NhXHJvCW_400x400.jpg', NULL, NULL, NULL, 'https://www.facebook.com/Bremen', NULL, NULL, NULL, 'https://www.instagram.com/bremermoment/', NULL, NULL, NULL, NULL, 'https://twitter.com/bremen#_de', NULL, 'http://www.bremen.de/', 'https://de.wikipedia.org/wiki/Freie_Hansestadt_Bremen', NULL, 'https://www.youtube.com/user/BREMENbewegt');
INSERT INTO bundesland (id, bundesland, bundesland_lang, beschreibungs_text, logo_url, symbol_bild, abgeordnetenwatch, bundestag, facebook, flickr, github, google_plus, instagram, linked_in, lobbypedia_url, soundcloud, stackoverflow, twitter, vimeo, webseite, wikipedia_article, xing, youtube) VALUES (1, 'BB', 'Brandenburg', NULL, 'https://scontent-frx5-1.xx.fbcdn.net/v/t1.0-1/p200x200/18447103_693239414216899_103344698958493761_n.jpg?oh=c8b86463c3d982031c15ef0844a5fbef&oe=5A4534D9', NULL, NULL, NULL, 'https://www.facebook.com/UnserBrandenburg', 'https://www.flickr.com/photos/103986544@N07/albums/', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'http://www.brandenburg.de/', 'https://de.wikipedia.org/wiki/Brandenburg', NULL, 'https://www.youtube.com/user/brandenburgde');


--
-- PostgreSQL database dump complete
--

