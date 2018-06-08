#!/usr/bin/env bash

source conf.sh

export DATASOURCE_URL='jdbc:postgresql://localhost:5432/kandidatentest?user=kandidatentest&password=kandidatentestpwd'

export DATASOURCE_USERNAME=kandidatentest
export DATASOURCE_PASSWORD=kandidatentestpwd

export BTW17_JPA_HIBERNATE_DDL_AUTO=update

./mvnw -e clean install dependency:tree site

exit 0
