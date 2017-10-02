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
-- Data for Name: berufsgruppe; Type: TABLE DATA; Schema: public; Owner: kandidaten
--

INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (1, 'Selbsständige', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (2, 'Wirtschaftsprüfer / Steuerberater', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (3, 'Dipl.-Kaufleute', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (4, 'Arbeiter', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (5, 'künstlerische Berufe', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (6, 'Ingenieure', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (7, 'Geographen/Geologen', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (8, 'Handwerker', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (9, 'Theologen', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (10, 'Gesellschaftswissenschaftler', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (11, 'Hochschullehrer und Dozenten', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (12, 'Angestellte', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (13, 'Unternehmensberater', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (14, 'Gesundheits-, Kranken- und Altenpfleger', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (15, 'Beamte', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (16, 'Mathematiker', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (17, 'Facharbeiter (Industrie)', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (18, 'Berater', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (19, 'Verwaltungsfachleute', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (20, 'Schüler, Studenten und Auszubildende', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (21, 'Ärzte, Psychologen, Therapeuten', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (22, 'Journalisten, Publizisten', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (23, 'Bergleute', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (24, 'Unternehmer', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (27, '#NV', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (25, 'Flaschensammler', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (26, 'Wirtschaftswissenschaftler', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (28, 'Feuerwehrleute, Retter', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (29, 'Berufssoldaten', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (30, 'Landwirte und Agraringenieure', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (31, 'Geschäftsführer', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (32, 'Büroangestellte', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (33, 'Berufspolitiker', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (34, 'Lehrer und Erzieher', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (35, 'Gewerkschafter', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (36, 'Kaufleute (Ausbildung)', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (37, 'Projektleiter', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (38, 'Hausfrau/Hausmann', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (39, 'Berufe im Bau', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (40, 'Dipl.-Kaufleute (Ausbildung)', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (41, 'naturwissenschaftliche Berufe', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (42, 'Sozialpädagogen und Sozialarbeiter', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (43, 'Polizisten', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (44, 'Wirtschaftsingenieure', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (45, 'Kultur und Kunst', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (46, 'Bankkaufleute', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (47, 'Juristen', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (48, 'Rentner/Pensionäre', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (49, 'Facharbeiter', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (50, 'Gastronomen', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (51, 'Geisteswissenschaftler', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (52, 'IT-Fachleute', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (53, 'Banker, Finanzprofis', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (54, 'wissenschaftliche Mitarbeiter', 'FINISHED');
INSERT INTO berufsgruppe (id, berufsgruppe, edit_status) VALUES (55, 'Betriebswirt (Ausbildung)', 'FINISHED');


--
-- PostgreSQL database dump complete
--

