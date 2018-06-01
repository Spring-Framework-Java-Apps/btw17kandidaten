#!/bin/sh


if [ "$DATABASE" == "" ]
then
    export DATABASE='kandidaten'
    #export DATABASE='kandidatentest'
fi

echo "Database: $DATABASE"

export ENCODING=UTF8
export PG_DUMP_COMMON_PARAMETER='--data-only --blobs --no-owner --jobs=1 --column-inserts '

export EXP_FACETTEN="1"
export EXP_WAHLLEITER_DATA="1"
export EXP_MAIN="1"

export TABLES=""

if [ "$EXP_WAHLLEITER_DATA" == "1" ]
then

echo "EXP_WAHLLEITER_DATA"

export TABLES="$TABLES btw17_ergebnis btw17_strukturdaten btw17_wahlbewerber btw17_wahlkreis btw17_mdb_wahlperiode btw17_mdb_stammdaten btw17_mdb_stammdaten_wahlperiode"

fi


if [ "$EXP_FACETTEN" == "1" ]
then

echo "FACETTEN"

export TABLES="$TABLES cms agentur bundesland_agentur fraktion_agentur ministerium_agentur partei_agentur"
export TABLES="$TABLES wohnort_agentur ausschuss beruf berufsgruppe bundesland fraktion geburtsort landesliste"
export TABLES="$TABLES listepartei ministerium partei wahlkreis wohnort wahlperiode"

fi


if [ "$EXP_MAIN" == "1" ]
then

echo "MAIN"

export TABLES="$TABLES kandidat_agentur kandidat_ausschuss kandidat_ministerium kandidat"

fi

for i in $TABLES
do
    echo "sql dump table: $i"
    pg_dump -U $DATABASE --table=$i $PG_DUMP_COMMON_PARAMETER --encoding=$ENCODING $DATABASE | grep "INSERT INTO $i " | perl -pe  's/\(([0-9]{3}),/(00$1,/g' | perl -pe  's/\(([0-9]{2}),/(000$1,/g' | perl -pe  's/\(([0-9]{1}),/(0000$1,/g' | perl -pe  's/\(([0-9]{4}),/(0$1,/g' | perl -pe  's/\(([0-9]{5}),/($1,/g' | sort > 3nf/data/insert-data-$i.sql
done

echo "Start building new Version of: src/main/resources/data-postgresql.sql"

./build-db-data-import-file.sh

exit 0
