
### To build 
* $ mvn clean package

### To run 
* $ mvn spring-boot:run

### to get the token
````
$ curl --location --request POST 'localhost:9090/oauth/token' \
--header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=admin' \
--data-urlencode 'password=admin'
````
* Response 
````
{
  "access_token": "c8c1505e-7330-48a2-a702-df2a6b75962a",
  "token_type": "bearer",
  "refresh_token": "c1f3fa55-4bd3-4707-8a24-e64e2955d0b6",
  "expires_in": 43042,
  "scope": "read write"
}
````

### To check the token details
* $ curl localhost:9090/oauth/check_token?token=<>
* $ curl localhost:9090/oauth/check_token?token=c8c1505e-7330-48a2-a702-df2a6b75962a
````
{
  "active": true,
  "exp": 1587195082,
  "user_name": "admin",
  "authorities": [
    "ROLE_ADMIN",
    "ROLE_USER"
  ],
  "client_id": "espark-app",
  "scope": [
    "read",
    "write"
  ]
}
````


