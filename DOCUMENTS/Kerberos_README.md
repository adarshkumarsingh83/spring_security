# Kerberos flow 
![img](./image/Kerberos-flow.webp)

* Client requests an authentication ticket (TGT) from the Key Distribution Center (KDC)
* The KDC verifies the credentials and sends back an encrypted TGT and session key
* The TGT is encrypted using the Ticket Granting Service (TGS) secret key
* The client stores the TGT and when it expires the local session manager will request another TGT (this process is transparent to the user)

> If the Client is requesting access to a service or other resource on the network, this is the process:

* The client sends the current TGT to the TGS with the Service Principal Name (SPN) of the resource the client wants to access
* The KDC verifies the TGT of the user and that the user has access to the service
* TGS sends a valid session key for the service to the client
* Client forwards the session key to the service to prove the user has access, and the service grants access.