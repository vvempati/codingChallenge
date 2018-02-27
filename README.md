<p>An application to demonstrate the functionality of the following RESTful endpoints</p>
       ```GET localhost:8081/films
             lists all films and relevant metadata
	```
	```
	   GET localhost:8081/films/:id
               lists a single film, given the id
	```
	```POST localhost:8081/rating/:id
	       retrieves rating of single film if available
	       also retrieves films metadata 
	       accepts rating of single film from user 
	```
<p>How to access this application </p>
```
    Run ./gradlew build in terminal in the location of the project repository
    Copy & paste any of the URI's into browser
```
<p>How to run the tests for this application </p>
```
    Run ./gradlew test in terminal in the location of the project repository 
```
