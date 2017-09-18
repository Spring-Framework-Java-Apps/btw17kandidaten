#!/bin/sh

rm ../src/main/resources/data.sql

echo ' '
echo '-- Empty Tables'
echo '-- etc/empty-tables.sql'
echo '--' > ../src/main/resources/data.sql
echo '-- This data.sql File is build by etc/build-db-data-import-file.sh' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql
echo '-- Empty Tables' >> ../src/main/resources/data.sql
echo '-- etc/empty-tables.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat empty-tables.sql >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Beruf'
echo '-- Table: beruf'
echo '-- etc/3nf/data/insert-data-beruf.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Beruf' >> ../src/main/resources/data.sql
echo '-- Table: beruf' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-beruf.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-beruf.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO beruf " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe'
echo '-- Table: berufsgruppe'
echo '-- etc/3nf/data/insert-data-berufsgruppe.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe' >> ../src/main/resources/data.sql
echo '-- Table: berufsgruppe' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-berufsgruppe.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-berufsgruppe.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO berufsgruppe " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Bundesland'
echo '-- Table: bundesland'
echo '-- etc/3nf/data/insert-data-bundesland.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Bundesland' >> ../src/main/resources/data.sql
echo '-- Table: bundesland' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-bundesland.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-bundesland.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO bundesland " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Geburtsort'
echo '-- Table: geburtsort'
echo '-- etc/3nf/data/insert-data-geburtsort.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Geburtsort' >> ../src/main/resources/data.sql
echo '-- Table: geburtsort' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-geburtsort.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-geburtsort.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO geburtsort " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.ListePartei'
echo '-- Table: liste_partei'
echo '-- etc/3nf/data/insert-data-listepartei.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.ListePartei' >> ../src/main/resources/data.sql
echo '-- Table: liste_partei' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-listepartei.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-listepartei.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO listepartei " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Partei'
echo '-- Table: partei'
echo '-- etc/3nf/data/insert-data-partei.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Partei' >> ../src/main/resources/data.sql
echo '-- Table: partei' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-partei.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-partei.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO partei " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis'
echo '-- Table: wahlkreis'
echo '-- etc/3nf/data/insert-data-wahlkreis.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis' >> ../src/main/resources/data.sql
echo '-- Table: wahlkreis' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-wahlkreis.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-wahlkreis.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO wahlkreis " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Wohnort'
echo '-- Table: wohnort'
echo '-- etc/3nf/data/insert-data-wohnort.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Wohnort' >> ../src/main/resources/data.sql
echo '-- Table: wohnort' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-wohnort.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-wohnort.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO wohnort" >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.LandesListe'
echo '-- Table: landesliste'
echo '-- etc/3nf/data/insert-data-landesliste.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.LandesListe' >> ../src/main/resources/data.sql
echo '-- Table: landesliste' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-landesliste.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-landesliste.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO landesliste "  >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Fraktion'
echo '-- Table: fraktion'
echo '-- etc/3nf/data/insert-data-fraktion.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Fraktion' >> ../src/main/resources/data.sql
echo '-- Table: fraktion' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-fraktion.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-fraktion.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO fraktion "  >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Ausschuss'
echo '-- Table: ausschuss'
echo '-- etc/3nf/data/insert-data-ausschuss.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Ausschuss' >> ../src/main/resources/data.sql
echo '-- Table: ausschuss' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-ausschuss.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-ausschuss.sql  | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO ausschuss " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.KandidatFlat'
echo '-- Table: kandidat_flat'
echo '-- etc/3nf/data/insert-data-kandidat_flat.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.KandidatFlat' >> ../src/main/resources/data.sql
echo '-- Table: kandidat_flat' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-kandidat_flat.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-kandidat_flat.sql >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Kandidat'
echo '-- Table: kandidat'
echo '-- etc/3nf/data/insert-data-kandidat.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Kandidat' >> ../src/main/resources/data.sql
echo '-- Table: kandidat' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-kandidat.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-kandidat.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO kandidat " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Ministerium'
echo '-- Table: ministerium'
echo '-- etc/3nf/data/insert-data-ministerium.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Ministerium' >> ../src/main/resources/data.sql
echo '-- Table: ministerium' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-ministerium.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-ministerium.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO ministerium " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Kandidat.ministerium'
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Ministerium'
echo '-- Table: kandidat_ministerium'
echo '-- etc/3nf/data/insert-data-kandidat_ministerium.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Kandidat.ministerium' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Ministerium' >> ../src/main/resources/data.sql
echo '-- Table: kandidat_ministerium' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-kandidat_ministerium.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-kandidat_ministerium.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO kandidat_ministerium " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Kandidat.ausschuss'
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Ausschuss'
echo '-- Table: kandidat_ausschuss'
echo '-- etc/3nf/data/insert-data-kandidat_ausschuss.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Kandidat.ausschuss' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.model.Ausschuss' >> ../src/main/resources/data.sql
echo '-- Table: kandidat_ausschuss' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-kandidat_ausschuss.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-kandidat_ausschuss.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO kandidat_ausschuss "  >> ../src/main/resources/data.sql

echo ' '

exit 0