
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
