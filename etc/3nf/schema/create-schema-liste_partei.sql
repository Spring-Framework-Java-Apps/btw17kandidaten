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

-- Index: idx_liste_partei_liste_partei_lang

-- DROP INDEX public.idx_liste_partei_liste_partei_lang;

CREATE INDEX idx_liste_partei_liste_partei_lang
  ON public.liste_partei USING btree
  (liste_partei_lang COLLATE pg_catalog."default")
TABLESPACE pg_default;