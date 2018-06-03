#!/usr/bin/env bash

source conf.sh

export PORT=8080
export JAVA_OPTS='-Xmx350m -Xss512k'

export DATASOURCE_URL='jdbc:postgresql://localhost:5432/kandidatenheroku?user=kandidatenheroku&password=kandidatenherokupwd'

export DATASOURCE_USERNAME=kandidatenheroku
export DATASOURCE_PASSWORD=kandidatenherokupwd

./mvnw clean install

java -Dserver.port=$PORT $JAVA_OPTS -jar target/kandidaten-2.0.1-SNAPSHOT.jar
