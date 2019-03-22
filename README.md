Adidas Coding Exercise
----------------------

Introduction
------------

I have created a service that given an origin city & destiny city, will return a list of itineraries. One based in the less number of connections and the second based in the less time.

The solution has following modules:
-----------------------------------

1. config-service: 

	It maintains the configuration of all modules.
	Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system. 
	With the Config Server you have a central place to manage external properties for applications across all environments.
	
2. eureka-server: 

	Eureka Server is an application that holds the information about all client-service applications. 
	Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each             port and IP address. 
	Eureka Server is also known as Discovery Server.
	In our scenario this eurkea-server has two client airline-data-service and airline-business-service.
	
3. airline-data-service: 

	It expose all airline data defined with : city, destiny city, departure time, arrival time, stored in database.
	It has one API:
	
		i)/airlines
		
4. airline-business-service: 

	It consume the airline-data-service API in order to calculate the sortest way( in time and in
	connections ) to travel from one city to another , independent of the departure time.
	Have used SimpleDirectedWeightedGraph of JGraphT and Bellman-Ford algorithm to get the shortest path.
	JGraphT is an open-source Java class library which provides us with various types of graphs and also many useful algorithms for         solving most frequently encountered graph problems.
	It has following two APIs
	
		i)/shortestTime
		
		ii)/shortestConnection
		
5. mysql-database: 

	mysql database service.
	
6. auth-service: 
	
	It is authorization service using JWT.
		
7. gateway-service: 

	It is entrypoint to this application. 
	

Steps to run the application
--------------------------------

Build Project
-------------
mvn clean install -DskipTests=true
 
Build containers using docker command
-------------------------------------

docker build -t adidas/config-service:1.0.0 ./config-service

docker build -t adidas/gateway-service:1.0.0 ./gateway-service

docker build -t adidas/eureka-server:1.0.0 ./eureka-server

docker build -t adidas/auth-service:1.0.0 ./auth-service

docker build -t adidas/airline-data-service:1.0.0 ./airline-data-service

docker build -t adidas/airline-business-service:1.0.0 ./airline-business-service

docker build -t mysql-database ./mysql-database


Execute docker-compose.yml
--------------------------
docker-compose up --no-start

Start containers in sequence
----------------------------

docker start -a config-service   

docker start -a eureka-server

docker start -a auth-service

docker start -a mysql-database

docker start -a airline-data-service

docker start -a airline-business-service

docker start -a gateway-service

_____________________________________________________________________________________________________



URLs of the Application:
------------------------
Swagger:
-------
http://192.168.99.100:8080/swagger-ui.html


Eureka Server:
--------------

http://192.168.99.100:8761/ 


Hystrix:
--------

http://192.168.99.100:8080/hystrix

http://192.168.99.100:8080/airlines/actuator/hystrix.stream


STEP 1:Generate JWT Token
------------------------

http://192.168.99.100:8080/login 


POST API
--------

Sample request:
---------------

{"username":"adidas","password":"adidas"}



STEP 2:Add Generated JWT token to header
---------------------------------------
 e.g. Key = Authorization
      Value = Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZGlkYXMiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNTUzMjI4MTk2LCJleHAiOjE1NTMzMTQ1OTZ9.IA8TgS6e3sgHAc1gpVCxlF-no50d7iVX01S_4Zx0c4E
      
      
 
 STEP 3: Execute the request
 ---------------------------


i) http://192.168.99.100:8080/airlines/shortestConnection

POST API
-------

Sample request:
---------------

{
    "originCity": "Delhi",
    "destinyCity": "Chennai"
}


Sample Response:
---------------

{
    "path": [
        "Delhi",
        "Mumbai",
        "Chennai"
    ]
}




ii) http://192.168.99.100:8080/airlines/shortestTime

POST API
-------

Sample request:
---------------

{
    "originCity": "Delhi",
    "destinyCity": "Chennai"
}


Sample Response:
---------------

{
    "path": [
        "Delhi",
        "Bangalore",
        "Chennai"
    ]
}
