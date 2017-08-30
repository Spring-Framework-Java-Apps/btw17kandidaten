-- Table: public.landesliste

-- DROP TABLE public.landesliste;

CREATE TABLE public.landesliste
(
  id bigint NOT NULL,
  fk_bundesland bigint NOT NULL,
  fk_liste_partei bigint NOT NULL,
  CONSTRAINT landesliste_pkey PRIMARY KEY (id),
  CONSTRAINT unique_liste_partei UNIQUE (fk_bundesland, fk_liste_partei),
  CONSTRAINT fkg37vb8bas395k4qn5sjex8ahy FOREIGN KEY (fk_bundesland)
  REFERENCES public.bundesland (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT fkjt1jyj6n7ojxqev01moiyl3v2 FOREIGN KEY (fk_liste_partei)
  REFERENCES public.liste_partei (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.landesliste
  OWNER to kandidaten;