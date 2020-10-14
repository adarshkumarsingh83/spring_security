
### create db and tables

### generate the public and private key using open ssl cmd refer the doc in help
### [OPEN SSL KEY GENERATION DOCUMENT](https://github.com/adarshkumarsingh83/spring_security/blob/master/SPRINGBOOT-OAUTH-JWT/OpenSSL_RSA_Keypair.pdf)
* $ cd src/main/resources

### To generate the keys
* $ openssl genrsa -out jwt.pem 2048

### To fetch the private keys
* $ openssl rsa -in jwt.pem
* NOTE COPY THE PRIVATE KEY TO CONFIGURATION SERVER

### to Fetch the public key
* $ openssl rsa -in jwt.pem -pubout
* NOTE COPY THE PUBLIC KEY TO CONFIGURATION SERVER

### TO GET THE TOKEN FROM AUTH SERVER
```` 
$ curl --location --request POST 'localhost:9090/oauth/token' \
  --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'grant_type=password' \
  --data-urlencode 'username=adarsh' \
  --data-urlencode 'password=adarsh'
````
### TO VIEW THE DETAILS OF THE TOKEN FROM AUTH SERVER
```` 
$ curl --location --request GET 'localhost:9090/oauth/check_token?token=<JWT-TOKEN-VALUE>' \
  --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ='
  
NOTE WE CAN VERIFY THE AUTH TOKEN BY GOING TO 
https://jwt.io/
And provide the auth token public key and privat key to view the data into the token   
````

### TO FETCH THE DATA FROM RESOURCE SERVER
```` 
$ curl --location --request GET 'http://localhost:8181/api/employees' \
--header 'Authorization: Bearer <JWT-TOKEN-VALUE'
````

