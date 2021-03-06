# Transport Layer Security(TLS )
----
```
client must be notified by server that server is TLS enabled so they used different port 
like 443 https. 
once client and server have agreed to use TLS, they negotiate a stateful connection by using 
a handshaking procedure.The protocols use a handshake with an asymmetric cipher to establish
 not only cipher settings but also a session-specific shared key with which further 
 communication is encrypted using a symmetric cipher. During this handshake, the client 
 and server agree on various parameters used to establish the connection's security:
 ```
* 1. The handshake begins when a client connects to a TLS-enabled server requesting a secure 
 connection and the client presents a list of supported cipher suites 
 
* 2. From this list, the server picks a cipher and hash function that 
 it also supports and notifies the client of the decision.
 
* 3.The server usually then provides identification in the form of a digital certificate. 
 The certificate contains the server name, the trusted certificate authority (CA) 
 that vouches for the authenticity of the certificate, and the server's public encryption key.
 
* 4.The client confirms the validity of the certificate before proceeding.
 
* 5.To generate the session keys used for the secure connection, the client either

``` 
 @ encrypts a random number with the server's public key and sends the result to the server 
 (which only the server should be able to decrypt with its private key); both parties then 
 use the random number to generate a unique session key for subsequent encryption and
  decryption of data during the session
  
 @ uses Diffie–Hellman key exchange to securely generate a random and unique session key 
 for encryption and decryption that has the additional property of forward secrecy: 
 if the server's private key is disclosed in future, it cannot be used to decrypt
  the current session, even if the session is intercepted and recorded by a third party.
  
This concludes the handshake and begins the secured connection, which is encrypted 
and decrypted with the session key until the connection closes.  
TLS handshake fails and the connection is not created.
```