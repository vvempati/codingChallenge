An application to demonstrate the functionality of the following RESTful endpoints
	1.localhost:8081/films
		- lists all films and relevant metadata 
	2.localhost:8081/films/:id
		- lists a single film, given the id
	3.localhost:8081/rating/:id
		- retrieves rating of single film if available
		- also retrieves films metadata 
		- accepts rating of single film from user 
How to access this application 
	1. Run ./gradlew build in terminal in the location of the project repository
	2. Copy & paste any of the URI's into browser
How to run the tests for this application 
	1. Run ./gradlew test in terminal in the location of the project repository 
