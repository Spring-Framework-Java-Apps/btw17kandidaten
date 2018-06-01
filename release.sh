#!/bin/sh

source conf.sh

export DATABASE_URL='jdbc:postgresql://localhost:5432/kandidatenrelease?user=kandidatenrelease&password=kandidatenreleasepwd'

export BTW17_JPA_HIBERNATE_DDL_AUTO=update

./mvnw clean install

./mvnw clean spring-boot:run

./mvnw clean spring-boot:run

./mvnw clean spring-boot:run

./mvnw clean release:prepare

echo "./mvnw release:perform"

echo "git commit -m 'after release'"

echo "git push"

exit 0
