#!/usr/bin/env bash

export PORT=8080
export JAVA_OPTS='-Xmx350m -Xss512k'

export DATABASE_URL="jdbc:postgresql://localhost:5432/kandidaten?user=kandidaten&password=kandidatenpwd&schmema=public"
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

./mvnw clean install

java -Dserver.port=$PORT $JAVA_OPTS -jar target/kandidaten-0.0.18-SNAPSHOT.jar
