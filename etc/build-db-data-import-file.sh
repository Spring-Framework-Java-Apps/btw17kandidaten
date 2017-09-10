#!/bin/sh

rm ../src/main/resources/data.sql

echo '--' > ../src/main/resources/data.sql
echo '-- Empty Tables' >> ../src/main/resources/data.sql
echo '-- etc/empty-tables.sql' >> ../src/main/resources/data.sql
echo '-- This data.sql File is build by etc/build-db-data-import-file.sh' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat empty-tables.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Beruf' >> ../src/main/resources/data.sql
echo '-- Table: beruf' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-beruf.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe' >> ../src/main/resources/data.sql
echo '-- Table: berufsgruppe' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-berufsgruppe.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Bundesland' >> ../src/main/resources/data.sql
echo '-- Table: bundesland' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-bundesland.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Geburtsort' >> ../src/main/resources/data.sql
echo '-- Table: geburtsort' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-geburtsort.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.ListePartei' >> ../src/main/resources/data.sql
echo '-- Table: liste_partei' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-liste_partei.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Partei' >> ../src/main/resources/data.sql
echo '-- Table: partei' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-partei.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis' >> ../src/main/resources/data.sql
echo '-- Table: wahlkreis' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-wahlkreis.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Wohnort' >> ../src/main/resources/data.sql
echo '-- Table: wohnort' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-wohnort.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.LandesListe' >> ../src/main/resources/data.sql
echo '-- Table: landesliste' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-landesliste.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.KandidatFlat' >> ../src/main/resources/data.sql
echo '-- Table: kandidat_flat' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-kandidat_flat.sql >> ../src/main/resources/data.sql

echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Kandidat' >> ../src/main/resources/data.sql
echo '-- Table: kandidat' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-kandidat.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep -v "SET " >> ../src/main/resources/data.sql



exit 0