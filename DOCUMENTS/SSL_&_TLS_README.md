
## public and private key 
* 1.client can encrypt the data with server public key -----> only server can de-crypt the data from servers private key  
* 2.when server encrypt the data from its private key ------> then only client can de-crypt data from server public key 

```
when client browser request for https;//youtube.com then 
youtube server will return the youtube certificate which is signed by google and list of the 
the trusted Ca information is build in the browser, so browser know that certificate which is 
send by youtube is valid and respond back to the server saying i can trust you for communication. 


then client browser create a secret key encrypt by server public key which is their in the 
certificate send by server. and server can de-encrypt that data with its  private key 

then both are ready to transfer the data encrypt by new key shared by browser and both 
client and server have the keys to intercept the data for secure communication.
```


## TLS HANDSHAK
* 1.CLIENT send hello request to the server with 
(SSL or TLS version,Cryptography algo, Data compression )
* 2.SERVER responde with hello and 
(Cryptography algo, SessionId, Server Digital Certificat, Server public key)
* 3.CLIENT contact the Server CA for validating the Authenticity of the Server Certificate
 to build the trust between client and server 
* 4.Client Generate a Secret key and encrypt it with SErver public key.
* 5.Client Send the finish message in the encrypted with earlier shared key to finish the handshake 
* 6.Server will also send finish message to the Client encrypt with shared secret key to 
 acknowledge handshake finish 
* 7. once handshake is done then client and server can exchange the message encrypted with 
the keys shared earlier 




