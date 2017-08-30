-- Table: public.wohnort

-- DROP TABLE public.wohnort;

CREATE TABLE public.wohnort
(
  id bigint NOT NULL,
  wohnort character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT wohnort_pkey PRIMARY KEY (id),
  CONSTRAINT unique_wohnort UNIQUE (wohnort)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.wohnort
  OWNER to kandidaten;