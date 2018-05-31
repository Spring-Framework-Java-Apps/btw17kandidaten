#!/bin/sh

source conf.sh

export DATABASE_URL='jdbc:postgresql://localhost:5432/kandidatenrelease?user=kandidatenrelease&password=kandidatenreleasepwd'

./mvnw clean install

./mvnw clean spring-boot:run

./mvnw clean spring-boot:run

./mvnw clean spring-boot:run

./mvnw clean release:prepare

echo "./mvnw release:perform"

echo "git commit -m 'after release'"

echo "git push"

exit 0
