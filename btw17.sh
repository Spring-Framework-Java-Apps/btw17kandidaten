#!/opt/local/bin/bash

source conf.sh

psql -U kandidatentest < etc/drop-tables.sql

export DATASOURCE_URL='jdbc:postgresql://localhost:5432/kandidatentest?user=kandidatentest&password=kandidatentestpwd'
export DATASOURCE_USERNAME=kandidatentest
export DATASOURCE_PASSWORD=kandidatentestpwd

#psql -c 'DROP DATABASE kandidatentest;' -U postgres
#psql -c 'DROP USER kandidatentest;' -U postgres
#psql -c 'DROP ROLE kandidatentest;' -U postgres
#psql -c "CREATE USER kandidatentest WITH PASSWORD 'kandidatentestpwd' LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION;" -U postgres
#psql -c 'GRANT pg_signal_backend, postgres TO kandidatentest WITH ADMIN OPTION;' -U postgres
#psql -c "CREATE DATABASE kandidatentest WITH OWNER = kandidatentest TEMPLATE = template1 ENCODING = 'UTF8' LC_COLLATE = 'de_DE.UTF-8' LC_CTYPE = 'de_DE.UTF-8' CONNECTION LIMIT = -1;" -U postgres

#psql -c 'select * from version();' -U kandidatentest
#psql -c '\l' -U postgres
#psql -c '\dg' -U postgres
#psql -c '\dn' -U postgres

./mvnw clean install -DskipTests=true -Dmaven.javadoc.skip=true -B -V
#./mvnw clean test -Pdevtest -Dtest=KandidatEnricher -Dmaven.javadoc.skip=true -B -V
./mvnw clean test -Pdevtest -Dtest=KandidatEnricher -Dmaven.javadoc.skip=true -B -V
#./mvnw clean test -Pdevtest -Dtest=BerufEnricher -Dmaven.javadoc.skip=true -B -V
#./mvnw clean test -Pdevtest -Dtest=BundeslandEnricher -Dmaven.javadoc.skip=true -B -V
#./mvnw clean test -Pdevtest -Dtest=GeburtsortEnricher -Dmaven.javadoc.skip=true -B -V
#./mvnw clean test -Pdevtest -Dtest=ParteiEnricher -Dmaven.javadoc.skip=true -B -V
#./mvnw clean test -Pdevtest -Dtest=WahlkreisEnricher -Dmaven.javadoc.skip=true -B -V
#./mvnw clean test -Pdevtest -Dtest=WahlperiodeEnricher -Dmaven.javadoc.skip=true -B -V
#./mvnw clean test -Pdevtest -Dtest=WohnortEnricher -Dmaven.javadoc.skip=true -B -V

exit 0
