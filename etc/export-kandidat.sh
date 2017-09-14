#!/bin/sh

export EXP_FACETTEN="1"

if [ $EXP_FACETTEN == "1" ]
then

echo "FACETTEN"


echo "sql dump table: ausschuss"

pg_dump -U kandidaten --table=ausschuss --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-ausschuss.sql

echo "sql dump table: beruf"

pg_dump -U kandidaten --table=beruf --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-beruf.sql

echo "sql dump table: berufsgruppe"

pg_dump -U kandidaten --table=berufsgruppe --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-berufsgruppe.sql

echo "sql dump table: bundesland"

pg_dump -U kandidaten --table=bundesland --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-bundesland.sql

echo "sql dump table: fraktion"

pg_dump -U kandidaten --table=fraktion --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-fraktion.sql

echo "sql dump table: geburtsort"

pg_dump -U kandidaten --table=geburtsort --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-geburtsort.sql

echo "sql dump table: landesliste"

pg_dump -U kandidaten --table=landesliste --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-landesliste.sql

echo "sql dump table: liste_partei"

pg_dump -U kandidaten --table=liste_partei --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-liste_partei.sql

echo "sql dump table: ministerium"

pg_dump -U kandidaten --table=ministerium --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-ministerium.sql

echo "sql dump table: partei"

pg_dump -U kandidaten --table=partei --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-partei.sql

echo "sql dump table: wahlkreis"

pg_dump -U kandidaten --table=wahlkreis --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-wahlkreis.sql

echo "sql dump table: wohnort"

pg_dump -U kandidaten --table=wohnort --data-only --jobs=1 --column-inserts kandidaten > 3nf/data/insert-data-wohnort.sql

fi

echo "MAIN"

echo "sql dump table: kandidat_ausschuss"

pg_dump -U kandidaten --table=kandidat_ausschuss --data-only --no-owner  --jobs=1 --column-inserts kandidaten | sort  > 3nf/data/insert-data-kandidat_ausschuss.sql

echo "sql dump table: kandidat_ministerium"

pg_dump -U kandidaten --table=kandidat_ministerium --data-only --no-owner --jobs=1 --column-inserts kandidaten | sort  > 3nf/data/insert-data-kandidat_ministerium.sql

echo "sql dump table: kandidat"

pg_dump -U kandidaten --table=kandidat --data-only --no-owner --jobs=1 --column-inserts kandidaten | sort > 3nf/data/insert-data-kandidat.sql

echo "Build new Version of: src/main/resources/data.sql"

./build-db-data-import-file.sh

exit 0