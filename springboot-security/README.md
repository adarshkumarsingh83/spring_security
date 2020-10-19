
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
* $ curl -v -H "X-Token: <token>"   http://localhost:8080/api/message

### To access user details
* $ curl -v -H "X-Token: <token>"  http://localhost:8080/user/adarsh
  
````
{
  "data": {
    "id": 1,
    "userName": "adarsh",
    "password": null,
    "userRoles": [
      "ADMIN"
    ]
  },
  "message": "User Details"
}
````

### To Fetch the Employee Data 
* $ curl -v -H "X-Token: TOKEN-VALUE-XXX" http://localhost:8080/api/employees
````
{
  "data": [
    {
      "id": 1,
      "firstName": "adarsh",
      "lastName": "kumar",
      "career": "It"
    },
    {
      "id": 2,
      "firstName": "radha",
      "lastName": "singh",
      "career": "IT"
    },
    {
      "id": 3,
      "firstName": "sonu",
      "lastName": "singh",
      "career": "IT"
    },
    {
      "id": 4,
      "firstName": "amit",
      "lastName": "kumar",
      "career": "Finance"
    }
  ],
  "message": "All User Fetched Successfully"
}
````