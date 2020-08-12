

----
### Entities 
----
```
Resource : Actual Resource eg (Product,Customer or Employee)

Resource Server : Server which hold the Resource with it 

Resource Owner : is the person who has authorities to grant persimmon to client for access 

Auth Server : who do the authentication of the resource owner and confirm the consensus for
				 sharing resource with client

Client : is the app who wants to access the resource hold by resource server 
```

----
### Terms in OAuth
----
```
Access Token: access token represents the authorization of a client application to access 
	    specific parts of a resource of resource owner  
	    
Refresh Token : its a token to get the new token when access token is expired. 

Client_id/Secret : client_id is a public identifier for apps
			client_secret is a secret known only to the application and the authorization server
			
Scope:  limit an client access to resources of the resource owner. 

Jwt : a way to pass the information in encrypted manner 
```

----
### Grant Type 
----
```
Authorization code : Authorization Code grant type is used by confidential and public
					 clients to exchange an authorization code for an access token.
					 After the user returns to the client via the redirect URL, 
					 the application will get the authorization code from the URL and 
					 use it to request an access token
					 
Client Credentials :  grant type is used by clients to obtain an access token outside 
					of the context of a user. typically used by clients to access resources 
					about themselves rather than to access a user's resources.
					
Refresh Token :   grant type is used by clients to exchange a refresh token for an access 
				  token when the access token has expired.							
				  					
Device code :    browserless or input-constrained devices in the device flow to exchange 
				 a previously obtained device code for an access token.
				 
Implicit:   :    the access token was returned immediately without an extra authorization
				  code exchange

Password    :	 Password grant type is a way to exchange a user's credentials for an 
					access token. Because the client application has to collect the user's 
					password and send it to the authorization server				 

```

----
### SPRING BOOT APPLICATIN DEVELPMENT HELP
----
```
* 1. POM.XML DEPENDENCY 

     <properties>
		<spring-cloud.version>Hoxton.SR3</spring-cloud.version>
	</properties>
	
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-security</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-oauth2</artifactId>
	</dependency>
		
<dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
		  		<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
</dependencyManagement>


----
* 2.GENERATE KEYS 

## Generate key store file
  this will generate jwt.jks which contains public and private keys
 $ cd src/main/resources/
 $ keytool -genkeypair -alias jwt -keyalg RSA --keypass password -keystore jwt.jks --storepass password

## Moving to PKCS12
  this cmd will prompt for key-store password
  after execution this cmd will generate jwt.jks copy that file to resource dir of application
 $ keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.jks -deststoretype pkcs12

## export the public key
  after execution of this cmd copy the public key from save for resource server config
  ---- BEGIN PUBLIC KEY ------
  			XXX
  			XXX
  ----- END PUBLIC KEY -------
 $ keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey

NOTE :
COPY THE JKS FILE IN THE RESOURCE DIR OF THE AUTH-SERVER 
COPY THE PUBLIC KEY FOR THE RESOURCE-SERVER
----

### STEP 3 CREATE DATABASE AND TABLE 

----

STEP 4 CREATE CONFIG CLASS FOR SECURITY 
 extends class from WebSecurityConfigurerAdapter and annotate with @EnableWebSecurity
 override configure method for setting up user details service and password encoder 
 create pwd encode 
 crete user details service 
 create authentication manager 
 
----
### STEP 5. CREATE CONFIG CLASS FOR OAUTH SERVER 
----
```
