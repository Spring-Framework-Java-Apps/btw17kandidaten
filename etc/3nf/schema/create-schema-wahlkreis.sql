-- Table: public.wahlkreis

-- DROP TABLE public.wahlkreis;

CREATE TABLE public.wahlkreis
(
  id bigint NOT NULL,
  wahlkreis_id integer,
  wahlkreis_name character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT wahlkreis_pkey PRIMARY KEY (id),
  CONSTRAINT unique_wahlkreis UNIQUE (wahlkreis_id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.wahlkreis
  OWNER to kandidaten;

-- Index: idx_wahlkreis_wahlkreis_name

-- DROP INDEX public.idx_wahlkreis_wahlkreis_name;

CREATE INDEX idx_wahlkreis_wahlkreis_name
  ON public.wahlkreis USING btree
  (wahlkreis_name COLLATE pg_catalog."default")
TABLESPACE pg_default;