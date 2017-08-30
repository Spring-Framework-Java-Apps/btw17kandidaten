-- Table: public.beruf

DROP TABLE IF EXISTS beruf;

CREATE TABLE beruf
(
  id bigint NOT NULL,
  beruf character varying(255) COLLATE pg_catalog."default",
  CONSTRAINT beruf_pkey PRIMARY KEY (id),
  CONSTRAINT unique_beruf UNIQUE (beruf)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;