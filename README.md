# Code202 Challenge
> Spring Boot microservices
---
## Table of Contents
1. [Installation & Setup](#installation-setup)
2. [Configuration](#configuration)
3. [API Documentation](#openapi-specification)
---
## Installation & Setup
### Prerequisites
Before running this application, you will need to have the following tools installed:
- **Java 21** or higher (check the Java version you are using with `java -version`)
- **Maven**
- **IDE** (like [IntelliJ IDEA])
### Clone the repository
Clone the repository to your local machine:

HTTPS: `git clone https://github.com/SahitBerisha/code202-microservices.git`

or, SSH: `git clone git@github.com:SahitBerisha/code202-microservices.git`

Go to the project root directory: `cd code202-microservices`

### Setup Project Dependencies
Make sure you are in the working directory ex. for tender service change directory to: `cd tender-service`

Run this command: `mvn clean install`

To start the service: `mvn spring-boot:run`

Beware that you should run first the Tender service and thus create a tender before using any endpoints of Bid service because it depends on Tender service.

This is a sample to create a tender: 

`POST` `http://localhost:8081/api/v1/tenders` 

```
{
    "title": "first tender",
    "status": "OPEN"
}
```
### Starting Microservices with IntelliJ IDEA

After opening the project in IntelliJ IDEA, go to `File → Project Structure`, and for both modules set the SDK to Java 21.

To run multiple instances in a workspace, go to `Edit Configurations... → Modify options` (drop-down menu) `→ Allow multiple instances`

## Configuration
### Default Configuration (`src/main/resources/application.yml`)
```yaml
server:
  port: 8081 (8082 for Bid service)
spring:
  datasource:
    url: jdbc:postgresql://localhost:7432/tender
    username: user
    password: password
```
## OpenAPI Specification

You can find the OpenAPI Specification in the url:

for Tender APIs `http://localhost:8081/swagger-ui.html`

for Bid APIs `http://localhost:8082/swagger-ui.html`