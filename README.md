# Phone App
Masmovil challenge

## Software requeriments for this project

+ Maven 4
+ JDK 8
+ Docker 18.06.1-ce

## Build and run

To build application run command `./mvn clean package`.
To run application run command `docker-compose up --build` and wait till all services will start.
Go to [discovery service](http://localhost:8761/eureka) and check that 4 services 
are registered.

## Services

This application has a microservices arquitechture with 2 microservice, one for Phone entity and one for Order Entity.
There is a Discovery service with Eureka, a Spring Cloud Config server and a gateway server with Zuul.
The application uses MySQL databases running on Docker containers.

### Ports
Discovery service: 8761.  
Gateway service: 8084.  
Config service: 8888.  
MySQL database for Phone service: 8083.  
Phone service: 8081.  
MySQL database for Order service: 8082.  
Order service: 8089.  

### Endpoints
###Phones
```
GET /phones
```
###Orders
```
POST /order
```

Request:

```
{
  "nombre":"Juan",
  "apellidos":"Gomez Gil",
  "email":"juan@gmail.com",
  "items":[2,3],
  "total":65.89
}
```
## Questions
- How would you improve the system?

Add documentation for the services with Swagger or another framework.

Add pagination to phone service when return the list of phones.

Add security to the system with JWT and OAuth.

Add exception and error management.

Deploy containers using and orchestrator like Kubernetes.


- How would you avoid your order API to be overflow?

Deploying microservices in a PaaS as AWT to manage the microservice demand and load balancing.