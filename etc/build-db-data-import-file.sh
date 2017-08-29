#!/bin/sh

rm ../src/main/resources/data.sql

cat ./3nf/data/insert-data-beruf.sql > ../src/main/resources/data.sql
cat ./3nf/data/insert-data-berufsgruppe.sql >> ../src/main/resources/data.sql
cat ./3nf/data/insert-data-bundesland.sql >> ../src/main/resources/data.sql
cat ./3nf/data/insert-data-geburtsort.sql >> ../src/main/resources/data.sql
cat ./3nf/data/insert-data-liste_partei.sql >> ../src/main/resources/data.sql
cat ./3nf/data/insert-data-partei.sql >> ../src/main/resources/data.sql
cat ./3nf/data/insert-data-wahlkreis.sql >> ../src/main/resources/data.sql
cat ./3nf/data/insert-data-wohnort.sql >> ../src/main/resources/data.sql
cat ./3nf/data/insert-data-kandidat.sql >> ../src/main/resources/data.sql
cat ./3nf/data/insert-data-kandidat_flat.sql >> ../src/main/resources/data.sql

exit 0