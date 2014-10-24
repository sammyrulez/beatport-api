beatport.com api client
=======================

This is Java client library for beatport.com api

To use this library you need to register an account at http://beatport.com and request a key/secret value.

Detalis at https://oauth-api.beatport.com/

Inizializing the client is very simple:

```java
final BeatportAuthService authService = new BeatportAuthService(apiKey, apiSecret);
final AuthorizationKey authorizationKey = authService.getAuthorizationKey();
String authorizationUrl =  authorizationKey.getAuthorizationUrl(); // user must visit this link in orther to obtain the activation code
...
final OauthHolder auth = authService.auth(code ,authorizationKey);

```
**OauthHolder** has a method **public Serializable persistableToken()** that let you store the token for invoke the service later on

```java
final BeatportService service = new BeatportService(token);
ApiQuery q =  new ApiQuery().addFilter("name", "deadmau5");
final Map<String, Object> artists = service.getArtists(q ); // access this map by api response fields names


```


See https://oauth-api.beatport.com/ for available parameters,filters and fields names for specific methods
