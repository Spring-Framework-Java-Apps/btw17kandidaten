#!/opt/local/bin/bash

source conf.sh

export DATABASE_URL='jdbc:postgresql://localhost:5432/kandidatenrelease?user=kandidatenrelease&password=kandidatenreleasepwd'

export BTW17_JPA_HIBERNATE_DDL_AUTO=drop-create

psql -U kandidatentravis < etc/drop-tables.sql

#psql -c 'DROP DATABASE kandidatentravis;' -U postgres
#psql -c 'DROP USER kandidatentravis;' -U postgres
#psql -c 'DROP ROLE kandidatentravis;' -U postgres
#psql -c "CREATE USER kandidatentravis WITH PASSWORD 'kandidatentravispwd' LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION;" -U postgres
#psql -c 'GRANT pg_signal_backend, postgres TO kandidatentravis WITH ADMIN OPTION;' -U postgres
#psql -c "CREATE DATABASE kandidatentravis WITH OWNER = kandidatentravis TEMPLATE = template1 ENCODING = 'UTF8' LC_COLLATE = 'de_DE.UTF-8' LC_CTYPE = 'de_DE.UTF-8' CONNECTION LIMIT = -1;" -U postgres

psql -c 'select * from version();' -U kandidatentravis
psql -c '\l' -U postgres
psql -c '\dg' -U postgres
psql -c '\dn' -U postgres

./mvnw install -DskipTests=true -Dmaven.javadoc.skip=true -B -V
./mvnw clean site site:deploy -Ptravis -Dtest=AlphaTopLevelSuiteIT  -B -V

exit 0
