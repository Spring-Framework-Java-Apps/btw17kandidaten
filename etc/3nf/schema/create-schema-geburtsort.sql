-- Table: public.geburtsort

-- DROP TABLE public.geburtsort;

CREATE TABLE public.geburtsort
(
  id bigint NOT NULL,
  geburtsort character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT geburtsort_pkey PRIMARY KEY (id),
  CONSTRAINT unique_geburtsort UNIQUE (geburtsort)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.geburtsort
  OWNER to kandidaten;