Just checking possibility of creating single jar rest application with heroku deployment.

Heroku is passing database info via enviromental variables.
This is taken into account in `application.properties`.

If you want to use own database (or run on local postgresql), copy `jdbc_settings.sh.example` to `jdb_settings.sh` and fill it properly.
Also remember to run `set_up_db.sql` on your database.

To build:
`./gradlew clean build`

To run:

    . ./jdbc_settings.sh #can be run once per terminal
    ./gradlew bootRun

This is using https://spring.io/guides/gs/rest-service/ which runs on Tomcat underneath via spring boot.
With spring data access set up: https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html

No database requests:

  * https://vast-dawn-3751.herokuapp.com/greeting?name=Jerzy
  * https://vast-dawn-3751.herokuapp.com/greeting
  
Requests working with database:
  
  * https://vast-dawn-3751.herokuapp.com/db_greetings
  * https://vast-dawn-3751.herokuapp.com/db_greeting?id=x
  * https://vast-dawn-3751.herokuapp.com/db_greeting?content=Hello # PUT method

It can take a bit of time before first request after deploy is served.

If you want to deploy on your own heroku you need to:
  * https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku#introduction
  * add `Heroku Postgres :: Database`

I also suggest adding `Papertrail` for nice logs.

