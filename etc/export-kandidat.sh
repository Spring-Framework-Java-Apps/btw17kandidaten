#!/bin/sh

pg_dump -U kandidaten --table=kandidat --data-only --column-inserts kandidaten > 3nf/data/insert-data-kandidat.sql

#pg_dump -U kandidaten --table=liste_partei --data-only --column-inserts kandidaten > 3nf/data/insert-data-liste_partei.sql

./build-db-data-import-file.sh

exit 0