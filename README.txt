Application Specifications:

The application should provide the following functionality:

RESTful endpoints for retrieving a list of films or an individual film
Support for allowing a user to rate a specific film
Include average rating for a film as one of its attributes
Requests and responses should follow the JSON API specification

I created this application using Vert.x(a modular library that allows you to 
easily build REST API's and dynamic applications) and Kotlin which is a Java
based language. I chose to use Kotlin because I am very familiar with it and 
it's very concise and interoperable with Java.

My gradle build file should download all the required dependencies(ex: SPEK 
the testing tool that I used) but it would be simple if the user were to 
have the gradle build tool or the IDE IntelliJ at their disposal. 

A simple gradle test or gradle build will work to run the application. 

I created RESTful endpoints for viewing the information related to a single 
film and for viewing a list of films. I also mocked out the services for these
functions since we aren't connecting the application to a database at this 
point. 
