# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)

After start com.vi.shorturl.ShorturlApplication.main()
You can fill some URLs object in DB (session). Application checks if short URL does not exist, will insert new object with new generated key and original URL (In the future you can expand the object with additional attributes, like click count, other things for statistical analysis)
with following call:
Call: 

localhost:8080/shorturls/url?url=www.anazon.com/page1.php

and you see new entry in db. You can see content of DB with following call:

localhost:8080/shorturls/

And to find origin URL you can:

localhost:8080/shorturls/originurl?shortUrl=www.miele.de/x7BOoFSzt

where www.miele.de is default domain  and

x7BOoFSzt is generated key for intern short URL)
