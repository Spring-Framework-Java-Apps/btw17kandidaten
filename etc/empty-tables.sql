TRUNCATE kandidat_ministerium, kandidat_ausschuss, ministerium, kandidat, kandidat_flat,landesliste,beruf,berufsgruppe,bundesland,geburtsort,liste_partei,partei,wahlkreis,wohnort,fraktion,ausschuss,ministerium RESTART IDENTITY CASCADE;
ALTER SEQUENCE IF EXISTS hibernate_sequence RESTART;
