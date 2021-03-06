### create db and table with data.sql script in the dir
### generate the jwt.jsk file with below steps
---
### Generate key store file
````
  this will generate jwt.jks which contains public and private keys
````
* $ cd src/main/resources/
* $ keytool -genkeypair -alias jwt -keyalg RSA --keypass password -keystore jwt.jks --storepass password

### Moving to PKCS12
````
  this cmd will prompt for key-store password
  after execution this cmd will generate jwt.jks copy that file to resource dir of application
````
* $ keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.jks -deststoretype pkcs12

### export the public key
````
  after execution of this cmd copy the public key from save for resource server config
  ---- BEGIN PUBLIC KEY ------
  			XXX
  			XXX
  ----- END PUBLIC KEY -------
 $ keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey

NOTE :
  for help get check the file keystore-execution.txt
````
----
### application cmd 
* $ mvn clean package
* $ mvn spring-boot:run

### To get the token with admin
````
$ curl --location --request POST 'localhost:9090/oauth/token' \
  --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'grant_type=password' \
  --data-urlencode 'username=adarsh' \
  --data-urlencode 'password=adarsh'
````

### to get the token with user only
````
$ curl --location --request POST 'localhost:9090/oauth/token' \
--header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=radha' \
--data-urlencode 'password=radha'
````

### To Validate token
````
$ curl --location --request GET 'localhost:9090/oauth/check_token?token=<TOKEN-VALUE>' \
  --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ='
````