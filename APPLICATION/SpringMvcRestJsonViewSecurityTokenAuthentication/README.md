

# MYSQL DB DOCKER

### Download mongo docker image from docker hub
* $ sudo docker pull mysql

### To start mongo
* $ docker run --name <mysql-instance-name> -e MYSQL_ROOT_PASSWORD=<root-user-ped> -e MYSQL_DATABASE=<mysql-db-name> -d mysql:<5.6]>
* $ docker run -p 3306:3306 --name espark-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=espark  mysql:5.6

### interact with the database through the bash shell client.
* $ docker exec -it espark-mysql bash

---
### To Build and Run Application 
* mvn clean package
* mvn jetty:run
* crt+c

### jsp ui login page url

* http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/login.do

### LOGIN URL
* URL=http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/rest/authenticate/login

### SET IN THE HEADER PARAM
* Content-Type = application/json

* SET AS THE RAW TYPE JSON
````
{"username":"adarsh", "password":"adarsh"}
````

### SERVICE URL
* URL=http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/rest/employee/detail/all
* SET IN THE HEADER PARAM
```
Content-Type = application/json
Authentication-token = <TOKEN VALUE>
```
### LOGOUT URL
* URL=http://localhost:8080/SpringMvcRestJsonViewSecurityTokenAuthentication/rest/logout
* SET IN THE HEADER PARAM
````
Authentication-token = <TOKEN VALUE>
````
