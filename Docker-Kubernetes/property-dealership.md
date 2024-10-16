Here's a basic implementation of the Real Estate Management System using Angular, Spring Boot, and MySQL. This example covers core functionalities and provides a starting point for your project.

### 1. Spring Boot (Backend)

#### **Project Structure:**

```
real-estate-management-system
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── RealEstateApplication.java
│   │   │           ├── controller
│   │   │           │   ├── AdminController.java
│   │   │           │   ├── UserController.java
│   │   │           ├── model
│   │   │           │   ├── Property.java
│   │   │           │   ├── User.java
│   │   │           ├── repository
│   │   │           │   ├── PropertyRepository.java
│   │   │           │   ├── UserRepository.java
│   │   │           └── service
│   │   │               ├── PropertyService.java
│   │   │               └── UserService.java
│   └── resources
│       ├── application.properties
│       └── schema.sql
└── pom.xml
```

#### **1.1 `RealEstateApplication.java`:**

```java
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealEstateApplication {
    public static void main(String[] args) {
        SpringApplication.run(RealEstateApplication.class, args);
    }
}
```

#### **1.2 `application.properties`:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/remsdb
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

#### **1.3 `Property.java`:**

```java
package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String location;
    private double price;

    // Getters and setters
}
```

#### **1.4 `User.java`:**

```java
package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;

    // Getters and setters
}
```

#### **1.5 `PropertyRepository.java`:**

```java
package com.example.repository;

import com.example.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
```

#### **1.6 `UserRepository.java`:**

```java
package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
```

#### **1.7 `PropertyService.java`:**

```java
package com.example.service;

import com.example.model.Property;
import com.example.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
```

#### **1.8 `UserService.java`:**

```java
package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
```

#### **1.9 `AdminController.java`:**

```java
package com.example.controller;

import com.example.model.Property;
import com.example.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/properties")
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @PostMapping("/properties")
    public Property addProperty(@RequestBody Property property) {
        return propertyService.saveProperty(property);
    }

    @DeleteMapping("/properties/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }
}
```

#### **1.10 `UserController.java`:**

```java
package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
```

### 2. Angular (Frontend)

#### **Project Structure:**

```
real-estate-frontend
├── src
│   ├── app
│   │   ├── components
│   │   │   ├── home
│   │   │   │   └── home.component.ts
│   │   │   ├── property
│   │   │   │   └── property.component.ts
│   │   │   ├── user
│   │   │   │   └── user.component.ts
│   │   │   └── login
│   │   │       └── login.component.ts
│   │   ├── services
│   │   │   ├── property.service.ts
│   │   │   └── user.service.ts
│   │   ├── app.component.ts
│   │   └── app.module.ts
└── angular.json
```

#### **2.1 `app.module.ts`:**

```typescript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { PropertyComponent } from './components/property/property.component';
import { UserComponent } from './components/user/user.component';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PropertyComponent,
    UserComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

#### **2.2 `home.component.ts`:**

```typescript
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor() { }

  ngOnInit(): void {
  }
}
```

#### **2.3 `property.component.ts`:**

```typescript
import { Component, OnInit } from '@angular/core';
import { PropertyService } from '../../services/property.service';

@Component({
  selector: 'app-property',
  templateUrl: './property.component.html',
  styleUrls: ['./property.component.css']
})
export class PropertyComponent implements OnInit {
  properties: any[] = [];

  constructor(private propertyService: PropertyService) { }

  ngOnInit(): void {
    this.propertyService.getProperties().subscribe(data => {
      this.properties = data;
    });
  }
}
```

#### **2.4 `user.component.ts`:**

```typescript
import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: any;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUser('testuser2@gmail.com').subscribe(data => {
      this.user = data;
    });
  }
}
```

#### **2.5 `login.component.ts`:**

```typescript
import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component

.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private userService: UserService) { }

  login(): void {
    this.userService.login(this.username, this.password).subscribe(data => {
      // Handle login
    });
  }
}
```

#### **2.6 `property.service.ts`:**

```typescript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PropertyService {
  private baseUrl = 'http://localhost:8080/admin/properties';

  constructor(private http: HttpClient) { }

  getProperties(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  addProperty(property: any): Observable<any> {
    return this.http.post<any>(this.baseUrl, property);
  }

  deleteProperty(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
```

#### **2.7 `user.service.ts`:**

```typescript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8080/user';

  constructor(private http: HttpClient) { }

  getUser(username: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${username}`);
  }

  login(username: string, password: string): Observable<any> {
    // Implement login API call
    return this.http.post<any>(`${this.baseUrl}/login`, { username, password });
  }
}
```

### 3. MySQL Setup

1. **Create Database:**
   ```sql
   CREATE DATABASE remsdb;
   ```

2. **Create Tables (in `schema.sql`):**
   ```sql
   CREATE TABLE property (
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       type VARCHAR(255) NOT NULL,
       location VARCHAR(255) NOT NULL,
       price DOUBLE NOT NULL
   );

   CREATE TABLE user (
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(255) NOT NULL UNIQUE,
       password VARCHAR(255) NOT NULL,
       role VARCHAR(255) NOT NULL
   );
   ```

### 4. Running the Application

1. **Backend:**
   - Navigate to the Spring Boot project directory and run:
     ```bash
     mvn clean install
     mvn spring-boot:run
     ```

2. **Frontend:**
   - Navigate to the Angular project directory and run:
     ```bash
     npm install
     ng serve
     ```

3. **Database Configuration:**
   - Ensure MySQL server is running and configured as specified in `application.properties`.

### 5. Login Details

- **Admin:**
  - **Username:** admin
  - **Password:** Test@123

- **Broker/Agent:**
  - **Username:** test@gmail.com
  - **Password:** Test@123

- **Simple User:**
  - **Username:** testuser2@gmail.com
  - **Password:** Test@123

Feel free to customize and expand upon this basic implementation based on your project requirements.
