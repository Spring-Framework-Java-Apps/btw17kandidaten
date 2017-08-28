-- Database: kandidaten

-- DROP DATABASE kandidaten;

CREATE DATABASE kandidaten
WITH
OWNER = kandidaten
ENCODING = 'UTF8'
LC_COLLATE = 'de_DE.UTF-8'
LC_CTYPE = 'de_DE.UTF-8'
TABLESPACE = pg_default
CONNECTION LIMIT = -1;




CREATE SEQUENCE public.hibernate_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.hibernate_sequence
OWNER TO kandidaten;



-- Table: public.beruf

-- DROP TABLE public.beruf;

CREATE TABLE public.beruf
(
  id bigint NOT NULL,
  beruf character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT beruf_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.beruf
  OWNER to kandidaten;




-- Table: public.berufsgruppe

-- DROP TABLE public.berufsgruppe;

CREATE TABLE public.berufsgruppe
(
  id bigint NOT NULL,
  berufsgruppe character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT berufsgruppe_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.berufsgruppe
  OWNER to kandidaten;


-- Table: public.geburtsort

-- DROP TABLE public.geburtsort;

CREATE TABLE public.geburtsort
(
  id bigint NOT NULL,
  geburtsort character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT geburtsort_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.geburtsort
  OWNER to kandidaten;



-- Table: public.liste_partei

-- DROP TABLE public.liste_partei;

CREATE TABLE public.liste_partei
(
  id bigint NOT NULL,
  liste_partei character varying(255) COLLATE pg_catalog."default",
  liste_partei_lang character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT liste_partei_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.liste_partei
  OWNER to kandidaten;



-- Table: public.partei

-- DROP TABLE public.partei;

CREATE TABLE public.partei
(
  id bigint NOT NULL,
  partei character varying(255) COLLATE pg_catalog."default",
  partei_lang character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT partei_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.partei
  OWNER to kandidaten;



-- Table: public.wahlkreis

-- DROP TABLE public.wahlkreis;

CREATE TABLE public.wahlkreis
(
  id bigint NOT NULL,
  wahlkreis_id integer,
  wahlkreis_name character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT wahlkreis_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.wahlkreis
  OWNER to kandidaten;




-- Table: public.wohnort

-- DROP TABLE public.wohnort;

CREATE TABLE public.wohnort
(
  id bigint NOT NULL,
  wohnort character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT wohnort_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.wohnort
  OWNER to kandidaten;





-- Table: public.kandidat

-- DROP TABLE public.kandidat;

CREATE TABLE public.kandidat
(
  id bigint NOT NULL,
  alter integer,
  color character varying(255) COLLATE pg_catalog."default",
  foto character varying(255) COLLATE pg_catalog."default",
  geburtsjahr integer,
  geschlecht character varying(255) COLLATE pg_catalog."default",
  id_eigen character varying(255) COLLATE pg_catalog."default",
  kandidat_key character varying(255) COLLATE pg_catalog."default",
  lat double precision,
  liste_bundesland_land character varying(255) COLLATE pg_catalog."default",
  liste_platz integer,
  lng double precision,
  mdb character varying(255) COLLATE pg_catalog."default",
  nachname character varying(255) COLLATE pg_catalog."default",
  nachname_ohne character varying(255) COLLATE pg_catalog."default",
  namenszusatz character varying(255) COLLATE pg_catalog."default",
  scatter_x double precision,
  scatter_y double precision,
  titel character varying(255) COLLATE pg_catalog."default",
  vorname character varying(255) COLLATE pg_catalog."default",
  beruf_id bigint,
  berufsgruppe_id bigint,
  bundesland_id bigint,
  geburtsort_id bigint,
  partei_id bigint,
  wahlkreis_id bigint,
  wohnort_id bigint,
  CONSTRAINT kandidat_pkey PRIMARY KEY (id),
  CONSTRAINT fk9ot791q3fm7qlya5cnypwpkns FOREIGN KEY (beruf_id)
  REFERENCES public.beruf (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkaqs09bjyxgdo1vjtcje07hinb FOREIGN KEY (wahlkreis_id)
  REFERENCES public.wahlkreis (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkel6u947pajpehcsxcegk7wguc FOREIGN KEY (bundesland_id)
  REFERENCES public.bundesland (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkfbbmtedn5bgsiw1pyrhalemdc FOREIGN KEY (geburtsort_id)
  REFERENCES public.geburtsort (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkgtx2103211q8ykysqf8l5bsfq FOREIGN KEY (partei_id)
  REFERENCES public.partei (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkrknmc2j06jqf5eyipc2x0xud4 FOREIGN KEY (berufsgruppe_id)
  REFERENCES public.berufsgruppe (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fktoocme5hcafwxbn0ms0y4tnyk FOREIGN KEY (wohnort_id)
  REFERENCES public.wohnort (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.kandidat
  OWNER to kandidaten;







