# Java Full Stack Interview Questions & Answers

## Cheat Sheets

### Table of Contents

<details open>
<summary>
Hide/Show table of contents
</summary>
    
| No. | Cheat Sheets |
|---- | ---------|
|1 | [**Cheat-Sheet-Docker**](cheat-sheet/Cheat-Sheet-Docker.md)|
|2 | [**Cheat-Sheet-Kafka**](cheat-sheet/Cheat-Sheet-Kafka.md)|
|3 | [**Cheat-Sheet-Kubernetes**](cheat-sheet/Cheat-Sheet-Kubernetes.md)|
|4 | [**Cheat-Sheet-Linux**](cheat-sheet/Cheat-Sheet-Linux.md)|
|5 | [**Cheat-Sheet-Java8**](cheat-sheet/Cheat-Sheet-Java8.md)|
|6 | [**Cheat-Sheet-MongoDB**](cheat-sheet/Cheat-Sheet-MongoDB.md)|

</details>

## Interview Questions & Answers - Java Script, Angular & React

### Table of Contents

<details open>
<summary>
Hide/Show table of contents
</summary>
 
| No. | Topics |
|---- | ---------|
|1 | [**Q&A-JavaScript**](conceptsI/FAQ-JavaScript.md)|
|2 | [**Q&A-Angular**](conceptsI/FAQ-Angular.md)|
|3 | [**Q&A-React**](conceptsI/FAQ-React.md)|
|5 | [**Q&A-React-Advanced**](conceptsI/FAQ-React-Advanced.md)|
|6 | [**Q&A-React**](conceptsI/Q&A-React.md)|
</details>

## Interview Questions & Answers - Java & J2EE Technologies

### Table of Contents

<details open>
<summary>
Hide/Show table of contents
</summary>
 
| No. | Topics |
|---- | ---------|
|1 | [**Q&A-Design-Patterns**](FAQ-Design-Patterns.md)|
|2 | [**Java Collection Framework**](Java-Collection-Framework.md)|
|3 | [**Java Thread & Concurrency**](Java-Thread-Concurrency.md)|
|4 | [**Java File I/O**](FileIOcompleteReference.md)|
|5 | [**End-to-End CICD Pipeline Implementation**](End-to-End-CICD-Pipeline-Implementation.md)|
|6 | [**Java Basic Differences & Comparisions**](java-basic-differences-and-comparisions.md)|



## Java Programing Exercises
* [java-basic-exercises-001-Basic-1](exercisesI/java-basic-exercises-001-Basic-1.md)
* [java-basic-exercises-002-Basic-2](exercisesI/java-basic-exercises-002-Basic-2.md)
* [java-basic-exercises-003-Recursive](exercisesI/java-basic-exercises-003-Recursive.md)
* [java-basic-exercises-004-Exception](exercisesI/java-basic-exercises-004-Exception.md)
* [java-basic-exercises-005-Array](exercisesI/java-basic-exercises-005-Array.md)
* [java-basic-exercises-006-Inheritance](exercisesI/java-basic-exercises-006-Inheritance.md)
* [java-basic-exercises-007-Abstract](exercisesI/java-basic-exercises-007-Abstract.md)
* [java-basic-exercises-008-Thread](exercisesI/java-basic-exercises-008-Thread.md)
* [java-basic-exercises-009-Multithreading](exercisesI/java-basic-exercises-009-Multithreading.md)
* [java-basic-exercises-010-Generic](exercisesI/java-basic-exercises-010-Generic.md)
* [java-basic-exercises-011-OOPs](exercisesI/java-basic-exercises-011-OOPs.md)
* [java-basic-exercises-012-Interface](exercisesI/java-basic-exercises-012-Interface.md)
* [java-basic-exercises-013-Encapsulation](exercisesI/java-basic-exercises-013-Encapsulation.md)
* [java-basic-exercises-014-Polymorphism](exercisesI/java-basic-exercises-014-Polymorphism.md)
* [java-basic-exercises-015-String](exercisesI/java-basic-exercises-015-String.md)
* [java-basic-exercises-016-Lambda](exercisesI/java-basic-exercises-016-Lambda.md)
* [java-basic-exercises-017-Stream](exercisesI/java-basic-exercises-017-Stream.md)
* [java-basic-exercises-018-Method](exercisesI/java-basic-exercises-018-Method.md)
* [java-basic-exercises-019-Numbers](exercisesI/java-basic-exercises-019-Numbers.md)
* [java-basic-exercises-020-Collection](exercisesI/java-basic-exercises-020-Collection.md)
  * [java-basic-exercises-020-collection-arraylist](exercisesI/java-basic-exercises-020-collection-arraylist.md)
  * [java-basic-exercises-020-collection-hashmap](exercisesI/java-basic-exercises-020-collection-hashmap.md)
  * [java-basic-exercises-020-collection-hashset](exercisesI/java-basic-exercises-020-collection-hashset.md)
  * [java-basic-exercises-020-collection-linkedlist](exercisesI/java-basic-exercises-020-collection-linkedlist.md)
  * [java-basic-exercises-020-collection-priorityqueue](exercisesI/java-basic-exercises-020-collection-priorityqueue.md)
  * [java-basic-exercises-020-collection-treemap](exercisesI/java-basic-exercises-020-collection-treemap.md)
  * [java-basic-exercises-020-collection-treeset](exercisesI/java-basic-exercises-020-collection-treeset.md)
* [java-basic-exercises-021-Sorting](exercisesI/java-basic-exercises-021-Sorting.md)
* [java-basic-exercises-022-Search](exercisesI/java-basic-exercises-022-Search.md)
* [java-basic-exercises-023-Unit-Test](exercisesI/java-basic-exercises-023-Unit-Test.md)
## Java Programing Question Answer
* [java-programming-question-answer-1](exercisesII/java-programming-question-answer-1.md)
* [java-programming-question-answer-2](exercisesII/java-programming-question-answer-2.md)
* [java-programming-question-answer-3-emp-mgmt](exercisesII/java-programming-question-answer-3-emp-mgmt.md)
* [java-programming-question-answer-4-java-8](exercisesII/java-programming-question-answer-4-java-8.md)
* [java-programming-question-answer-5-java-8](exercisesII/java-programming-question-answer-5-java-8.md)
* [java-programming-question-answer-consolidated](exercisesII/java-programming-question-answer-consolidated.md)

</details>
Here is an example of security configurations in Angular:

1. To implement security in Angular, you can use Angular Route Guards to protect routes based on user authentication and authorization.

2. Create a service to authenticate users using JWT tokens or OAuth.

3. Implement guards such as CanActivate, CanActivateChild, CanDeactivate, and Resolve to control access to specific routes.

4. Use HTTP Interceptors to add authorization headers or handle token expiration.

5. Implement user roles and permissions to restrict access to certain features or data.

6. Store sensitive data securely using Angular’s Secure Storage API or encrypting data before sending it over HTTP requests.

7. Always validate user input on the client-side and server-side to prevent XSS and CSRF attacks.

8. Use Content Security Policy (CSP) to prevent malicious scripts from running in your Angular application.

9. Implement Cross-Origin Resource Sharing (CORS) to restrict access to your API from unauthorized domains.

10. Keep Angular dependencies and packages updated to prevent security vulnerabilities.

11. Enable HTTPS to encrypt data transmitted between the client and server.

12. Regularly perform security audits and code reviews to identify and fix security issues in your Angular application.

The 12 rules of microservices, as defined by Sam Newman in his book "Building Microservices," are:

1. Model around business domain concepts
2. Design for failure
3. Decentralize all the things
4. Embrace shared-nothing architecture
5. Automate everything
6. Enable easy and confident changes
7. Architecture evolves over time
8. Build a culture of automation
9. Design for operability
10. Monitor everything
11. Log everything
12. Secure everything

These rules guide the development and deployment of microservices architectures, emphasizing principles such as scalability, resilience, and agility.


One way to secure user requests in an Angular and Spring Boot application is by implementing authentication and authorization mechanisms.

Here are a few steps you can take to secure user requests:

1. Implement JWT (JSON Web Token) authentication: You can use JWT to securely authenticate users in your application. When a user logs in, they will receive a JWT token which needs to be passed with each request to authorize the user.

2. Use Spring Security to secure the backend: Spring Security provides authentication and authorization features to secure your Spring Boot application. You can define roles and permissions for users and restrict access to certain endpoints based on these roles.

3. Use HTTPS to encrypt data: Ensure that your application is using HTTPS to encrypt communication between the client and the server. This will prevent data from being intercepted and tampered with.

4. Secure your API endpoints: Make sure to use proper authentication and authorization mechanisms to secure your API endpoints. You can use Spring Security to add security configurations to specific endpoints.

5. Handle server-side validation: Always validate user input on the server-side to prevent any unauthorized access or data manipulation.

If a user tries to change URL properties using the network tab in the browser, your backend should still be able to validate the request and deny access if the user is not authorized to access the resource. Make sure to implement proper error handling and validation checks in your backend to prevent any unauthorized access.

Overall, it's important to implement a combination of front-end and back-end security measures to secure user requests in your Angular and Spring Boot application.


Creating a complete Spring Boot and Angular application that embodies the 12 rules of microservices as defined by Sam Newman is a large undertaking. Below is an outline and a simplified example that touches on these principles, but please note that providing a full codebase would be too extensive for this format. However, I can guide you through a basic structure and essential code snippets.

### Project Structure

1. **Backend (Spring Boot)**
   - **Models**: Define your domain models.
   - **Controllers**: Handle incoming requests.
   - **Services**: Business logic layer.
   - **Repositories**: Data access layer.
   - **Configuration**: Set up security, monitoring, etc.

2. **Frontend (Angular)**
   - **Components**: UI elements.
   - **Services**: HTTP requests to the backend.
   - **Routing**: Navigation between views.

### Example Code

#### Backend: Spring Boot

**1. pom.xml (Dependencies)**

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-logging</artifactId>
    </dependency>
</dependencies>
```

**2. Domain Model**

```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    // Getters and Setters
}
```

**3. Repository**

```java
public interface ProductRepository extends JpaRepository<Product, Long> {
}
```

**4. Service**

```java
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }
}
```

**5. Controller**

```java
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
```

**6. Security Configuration**

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest().permitAll();
    }
}
```

**7. Monitoring Configuration (Actuator)**

```properties
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
```

#### Frontend: Angular

**1. Angular Service**

```typescript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl = 'http://localhost:8080/api/products';

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.apiUrl);
  }

  addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.apiUrl, product);
  }
}
```

**2. Angular Component**

```typescript
import { Component, OnInit } from '@angular/core';
import { ProductService } from './product.service';
import { Product } from './product.model';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html'
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.productService.getProducts().subscribe(data => {
      this.products = data;
    });
  }
}
```

**3. Product Model**

```typescript
export interface Product {
  id: number;
  name: string;
  price: number;
}
```

**4. Angular Routing**

```typescript
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';

const routes: Routes = [
  { path: 'products', component: ProductListComponent },
  { path: '', redirectTo: '/products', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```

### Implementation of Principles

1. **Model around business domain concepts**: Use domain models like `Product`.
2. **Design for failure**: Use circuit breakers (e.g., Hystrix) in a real scenario.
3. **Decentralize all the things**: Separate services (like product and order services).
4. **Embrace shared-nothing architecture**: Each service has its own database.
5. **Automate everything**: CI/CD pipelines for deployment.
6. **Enable easy and confident changes**: Feature flags.
7. **Architecture evolves over time**: Microservices can evolve independently.
8. **Build a culture of automation**: Automated tests and deployment.
9. **Design for operability**: Use Spring Boot Actuator.
10. **Monitor everything**: Integrate with tools like Prometheus or Grafana.
11. **Log everything**: Use centralized logging (e.g., ELK stack).
12. **Secure everything**: Implement security with Spring Security.

### Conclusion

This example provides a basic framework that embodies the principles of microservices. For a full implementation, consider using Docker for containerization, Kubernetes for orchestration, and additional monitoring and logging frameworks. Always follow best practices for security, testing, and code quality.

