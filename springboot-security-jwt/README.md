
### To build the application
* $ mvn clean package

### To run 
* $ mvn spring-boot:run

### To access endpoint 
* $ curl -v http://localhost:8080/api/message

### To get the login token 
````
$ curl -v -X POST -H "Content-Type: application/json" \
  -d '{"userName":"adarsh","userPwd":"adarsh"}' \
   http://localhost:8080/login
````
### To access endpoint with token 
````
$ curl -v -H "X-Token: <token>" \
  http://localhost:8080/api/message
````
