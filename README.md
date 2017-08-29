# [btw17kandidaten](https://github.com/phasenraum2010/btw17kandidaten)

+ App the Browse Data for #btw17 with [spring:boot](https://projects.spring.io/spring-boot/) for [heroku](https://heroku.com)
+ More Info: [https://phasenraum2010.github.io/btw17kandidaten/](https://phasenraum2010.github.io/btw17kandidaten/)
+ Moore Info and Source of Data: [https://interaktiv.morgenpost.de/kandidaten-bundestagswahl-2017/ ](https://interaktiv.morgenpost.de/kandidaten-bundestagswahl-2017/ )

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
- run with: **mvn clean spring-boot:run**

## Contribute

### Fork, patch and contribute code

Feel free to fork Twitterwall [Git repository at GitHub][twitterwall-github] for your own use and
updates.

Contribute your fixes and new features back to the main codebase using
[GitHub pull requests][github-pull-req].

[twitterwall-github]: https://github.com/phasenraum2010/btw17kandidaten/
[github-pull-req]: http://help.github.com/articles/using-pull-requests

### Issues (bug and feature tracker)

Please report any bugs found, feature requests or other issues on
[Twitterwall GitHub tracker][twitterwall-issues].

When creating a new issue, try following [necolas's guidelines][issue-guidelines].

[twitterwall-issues]: https://github.com/phasenraum2010/btw17kandidaten/issues
[issue-guidelines]: http://github.com/necolas/issue-guidelines/#readme

### Support

Let me know if you are using App. I may get around to creating a showcase page listing user sites.

[Contact me][av-site] if you have questions about Twitterwall, or just like to say something about it.
If you _really really_ like it and want to support the author, I will be glad to
[accept a small donation][donate].

[av-site]: https://twitter.com/ThomasWoehlke
[donate]: https://www.paypal.me/ThomasWoehlke

### Author  

**Thomas Wöhlke**
+ Twitter: [https://twitter.com/ThomasWoehlke](https://twitter.com/ThomasWoehlke)
+ Github: [https://github.com/phasenraum2010](https://github.com/phasenraum2010)
+ Blog: [https://thomas-woehlke.blogspot.de](https://thomas-woehlke.blogspot.de)

### Acknowledgements

+ Twitterwall Frontend is built on [Bootstrap][bootstrap].
+ These include icons from [Glyphicons][glyphicons] and web fonts from [Google][webfonts].
+ JavaScript goodies with [jQuery][jquery].
+ More icons by [fontawesome][fontawesome].
+ Google Maps JavaScript API [google-maps-javascript-api][google-maps-javascript-api]
+ Google Analytics [google-analytics][google-analytics]
+ Serverside is made with [Java][java] and [Spring-Boot][spring-boot].
+ Spring Frameworks used: [spring-web-mvc][spring-web-mvc] [JPA][spring-data-jpa], [Security][spring-security]
+ Database [PostgreSQL][postgresql] and jdbc by [PostgreSQL-JDBC][postgresql-jdbc].
+ Running on Cloud-Service [Heroku][heroku] with [Heroku PostegreSQL][postgresql-heroku].

[java]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[fontawesome]: http://fontawesome.io/icons/
[postgresql-jdbc]: https://jdbc.postgresql.org/
[postgresql]: https://www.postgresql.org/
[heroku]: https://heroku.com/
[postgresql-heroku]: https://devcenter.heroku.com/categories/heroku-postgres/
[spring-web-mvc]: http://projects.spring.io/spring-framework/
[spring-boot]: https://projects.spring.io/spring-boot/
[spring-data-jpa]: http://projects.spring.io/spring-data-jpa/
[spring-security]: http://projects.spring.io/spring-security/
[bootstrap]: http://getbootstrap.com/
[glyphicons]: http://glyphicons.com/
[webfonts]: http://www.google.com/webfonts/
[jquery]: http://jquery.org
[google-analytics]: https://analytics.google.com/analytics/web/
[google-maps-javascript-api]: https://developers.google.com/maps/documentation/javascript/

### Copyright and license

&copy; 2017 Thomas Wöhlke

Licensed under the **Apache License, Version 2.0**

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Except where otherwise noted, Documentation of this work is licensed under 
[Creative Commons CC BY-ND 3.0](http://creativecommons.org/licenses/by-nd/3.0/)











