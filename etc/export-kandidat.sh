#!/bin/sh

pg_dump -U kandidaten --table=kandidat --data-only --column-inserts kandidaten > 3nf/data/insert-data-kandidat.sql

./build-db-data-import-file.sh

exit 0