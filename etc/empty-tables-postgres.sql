TRUNCATE kandidat_ministerium, kandidat_ausschuss, ministerium, kandidat, kandidat_flat,landesliste,beruf,berufsgruppe,bundesland,geburtsort,listepartei,partei,wahlkreis,wohnort,fraktion,ausschuss,ministerium,kandidat_agentur,bundesland_agentur,listepartei_agentur,partei_agentur,wohnort_agentur,fraktion_agentur,ministerium_agentur,agentur,cms RESTART IDENTITY CASCADE;
-- TRUNCATE spring_session_attributes,spring_session RESTART IDENTITY CASCADE;
ALTER SEQUENCE IF EXISTS hibernate_sequence RESTART;
