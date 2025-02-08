parent
├───pom.xml  <-- Parent POM that manages dependencies and modules
├───base-app (sub module1)
│   ├───pom.xml  <-- Base App module POM
│   └───activities (sub module1 child 1)
│       └───customerservice
│           └───src
│               ├───main
│               │   ├───java
│               │   │   └───com
│               │   │       └───baseapp
│               │   │           └───activities
│               │   │               └───customerservice
│               │   │                   ├───CustomerServiceActivity.java
│               │   │                   └───StandardCustomerServiceActivity.java
│               │   ├───resources
│               │   │   └───application.properties
│               │   └───test
│               │       └───java
│               │           └───com
│               │               └───baseapp
│               │                   └───activities
│               │                       └───customerservice
│               │                           ├───CustomerServiceActivityTest.java
│               │                           └───StandardCustomerServiceActivityTest.java
│               └───pom.xml  <-- Activities module POM
│   └───base-app-config (sub module1 child 2)
│       └───src
│           ├───main
│           │   ├───java
│           │   │   └───com
│           │   │       └───baseapp
│           │   │           └───config
│           │   │               ├───BaseAppConfig.java  <-- Java-based configuration instead of XML
│           │   │               ├───ContextConfig.java
│           │   │               └───MessagingConfig.java
│           │   ├───resources
│           │   │   ├───application.properties
│           │   │   └───static
│           │   │       └───css
│           │   │           └───style.css
│           │   └───test
│           │       └───java
│           │           └───com
│           │               └───baseapp
│           │                   └───config
│           │                       ├───BaseAppConfigTest.java
│           │                       └───MessagingConfigTest.java
│           └───pom.xml  <-- Base App Config module POM
├───base-app-sites (sub module2)
│   ├───admin (sub module2 child 1)
│   ├───brand2 (sub module2 child 2)
│   ├───brand3 (sub module2 child 3)
│   │   └───src
│   │       ├───main
│   │       │   ├───java
│   │       │   │   └───com
│   │       │   │       └───baseapp
│   │       │   │           └───brand3
│   │       │   │               └───controller
│   │       │   │                   └───CustomerServiceController.java
│   │       │   ├───jetty
│   │       │   │   ├───app-specification.properties
│   │       │   │   ├───jetty.xml
│   │       │   │   ├───jetty-env.xml
│   │       │   │   ├───jetty-http.xml
│   │       │   │   ├───jetty-https.xml
│   │       │   │   ├───jetty-jmx.xml
│   │       │   │   ├───jetty-ssl.xml
│   │       │   │   └───log4j.properties
│   │       │   ├───resources
│   │       │   │   └───com
│   │       │   │       ├───brand3
│   │       │   │       │   ├───application.properties
│   │       │   │       │   ├───services-servlet.xml
│   │       │   │       │   └───spring-context.xml
│   │       │   │       └───application.properties
│   │       │   └───webapp
│   │       │       └───WEB-INF
│   │       │           └───web.xml
│   │       └───pom.xml  <-- Brand3 module POM
└───README.md
