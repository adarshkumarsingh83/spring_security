
### build both authentication server and resource server 
* $ mvn clean package


### execute both authentication server and resource server 
* $ mvn spring-boot:run


### get the token from the authentication server
````
$ curl --location --request POST 'localhost:9090/oauth/token' \
--header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=admin' \
--data-urlencode 'password=admin'
````

### To check the token details
````
* $ curl localhost:9090/oauth/check_token?token=<xxxxxxxxxxxx>
````

### To fetch the service at the resource Server
```` 
$ curl --location --request GET 'http://localhost:8181/api/employees' \
--header 'Authorization: Bearer 73c93e70-0ec5-44c3-8ec2-0bb094a4e7d3'
````

### To fetch the message service where only authentication is required
```` 
not permission but READ ACCESS in token 
$ curl --location --request GET 'http://localhost:8181/api/message' \
--header 'Authorization: Bearer 12f6a35b-0465-41f1-b6e4-744857c01097' 
````

### After Executing the springboot-sso-auth-ui
```` 
for home page in browser 
http://localhost:8080/

use admin:admin in secure page for data fetching successful
use user:user in secure page for date fetching failure 
````

