CREATE SEQUENCE public.hibernate_sequence
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

ALTER SEQUENCE public.hibernate_sequence
OWNER TO kandidaten;





-- Table: public.kandidat

-- DROP TABLE public.kandidat;

CREATE TABLE public.kandidat
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
  CONSTRAINT kandidat_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.kandidat
  OWNER to kandidat;