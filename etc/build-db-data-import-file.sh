#!/bin/sh

export EXP_WAHLLEITER_DATA="0"

rm ../src/main/resources/data.sql

echo ' '
echo '-- Empty Tables'
echo '-- etc/empty-tables.sql'
echo '--' > ../src/main/resources/data.sql
echo '-- This data-postgresql.sql File is build by etc/build-db-data-import-file.sh' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql
echo '-- Empty Tables' >> ../src/main/resources/data.sql
echo '-- etc/empty-tables.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat empty-tables-postgres.sql >> ../src/main/resources/data.sql


if [ "$EXP_WAHLLEITER_DATA" == "1" ]
then


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17KandidatFlat'
echo '-- Table: btw17_kandidat_flat'
echo '-- etc/3nf/data/insert-data-btw17_kandidat_flat.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17KandidatFlat' >> ../src/main/resources/data.sql
echo '-- Table: btw17_kandidat_flat' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-btw17_kandidat_flat.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-btw17_kandidat_flat.sql | grep "INSERT INTO btw17_kandidat_flat " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlkreis'
echo '-- Table: btw17_wahlkreis'
echo '-- etc/3nf/data/insert-data-btw17_wahlkreis.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlkreis' >> ../src/main/resources/data.sql
echo '-- Table: btw17_wahlkreis' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-btw17_wahlkreis.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-btw17_wahlkreis.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO btw17_wahlkreis " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Strukturdaten'
echo '-- Table: btw17_strukturdaten'
echo '-- etc/3nf/data/insert-data-btw17_strukturdaten.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Strukturdaten' >> ../src/main/resources/data.sql
echo '-- Table: btw17_strukturdaten' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-btw17_strukturdaten.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-btw17_strukturdaten.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO btw17_strukturdaten " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlbewerber'
echo '-- Table: btw17_wahlbewerber'
echo '-- etc/3nf/data/insert-data-btw17_wahlbewerber.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlbewerber' >> ../src/main/resources/data.sql
echo '-- Table: btw17_wahlbewerber' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-btw17_wahlbewerber.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-btw17_wahlbewerber.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO btw17_wahlbewerber " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Ergebnis'
echo '-- Table: btw17_ergebnis'
echo '-- etc/3nf/data/insert-data-btw17_ergebnis.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Ergebnis' >> ../src/main/resources/data.sql
echo '-- Table: btw17_ergebnis' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-btw17_ergebnis.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-btw17_ergebnis.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO btw17_ergebnis " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Mdb'
echo '-- Table: btw17_mdb_stammdaten'
echo '-- etc/3nf/data/insert-data-btw17_mdb_stammdaten.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Mdb' >> ../src/main/resources/data.sql
echo '-- Table: btw17_mdb_stammdaten' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-btw17_mdb_stammdaten.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-btw17_mdb_stammdaten.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO btw17_mdb_stammdaten " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlperiode'
echo '-- Table: btw17_mdb_wahlperiode'
echo '-- etc/3nf/data/insert-data-btw17_mdb_wahlperiode.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Btw17Wahlperiode' >> ../src/main/resources/data.sql
echo '-- Table: btw17_mdb_wahlperiode' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-btw17_mdb_wahlperiode.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-btw17_mdb_wahlperiode.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO btw17_mdb_wahlperiode " >> ../src/main/resources/data.sql
cat ./3nf/data/insert-data-btw17_mdb_stammdaten_wahlperiode.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO btw17_mdb_stammdaten_wahlperiode " >> ../src/main/resources/data.sql


fi



echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Wahlperiode'
echo '-- Table: wahlperiode'
echo '-- etc/3nf/data/insert-data-wahlperiode.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Wahlperiode' >> ../src/main/resources/data.sql
echo '-- Table: wahlperiode' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-wahlperiode.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-wahlperiode.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | sed "s/INSERT INTO btw17_mdb_wahlperiode /INSERT INTO wahlperiode /g" | grep "INSERT INTO wahlperiode " | sed 's/wp, wahlperioden_mdb_id)/wp)/g' | sed 's/, [0-9]*);/);/g' >> ../src/main/resources/data.sql



echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Cms'
echo '-- Table: cms'
echo '-- etc/3nf/data/insert-data-cms.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Cms' >> ../src/main/resources/data.sql
echo '-- Table: cms' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-cms.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-cms.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO cms " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Agentur'
echo '-- Table: agentur'
echo '-- etc/3nf/data/insert-data-agentur.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Agentur' >> ../src/main/resources/data.sql
echo '-- Table: agentur' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-agentur.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-agentur.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO agentur " >> ../src/main/resources/data.sql



echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Beruf'
echo '-- Table: beruf'
echo '-- etc/3nf/data/insert-data-beruf.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Beruf' >> ../src/main/resources/data.sql
echo '-- Table: beruf' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-beruf.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-beruf.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO beruf " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Berufsgruppe'
echo '-- Table: berufsgruppe'
echo '-- etc/3nf/data/insert-data-berufsgruppe.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Berufsgruppe' >> ../src/main/resources/data.sql
echo '-- Table: berufsgruppe' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-berufsgruppe.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-berufsgruppe.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO berufsgruppe " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Bundesland'
echo '-- Table: bundesland'
echo '-- etc/3nf/data/insert-data-bundesland.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Bundesland' >> ../src/main/resources/data.sql
echo '-- Table: bundesland' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-bundesland.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-bundesland.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO bundesland " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Geburtsort'
echo '-- Table: geburtsort'
echo '-- etc/3nf/data/insert-data-geburtsort.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Geburtsort' >> ../src/main/resources/data.sql
echo '-- Table: geburtsort' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-geburtsort.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-geburtsort.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO geburtsort " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.ListePartei'
echo '-- Table: liste_partei'
echo '-- etc/3nf/data/insert-data-listepartei.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.ListePartei' >> ../src/main/resources/data.sql
echo '-- Table: listepartei' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-listepartei.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-listepartei.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO listepartei " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Partei'
echo '-- Table: partei'
echo '-- etc/3nf/data/insert-data-partei.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Partei' >> ../src/main/resources/data.sql
echo '-- Table: partei' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-partei.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-partei.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO partei " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Wahlkreis'
echo '-- Table: wahlkreis'
echo '-- etc/3nf/data/insert-data-wahlkreis.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Wahlkreis' >> ../src/main/resources/data.sql
echo '-- Table: wahlkreis' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-wahlkreis.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-wahlkreis.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO wahlkreis " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Ort'
echo '-- Table: wohnort'
echo '-- etc/3nf/data/insert-data-wohnort.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Ort' >> ../src/main/resources/data.sql
echo '-- Table: wohnort' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-wohnort.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-wohnort.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO wohnort" >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.ListeParteiBundesland'
echo '-- Table: landesliste'
echo '-- etc/3nf/data/insert-data-landesliste.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.ListeParteiBundesland' >> ../src/main/resources/data.sql
echo '-- Table: landesliste' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-landesliste.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-landesliste.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO landesliste "  >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Fraktion'
echo '-- Table: fraktion'
echo '-- etc/3nf/data/insert-data-fraktion.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Fraktion' >> ../src/main/resources/data.sql
echo '-- Table: fraktion' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-fraktion.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-fraktion.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO fraktion "  >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Ausschuss'
echo '-- Table: ausschuss'
echo '-- etc/3nf/data/insert-data-ausschuss.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Ausschuss' >> ../src/main/resources/data.sql
echo '-- Table: ausschuss' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-ausschuss.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-ausschuss.sql  | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO ausschuss " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat'
echo '-- Table: kandidat'
echo '-- etc/3nf/data/insert-data-kandidat.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat' >> ../src/main/resources/data.sql
echo '-- Table: kandidat' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-kandidat.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-kandidat.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO kandidat " >> ../src/main/resources/data.sql
#cat ./3nf/data/insert-data-kandidat2.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO kandidat " >> ../src/main/resources/data-postgresql.sql
#cat ./3nf/data/insert-data-kandidat3.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO kandidat " >> ../src/main/resources/data-postgresql.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Ministerium'
echo '-- Table: ministerium'
echo '-- etc/3nf/data/insert-data-ministerium.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Ministerium' >> ../src/main/resources/data.sql
echo '-- Table: ministerium' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-ministerium.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-ministerium.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO ministerium " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat.ministerium'
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Ministerium'
echo '-- Table: kandidat_ministerium'
echo '-- etc/3nf/data/insert-data-kandidat_ministerium.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat.ministerium' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Ministerium' >> ../src/main/resources/data.sql
echo '-- Table: kandidat_ministerium' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-kandidat_ministerium.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-kandidat_ministerium.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO kandidat_ministerium " >> ../src/main/resources/data.sql


echo ' '
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat.ausschuss'
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Ausschuss'
echo '-- Table: kandidat_ausschuss'
echo '-- etc/3nf/data/insert-data-kandidat_ausschuss.sql'
echo '--' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Kandidat.ausschuss' >> ../src/main/resources/data.sql
echo '-- org.woehlke.btw17.kandidaten.oodm.db.model.Ausschuss' >> ../src/main/resources/data.sql
echo '-- Table: kandidat_ausschuss' >> ../src/main/resources/data.sql
echo '-- etc/3nf/data/insert-data-kandidat_ausschuss.sql' >> ../src/main/resources/data.sql
echo '--' >> ../src/main/resources/data.sql

cat ./3nf/data/insert-data-kandidat_ausschuss.sql | sed "s/'',/NULL,/g" | sed "s/'')/NULL)/g" | grep "INSERT INTO kandidat_ausschuss "  >> ../src/main/resources/data.sql

echo ' ' >> ../src/main/resources/data.sql

echo "VACUUM;" >> ../src/main/resources/data.sql

exit 0
