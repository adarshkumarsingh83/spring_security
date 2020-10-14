
### NOTE:MAKE SURE PUBLIC KEY IS COPIED IN RESOURCE SERVER OTHER WISE CHECK THE HELP DOC IN TEH SERVER DOCUMENT.

* $ mvn clean package 
* $ mvn spring-boot:run 


### to generate token
```` 
$ curl --location --request POST 'localhost:9090/oauth/token' \
--header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=adarsh' \
--data-urlencode 'password=adarsh'
````

### to validate token
```` 
$ curl --location --request GET 'localhost:9090/oauth/check_token?token=<JWT-TOKEN-VALUE>' \
--header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ='
````

### to Hit admin endpoint
````
$ curl --location --request GET 'http://localhost:8080/api/admin' \
--header 'Authorization: Bearer <JWT-TOKEN-VALUE>'
````

### To hit user endpoint
```` 
$ curl --location --request GET 'http://localhost:8080/api/users' \
--header 'Authorization: Bearer <JWT-TOKEN-VALUE>'
````

### without role endpoint
```` 
$ curl --location --request GET 'http://localhost:8080/api/common'
````