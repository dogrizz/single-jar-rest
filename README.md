Just checking possibility of creating single jar rest application with heroku deployment.

Heroku is setting up database info in enviromental variables which is reflected in `application.properties`.
If you want to use own database, copy `jdbc_settings.sh.example` to `jdb_settings.sh` and fill it properly.

To build:
`./gradlew clean build`

To run:

    . ./jdbc_settings.sh
    ./gradlew bootRun

This is using https://spring.io/guides/gs/rest-service/ which runs on Tomcat underneath via spring boot.
With spring data access set up: https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html

No database requests:

  * https://vast-dawn-3751.herokuapp.com/greeting?name=Przemek
  * https://vast-dawn-3751.herokuapp.com/greeting
  
Requests working with database:
  
  * https://vast-dawn-3751.herokuapp.com/db_greetings
  * https://vast-dawn-3751.herokuapp.com/db_greeting?id=x
  * https://vast-dawn-3751.herokuapp.com/db_greeting?content='New greeting through PUT'

It can take a bit of time before first request after deploy is served.
