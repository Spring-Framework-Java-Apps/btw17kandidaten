#!/bin/sh

echo "Facetten"

pg_dump -U kandidaten --table=ausschuss --data-only --column-inserts kandidaten > 3nf/data/insert-data-ausschuss.sql

pg_dump -U kandidaten --table=beruf --data-only --column-inserts kandidaten > 3nf/data/insert-data-beruf.sql

pg_dump -U kandidaten --table=berufsgruppe --data-only --column-inserts kandidaten > 3nf/data/insert-data-berufsgruppe.sql

pg_dump -U kandidaten --table=bundesland --data-only --column-inserts kandidaten > 3nf/data/insert-data-bundesland.sql

pg_dump -U kandidaten --table=fraktion --data-only --column-inserts kandidaten > 3nf/data/insert-data-fraktion.sql

pg_dump -U kandidaten --table=geburtsort --data-only --column-inserts kandidaten > 3nf/data/insert-data-geburtsort.sql

pg_dump -U kandidaten --table=landesliste --data-only --column-inserts kandidaten > 3nf/data/insert-data-landesliste.sql

pg_dump -U kandidaten --table=liste_partei --data-only --column-inserts kandidaten > 3nf/data/insert-data-liste_partei.sql

pg_dump -U kandidaten --table=ministerium --data-only --column-inserts kandidaten > 3nf/data/insert-data-ministerium.sql

pg_dump -U kandidaten --table=partei --data-only --column-inserts kandidaten > 3nf/data/insert-data-partei.sql

pg_dump -U kandidaten --table=wahlkreis --data-only --column-inserts kandidaten > 3nf/data/insert-data-wahlkreis.sql

pg_dump -U kandidaten --table=wohnort --data-only --column-inserts kandidaten > 3nf/data/insert-data-wohnort.sql

echo "Main"

pg_dump -U kandidaten --table=kandidat_ausschuss --data-only --column-inserts kandidaten > 3nf/data/insert-data-kandidat_ausschuss.sql

pg_dump -U kandidaten --table=kandidat_ministerium --data-only --column-inserts kandidaten > 3nf/data/insert-data-kandidat_ministerium.sql

pg_dump -U kandidaten --table=kandidat --data-only --column-inserts kandidaten > 3nf/data/insert-data-kandidat.sql

echo "Build new Version of: src/main/resources/data.sql"

./build-db-data-import-file.sh

exit 0