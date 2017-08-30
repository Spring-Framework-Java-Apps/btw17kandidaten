-- Table: public.bundesland

-- DROP TABLE public.bundesland;

CREATE TABLE public.bundesland
(
  id bigint NOT NULL,
  bundesland character varying(255) COLLATE pg_catalog."default",
  bundesland_lang character varying(255) COLLATE pg_catalog."default" NOT NULL,
  facebook character varying(255) COLLATE pg_catalog."default",
  logo_url character varying(255) COLLATE pg_catalog."default",
  twitter character varying(255) COLLATE pg_catalog."default",
  webseite character varying(255) COLLATE pg_catalog."default",
  youtube character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT bundesland_pkey PRIMARY KEY (id),
  CONSTRAINT unique_bundesland UNIQUE (bundesland)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.bundesland
  OWNER to kandidaten;

-- Index: idx_bundesland_bundesland_lang

-- DROP INDEX public.idx_bundesland_bundesland_lang;

CREATE INDEX idx_bundesland_bundesland_lang
  ON public.bundesland USING btree
  (bundesland_lang COLLATE pg_catalog."default")
TABLESPACE pg_default;