-- Table: public.partei

-- DROP TABLE public.partei;

CREATE TABLE public.partei
(
  id bigint NOT NULL,
  facebook character varying(255) COLLATE pg_catalog."default",
  logo_url character varying(255) COLLATE pg_catalog."default",
  partei character varying(255) COLLATE pg_catalog."default",
  partei_lang character varying(255) COLLATE pg_catalog."default",
  twitter character varying(255) COLLATE pg_catalog."default",
  webseite character varying(255) COLLATE pg_catalog."default",
  youtube character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT partei_pkey PRIMARY KEY (id),
  CONSTRAINT unique_partei UNIQUE (partei)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.partei
  OWNER to kandidaten;

-- Index: idx_partei_facebook

-- DROP INDEX public.idx_partei_facebook;

CREATE INDEX idx_partei_facebook
  ON public.partei USING btree
  (facebook COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_partei_logo_url

-- DROP INDEX public.idx_partei_logo_url;

CREATE INDEX idx_partei_logo_url
  ON public.partei USING btree
  (logo_url COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_partei_partei_lang

-- DROP INDEX public.idx_partei_partei_lang;

CREATE INDEX idx_partei_partei_lang
  ON public.partei USING btree
  (partei_lang COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_partei_twitter

-- DROP INDEX public.idx_partei_twitter;

CREATE INDEX idx_partei_twitter
  ON public.partei USING btree
  (twitter COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_partei_webseite

-- DROP INDEX public.idx_partei_webseite;

CREATE INDEX idx_partei_webseite
  ON public.partei USING btree
  (webseite COLLATE pg_catalog."default")
TABLESPACE pg_default;

-- Index: idx_partei_youtube

-- DROP INDEX public.idx_partei_youtube;

CREATE INDEX idx_partei_youtube
  ON public.partei USING btree
  (youtube COLLATE pg_catalog."default")
TABLESPACE pg_default;