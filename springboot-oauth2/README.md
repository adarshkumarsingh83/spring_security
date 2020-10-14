
### To build and run the application 
* $ mvn clean package
* $ mvn spring-boot:run

### Direct testing without authentication.
* $ curl -X GET --user espark:radha http://localhost:8080/api/users/me


### 1# hit the url in browser
````
http://localhost:8080/oauth/authorize?client_id=clientapp&response_type=code&scope=read_profile_info
````

### 2# provide the user name and pwd
````
user name => “espark”
user pwd => “radha”
````

### 3# Copy the redirect url
````
 http://localhost:8081/login?code=I8aQVA
````

----

### from postman
````
POST
http://localhost:8080/oauth/token

Headers:
Content-Type: application/x-www-form-urlencoded
authorization: Basic Y2xpZW50YXBwOjEyMzQ1Ng==

Form data - application/x-www-form-urlencoded:
grant_type=authorization_code
code=<EAR76A> //Code obtained in 3 step earlier
redirect_uri=http://localhost:8081/login

````

----

### 4#POST from the curl cmd
````
$ curl -X POST --user clientapp:radha http://localhost:8080/oauth/token        \
 -H "content-type: application/x-www-form-urlencoded"       \
 -d "code=4Dpm2g&grant_type=authorization_code&redirect_uri=http%3A%2F%2Flocalhost%3A8081%2Flogin&scope=read_profile_info"
````
* response 
````
{
  "access_token": "3def2a1b-ad0f-48d5-8776-e99e1b544d57",
  "token_type": "bearer",
  "refresh_token": "badb791a-b7f8-4203-b5b1-e4597923583a",
  "expires_in": 4999,
  "scope": "read_profile_info"
}
````

### 5# hit the service url using a "access_token" in step 4
````
$ curl -X GET http://localhost:8080/api/users/me \
     -H "authorization: Bearer 3def2a1b-ad0f-48d5-8776-e99e1b544d57"
````
* response 
````
{
  "name": "espark",
  "email": "espark@espark.com"
}
````