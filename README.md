# SpringBoot-SpringCloud-Microservices
Repository for SpringBoot-SpringCloud-Microservices Training

Swagger URL 

host:port/swagger-ui.html#/

Ex: http://localhost:8080/swagger-ui.html#/


# Spring Security Oauth need Roles, Insert below roles Before creating Users

- insert into roles values(1,'ROLE_USER');
- insert into roles values(2,'ROLE_ADMIN');

# Create user
![token generate/ user login ](https://github.com/HarshaVardhanAcharyAthaluri/SpringBoot-SpringCloud-Microservices/blob/main/usercreate.PNG)


# token generate/ user login
![Create user ](https://github.com/HarshaVardhanAcharyAthaluri/SpringBoot-SpringCloud-Microservices/blob/main/tokengenerate.PNG)

# access users
![access users ](https://github.com/HarshaVardhanAcharyAthaluri/SpringBoot-SpringCloud-Microservices/blob/main/accesusers.PNG)

# Docker Image Creation
docker build -f Dockerfile -t mydemoimage . ("." is current location)
# Running Docker Image
docker run -p 7070:7070 mydemoimage0

# insted of runing commands every time we can use docker-compose
- docker-compose -f docker-compose.yml up
- docker-compose -f docker-compose.yml down
