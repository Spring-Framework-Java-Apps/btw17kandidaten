set JAVA_OPTIONS="-Xmx300m -Xss512k -Dfile.encoding=UTF-8"

set DATABASE_URL="jdbc:postgresql://localhost:5432/kandidaten?user=jdbc&password=jdbcpwd&schmea=public"
set BTW17_LOGIN_USERNAME=blubb
set BTW17_LOGIN_PASSWORD=blablablablablablablablabla
set BTW17_JPA_HIBERNATE_DDL_AUTO=update
set BTW17_GOOGLE_APS_API_KEY=AIzaSyCMWLD6SK1QY3f-94mDS6x7u_jxwYASgqY
set BTW17_GOOGLE_ANALYTICS_ID=UA-17174370-11
set BTW17_GOOGLE_WEBMASTER_TOOLS_ID=3eksTC3Rvao6fLvSUwoRECBwd9Gdg4F51IhOE3DD-T8
set BTW17_MICROSOFT_WEBMASTER_TOOLS_ID=52F1EDC0244BCDCF5C95E402E9E3E49B
set BTW17_FACEBOOK_APP_ID=1721279777913278
set BTW17_TWITTER_CARD_SITE=port80guru
set BTW17_TWITTER_CARD_CREATOR=port80guru

mvnw clean spring-boot:run

exit 0
