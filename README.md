### Description

Web extension starter for [Spring](https://spring.io) apps.

[![Java CI with Maven](https://github.com/WildDev/spring-starter-web-ext/actions/workflows/maven.yml/badge.svg)](https://github.com/WildDev/spring-starter-web-ext/actions/workflows/maven.yml)

### What it carries

* `fun.wilddev.spring.web.controllers.AbstractController` - an abstraction to deal with the server responses and errors assembling more easily.
* `fun.wilddev.spring.web.mappers.MultiValueMapper` - a mapping bean to instantiate Spring's `MultiValueMap`. It may be used to assemble http headers.
* `fun.wilddev.spring.web.controllers.responses.errors.ErrorResponse` - a basic error schema which is well-suited for most of the apps.

### Get started

Build requirements:
* latest JDK and Maven

Also available in Maven central:

```xml
<dependency>
    <groupId>fun.wilddev.lib</groupId>
    <artifactId>spring-starter-web-ext</artifactId>
    <version>1.0.0.RELEASE</version>
</dependency>
```
