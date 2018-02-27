An application to demonstrate the functionality of the following RESTful endpoints
	1.GET localhost:8081/films
		1.lists all films and relevant metadata 
	2.GET localhost:8081/films/:id
		2.lists a single film, given the id
	3.POST localhost:8081/rating/:id
		3. retrieves rating of single film if available
		3. also retrieves films metadata 
		3. accepts rating of single film from user 
How to access this application 
	1. Run ./gradlew build in terminal in the location of the project repository
	2. Copy & paste any of the URI's into browser
How to run the tests for this application 
	1. Run ./gradlew test in terminal in the location of the project repository 
