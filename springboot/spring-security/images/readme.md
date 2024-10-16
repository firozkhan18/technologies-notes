
### How to handle incoming requests in Java with Spring Boot

Spring Boot’s @RestController components support multi-threading by default, but it's important to consider the concurrency when writing the code in the controllers.

Each incoming request to a @RestController endpoint creates a new thread, and the endpoint is executed in this thread. This means that multiple requests can be processed simultaneously, improving the performance and scalability of the application.

However, if your endpoint performs a blocking operation, such as a database query or a slow API call, the thread will be blocked, and will not be available to process other incoming requests until the blocking operation completes. This can result in poor performance and scalability, especially under heavy load.

To avoid this, it’s important to write non-blocking code in your @RestController endpoints, or to use asynchronous programming techniques such as Futures, Callables, or the Reactor library, to ensure that the thread is not blocked while waiting for a slow operation to complete.

It’s also important to handle concurrency issues, such as race conditions or deadlocks, that can arise when multiple threads access shared data structures. You should use appropriate synchronization techniques, such as locks or atomic variables, to ensure that the data remains consistent and correct even when multiple threads access it simultaneously.

In summary, while Spring Boot’s @RestController components support multi-threading by default, it's important to consider the concurrency when writing the code, to ensure that the application remains performant and scalable even under heavy load.


Spring Boot @RestController
In a Spring Boot application, a REST endpoint is typically implemented as a method within a @RestController class. To handle multiple incoming requests to the same API endpoint, you can use the following strategies:

Synchronous handling: The endpoint method is executed in a synchronous way, meaning that each request is handled one at a time, in the order in which it was received. To implement this, you can simply annotate the endpoint method with @RequestMapping and Spring Boot will handle the request synchronously.
Asynchronous handling: The endpoint method is executed asynchronously, meaning that multiple requests can be handled simultaneously. To implement this, you can annotate the endpoint method with @Async and return a java.util.concurrent.CompletableFuture<T> instead of a regular object. Spring Boot will handle the request asynchronously using a thread pool.
Concurrent handling: The endpoint method is executed concurrently, meaning that multiple requests can be handled simultaneously. To implement this, you can use the @EnableAsync and @EnableScheduling annotation in your configuration class and use java.util.concurrent.Executor and java.util.concurrent.ScheduledExecutorService to handle the requests concurrently.
Using a load balancer: you can use a load balancer such as Nginx, HAProxy or Amazon’s Elastic Load Balancer to distribute the incoming requests across multiple instances of your application, thus allowing the application to handle more requests at the same time.
It’s worth noting that the choice of strategy will depend on the specific requirements of your application and the expected load. Synchronous handling is the simplest and easiest to implement but can become a bottleneck under heavy load, while asynchronous and concurrent handling can handle more requests but are more complex to implement.

Here ‘s some examples of each item explained above:

Synchronous handling
@RestController
public class ExampleController {

    @RequestMapping("/example")
    public ResponseEntity<String> handleExampleRequest(@RequestParam("param") String param) {
        // Perform some logic here
        String result = "Hello, " + param;
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
In this example, the handleExampleRequest method is annotated with @RequestMapping and takes a single parameter param. When a client makes a request to the /example endpoint with a query parameter param, this method will be called and will execute the logic inside of it.

This method returns a ResponseEntity<String> which contains the response body and the HTTP status. Spring Boot will handle the request synchronously, meaning that each request will be handled one at a time, in the order in which it was received.

It’s worth noting that if the logic inside the method is time-consuming, the incoming request will be blocked until the previous request is finished, this could cause performance issues if the number of requests is high.

2. Asynchronous handling

@RestController
public class ExampleController {

    @Autowired
    private AsyncTaskService asyncTaskService;
    
    @RequestMapping("/example")
    public CompletableFuture<ResponseEntity<String>> handleExampleRequest(@RequestParam("param") String param) {
        return asyncTaskService.handleExampleRequestAsync(param)
                .thenApply(result -> new ResponseEntity<>(result, HttpStatus.OK));
    }
}
@Service
public class AsyncTaskService {

    @Async
    public CompletableFuture<String> handleExampleRequestAsync(String param) {
        // Perform some logic here
        String result = "Hello, " + param;
        return CompletableFuture.completedFuture(result);
    }
}
In this example, the handleExampleRequest method is annotated with @RequestMapping and takes a single parameter param. When a client makes a request to the /example endpoint with a query parameter param, this method will be called.

Instead of performing the logic inside the method, it calls the handleExampleRequestAsync method in AsyncTaskService class which is annotated with @Async that will perform the logic inside it asynchronously and return a CompletableFuture<String>.

The handleExampleRequest method then uses the thenApply method to convert the CompletableFuture<String> to CompletableFuture<ResponseEntity<String>> and return it. Spring Boot will handle the request asynchronously, meaning that multiple requests can be handled simultaneously using a thread pool.

This way, the incoming request will not be blocked, and the response will be returned as soon as the logic inside the Async method is finished, this could improve the performance of the application if the number of requests is high.

3. Concurrent handling

@RestController
public class ExampleController {
    @RequestMapping("/example")
    public String handleExampleRequest(@RequestParam("param") String param) {
        Executor executor = Executors.newFixedThreadPool(10);
        String result = executor.submit(() -> {
            // Perform some logic here
            return "Hello, " + param;
        }).get();
        return result;
    }
}
In this example, the handleExampleRequest method is annotated with @RequestMapping and takes a single parameter param. When a client makes a request to the /example endpoint with a query parameter param, this method will be called and will execute the logic inside of it.

This method creates an Executor with a fixed thread pool of 10 threads using Executors.newFixedThreadPool(10). Then it uses the submit method of the executor to submit a new task that performs the logic and return the result.

The get() method is used to wait for the result of the task and return it.

Spring Boot will handle the request concurrently, meaning that multiple requests can be handled simultaneously using a thread pool, similar to the asynchronous handling example, but the difference is that here we are using the Executor framework to handle the concurrent requests. This way, the incoming request will not be blocked, and the response will be returned as soon as the logic inside the task is finished, this could improve the performance of the application if the number of requests is high.

4. Using a load balancer

Here is an example of using a load balancer to handle multiple incoming requests in a Spring Boot application:

Let’s assume that you have two instances of your Spring Boot application running on different machines, each with their own IP address and port.

Instance 1: http://192.168.0.1:8080
Instance 2: http://192.168.0.2:8080
You can use a load balancer, such as HAProxy or Nginx, to distribute the incoming requests across these two instances.

Here is an example configuration for HAProxy:

frontend http-in
    bind *:80
    default_backend servers

backend servers
    server instance1 192.168.0.1:8080 weight 1
    server instance2 192.168.0.2:8080 weight 1
This configuration tells HAProxy to listen on port 80 for incoming requests and forward them to the “servers” backend. The “servers” backend contains two servers, “instance1” and “instance2” running on IP addresses 192.168.0.1 and 192.168.0.2 respectively and both have the same weight of 1.

The load balancer will use a load balancing algorithm, such as Round Robin, to distribute the requests among the two instances.

You can also configure the load balancer to monitor the health of the instances, and only forward requests to healthy instances. This is done by configuring the load balancer to periodically send a health check request to a specific endpoint on each instance and only forward requests to instances that respond with a 200 OK status.

You should configure the load balancer to use a domain name like “myapp.com” or “api.myapp.com” as the frontend and in the client side, the requests should be sent to this domain name instead of the IP address and port of the instances, this way you don’t need to change the IP address or port in the client-side if you decide to add or remove instances from your infrastructure.

This way, the load balancer will handle the incoming requests and distribute them among the instances, improving the performance and scalability of the application.
