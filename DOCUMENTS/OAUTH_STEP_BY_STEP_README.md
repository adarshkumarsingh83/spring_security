----
### Terms in OAuth

----
* Access Token : 
```
Refresh Token : its a token to get the new token when access token is expired. 
Client_id/Secret :
Scope : Allowed Permission 
Jwt : a way to pass the information in encrypted manner 
```

----
* Resource Owner
```
The user who authorizes an application to access his account. The access is limited to the scope.
Resource Server:
A server that handles authenticated requests after the client has obtained an access token.
```

----
* Client
```
An application that access protected resources on behalf of the resource owner.
Authorization Server
A server which issues access tokens after successfully authenticating a client and resource owner, and authorizing the request.
```

---

* Access Token
```
A unique token used to access protected resources
```

---
* Scope
```
A Permission
```

---
* JWT
```
JSON Web Token is a method for representing claims securely between two parties as defined in RFC 7519
```

---
* Grant type
```
A grant is a method of acquiring an access token
```

----
### Grant Type 

----
* Authorization code 
* Client Credentials
* Implicit
* Password
* Device code 
---

### Entities 

---
* Resource : Actual Resource eg (Product,Customer or Employee)
* Resource Server : Server which hold the Resource with it 
* Resource Owner : is the person who has authorities to grant persimmon to client for access 
* Auth Server : who do the authentication of the resource owner and confirm the consensus for sharing resource with client
* Client : is the app who wants to access the resource hold by resource server 

----
### OATH IN GENERIC APPLICATION

----

* 1.user login to the client application 
* 2.client-server will make request to client-auth-server for authentication 
* 3.client-auth-server will authentication user 
* 4.user will get access to the client application 
* 5.user proceed will action which required resource on the resource-server 
* 6.client-server will make request to the resource-server for access the resource 
* 7.resource-server will forward the request to the resource-auth-server which notified
 the resource owner saying that client-server want to access resource from resource-server
 and show the login window for the resource owner for login in to the resource-server 
* 8.resource owner will enter the credentials for the resource-server in login screen
* 9.resource-auth-server will take the credentials for authentication
* 10. then  resource-auth-server will authentication the resource owner 
* 11. then resource-auth-server will show the information about the resource which
 client-server want to access from the resource-server 
* 12.then resource owner will allow the access to the resource holding by the resource-server 
* 13.then resource-auth-server will generate a token which is authentication token 
* a then authentication token  will send to client-server 
* b then authentication token  is verified by client-server and respond back to the resource-server
* c then resource-serve with the help of the resource-auth-server will create a access token 
     with the access privilege to accces the resource on the resource-server.
* 14.then resource-auth-server will generate a token with appropriate access permissions 
* 15.this token will be given back to the client-server for further communications with resource-server 
* 16.then client-server will make a request to the resource-server with token provided by resource-server 
* 17.then resource-server will intercept the token and then send to the resource-auth-server for authentication 
* 18.once the token is verified then resource-server will grant access to the client-server request 
    to access the resource hold by resource-server 
* 19.resource-server will get the requested resource 
* 20 resource-server will return the requested resource resource will return to the client-server

### NOTE:
**CLIENT APPLICATION**
* 1.has client id and client secret
* 2.has the service url of the resource-server to fetch the resource
* 3.has resource-auth-server authorization url 
* 4.has resource-auth-server token generation url
* 5.has resource-auth-server token validation url
becoz client application is registed with the resource-auth-server already 
that is why client server know how how can it get the resource hold by resource-server 

**RESOURCE SERVER** 
* 1.has client id and client secret
* 2.has resource-auth-server token validation url

**RESOURCE AUTH SERVER**
* 1.has client id and client secret
* 2.has client scope which that what are the access privilege client application has 
* 3.has the client redirection url after authentication successful it has to redirect to it
* 4.has the grant types 
* 5.has the credentials for authentication 
* 6.has the roles for the users 

```
resource-owner will do operation on client-server which need resource from the 
resource-server becoz client-server is already register will the resource-server so some 
information about the client-server is already with resource-server and resource-auth-server
client-server will hit the url for accessing the resource from the resource-server that 
request will be forwarded to the resource-auth-server by resource-server for authentication 
resource-auth-server will see request is not authentication but it originated from the 
register client-server so it will check the client id and client secret and show to dialog 
login to the resource-owner saying that login for authentication once resource-owner login 
into the resource-auth-server then resource-auth-server will show the requested resource 
access page to the resource-owner and get the consensus from the resource-owner that 
is he allow to client-server to access the resource hold by resource server once 
resource-owner grant access then authentication token is generated and share by 
the client-server then client-server will make request to the resource-server for accessing 
the resource from the resource-server then again the resource-server  will again forward 
the request to the resource-auth-server for validating the token request and 
resource-auth-server will authenticate the request and then resource-server  
will respond back with the resource to the client-server 
```
 
---
###  OAUTH IN MICROSERVICES 

---
* 0.User is already authenticated 
* 1.User will make request to the api server for information related 
  to the personal academic and contact 
* 2.then api server internally make call to the micro-service-0 which has personal 
information but required academic and contact information from other micro-services
* 3.then micro-service-0 will make request to the authentication-server with the client-id 
* 4.then server will return the token with the access privilege to access the micro-service-1
* 5.then micro-service-0 will make a call to the micro-service-1 for
  accessing the academic information which is part of the token and 
  it will clearly specify that it has ready or write privilege 
* 6. micro-service-1 will verify the token and its access privilege and request resource 
and decide that request is valid resource or not if its valid then return the resource. 
* NOTE:if micro-service-0 will make a request to access the professional information and 
access privilege in token is not mentioned then micro-service-1 will deny the request to serve 
* 7.then the information of personale with academic is return to api-server
* 8.api-server will again make request to the micro-service-0 for personal information with contact 
* 9. micro-service-0 has personal information but it has to access the 
 contact information form micro-service-2 so it will make the 
 request to the authentication-server with the client-id 
* 10. authentication-server will check the client-id and then it wil return the token and 
 provide the access privilege in the token 
* 11. micro-service-0 will user the token and make a request to the micro-service-1
* 12. micro-service-2 will validate the token and also the access privilege and request for 
  resource and decide that weather the client which is micro-service-0 is elegible to 
  access the requested resource form micro-service-2 or not if the token has suffice 
  privilege then micro-service-2 will provide the resource as response to the micro-service-0
* NOTE:if micro-service-0 will make a request to access the address information and 
access privilege in token is not mentioned then micro-service-2 will deny the request to serve   
* 13.then micro-service-0 will return the information of the personal and contact to the 
  api-server 
* 14.then api-server will return the data to the client   

---
### JWT WORK IN AUTHENTICATIN 
---
* 1.user make a request to the resource-server for accessing the resource 
* 2.server will deny the request and instruct for login 
* 3.user will make a request to the server with valid credentials and pass the client-id in header 
* 4.resource-server will forward the request to the auth-server for authentication and authorization 
* 5.once the credentials are authenticated then the jwt token will be created which contains 
 user information and expiration data and other custom information and token will be signed 
 with the client-id secret which is already in the auth-server and return to the resource-server
 ```
 JWT-TOKEN: is a value token becoz it contains actual information values in it. 
 where as session token are referenced token wehre session is stored in server and 
 session id is referenced by the token in cookies 
 it has three part header,payload,signature
 
 xxx-header-xxx.xxx-payload-xxx.xxx-signature-xxx
 header contains(what is the type of token and algo to verify the signature)and encoded in base64 
 payload contains (id,name,issued time) and encoded in base64 
 signature contains(algo information which is used for signing the 
 json using the secret key which only server has)its also and encoded in base64 
 ```
* 6.then resource-server will take token and return back to the user 
* 7.user will make the request to the resource-server with the token and client-id 
* 8.resource-server will take token and forward that to the auth-server for 
 validated the token for expiry and signature.
* 9.auth-server  uses the client-id secret which is  already with the auth-server to
 get the user information form the token and validate the user information 
 and get the access privilege for the user based on the user information mentioned in token 
 and return back to the resource-server 
* NOTE: jwt always has only authentication not the authorization or acces privilege   
* 10.now resource-server has the access privilege which it will set to the security context 
of the application and check the original resource request by the user and fetch the resource
for the user 
* 11.resource-server will get the requested resource then create a http response 
* 12.resource-server will return the http response to the user and clear the security context
---
