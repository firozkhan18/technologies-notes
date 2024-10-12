# REST API: How to Prevent Duplicate Requests Effectively

Preventing duplicate requests is crucial when users manipulate an API feed or any data source. Even if a user only intends to perform an action once, various reasons—intentional or unintentional—can lead to duplicate requests and cause data errors. 

In this article, we’ll implement a deduplication solution using Redis and Spring Boot 3.

## Overview

The approach involves the following steps:

1. Extract data fields from the Request Body to create a Redis key. The choice of fields depends on business needs and system architecture.
2. Build the key in an optional format and hash it using MD5 (using Fast MD5 for better performance is also an option).
3. Check if the Redis key exists on every API call. If it does, return a duplicate data error. If not, continue processing the logic.
4. Set an expiration time for the Redis key. In this demo, we'll use a 40-second expiration.

## Project Structure

We will use:
- Spring Boot 3.3.4
- Java 17
- Spring AOP

### Implementation

#### 1. PreventDuplicateValidator

We declare this as an annotation with three data fields:
- **includeFieldKeys**: List of fields needed to generate the key based on the Request Body.
- **optionalValues**: Values that can be added to the key for flexibility.
- **expireTime**: Key expiration time value, default is 10 seconds.

```java
// Java code for PreventDuplicateValidator
```

#### 2. PreventDuplicateValidatorAspect

This is an advice implementing logic for the `PreventDuplicateValidator` annotation. We use Around Advice for flexibility.

The logic implementation is as follows:

1. Extract the request body from the API.
2. Parse request body into `Map<K, V>` format.
3. Build raw keys from defined data fields.
4. Build MD5 key.
5. Check for duplicate requests by key.
6. If the key exists in Redis, throw an exception.
7. If not, insert the key into Redis with the expiration time and continue the main logic using `pjp.proceed()`.

```java
// Java code for PreventDuplicateValidatorAspect
```

#### 3. Bean Configuration

Add bean configuration for `ObjectMapper` and Redis connection.

```java
// Java code for BeanConfig
```

#### 4. BaseResponse

This is the response class that returns results via API, containing fields such as code, message, and data.

```java
// Java code for BaseResponse
```

#### 5. HandleGlobalException

This class handles `DuplicationException`, which is triggered by `PreventDuplicateValidatorAspect`.

```java
// Java code for HandleGlobalException
```

#### 6. Utility Functions

This class includes logic functions to extract the request body and the MD5 hash function.

```java
// Java code for Utils
```

### Main Controller

In the main controller, we use the `PreventDuplicateValidator` annotation with the following parameters:
- **includeFieldKeys**: Using `productId` and `transactionId` from the request body to generate the key.
- **optionalValues**: Declaring an optional value, "CAFEINCODE".
- **expireTime**: Setting the Redis cache lifetime to 40 seconds.

### Running the Project

1. For MacOS and Windows, ensure Docker Desktop is running and execute:
   ```bash
   docker-compose up -d
   ```
   
2. For Ubuntu, install Docker first, then run the above command.

3. Use Postman to test the API with the following request body:

   ```json
   {
       "productId": "hungtv27-test-001",
       "productName": "CAFEINCODE",
       "productDescription": "Threat identify buy war manage little friend south really chair",
       "transactionId": "cd076846-ff28-4307-8524-3eb6e1809838",
       "requestTime": 1696069378367,
       "requestId": "{{$randomUUID}}"
   }
   ```

### Testing the API

**First Call:**
- Validate success, initialize the key in Redis.
- Console log: "MD5 key: 6C518A2B1666005572EDFC8240A130F2 does not exist in Redis".

**Second Call:**
- Console log: Check if the key exists. If it does, return error `CF_275` to the client.

### Conclusion

In summary, the implementation of duplicate prevention using Redis and Spring AOP involves careful selection of fields for key generation, setting appropriate expiration times, and considering the use of MD5 hashing. 

After implementing the complete logic, you only need to declare the annotation on the controllers that require it, ensuring flexibility with minimal modification needed.
