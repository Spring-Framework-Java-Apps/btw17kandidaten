# [btw17kandidaten](https://github.com/phasenraum2010/btw17kandidaten)

[![Build Status](https://travis-ci.org/phasenraum2010/btw17kandidaten.svg?branch=master)](https://travis-ci.org/phasenraum2010/btw17kandidaten)

## Alle 2559 Direktkandidaten

Die Anwendung basiert auf den Daten des Bundeswahlleiters zu allen zugelassenen Kandidaten. 
Die offiziellen Angaben zu Namen (inklusive Zweitnamen), Beruf sowie Wohn- und Geburtsort wurden exakt übernommen. 
Bei der Angabe des Alters kann es zu Abweichungen kommen, da dies lediglich auf Grundlage des Geburtsjahres errechnet wurde.

## public BETA

Einige Informationen werden aktuell noch manuell gesammelt und sukzessive bereit gestellt.
Einige Funktionen der Software werden aktuell noch weiter entwickelt und sukzessive bereit gestellt
Die Daten können Inkonsistenzen oder Fehler enthalten.
Die Funktionen der Software können Inkonsistenzen oder Fehler enthalten.
Sie können Fehler bei Daten oder Software-Funktionen melden unter: [https://github.com/phasenraum2010/btw17kandidaten/issues](https://github.com/phasenraum2010/btw17kandidaten/issues)
Das Hosting bei Heroku ist der kleinste, kostenlose, Tarif. Das kann je nach Anzahl der Besucher langsam werden. 
Kostenpflichtige Upgrades mit extremer Skalierung sind durch Sponsoring zeitnah möglich.
Das Hosting bei Heroku ist in Europa, nicht in den USA.

## URLs
+ Demo on Heroku [https://btw17-kandidaten.herokuapp.com](https://btw17-kandidaten.herokuapp.com)
+ Github [https://github.com/phasenraum2010/btw17kandidaten](https://github.com/phasenraum2010/btw17kandidaten)
+ Maven Reports [http://woehlke.org/p/btw17-kandidaten/](http://woehlke.org/p/btw17-kandidaten/)

## Abstract
+ App the Browse Data for #btw17 with [spring:boot](https://projects.spring.io/spring-boot/) for [heroku](https://heroku.com)
+ More Info: [https://phasenraum2010.github.io/btw17kandidaten/](https://phasenraum2010.github.io/btw17kandidaten/)
+ Moore Info and Source of Data: [interaktiv-morgenpost-de-kandidaten-bundestagswahl-2017][interaktiv-morgenpost-de-kandidaten-bundestagswahl-2017]

## Neo4J

### Download
* https://github.com/neo4j/neo4j/releases

### Support
* https://stackoverflow.com/questions/tagged/neo4j
* https://github.com/neo4j/neo4j
* https://groups.google.com/forum/#!forum/neo4j

### Docu
* https://neo4j.com/docs/
* https://neo4j.com/docs/developer-manual/current/
* https://neo4j.com/docs/operations-manual/current/

### OGM & Graph Algorithms
* https://neo4j.com/docs/ogm-manual/current/
* https://neo4j.com/docs/graph-algorithms/current/
* 
* https://neo4j.com/docs/pdf/cypher-refcard-3.4.pdf

### resources
* https://neo4j.com/developer/resources/
* http://neo4j-users-slack-invite.herokuapp.com/
* https://twitter.com/neo4j
* https://github.com/neo4j/neo4j
* https://groups.google.com/forum/#!forum/neo4j
* https://www.youtube.com/c/neo4j
* https://www.meetup.com/de-DE/Neo4j-Online-Meetup/?chapter_analytics_code=UA-1192232-34
* https://stackoverflow.com/questions/tagged/neo4j

## Spring-Boot

* https://spring.io/projects/spring-boot
* https://docs.spring.io/spring-boot/docs/2.0.2.RELEASE/reference/htmlsingle
* https://docs.spring.io/spring-boot/docs/2.0.2.RELEASE/api
* https://projects.spring.io/spring-data-neo4j
* https://spring.io/projects/spring-data-jpa

### Resources
* https://github.com/spring-projects/spring-boot

## Maven Repositories

* [http://localhost:8081/artifactory/webapp/#/admin/repositories/remote](http://localhost:8081/artifactory/webapp/#/admin/repositories/remote)

lfdNr | key | Url
----|--------|----
1 | central | https://repo.spring.io/libs-release-local
3 | ga.maven.repository.redhat.com | https://maven.repository.redhat.com/ga/
3 | jcenter | https://jcenter.bintray.com/
4 | maven2.central.maven.org | http://central.maven.org/maven2/
5 | maven2.dist.wso2.org |  http://dist.wso2.org/maven2/
6 | plugins-release.repo.spring.io |  http://repo.spring.io/plugins-release/
7 | release.repo.spring.io |  http://repo.spring.io/release/
8 | releases.repository.apache.org |  https://repository.apache.org/content/repositories/releases/
9 | sonatype-nexus-snapshots |  https://oss.sonatype.org/content/repositories/snapshots/

## Development 

### Repository
- Get Source Code: git clone [https://github.com/phasenraum2010/btw17kandidaten.git](https://github.com/phasenraum2010/btw17kandidaten.git)
- Issues: [https://github.com/phasenraum2010/btw17kandidaten/issues](https://github.com/phasenraum2010/btw17kandidaten/issues)

### heroku CLI
- export APP_NAME=btw17-kandidaten
- heroku login
- heroku pg:psql --app $APP_NAME
- heroku logs -t --app $APP_NAME
- more: 
  - [https://devcenter.heroku.com/categories/command-line](https://devcenter.heroku.com/categories/command-line)
  - [https://devcenter.heroku.com/articles/heroku-cli](https://devcenter.heroku.com/articles/heroku-cli)


### Setup Test and Development on Localhost
- **Setup for all Environments**
  - Create API Key for Google Maps API JavaScript
  - Create API Key for Google Maps JavaScript API [google-maps-javascript-api][google-maps-javascript-api]
  - Create API Key for Google Analytics [google-analytics][google-analytics]
  - export BTW17_GOOGLE_APS_API_KEY=...
  - export BTW17_GOOGLE_ANALYTICS_ID=...
- **Setup Localhost**
  - export DATABASE_URL=jdbc:postgresql://localhost:5432/kandidaten?user=kandidaten&password=kandidatenpwd
  - export DATABASE_URL_TEST=jdbc:postgresql://localhost:5432/kandidaten?user=kandidaten&password=kandidatenpwd
  - export BTW17_JPA_HIBERNATE_DDL_AUTO=update
  - export BTW17_LOGIN_USERNAME=jhfdbvfjdbvjdfh
  - export BTW17_LOGIN_PASSWORD=hfbjvbfbvgjhfvgh
- run with: **mvn clean spring-boot:run**

## Contribute

### Fork, patch and contribute code

Feel free to fork btw17kandidaten [Git repository at GitHub][btw17kandidaten-github] for your own use and
updates.

Contribute your fixes and new features back to the main codebase using
[GitHub pull requests][github-pull-req].

[btw17kandidaten-github]: https://github.com/phasenraum2010/btw17kandidaten/
[github-pull-req]: http://help.github.com/articles/using-pull-requests

### Issues (bug and feature tracker)

Please report any bugs found, feature requests or other issues on
[btw17kandidaten GitHub tracker][btw17kandidaten-issues].

When creating a new issue, try following [necolas's guidelines][issue-guidelines].

[btw17kandidaten-issues]: https://github.com/phasenraum2010/btw17kandidaten/issues
[issue-guidelines]: http://github.com/necolas/issue-guidelines/#readme

### Support

Let me know if you are using App. I may get around to creating a showcase page listing user sites.

[Contact me][av-site] if you have questions about btw17kandidaten, or just like to say something about it.
If you _really really_ like it and want to support the author, I will be glad to
[accept a small donation][donate].

[av-site]: https://twitter.com/ThomasWoehlke
[donate]: https://www.paypal.me/ThomasWoehlke

### Author  

**Thomas Wöhlke**
+ Twitter: [https://twitter.com/ThomasWoehlke](https://twitter.com/port80guru)
+ Github: [https://github.com/phasenraum2010](https://github.com/phasenraum2010)
+ Blog: [https://thomas-woehlke.blogspot.de](https://thomas-woehlke.blogspot.de)

### Acknowledgements

+ btw17 Frontend is built on [Bootstrap][bootstrap].
+ These include icons from [Glyphicons][glyphicons] and web fonts from [Google][webfonts].
+ JavaScript goodies with [jQuery][jquery].
+ More icons by [fontawesome][fontawesome].
+ Google Maps JavaScript API [google-maps-javascript-api][google-maps-javascript-api]
+ Google Analytics [google-analytics][google-analytics]
+ Serverside is made with [Java][java] and [Spring-Boot][spring-boot].
+ Spring Frameworks used: [spring-web-mvc][spring-web-mvc] [JPA][spring-data-jpa], [Security][spring-security]
+ HTML Templating: [Thymeleaf][thymeleaf]
+ Database [PostgreSQL][postgresql] and jdbc by [PostgreSQL-JDBC][postgresql-jdbc].
+ Continous Integration with [Travis-CI][travis-ci]
+ Scalable Operating on Cloud-Service in Zone EU [Heroku][heroku] with [Heroku PostegreSQL][postgresql-heroku].

[java]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[fontawesome]: http://fontawesome.io/icons/
[postgresql-jdbc]: https://jdbc.postgresql.org/
[postgresql]: https://www.postgresql.org/
[heroku]: https://heroku.com/
[travis-ci]: https://travis-ci.org/
[postgresql-heroku]: https://devcenter.heroku.com/categories/heroku-postgres/
[spring-web-mvc]: http://projects.spring.io/spring-framework/
[spring-boot]: https://projects.spring.io/spring-boot/
[spring-data-jpa]: http://projects.spring.io/spring-data-jpa/
[spring-security]: http://projects.spring.io/spring-security/
[thymeleaf]: http://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html
[bootstrap]: https://getbootstrap.com/docs/3.3/
[glyphicons]: http://glyphicons.com/
[webfonts]: http://www.google.com/webfonts/
[jquery]: http://jquery.org
[google-analytics]: https://analytics.google.com/analytics/web/
[google-maps-javascript-api]: https://developers.google.com/maps/documentation/javascript/
[interaktiv-morgenpost-de-kandidaten-bundestagswahl-2017]: https://interaktiv.morgenpost.de/kandidaten-bundestagswahl-2017/

### Copyright and license

&copy; 2017 Thomas Wöhlke for the Software at [Github](https://github.com/phasenraum2010/btw17kandidaten)

&copy; 2017 [Bundeswahlleiter](https://www.bundeswahlleiter.de/dam/jcr/4d632553-d0be-4a4a-acde-5bb985a6302c/btw17_kandidaten.zip) for the Data (mentioned by morgenpost.de)

&copy; 2017 [morgenpost.de][interaktiv-morgenpost-de-kandidaten-bundestagswahl-2017] for the Data (CSV-Download)

Licensed under the **Apache License, Version 2.0**

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Except where otherwise noted, Documentation of this work is licensed under 
[Creative Commons CC BY-ND 3.0](http://creativecommons.org/licenses/by-nd/3.0/)











