#!/usr/bin/env bash


source conf.sh

export DATASOURCE_URL='jdbc:postgresql://localhost:5432/kandidatenrelease?user=kandidatenrelease&password=kandidatenreleasepwd'

export DATASOURCE_USERNAME=kandidatenrelease
export DATASOURCE_PASSWORD=kandidatenreleasepwd

export BTW17_JPA_HIBERNATE_DDL_AUTO=update

./mvnw clean install

./mvnw clean spring-boot:run

./mvnw clean spring-boot:run

./mvnw clean spring-boot:run

echo "./mvnw clean release:prepare"

echo "./mvnw release:perform"

echo "git commit -m 'after release'"

echo "git push"

exit 0
