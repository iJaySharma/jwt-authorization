# techwon-jwt-authorization

## Description
This project contains :
1) Rest APIs to manage Company
2) Rest APIs to manage Team

## Project Architecture 
This project is built using the following technologies 
1) Java 
2) Spring Boot
3) Spring Security 
4) Swagger
5) Maven

## To Run this project 
1) run mvn clean install on root
2) execute cmd mvn spring-boot:run 


## How to access the application 
1) Hit actuator end point :http://localhost:8080/actuator/health to verify the application is up and running 
2) Launch swagger url : http://localhost:8080/swagger-ui.html
3) Generate jwt token from authController /login endpoint 
4) Use the "Bearer <jwttoken>" in Autorization header to access rest of the end point.
  
  
<b>List of user</b>
1) User1 : username = user1 and password = 1234 with role ADMIN and TEAM_MEMBER
1) User2 : username = user2 and password = 1234 with role TEAM_MEMBER  






















