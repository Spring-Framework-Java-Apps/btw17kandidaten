-- Table: public.kandidat

-- DROP TABLE public.kandidat;

CREATE TABLE public.kandidat
(
  id bigint NOT NULL,
  alter integer,
  color character varying(255) COLLATE pg_catalog."default",
  facebook character varying(255) COLLATE pg_catalog."default",
  foto character varying(255) COLLATE pg_catalog."default",
  foto_url character varying(255) COLLATE pg_catalog."default",
  geburtsjahr integer,
  geschlecht character varying(255) COLLATE pg_catalog."default",
  id_eigen character varying(255) COLLATE pg_catalog."default",
  kandidat_key character varying(255) COLLATE pg_catalog."default" NOT NULL,
  lat double precision,
  liste_platz integer,
  lng double precision,
  logo_url character varying(255) COLLATE pg_catalog."default",
  mdb character varying(255) COLLATE pg_catalog."default",
  nachname character varying(255) COLLATE pg_catalog."default",
  nachname_ohne character varying(255) COLLATE pg_catalog."default",
  namenszusatz character varying(255) COLLATE pg_catalog."default",
  remote_kandidat_key character varying(255) COLLATE pg_catalog."default",
  scatter_x double precision,
  scatter_y double precision,
  titel character varying(255) COLLATE pg_catalog."default",
  twitter character varying(255) COLLATE pg_catalog."default",
  vorname character varying(255) COLLATE pg_catalog."default",
  webseite character varying(255) COLLATE pg_catalog."default",
  youtube character varying(255) COLLATE pg_catalog."default",
  fk_beruf bigint,
  fk_berufsgruppe bigint,
  fk_bundesland bigint,
  fk_geburtsort bigint,
  fk_kandidat_flat bigint NOT NULL,
  fk_landes_liste bigint,
  fk_partei bigint,
  fk_wahlkreis bigint,
  fk_wohnort bigint,
  CONSTRAINT kandidat_pkey PRIMARY KEY (id),
  CONSTRAINT uk_8n2miyhh4yn1010p23vn02as6 UNIQUE (kandidat_key),
  CONSTRAINT fk2robn3kdpjikwadql8sbonjn1 FOREIGN KEY (fk_bundesland)
  REFERENCES public.bundesland (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fk3vxwn5f5f0cxo7j05448hdc09 FOREIGN KEY (fk_partei)
  REFERENCES public.partei (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkalhg37s306bhknqtn4mecqyk5 FOREIGN KEY (fk_kandidat_flat)
  REFERENCES public.kandidat_flat (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkbgsboyo5ym6xum2l0a2ig6r39 FOREIGN KEY (fk_berufsgruppe)
  REFERENCES public.berufsgruppe (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkbnt70c8eex5s9xv6emkyvttqn FOREIGN KEY (fk_beruf)
  REFERENCES public.beruf (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkc27dbjrer0umexs2xg8cokver FOREIGN KEY (fk_geburtsort)
  REFERENCES public.geburtsort (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkcf2jt18tfd0l0eq7gf7hwrur6 FOREIGN KEY (fk_wohnort)
  REFERENCES public.wohnort (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkfx2mocfytkdg06huqx2x3so8o FOREIGN KEY (fk_landes_liste)
  REFERENCES public.landesliste (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkrc112d5vlrjyjjdpmkd8ix1t4 FOREIGN KEY (fk_wahlkreis)
  REFERENCES public.wahlkreis (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.kandidat
  OWNER to kandidaten;

-- Index: idx_kandidat_alter

-- DROP INDEX public.idx_kandidat_alter;

CREATE INDEX idx_kandidat_alter
  ON public.kandidat USING btree
  (alter)
TABLESPACE pg_default;

-- Index: idx_kandidat_foto

-- DROP INDEX public.idx_kandidat_foto;

CREATE INDEX idx_kandidat_foto
  ON public.kandidat USING btree
  (foto COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_geburtsjahr

-- DROP INDEX public.idx_kandidat_geburtsjahr;

CREATE INDEX idx_kandidat_geburtsjahr
  ON public.kandidat USING btree
  (geburtsjahr)
TABLESPACE pg_default;

-- Index: idx_kandidat_geschlecht

-- DROP INDEX public.idx_kandidat_geschlecht;

CREATE INDEX idx_kandidat_geschlecht
  ON public.kandidat USING btree
  (geschlecht COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_id_eigen

-- DROP INDEX public.idx_kandidat_id_eigen;

CREATE INDEX idx_kandidat_id_eigen
  ON public.kandidat USING btree
  (id_eigen COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_liste_platz

-- DROP INDEX public.idx_kandidat_liste_platz;

CREATE INDEX idx_kandidat_liste_platz
  ON public.kandidat USING btree
  (liste_platz)
TABLESPACE pg_default;

-- Index: idx_kandidat_mdb

-- DROP INDEX public.idx_kandidat_mdb;

CREATE INDEX idx_kandidat_mdb
  ON public.kandidat USING btree
  (mdb COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_nachname

-- DROP INDEX public.idx_kandidat_nachname;

CREATE INDEX idx_kandidat_nachname
  ON public.kandidat USING btree
  (nachname COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_nachname_ohne

-- DROP INDEX public.idx_kandidat_nachname_ohne;

CREATE INDEX idx_kandidat_nachname_ohne
  ON public.kandidat USING btree
  (nachname_ohne COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_namenszusatz

-- DROP INDEX public.idx_kandidat_namenszusatz;

CREATE INDEX idx_kandidat_namenszusatz
  ON public.kandidat USING btree
  (namenszusatz COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_remote_kandidat_key

-- DROP INDEX public.idx_kandidat_remote_kandidat_key;

CREATE INDEX idx_kandidat_remote_kandidat_key
  ON public.kandidat USING btree
  (remote_kandidat_key COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_kandidat_titel

-- DROP INDEX public.idx_kandidat_titel;

CREATE INDEX idx_kandidat_titel
  ON public.kandidat USING btree
  (titel COLLATE pg_catalog."default")
TABLESPACE pg_default;