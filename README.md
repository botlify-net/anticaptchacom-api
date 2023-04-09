# Anti Captcha Com API

[![Latest release](https://img.shields.io/github/release/botlify-net/anticaptchacom-api.svg)](https://github.com/botlify-net/anticaptchacom-api/releases/latest)
[![Build Status](https://github.com/botlify-net/anticaptchacom-api/workflows/Java%20CI/badge.svg?branch=master)](https://github.com/botlify-net/anticaptchacom-api/actions)

This integration follow the documentation of the [Anti Captcha Com API](https://anti-captcha.com/fr/apidoc).

## How to install ?

Add the dependency in your pom.xml:
```xml
<dependency>
    <groupId>net.botlify.anticaptchacom-api</groupId>
    <artifactId>anticaptchacom-api</artifactId>
    <version>LATEST</version>
</dependency>
```

## Basic usage

To start using the API, you need to create an instance of the API with your API key.
You can find your API key in your account page, then use the following code:

```java
AntiCaptchaComConfig config = new AntiCaptchaComConfig("YOUR_API_KEY");
AntiCaptchaComAPI api = new AntiCaptchaComAPI(config);

// Solve a captcha
String response = solve(captchaKey, captchaUrl, captchaType);
```