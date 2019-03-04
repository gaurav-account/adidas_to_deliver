Adidas Coding Exercise

Introduction

We want to create a service that given an origin city will return a list of itineraries , one based in the less number of connections and the second based in the less time.
The solution has following modules:
1. config-service
	It maintains the configuration of all modules.
	Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system. 
	With the Config Server you have a central place to manage external properties for applications across all environments.
	
2. eureka-server
	Eureka Server is an application that holds the information about all client-service applications. 
	Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address. 
	Eureka Server is also known as Discovery Server.
	In our scenario this eurkea-server has two client airline-data-service and airline-business-service.
	
3. airline-data-service
	It expose all airline data defined with : city, destiny city, departure time, arrival time, stored in database.
	It has one API:
		i)/airlines
		
4. airline-business-service
	It consume the airline-data-service API in order to calculate the sortest way( in time and in
	connections ) to travel from one city to another , independent of the departure time.
	Have used SimpleDirectedWeightedGraph of JGraphT and Bellman-Ford algorithm to get the shortest path.
	JGraphT is an open-source Java class library which provides us with various types of graphs and also many useful algorithms for solving most frequently encountered graph problems.
	It has following two APIs
		i)/shortestTime
		ii)/shortestConnection
5. mysql-database
	mysql database service.

Steps to execute the application

Build Project

mvn clean install -DskipTests=true
 
Build containers using docker command:

docker build -t adidas/config-service:1.0.0 ./config-service
docker build -t adidas/eureka-server:1.0.0 ./eureka-server
docker build -t adidas/airline-data-service:1.0.0 ./airline-data-service
docker build -t adidas/airline-business-service:1.0.0 ./airline-business-service
docker build -t mysql-database ./mysql-database


Execute docker-compose.yml

docker-compose up --no-start

Start containers in sequence

docker start -a config-service    
docker start -a eureka-server
docker start -a mysql-database
docker start -a airline-data-service
docker start -a airline-business-service



Prior to testing with docker containers I have tested by running each microservice through eclipe by running following classes in sequence and have configured mysql on local.
1. ConfigServiceApplication.java(config-service)
2. EurekaServerApplication.java(eureka-server)
3. AirlineDataServiceApplication.java(airline-data-service)
4. AirlineBusinessServiceApplication.java(airline-business-service)

URLs of the Application:
Swagger:
airline-business-service
http://localhost:8085/swagger-ui.html
http://192.168.99.100:8085/swagger-ui.html (when using docker)
airline-data-service
http://localhost:8090/swagger-ui.html
http://192.168.99.100:8090/swagger-ui.html(when using docker)

Eureka Server:
http://localhost:8761/
http://192.168.99.100:8761/ (when using docker)

airline-business-service
1. http://localhost:8085/shortestTime
http://192.168.99.100:8085/shortestTime(when using docker)

POST API
Sample request:
{
    "originCity": "Delhi",
    "destinyCity": "Chennai"
}
Sample Response:
{
    "path": [
        "Delhi",
        "Mumbai",
        "Chennai"
    ]
}
2. http://localhost:8085/shortestConnection
http://192.168.99.100:8085/shortestConnection (when using docker)
POST API
{
    "originCity": "Delhi",
    "destinyCity": "Kolkata"
}
Sample Response:
{
    "path": [
        "Delhi",
        "Mumbai",
        "Kolkata"
    ]
}

airline-data-service
1. http://localhost:8090/airlines
http://192.168.99.100:8090/airlines (when using docker)
GET API
[
    {
        "id": 1,
        "originCity": "Delhi",
        "destinyCity": "Mumbai",
        "departureTime": "10:40",
        "arrivalTime": "12:15"
    },
    {
        "id": 2,
        "originCity": "Delhi",
        "destinyCity": "Bangalore",
        "departureTime": "11:00",
        "arrivalTime": "19:30"
    },
    {
        "id": 3,
        "originCity": "Mumbai",
        "destinyCity": "Delhi",
        "departureTime": "09:15",
        "arrivalTime": "18:25"
    },
    {
        "id": 4,
        "originCity": "Mumbai",
        "destinyCity": "Bangalore",
        "departureTime": "11:00",
        "arrivalTime": "16:30"
    },
    {
        "id": 5,
        "originCity": "Mumbai",
        "destinyCity": "Chennai",
        "departureTime": "11:30",
        "arrivalTime": "15:30"
    },
    {
        "id": 6,
        "originCity": "Mumbai",
        "destinyCity": "Kolkata",
        "departureTime": "11:15",
        "arrivalTime": "16:55"
    },
    {
        "id": 7,
        "originCity": "Chennai",
        "destinyCity": "Mumbai",
        "departureTime": "01:40",
        "arrivalTime": "05:30"
    },
    {
        "id": 8,
        "originCity": "Bangalore",
        "destinyCity": "Chennai",
        "departureTime": "10:00",
        "arrivalTime": "19:00"
    },
    {
        "id": 9,
        "originCity": "Bangalore",
        "destinyCity": "Mumbai",
        "departureTime": "23:30",
        "arrivalTime": "08:20"
    },
    {
        "id": 10,
        "originCity": "Bangalore",
        "destinyCity": "Kolkata",
        "departureTime": "07:15",
        "arrivalTime": "18:30"
    }
]

