# spring boot oauth h2db 

* $ mvn clean package 
* $ mvn spring-boot:run 

---

## Generate key store file
* this will generate jwt.jks which contains public and private keys
* $ cd springboot-oauth2-authentication-server
* $ cd src/main/resources/
* $ keytool -genkeypair -alias jwt -keyalg RSA --keypass password -keystore jwt.jks --storepass password

## Moving to PKCS12
````
 this cmd will prompt for key-store password
  after execution this cmd will generate jwt.jks copy that file to resource dir of application
````
 * $ keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.jks -deststoretype pkcs12

## export the public key
````
  after execution of this cmd copy the public key from console and save into the resource server config
  springboot-oauth2-resource-server/src/main/resources

  ---- BEGIN PUBLIC KEY ------
  			XXX
  			XXX
  ----- END PUBLIC KEY -------
````
* $ keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey -noout

````
NOTE :
  for help get check the file keystore-execution.txt
NOTE 
JWT.JSK FILE WILL BE COPIED TO THE OAUTH AUTHENTICAION SERVER RESORUCE DIR 
PUBLIC KEY WILL BE COPIED TO THE RESOURCE SERVER
````  
---

### TO GENERATE THE TOKEN FOR ADMIN
````
* $ curl --location --request POST 'localhost:9090/oauth/token' \
--header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=adarsh' \
--data-urlencode 'password=adarsh'
````

### TO VERIFY THE TOKEN FOR ADMIN
````
* $ curl --location --request GET 'localhost:9090/oauth/check_token?token=<TOKEN-VALUE>' \
--header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ='
````

### TO GENERATE THE TOKEN FOR USER
````
* $ curl --location --request POST 'localhost:9090/oauth/token' \
  --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'grant_type=password' \
  --data-urlencode 'username=radha' \
  --data-urlencode 'password=radha'
````

### TO VERIFY THE TOKEN FOR USER 
````
*  $ curl --location --request GET 'localhost:9090/oauth/check_token?token=<TOKEN-VALUE>' \
   --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ='
````

### TO HIT THE API ENDPOINT
```` 
* $ curl --location --request GET 'http://localhost:8181/api/employees' \
--header 'Authorization: Bearer <OAUTH-TOKEN-VALUE>'
````



