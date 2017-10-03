#!/opt/local/bin/bash

export BTW17_LOGIN_USERNAME=blubb
export BTW17_LOGIN_PASSWORD=blablablablablablablablabla
export BTW17_JPA_HIBERNATE_DDL_AUTO=update
export BTW17_GOOGLE_APS_API_KEY=AIzaSyCMWLD6SK1QY3f-94mDS6x7u_jxwYASgqY
export BTW17_GOOGLE_ANALYTICS_ID=UA-17174370-11
export BTW17_GOOGLE_WEBMASTER_TOOLS_ID=3eksTC3Rvao6fLvSUwoRECBwd9Gdg4F51IhOE3DD-T8
export BTW17_MICROSOFT_WEBMASTER_TOOLS_ID=52F1EDC0244BCDCF5C95E402E9E3E49B
export BTW17_FACEBOOK_APP_ID=1721279777913278
export BTW17_TWITTER_CARD_SITE=port80guru
export BTW17_TWITTER_CARD_CREATOR=port80guru

psql -U kandidatentest < etc/drop-tables.sql

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
#./mvnw clean test -Pdevtest -Dtest=Btw17WahlleiterDatenimport -Dmaven.javadoc.skip=true -B -V
./mvnw clean test -Pdevtest -Dtest=WahlkreisEnricher -Dmaven.javadoc.skip=true -B -V



exit 0
