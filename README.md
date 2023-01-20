# microservices-communication, discovery and fault tolerance
<img style="text-align:center" src="https://user-images.githubusercontent.com/81709725/213630593-3b7d6e17-e128-4d84-96ba-5662be7cf32e.png" width=800px height=400px/>


#

- Creating a few microservices with Spring Boot and Spring cloud and have them communicate with each other. 
- In the process, we'll understand how inter-service communication work, and we'll implement service discovery with Eureka to facilitate services finding each other to communicate.

#

# Rest Template
Spring's RestTemplate is a convenient way for a microservice to communicate with other microservices using HTTP. It can be used to make both synchronous and asynchronous requests, and supports many features 
such as request and response customization, error handling, and automatic serialization/deserialization of request and response bodies. 

## Example  
```
@Autowired
private RestTemplate restTemplate;

public User getUser(Long id) {
    String url = "http://userservice/users/" + id;
    User user = restTemplate.getForObject(url, User.class);
    return user;
}
```
In this example, the RestTemplate is autowired into the class, allowing it to be used to make requests to other services. 
The getUser method makes a GET request to the URL http://userservice/users/{id} using the getForObject method, passing in the user ID as a path variable. 
The response from the other service is automatically deserialized into a User object, which is returned by the method.

# 

# Service Discovery
Service discovery is a way for microservices to locate other microservices at runtime. 
This is important because it allows microservices to be deployed and scaled independently, without the need for hard-coded IP addresses or hostnames.
The most common service discovery tool used in microservices architecture is Eureka. 
Eureka is an open-source service registry developed by Netflix. It is built using Java and Spring Boot, and is designed to be highly available and fault-tolerant.

## Create Eureka Server
- > Create maven project and add the required dependencies such as spring-cloud-starter-netflix-eureka-server and spring-boot-starter-test
- > Create application.properties and add server.port="give any value default 8761",eureka.client.register-with-eureka=false,eureka.client.fetch-registry=false
- > Add EnableEurekaServer annotation in your Application class.
- > Finally run the application class and hit the url http://localhost:8761

#

# Fault tolerance
Fault tolerance is the ability of a system to continue operating properly in the event of the failure of one or more of its components. In microservices architecture, fault tolerance can be achieved through several solutions, including:

* Circuit Breakers: Hystrix is a popular library that can be used to implement circuit breakers in microservices. It allows developers to define fallback mechanisms and properties to control the behavior of the circuit breaker.
* Bulkheads: Bulkheads are a pattern that isolates different parts of the system, so that a failure in one part does not affect the entire system. This can be achieved by isolating resources such as threads, connections, or memory.
* Fallback: Fallback is a mechanism to provide an alternative action when a service call fails. This can be achieved by using libraries such as Hystrix.
* Load Balancing: Load balancing can be used to distribute the load across multiple instances of a service, so that if one instance fails, the load can be redirected to other instances.
* Service discovery: In microservices, service discovery helps to locate instances of a service, so that if one instance fails, the client can redirect the requests to another instance.

#

# Hystrix
- Hystrix is a latency and fault tolerance library designed by Netflix. 
- It is designed to stop cascading failures in a distributed system, and provides fallback options, circuit breakers, and monitoring.
- Hystrix also provides a dashboard for monitoring the state and health of all circuit breakers in an application, which can be useful for identifying and troubleshooting potential issues.
- Hystrix can be integrated with Spring Boot by adding the spring-cloud-starter-netflix-hystrix dependency to the project and annotating the service class or 
  method with the @HystrixCommand annotation.
- Adding Hystrix and adding a fallback setup and use the Hystrix dashboard web application to see metrics about our circuit breakers.
