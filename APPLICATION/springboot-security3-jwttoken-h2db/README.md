
# spring boot h2-db

### to build the application
* $ mvn clean package

### To Run the application 
* $ mvn spring-boot:run

### log into the homepage of db
* http://localhost:8080/h2-console
```
username, pwd , dburl and db driver class is mentioned in application.properties file
```

### to get the all the employee 
* http://localhost:8080/employees
    * admin/admin

* http://localhost:8080/employee/1
  * admin/admin user/user 

* http://localhost:8080/wish/adarsh
  * no security api 



* https://www.allkeysgenerator.com/
  * encryption key 
    * select the 256-bit key & click on hex
      * copy the generated key 


### with admin credentials to get token
```  
curl --location --request POST 'http://localhost:8080/token' \
--header 'Content-Type: application/json' \
--data-raw '{"username":"admin","password":"admin"}'

```
* to investigate about the token 
  * https://jwt.io/

### to hit api with admin token 
```
curl --location --request GET 'http://localhost:8080/employees' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY3NDUxMzkwMCwiZXhwIjoxNjc0NTE1NzAwfQ.NYym_8qGyRuMEKkVm0aUGhsmvgU-BYDylb0_f1ttEJc'
```

### with user credentials to get token 
```
curl --location --request POST 'http://localhost:8080/token' \
--header 'Content-Type: application/json' \
--data-raw '{"username":"user","password":"user"}'
```

### to hit api with user token 
```
curl --location --request GET 'http://localhost:8080/employees' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjc0NTE0MTMzLCJleHAiOjE2NzQ1MTU5MzN9.Ehw1Qa6vx_MQcH72A8_GtGfadPvz6GlQ4xd-mScsWU0' 

{privilege=Insufficient Privilege, message=Access denied, timestamp=2023-01-23T16: 49: 26.622290}
```

