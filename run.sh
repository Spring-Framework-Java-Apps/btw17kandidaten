#!/bin/bash

source ./etc/setenv.sh

function run() {
    ./mvnw clean spring-boot:run
}

function firstSetup() {
    ./mvnw clean install site -DskipTests=true
}

function main() {
    firstSetup
    #run
}

main
