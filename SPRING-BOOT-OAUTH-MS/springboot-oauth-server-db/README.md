### to build the application
* $ mvn clean package

### To run 
* $ mvn spring-boot:run

### To generate the pwd
````
https://www.browserling.com/tools/bcrypt
10 round

client-id=espark-app
secret = $2a$10$gPMrEzS0XiIXK.Fxvb9kceAQ0vEqBX4TijX5lBn.gmKTzKUsa1GuK
````

### To get the token
````
$ curl --location --request POST 'localhost:8080/oauth/token' \
--header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=adarsh' \
--data-urlencode 'password=adarsh'
````

````
$ curl --location --request GET 'localhost:8080/oauth/check_token?token=d4763a09-5ae0-4726-8428-a38d6c669a59' \
  --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
  --header 'Cookie: JSESSIONID=91DFA4B5CCE62F0F8D5939E1BC607014'
````
