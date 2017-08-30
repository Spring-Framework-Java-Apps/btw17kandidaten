-- Table: public.berufsgruppe

-- DROP TABLE public.berufsgruppe;

CREATE TABLE public.berufsgruppe
(
  id bigint NOT NULL,
  berufsgruppe character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT berufsgruppe_pkey PRIMARY KEY (id),
  CONSTRAINT unique_berufsgruppe UNIQUE (berufsgruppe)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.berufsgruppe
  OWNER to kandidaten;