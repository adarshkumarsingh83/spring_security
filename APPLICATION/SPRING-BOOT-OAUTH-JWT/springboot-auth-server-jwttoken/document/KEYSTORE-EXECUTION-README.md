
### EXAMPLE
````
 $ keytool -genkeypair -alias jwt -keyalg RSA --keypass password -keystore jwt.jks --storepass password
 What is your first and last name?
   [Unknown]:  adarsh kumar
 What is the name of your organizational unit?
   [Unknown]:  espak org
 What is the name of your organization?
   [Unknown]:  espark edu
 What is the name of your City or Locality?
   [Unknown]:  dallas
 What is the name of your State or Province?
   [Unknown]:  tx
 What is the two-letter country code for this unit?
   [Unknown]:  us
 Is CN=adarsh kumar, OU=espak org, O=espark edu, L=dallas, ST=tx, C=us correct?
   [no]:  yes

 Warning:
 The JKS keystore uses a proprietary format. It is recommended to migrate to PKCS12 which is an industry standard format using "keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.jks -deststoretype pkcs12".
````

### EXAMPLE
````
$ keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.jks -deststoretype pkcs12
Enter source keystore password:
Entry for alias jwt successfully imported.
Import command completed:  1 entries successfully imported, 0 entries failed or cancelled

Warning:
Migrated "jwt.jks" to Non JKS/JCEKS. The JKS keystore is backed up as "jwt.jks.old".
$
````

### EXAMPLE
````
$ keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey
Enter keystore password:  password
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtTjXLEch9eU6ujI9CJ2S
b2Ba/q9KXtYAUtNNzBhULspEafg0SQRxPGAM3q5B42kXak5kFy2zCgB6sdJLUUfK
rKYIHThn0JICQcVvCSsLXvINhezjmwnKzo1stk0fThH44HspQUh7qSj51Wo/SDKs
toi0C+WUP20vR1F2L9jh7ezMkb4oGO3CjGTvg9wAAOPl0R+AQFCzNXJE4MieO9iM
qEAMPE4Xsn6RbjcQJtk0lKr1EJ+Vm5uk+8w5GURDzCldbaxccvyzgxY9YcvYedXE
pcdxA+dvG73pOauEUFWoXnGiNeC4rwuG16dz595a1iIt6JwPriWEGMaK2ADVdGhJ
ZwIDAQAB
-----END PUBLIC KEY-----
-----BEGIN CERTIFICATE-----
MIIDdTCCAl2gAwIBAgIEYi+IBDANBgkqhkiG9w0BAQsFADBrMQswCQYDVQQGEwJ1
czELMAkGA1UECBMCdHgxDzANBgNVBAcTBmRhbGxhczETMBEGA1UEChMKZXNwYXJr
IGVkdTESMBAGA1UECxMJZXNwYWsgb3JnMRUwEwYDVQQDEwxhZGFyc2gga3VtYXIw
HhcNMjAwNDE5MDUyMDEzWhcNMjAwNzE4MDUyMDEzWjBrMQswCQYDVQQGEwJ1czEL
MAkGA1UECBMCdHgxDzANBgNVBAcTBmRhbGxhczETMBEGA1UEChMKZXNwYXJrIGVk
dTESMBAGA1UECxMJZXNwYWsgb3JnMRUwEwYDVQQDEwxhZGFyc2gga3VtYXIwggEi
MA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC1ONcsRyH15Tq6Mj0InZJvYFr+
r0pe1gBS003MGFQuykRp+DRJBHE8YAzerkHjaRdqTmQXLbMKAHqx0ktRR8qspggd
OGfQkgJBxW8JKwte8g2F7OObCcrOjWy2TR9OEfjgeylBSHupKPnVaj9IMqy2iLQL
5ZQ/bS9HUXYv2OHt7MyRvigY7cKMZO+D3AAA4+XRH4BAULM1ckTgyJ472IyoQAw8
TheyfpFuNxAm2TSUqvUQn5Wbm6T7zDkZREPMKV1trFxy/LODFj1hy9h51cSlx3ED
528bvek5q4RQVahecaI14LivC4bXp3Pn3lrWIi3onA+uJYQYxorYANV0aElnAgMB
AAGjITAfMB0GA1UdDgQWBBRgGOuhSdpGtx93wAej8z0BZrBRnDANBgkqhkiG9w0B
AQsFAAOCAQEAnYrSpFB0WZIY0ziM7xjBH8gLZKqMGkXhCuobTDSXzQZb5b2K3xne
y5gonR0AHUMElH5vRp1GHBetI3I0NONSEJ0qkCbf/ZnQmnUlTePfOWWm0V+6VJdC
14XnQGG/+6HIqOiOu4260CMloJsUGLTbM4AKiLMRB+cewxqRapg/2uOGYkWGOryv
pQBaEvBlZfyGB1e3HjfavpkEkQaU1ZpzyuaHMWKOGcYUPVkYjiiFEGI7npkGXgHo
JpO47n2DK+QvO0t5sdFCQUnx1Q6qjUIXEBv3invCdevq48Wso6hQ1YHGVvXRaA+E
bMZf3PhvwjM4pNaHd6vYu/lwfMM5ZtUMsw==
-----END CERTIFICATE-----
````