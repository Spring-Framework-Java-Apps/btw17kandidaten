-- Table: public.kandidat_flat

-- DROP TABLE public.kandidat_flat;

CREATE TABLE public.kandidat_flat
(
  id bigint NOT NULL,
  alter integer,
  beruf character varying(255) COLLATE pg_catalog."default",
  berufsgruppe character varying(255) COLLATE pg_catalog."default",
  bundesland character varying(255) COLLATE pg_catalog."default",
  color character varying(255) COLLATE pg_catalog."default",
  foto character varying(255) COLLATE pg_catalog."default",
  geburtsjahr integer,
  geburtsort character varying(255) COLLATE pg_catalog."default",
  geschlecht character varying(255) COLLATE pg_catalog."default",
  id_eigen character varying(255) COLLATE pg_catalog."default",
  kandidat_key character varying(255) COLLATE pg_catalog."default",
  lat double precision,
  liste_bundesland_land character varying(255) COLLATE pg_catalog."default",
  liste_partei character varying(255) COLLATE pg_catalog."default",
  liste_partei_lang character varying(255) COLLATE pg_catalog."default",
  liste_platz integer,
  lng double precision,
  mdb character varying(255) COLLATE pg_catalog."default",
  nachname character varying(255) COLLATE pg_catalog."default",
  nachname_ohne character varying(255) COLLATE pg_catalog."default",
  namenszusatz character varying(255) COLLATE pg_catalog."default",
  partei character varying(255) COLLATE pg_catalog."default",
  partei_lang character varying(255) COLLATE pg_catalog."default",
  scatter_x double precision,
  scatter_y double precision,
  titel character varying(255) COLLATE pg_catalog."default",
  vorname character varying(255) COLLATE pg_catalog."default",
  wahlkreis_id integer,
  wahlkreis_name character varying(255) COLLATE pg_catalog."default",
  wohnort character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT kandidat_flat_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.kandidat_flat
  OWNER to kandidaten;

-- Index: idx_kandidat_flat_alter

-- DROP INDEX public.idx_kandidat_flat_alter;

CREATE INDEX idx_kandidat_flat_alter
  ON public.kandidat_flat USING btree
  (alter)
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_beruf

-- DROP INDEX public.idx_kandidat_flat_beruf;

CREATE INDEX idx_kandidat_flat_beruf
  ON public.kandidat_flat USING btree
  (beruf COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_berufsgruppe

-- DROP INDEX public.idx_kandidat_flat_berufsgruppe;

CREATE INDEX idx_kandidat_flat_berufsgruppe
  ON public.kandidat_flat USING btree
  (berufsgruppe COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_bundesland

-- DROP INDEX public.idx_kandidat_flat_bundesland;

CREATE INDEX idx_kandidat_flat_bundesland
  ON public.kandidat_flat USING btree
  (bundesland COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_foto

-- DROP INDEX public.idx_kandidat_flat_foto;

CREATE INDEX idx_kandidat_flat_foto
  ON public.kandidat_flat USING btree
  (foto COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_geburtsjahr

-- DROP INDEX public.idx_kandidat_flat_geburtsjahr;

CREATE INDEX idx_kandidat_flat_geburtsjahr
  ON public.kandidat_flat USING btree
  (geburtsjahr)
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_geburtsort

-- DROP INDEX public.idx_kandidat_flat_geburtsort;

CREATE INDEX idx_kandidat_flat_geburtsort
  ON public.kandidat_flat USING btree
  (geburtsort COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_geschlecht

-- DROP INDEX public.idx_kandidat_flat_geschlecht;

CREATE INDEX idx_kandidat_flat_geschlecht
  ON public.kandidat_flat USING btree
  (geschlecht COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_id_eigen

-- DROP INDEX public.idx_kandidat_flat_id_eigen;

CREATE INDEX idx_kandidat_flat_id_eigen
  ON public.kandidat_flat USING btree
  (id_eigen COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_kandidat_key

-- DROP INDEX public.idx_kandidat_flat_kandidat_key;

CREATE INDEX idx_kandidat_flat_kandidat_key
  ON public.kandidat_flat USING btree
  (kandidat_key COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_liste_bundesland_land

-- DROP INDEX public.idx_kandidat_flat_liste_bundesland_land;

CREATE INDEX idx_kandidat_flat_liste_bundesland_land
  ON public.kandidat_flat USING btree
  (liste_bundesland_land COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_liste_partei

-- DROP INDEX public.idx_kandidat_flat_liste_partei;

CREATE INDEX idx_kandidat_flat_liste_partei
  ON public.kandidat_flat USING btree
  (liste_partei COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_liste_partei_lang

-- DROP INDEX public.idx_kandidat_flat_liste_partei_lang;

CREATE INDEX idx_kandidat_flat_liste_partei_lang
  ON public.kandidat_flat USING btree
  (liste_partei_lang COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_liste_platz

-- DROP INDEX public.idx_kandidat_flat_liste_platz;

CREATE INDEX idx_kandidat_flat_liste_platz
  ON public.kandidat_flat USING btree
  (liste_platz)
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_mdb

-- DROP INDEX public.idx_kandidat_flat_mdb;

CREATE INDEX idx_kandidat_flat_mdb
  ON public.kandidat_flat USING btree
  (mdb COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_nachname

-- DROP INDEX public.idx_kandidat_flat_nachname;

CREATE INDEX idx_kandidat_flat_nachname
  ON public.kandidat_flat USING btree
  (nachname COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_nachname_ohne

-- DROP INDEX public.idx_kandidat_flat_nachname_ohne;

CREATE INDEX idx_kandidat_flat_nachname_ohne
  ON public.kandidat_flat USING btree
  (nachname_ohne COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_namenszusatz

-- DROP INDEX public.idx_kandidat_flat_namenszusatz;

CREATE INDEX idx_kandidat_flat_namenszusatz
  ON public.kandidat_flat USING btree
  (namenszusatz COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_partei

-- DROP INDEX public.idx_kandidat_flat_partei;

CREATE INDEX idx_kandidat_flat_partei
  ON public.kandidat_flat USING btree
  (partei COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_partei_lang

-- DROP INDEX public.idx_kandidat_flat_partei_lang;

CREATE INDEX idx_kandidat_flat_partei_lang
  ON public.kandidat_flat USING btree
  (partei_lang COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_titel

-- DROP INDEX public.idx_kandidat_flat_titel;

CREATE INDEX idx_kandidat_flat_titel
  ON public.kandidat_flat USING btree
  (titel COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_wahlkreis_id

-- DROP INDEX public.idx_kandidat_flat_wahlkreis_id;

CREATE INDEX idx_kandidat_flat_wahlkreis_id
  ON public.kandidat_flat USING btree
  (wahlkreis_id)
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_wahlkreis_name

-- DROP INDEX public.idx_kandidat_flat_wahlkreis_name;

CREATE INDEX idx_kandidat_flat_wahlkreis_name
  ON public.kandidat_flat USING btree
  (wahlkreis_name COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_flat_wohnort

-- DROP INDEX public.idx_kandidat_flat_wohnort;

CREATE INDEX idx_kandidat_flat_wohnort
  ON public.kandidat_flat USING btree
  (wohnort COLLATE pg_catalog."default")
TABLESPACE pg_default;