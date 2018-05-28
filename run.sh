#!/bin/sh


export JAVA_OPTIONS='-Xmx300m -Xss512k -Dfile.encoding=UTF-8'

export DATABASE_URL='jdbc:postgresql://localhost:5432/kandidaten?user=jdbc&password=jdbcpwd'

source conf.sh

./mvnw clean spring-boot:run

exit 0
