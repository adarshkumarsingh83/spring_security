
### To build the application
* $ mvn clean package

### To execute 
* $ mvn spring-boot:run

### To hit the swagger url
* http://localhost:8080/swagger-ui.html

### log into the homepage of db
* http://localhost:8080/h2-console
``` username, pwd , dburl and db driver class is mentioned in application.properties file ```

### To take h2 db backup in sql file 
* $ SCRIPT NODATA TO '/Users/us-guest/db.sql' 

### services testing 

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

### To Fetch the Employee Data 
* $ curl -v -H "X-Token: TOKEN-VALUE-XXX" \
      http://localhost:8080/api/employees
````
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Sat, 17 Oct 2020 16:55:00 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

[
    {
        "career": "It",
        "firstName": "adarsh",
        "id": 1,
        "lastName": "kumar"
    },
    {
        "career": "IT",
        "firstName": "radha",
        "id": 2,
        "lastName": "singh"
    },
    {
        "career": "IT",
        "firstName": "sonu",
        "id": 3,
        "lastName": "singh"
    },
    {
        "career": "Finance",
        "firstName": "amit",
        "id": 4,
        "lastName": "kumar"
    }
]
````