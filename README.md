### employee-sample-microservice

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [IDEs](#ides)
* [Setup](#setup)

## General info
* This project is simple microservice demonstration using springboot/cloud and netflix.
* The main purpose is to demonstrate the benifites of:
	- Discovery service for services registery.
	- Gateway APIs.
	- Spring cloud configuration
	- Client proxy instead of spring rest template.
	- Load balancing.
	- Distributed tracing.
	- Zipkin-server for tracking.
	- Citcuit breaker
	
## Technologies
Project is created with:
* springboot 2.3.8.RELEASE
* spring cloud Hoxton.SR9
* JDK 11
* Netflix Eureka
* Netflix Openfeign
* Netflix Ribbon
* Netflix Zuul Gateway
* Netflix Sleuth
* Netflix Hystrix
* Zipkin-server
* RabbitMQ
* Maven 3.6
* H2 database
* MapStruct
* Lombok

## IDEs
* Spring Tool Suite 4.9.0.RELEASE
* ConEmu-Maximus5 

## Setup
| Server | Discovery-server | Gateway-server | Cloud-config-server |
|--------|------------------|----------------|---------------------|
| Port   |  8761            | 8762           | 8763                |

| service | employee         |
|---------|------------------|
| Port    |  8760            |

| service | commission       |
|---------|------------------|
| Port    |  8750            |
| Port    |  8751            |

# account-smaple-microservice