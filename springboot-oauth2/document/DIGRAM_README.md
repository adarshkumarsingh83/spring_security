````

     +--------+                               +---------------+
     |        |--(A)- Authorization Request ->|   Resource    |
     |        |                               |     Owner     |   // hit the url response with directional url
     |        |<-(B)-- Authorization Grant ---|               |
     |        |                               +---------------+
     |        |
     |        |                               +---------------+
     |        |--(C)-- Authorization Grant -->| Authorization |
     | Client |                               |     Server    |   // login into the login window and get the code
     |        |<-(D)----- Access Token -------|               |   // use code to get the token
     |        |                               +---------------+
     |        |
     |        |                               +---------------+
     |        |--(E)----- Access Token ------>|    Resource   |
     |        |                               |     Server    |  // hit the resource with the token and get response
     |        |<-(F)--- Protected Resource ---|               |
     +--------+                               +---------------+


      (A)  The client requests authorization from the resource owner.  The
             authorization request can be made directly to the resource owner
             (as shown), or preferably indirectly via the authorization
             server as an intermediary.

        (B)  The client receives an authorization grant, which is a
             credential representing the resource owner's authorization,
             expressed using one of four grant types defined in this
             specification or using an extension grant type.  The
             authorization grant type depends on the method used by the
             client to request authorization and the types supported by the
             authorization server.

        (C)  The client requests an access token by authenticating with the
             authorization server and presenting the authorization grant.

        (D)  The authorization server authenticates the client and validates
             the authorization grant, and if valid, issues an access token.

        (E)  The client requests the protected resource from the resource
             server and authenticates by presenting the access token.

        (F)  The resource server validates the access token, and if valid,
             serves the request.


  +--------+                                           +---------------+
  |        |--(A)------- Authorization Grant --------->|               |
  |        |                                           |               |
  |        |<-(B)----------- Access Token -------------|               |
  |        |               & Refresh Token             |               |
  |        |                                           |               |
  |        |                            +----------+   |               |
  |        |--(C)---- Access Token ---->|          |   |               |
  |        |                            |          |   |               |
  |        |<-(D)- Protected Resource --| Resource |   | Authorization |
  | Client |                            |  Server  |   |     Server    |
  |        |--(E)---- Access Token ---->|          |   |               |
  |        |                            |          |   |               |
  |        |<-(F)- Invalid Token Error -|          |   |               |
  |        |                            +----------+   |               |
  |        |                                           |               |
  |        |--(G)----------- Refresh Token ----------->|               |
  |        |                                           |               |
  |        |<-(H)----------- Access Token -------------|               |
  +--------+           & Optional Refresh Token        +---------------+

 (A)  The client requests an access token by authenticating with the
        authorization server and presenting an authorization grant.

   (B)  The authorization server authenticates the client and validates
        the authorization grant, and if valid, issues an access token
        and a refresh token.

   (C)  The client makes a protected resource request to the resource
        server by presenting the access token.

   (D)  The resource server validates the access token, and if valid,
        serves the request.

   (E)  Steps (C) and (D) repeat until the access token expires.  If the
        client knows the access token expired, it skips to step (G);
        otherwise, it makes another protected resource request.

   (F)  Since the access token is invalid, the resource server returns
        an invalid token error.

   (G)  The client requests a new access token by authenticating with
        the authorization server and presenting the refresh token.  The
        client authentication requirements are based on the client type
        and on the authorization server policies.

   (H)  The authorization server authenticates the client and validates
        the refresh token, and if valid, issues a new access token (and,
        optionally, a new refresh token).
````