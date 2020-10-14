
### create db and tables
### generate the public and private key using open ssl cmd refer the doc in help

* $ cd src/main/resources
### To generate the keys
* $ openssl genrsa -out jwt.pem 2048

### To fetch the private keys
* $ openssl rsa -in jwt.pem
* NOTE COPY THE PRIVATE KEY TO CONFIGURATION SERVER

### to Fetch the public key
* $ openssl rsa -in jwt.pem -pubout
* NOTE COPY THE PUBLIC KEY TO CONFIGURATION SERVER

----
* $ cd src/main/resources
* $ pwd
````
springboot-oauth-jwt-server/src/main/resources
````

* $ openssl genrsa -out jwt.pem 2048
````
Generating RSA private key, 2048 bit long modulus
............................................................+++
................+++
e is 65537 (0x10001)
````

* $ openssl rsa -in jwt.pem
````
writing RSA key
-----BEGIN RSA PRIVATE KEY-----
MIIEowIBAAKCAQEAomA12xUrnwcWgQHM+pdvJr6P/fWwmMSwOWiRfcheKGC3Scv0
bEZjl+uQe8qUSGwkoegme6zddmaq5jZRYgKlEOrK7IZxuhKBqKYm5XtALaKHDT13
bc9L1OAyoZz510W4RoXLR346khYdazFJ64EddUd+Y9+JKnSC1GKDyg4S+w4kJwOJ
TSRPxnYa4yKaNumxNVqT+w3HEpT0WRlYCkP1aPrtmoYvBClR7eiezeJKKWrmMXPY
o/7ETZVSNJeVz9Hq/gT3U/gpxqgkvJjWmQT1O9FxSEfcCnNmoREkWkvhNxrYjE9n
tCbrOMtWZHsc4cefKeGaXPzFuukq+Siw49SEjQIDAQABAoIBAD3kuIKjBjafCAfy
vMSEdrzpBJAEV+VTi+zGHDc66hEwFI2PrcKb7hiZlUBqjq0wc6I3kHux/9TC+7+2
0ryuT2csaF9SPAV2SnATrV3p5iO/AQWd+WklDD2/m+0Yne9dxwkytLKyvfazcVFL
v2aCl8z9jILbUTiaosf8KUoapUeGl94BRR6tWLl6tPgaB1/PWiAg2qzEdiSWuGb4
ax9jD5gv5H9F2a6+xvJ/qzwtQ/lDbrWEHnNls0A6aZp87DWPH8CQ4DUgRgZ1/p3/
VF9nr4ylB6YJqr7GPxGZXj/tTvIk2LegR9zisUI1CbmnninlN8rdjfJixvnunR5j
HVlY7M0CgYEA03qT/VvyezlkRo3iblXZs0u8zmk5xz21Icu5wN9iATd2Qf6qeB8A
R9vlBaQfHlpRAidDzsIbMxl/2WJ5uMRKK5s0/HhWbV1+QS188grLHmo+6oKZCJZ8
94Uvk7GR1MUBxpgsmmFeFTeAzIc5ExlHyFhA4f/09Pkp1M2X26vo/B8CgYEAxI9H
hHt5OPXuS7YiHrj/FWqDYB7Td6XuOx+0EoMK350DNpkOmvv82AHQ9NoHivbrfTQq
EyF+0yYRf17AfRxNbzsgZYmSo7IjTxwRXVF3WMm3dNu+QEpLkwIs2MztLRcr4vE0
gVWWMz2OLLRtYMLb8w+XttuK1Ghzz1Rr2fAcadMCgYBroCF6unWgQqgGxCStdGGT
vwK6pZCzFnN9XJoPT2AoMFqt4XZOJbDV4VIf2dPAdcRubR80NVL0YZDQSC6cWsFI
ifegWXnatM8RSp4g7F9M/lNAs/BAD55PtedtqdwGxbBOqplghBcGgzW4YUUptB71
Ff0HR2UZ20hvtaYINOggjwKBgCIsTuDHnsG6cB2VosT4oNCWXhTeByHsJUj+MA5v
3foWkDJz1cg4OzNKzYtkRJ9yYmq4IQCGeEg5fB1K2ehmfUfzXaSJkIcJN35PgO1a
dodnOpAEjEUdJZp/bFCdADcwqh6glOJPgPeToh4/mCyUdC0D7vqJnM9lAY1wPff7
+NSlAoGBAMq9zFMiUXz6QNZv7rAVp2QDjFa+GBk+l2E3wq5MGg6932q2SFxzTjVN
dtjVtIUNXvp9kRCkBCQnyvzxNsnn1AhfDnnaVjzwv5RdBoBecj2su6D4CLGQsgDF
QlHUqIHOqzqUD8mj3HD+d2rRZg8WbNd09xWL1sm+uri4PjMSDRMc
-----END RSA PRIVATE KEY-----
````

* $ openssl rsa -in jwt.pem -pubout
````
writing RSA key
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAomA12xUrnwcWgQHM+pdv
Jr6P/fWwmMSwOWiRfcheKGC3Scv0bEZjl+uQe8qUSGwkoegme6zddmaq5jZRYgKl
EOrK7IZxuhKBqKYm5XtALaKHDT13bc9L1OAyoZz510W4RoXLR346khYdazFJ64Ed
dUd+Y9+JKnSC1GKDyg4S+w4kJwOJTSRPxnYa4yKaNumxNVqT+w3HEpT0WRlYCkP1
aPrtmoYvBClR7eiezeJKKWrmMXPYo/7ETZVSNJeVz9Hq/gT3U/gpxqgkvJjWmQT1
O9FxSEfcCnNmoREkWkvhNxrYjE9ntCbrOMtWZHsc4cefKeGaXPzFuukq+Siw49SE
jQIDAQAB
-----END PUBLIC KEY-----
````
````
$ curl --location --request POST 'localhost:9090/oauth/token' \
  --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'grant_type=password' \
  --data-urlencode 'username=adarsh' \
  --data-urlencode 'password=adarsh'
````
````
$ curl --location --request GET 'localhost:9090/oauth/check_token?token=<JWT-TOKEN-VALUE>' \
  --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ='
````
````
 $ curl --location --request POST 'localhost:9090/oauth/token' \
   --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ=' \
   --header 'Content-Type: application/x-www-form-urlencoded' \
   --data-urlencode 'grant_type=password' \
   --data-urlencode 'username=radha' \
   --data-urlencode 'password=radha'
````
````
 $ curl --location --request GET 'localhost:9090/oauth/check_token?token=<JWT-TOKEN-VALUE>' \
  --header 'Authorization: Basic ZXNwYXJrLWFwcDpzZWNyZXQ='
````





