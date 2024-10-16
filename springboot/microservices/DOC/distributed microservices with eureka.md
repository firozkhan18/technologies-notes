# DISTRIBUTED MICROSERVICES WITH EUREKA

In this class I will talk about how to create distributed microservices in Spring Boot using the facilities provided by the [Spring Cloud NetFlix](http://spring.io/projects/spring-cloud-netflix) package.

Any microservice must be able to locate the different instances of another service on which it depends without having their addresses defined in the code.

In the event that one microservice must access another, the ideal would be that it could somehow know in which addresses the instances of that other microservice are running, since the most common thing is that different instances are created depending on the load.

For this, **Spring** uses **Eureka Server from the** [Spring Cloud NetFlix](http://spring.io/projects/spring-cloud-netflix) package. Using this package in addition to **Ribbon** and **Feign** we will ensure that our application is able to find the different instances of a microservice and balance the requests in such a way that the load is distributed.


In this article I am going to explain how to create a service that we will call to request the capital of a country. This service will in turn call another service to locate the requested data, since it will only be an entry point.

The programs used will be these:

* **Project** : capitals-service **Port**:: 8100

- **Project** : countries-service **Port**:: 8000 and 8001

- **project** : eureka-server **Port** : 8761

The ' **countries-service** ' project will be the one that has the database with the data of the different countries. Two instances of the same service will be launched so we can check how ' **capitals-service** ' makes a call to one instance and then load balances.

The example code for this article is on [GitHub](https://github.com/chuchip/springEureka).

## Step 1: Creating a Eureka server

The first thing we need is to have a place where all the microservices register when they are initialized. This service is the one that will be consulted when we want to locate the different instances. 

In this example we are going to use **Eureka Server** which is very easy to create.

**To do this we will create a new Spring Boot** project with only the **Eureka** Server Starter.

In this project we will change the **application.properties** file to include the following lines:

That is, we specify the name of the program with the line spring.application.name . The port the service will be listening on with **server.port** . And most importantly, since the previous values ​​are optional, the Eureka server parameters.

- **eureka.client.register-with-eureka=false** so that the server does not try to register itself.
- **eureka.client.fetch-registry=false** With this parameter we specify to clients that the addresses of the different instances are not saved in their local cache. This is so that you query the Eureka server every time you need to access a service. In production it is often set to **true** to speed up requests. Comment that this cache is updated every 30 seconds by default.

Now in our main class, where Spring Boot comes in, we must put the **EnableEurekaServer** annotations :

```java
@SpringBootApplication
@EnableEurekaServer
public class NetflixEurekaNamingServerApplication {
​
    public static void main(String[] args) {
        SpringApplication.run(NetflixEurekaNamingServerApplication.class, args);
    }
}
```
And it's ready!. Our Eureka server is created. To see its status we can use our preferred browser and navigate to: [http://localhost:8761/](http://localhost:8761/) to see the applications that have registered. As you can see in the screenshot there is still none.

![Setting the Scheme](../IMAGES/captura5-1024x427.png)

The status of the server is shown on the same screen. Note that it is normal for us to have several Eureka servers up. In our example we will only raise one, although that will be normal for us in production.

![Setting the Scheme](../IMAGES/captura2-1-1024x504.png)

## Step 2: Microservice 'countries-service'

Now that we have our server we are going to create our first client. To do this we will create another Spring Boot project with the following starters

- Eureka Discovery
- Web
- lombok
- H2
- JPA
  
As I mentioned previously, this microservice is the one that will have the database and the one that will be consulted by 'capitales-service' to search for the capitals of a country.

The highlight of this project is in the fileapplication.properties from **Spring Boot**

As you can see, with the parameter **eureka.client.service-url.default-zone** we specify where the Eureka server is. 
**Spring Boot** will automatically try to register on its corresponding server when it sees that you have the **Eureka Discovery package available**.

In order to launch the second instance of the country-service application on port 8001 with **Eclipse , we must go to the option** Run Configurations in the menu Run and copy the one that Eclipse will have created for **countries-service** once we have run the application for the first time. In the tab Arguments we will have to add the parameter--server.port=8001

![Setting the Scheme](../IMAGES/captura4.png)

In the following screenshot you can see how if we launched two instances of this program, one on port 8000 and another on port 8001, in Eureka Server we can see how the different instances have been registered. The name that has been registered and by which it will be searchable is the name of the application as declared in the variable spring.application.name from the file application.properties

![Servidor Eureka con dos instancias registradas](.\captura5.png)

Thus we see that the application COUNTRIES-SERVICE has two instances, both raised on the host port-chuchi one on port 8000 and another on port 8001.

My computer is called port-chuchi

This simple application will use H2 for data persistence by having a simple table called countries with the country data, which we will access through JPA. The structure of the table is defined in `com.profesorp.countriesservice.entities.Countries.java`

In the class `CapitalsServiceController` The following entry points are defined.

1. GET request.**/{country}**

- **Receive** : Country Code. ('es','eu','en'….)
- **Will return** an object CapitalsBean

![Llamada a paises-service](.\captura3.PNG)

2. GET request. **/time/{time}**

**Sets the length of time the /{country}** entry will pause before returning the result.

## Step 3: Microservice 'capitals-service'

This service is the one that will call the previous one to request all the data of a country, but will only show the capital, the port of the service to which the call was made and the name of the country.

![Llamada a capitals-service](.\captura9.PNG)

We will need to have the following starters

- Eureka Discovery
- Feign
- lombok
- Web
  
First of all, as in the previous service, in the fileapplication.propertieswe will have the following content:

That is, we define the name of the application, then we specify where the Eureka server is where we must register and finally the port where the program will listen.

* ##### Using RestTemplate.

To make a RESTFUL request tocountries-serviceThe simplest way would be to use the classRestTemplateof the packageorg.springframework.web.client.
```java
@GetMapping("/template/{country}")
public CapitalsBean getCountryUsingRestTemplate(@PathVariable String country) { 
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("country", country);               
    ResponseEntity<CapitalsBean> responseEntity = new RestTemplate().getForEntity(
            "http://localhost:8000/{country}", 
            CapitalsBean.class, 
            uriVariables );     
    CapitalsBean response = responseEntity.getBody();       
    return response;
}
```
As you can see, we simply put in ahashmapthe variables that we are going to pass in the request, which in this case is only the parameter pais, and then create an objectResponseEntitycalling static functionRestTemplate.getForEntity()passing as parameters, the URL that we want to call, the class where the response of the REST request should be left and the variables passed in the request.

Then we capture the objectCapitalsBeanthat we will have in the Body of the objectResponseEntity.

But using this method we have the problem that we must have defined in our program the URLs where the different instances of the microservice we call are, and as you can see, we have to write a lot of code to make a simple call.

* ##### Simple FEIGN petition

A more elegant way to make that call would be to use [Feign](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html). 
**Feign** is a **Spring** tool that allows us to make calls using declarative functions.

To use **Feign** we must include the **@EnableFeignClients** tag in our main class. In our example we put it in the class CapitalsServiceApplication
```java
@SpringBootApplication
@EnableFeignClients("com.profesorp.capitalsservice")
public class CapitalsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CapitalsServiceApplication.class, args);
    }
}
```
If we do not pass any parameter to the **@EnableFeignClients tag it will search for Feign** clients in our main package, if we put a value it will only search for clients in the sent package. So in the example it would only search in the packagecom.profesorp.capitalsservice

Now we define the Feing client with the interface CapitalsServiceProxy
```java
@FeignClient(name="simpleFeign",url="http://localhost:8000/")
public interface CapitalsServiceProxySimple {   
    @GetMapping("/{country}")
    public CapitalsBean getCountry(@PathVariable("country") String country);
}
```
The first thing is to tag the class with **@FeignClient** specifying the URL where the REST server that we want to call is located. Pay attention to the fact that we put the base address, in this case only the host name and its portlocalhost:8000. The parameter namemust be set but its content is not important.

Then we will define the different inputs that we want to have available. In our case there is only one defined, but we could include the call to **/time/{time}** .
```java
@Autowired
private CapitalsServiceProxySimple simpleProxy;
@GetMapping("/feign/{country}")
public CapitalsBean getCountryUsingFeign(@PathVariable String country) {
    CapitalsBean response = simpleProxy.getCountry(country);        
    return response;
}
```
**We use Spring**'s dependency injector to create a **CapitalsServiceProxySimple** object and then simply call the functiongetCountry()of the interface.

Much cleaner, right? Assuming our REST server had many entry points we would save a lot of typing, in addition to having much cleaner code.

But we still have the problem that the RESTFUL server address is written in our code which makes it impossible for us to reach different instances of the same service and our microservice will not be truly scalable.

* ##### FEIGN request using Eureka server

To solve the problem, instead of entering the address of the server, we will enter the name of the application and **Spring Boot** will be in charge of calling the Eureka server, asking for the address where that service is.

To do this we would create a **Feign** interface in this way
```java
@FeignClient(name="countries-service")
public interface CapitalsServiceProxy {
    @GetMapping("/{country}")
    public CapitalsBean getCountry(@PathVariable("country") String country);
}
```
As you can see here we do not specify the address of the service, we simply put the name. In this casecountries-servicewhich is how the application is registered on the Eureka server.

Now each request made will swing from one instance to another. In such a way that the first request will go to port 8000 and the next to port 8001.

![Respondiendo en el puerto 8000](.\captura6.png)

![Respondiendo en el puerto 8001](.\captura7.png)

In this way our application will use all instances of the service automatically.

* ##### Configuring RIBBON
  
The **Feign** package uses the [Ribbon](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-ribbon.html) package underneath and it is actually this that is responsible for balancing the requests. By default **Ribbon** will use the `RoundRobinRule` rule . With this rule, it will sequentially choose each of the instances that **Eureka** shows it raised, without taking into account the time it takes for each instance to respond.

If we want it to use one of the other three available by default or even a rule that we define, we will have to create a configuration class for **Ribbon** , like the following:

in the function `ribbonRule()` we will return the object `WeightedResponseTimeRule` if we want the balancing logic to take into account the response time of each instance.

Now, to specify that we want to use this class to configure **Ribbon** we will add the tag

'@RibbonClient(name="countries-service", configuration = RibbonConfiguration.class)` in our `classCapitalsServiceApplication`
```java
import org.springframework.context.annotation.Bean;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
public class RibbonConfiguration {
     @Bean
     public IPing ribbonPing() {
            return new NoOpPing();
     }   
     @Bean  
     public IRule ribbonRule() {
            return new WeightedResponseTimeRule();
     }
}
```
To check how weight balancing works, we will establish a pause of 10 milliseconds to the server on port 8001 and a pause of 300 to the server on port 8000, using the call to **/time/{time}** of the servicecountries-service

Assuming we are working on **Linux** , using **Bash** we will make 100 requests.

After a while we will be able to see the requests that have been made to each port by calling [http://localhost:8100/puertos](http://localhost:8100/puertos)

![Balanceo de peticiones](.\captura8.png)

As you can see, there are many more requests to port 8001 than to port 8000, which is normal considering that port 8000 has a delay of 300 milliseconds, while 8001 only has 10.

To finish this article, comment that **Ribbon** can be used without having **Feign** , using RestTemplate directly , but I will leave the study of that case for another occasion.

Also mention that to perform balancing tests I have used **Docker** , so in the [GitHub](https://github.com/chuchip/springEureka) source code , we will see that in the file `application.properties` of the project `countries-service` there are these lines:

Instead of those shown above. This is set to be able to dynamically define when the **docker container is launched, with the SERVER_PORT** environment variable the port where each instance should listen.

---

*Note: For the full example code, please refer to the GitHub repository of the author.*
