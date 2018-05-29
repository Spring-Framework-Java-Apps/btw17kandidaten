#!/bin/sh


export JAVA_OPTIONS='-Xmx300m -Xss512k -Dfile.encoding=UTF-8'

export DATABASE_URL='jdbc:postgresql://localhost:5432/kandidaten?user=kandidaten&password=kandidatenpwd'

source conf.sh

export BTW17_JPA_HIBERNATE_DDL_AUTO=update

./mvnw clean spring-boot:run

exit 0
