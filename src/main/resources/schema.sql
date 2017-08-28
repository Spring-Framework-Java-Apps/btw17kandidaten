-- Table: public.kandidat

DROP TABLE IF EXISTS kandidat2;

CREATE TABLE kandidat2 (
  id bigint NOT NULL,
  alter integer,
  beruf character varying(255) ,
  berufsgruppe character varying(255) ,
  bundesland character varying(255) ,
  color character varying(255) ,
  foto character varying(255) ,
  geburtsjahr integer,
  geburtsort character varying(255) ,
  geschlecht character varying(255) ,
  id_eigen character varying(255) ,
  kandidat_key character varying(255) ,
  lat double precision,
  liste_bundesland_land character varying(255) ,
  liste_partei character varying(255) ,
  liste_partei_lang character varying(255) ,
  liste_platz integer,
  lng double precision,
  mdb character varying(255) ,
  nachname character varying(255) ,
  nachname_ohne character varying(255) ,
  namenszusatz character varying(255) ,
  partei character varying(255) ,
  partei_lang character varying(255) ,
  scatter_x double precision,
  scatter_y double precision,
  titel character varying(255) ,
  vorname character varying(255) ,
  wahlkreis_id integer,
  wahlkreis_name character varying(255) ,
  wohnort character varying(255) ,
  CONSTRAINT kandidat2_pkey PRIMARY KEY (id)
) WITH ( OIDS = FALSE );