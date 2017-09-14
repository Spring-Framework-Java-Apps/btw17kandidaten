#!/bin/sh

export EXP_FACETTEN="1"

if [ $EXP_FACETTEN == "1" ]
then

echo "Facetten"

pg_dump -U kandidaten --table=ausschuss --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-ausschuss.sql

pg_dump -U kandidaten --table=beruf --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-beruf.sql

pg_dump -U kandidaten --table=berufsgruppe --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-berufsgruppe.sql

pg_dump -U kandidaten --table=bundesland --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-bundesland.sql

pg_dump -U kandidaten --table=fraktion --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-fraktion.sql

pg_dump -U kandidaten --table=geburtsort --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-geburtsort.sql

pg_dump -U kandidaten --table=landesliste --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-landesliste.sql

pg_dump -U kandidaten --table=liste_partei --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-liste_partei.sql

pg_dump -U kandidaten --table=ministerium --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-ministerium.sql

pg_dump -U kandidaten --table=partei --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-partei.sql

pg_dump -U kandidaten --table=wahlkreis --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-wahlkreis.sql

pg_dump -U kandidaten --table=wohnort --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-wohnort.sql

fi

echo "Main"

pg_dump -U kandidaten --table=kandidat_ausschuss --data-only --no-owner  --jobs=1 --column-inserts kandidaten | sort  > 3nf/data/insert-data-kandidat_ausschuss.sql

pg_dump -U kandidaten --table=kandidat_ministerium --data-only --no-owner --jobs=1 --column-inserts kandidaten | sort  > 3nf/data/insert-data-kandidat_ministerium.sql

pg_dump -U kandidaten --table=kandidat --data-only --no-owner --jobs=1 --column-inserts kandidaten | sort > 3nf/data/insert-data-kandidat.sql

echo "Build new Version of: src/main/resources/data.sql"

./build-db-data-import-file.sh

exit 0