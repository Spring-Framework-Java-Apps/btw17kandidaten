#!/bin/sh

#export DATABASE_URL='jdbc:postgresql://localhost:5432/kandidaten?user=kandidaten&password=kandidatenpwd'
#export DATABASE_URL_TEST='jdbc:postgresql://localhost:5432/kandidaten?user=kandidaten&password=kandidatenpwd'
#export DATABASE_URL='jdbc:postgresql://localhost:5432/kandidatentest?user=kandidatentest&password=kandidatentestpwd'
#export DATABASE_URL_TEST='jdbc:postgresql://localhost:5432/kandidatentest?user=kandidatentest&password=kandidatentestpwd'
export BTW17_LOGIN_USERNAME=blubb
export BTW17_LOGIN_PASSWORD=blablablablablablablablabla
export BTW17_JPA_HIBERNATE_DDL_AUTO=update
export BTW17_GOOGLE_APS_API_KEY=AIzaSyCMWLD6SK1QY3f-94mDS6x7u_jxwYASgqY
export BTW17_GOOGLE_ANALYTICS_ID=UA-17174370-11

#./mvnw clean install site -Ptravis

./mvnw clean install -Ptravis