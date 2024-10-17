# Spring Security OAuth2 Keycloak Demo

This repository contains source code to demonstrate OAuth2 features using Spring Security and Keycloak as the Authorization Server.

## Getting Started

After you check out the project, run the following command:

```bash
mvn clean verify
```

This project includes examples for three OAuth2 Grant Types:

- **Authorization Code Flow** (`oauth2-authorization-code-demo`)
- **PKCE Authorization Code Flow** (`oauth2-pkce-demo`)
- **Client Credentials Flow** (`oauth2-client-credentials-demo`)

## Running Keycloak

1. **Download Keycloak** from [Keycloak Downloads](https://www.keycloak.org/downloads).
2. If using the standalone version, run the following command inside the `bin` directory:
   ```bash
   standalone.bat -Djboss.http.port=<port>
   ```
   You can specify any port number you like.

### Importing Realm

Instead of creating the realm manually, you can use the `realm-export.json` file to import all realm details into your Keycloak instance.

## About

This repository demonstrates OAuth2 features using Spring Security and Keycloak as the Authorization Server.

---

## Create and Configure Keycloak OAuth 2.0 Authorization Server

This guide shows how to set up and configure Keycloak as an authorization server for the OAuth 2.0 framework using Docker.

### Architecture Overview

A typical project consists of three components:

1. **Authorization Server (Keycloak)**: Issues access and identity tokens.
2. **Protected Resource (Java, Spring Boot)**: A backend application that requires a valid access token for REST API security.
3. **Client (Angular)**: A frontend application that requires user authentication to obtain an access token and access the backend app.

### Running Keycloak Instance

Before configuring Keycloak, modify your OS’s hosts file to use a convenient URL for testing:

- **Linux (Ubuntu)**
- **Windows 10**
- **Mac**

Add the following line to the hosts file:

```plaintext
127.0.0.1	keycloak
```

Now, you can use `http://keycloak` instead of `http://localhost`.

### Docker Compose Configuration

Create a `docker-compose.yaml` file with the following content to set up PostgreSQL and Keycloak:

```yaml
version: "3.8"
services:
  postgres:
    image: postgres:13.0-alpine
    container_name: postgres
    ports:
      - 5432:5432
    environment:
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=postgres
    volumes:
      - postgres:/var/lib/postgresql/data
      - ./infra/postgres:/docker-entrypoint-initdb.d

  keycloak:
    image: jboss/keycloak:11.0.2
    container_name: keycloak
    ports:
      - 8080:8080
    environment:
      - KEYCLOAK_USER=admin
      - KEYCLOAK_PASSWORD=admin
      - DB_VENDOR=postgres
      - DB_ADDR=postgres
      - DB_DATABASE=keycloak
      - DB_USER=keycloak
      - DB_PASSWORD=keycloak
    depends_on:
      - postgres

volumes:
  postgres:
```

### Initialize the Database

Create an SQL script in `./infra/postgres` to initialize the database:

```sql
CREATE USER keycloak WITH ENCRYPTED PASSWORD 'keycloak';
CREATE DATABASE keycloak;
GRANT ALL PRIVILEGES ON DATABASE keycloak TO keycloak;
```

### Start Keycloak

Run the following command in your terminal:

```bash
docker-compose up -d keycloak
```

To check if the containers are running, execute:

```bash
docker ps
```

### Access Keycloak

Open your browser and go to `http://keycloak:8080`. Log in using:

- **Username**: `admin`
- **Password**: `admin`

### Create a Realm, Client, Roles, and Users

1. **Create a Realm**: Click on the dropdown in the top left corner and select **Add Realm**. Name it **test**.
2. **Create a Client**: Go to the **Clients** page and click **Create**. Set the **Client ID** to `test_client`, change **Access Type** to **confidential**, and enable **Service Accounts Enabled** and **Authorization Enabled**. Add the **Redirect URI** (e.g., `http://localhost:80`).
3. **Create Roles**: Navigate to the **Roles** section and create roles (e.g., `VISITOR` and `ADMIN`).
4. **Create Users**: Go to the **Users** section and click **Add User** to create users and assign roles.

### Testing Token Generation

Use Postman or similar tools to request tokens. For `client_credentials` flow:

- **URL**: `http://keycloak:8080/auth/realms/test/protocol/openid-connect/token`
- **Method**: `POST`
- **Body** (x-www-form-urlencoded):
  - `grant_type`: `client_credentials`
  - `scope`: `openid`
  - `client_id`: `test_client`
  - `client_secret`: `<your_client_secret>`

For `password` flow:

- **Body** (x-www-form-urlencoded):
  - `grant_type`: `password`
  - `scope`: `openid`
  - `client_id`: `test_client`
  - `client_secret`: `<your_client_secret>`
  - `username`: `<your_username>`
  - `password`: `<your_password>`

### Exporting and Importing Realm

To avoid manual setup in the future, export your realm to a JSON file and configure Keycloak to import it on startup. This is especially useful for development environments.

### Summary

Congratulations! You've successfully set up Keycloak as an OAuth2 authorization server. You can further customize your setup based on your application's requirements.
