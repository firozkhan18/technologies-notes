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

# PSQL Command Line Tool

```sql
Server [localhost]:
Database [postgres]:
Port [5432]:
Username [postgres]:
Password for user postgres:
psql (16.3)
WARNING: Console code page (437) differs from Windows code page (1252)
         8-bit characters might not work correctly. See psql reference
         page "Notes for Windows users" for details.
Type "help" for help.

postgres=# CREATE USER keycloak WITH ENCRYPTED PASSWORD 'keycloak';
CREATE ROLE
postgres=# CREATE DATABASE keycloak;
CREATE DATABASE
postgres=# GRANT ALL PRIVILEGES ON DATABASE keycloak TO keycloak;
GRANT
postgres=#
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

---
It looks like you've provided a comprehensive guide on setting up Keycloak with Docker, detailing the integration with PostgreSQL and the creation of realms, clients, roles, and users. Here's a condensed version that highlights the key points and instructions for clarity:

---

## Setting Up Keycloak with PostgreSQL in Docker

### Step 1: Define the Docker Compose Configuration

Create a `docker-compose.yaml` file with the following content:

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

### Step 2: Start the Containers

Run the following command in the terminal to start the Keycloak and PostgreSQL containers:

```bash
docker-compose up -d keycloak
```

### Step 3: Access Keycloak

Open your browser and navigate to `http://localhost:8080`. Log in using:

- **Username:** admin
- **Password:** admin

### Step 4: Create a New Realm

1. Click on the realm dropdown (top left) and select **Add Realm**.
2. Enter the realm name (e.g., `test`) and click **Create**.

### Step 5: Create a Client

1. Go to **Clients** and click **Create**.
2. Enter the client name (e.g., `test_client`).
3. Set **Access Type** to `confidential`, enable **Service Accounts** and **Authorization**, and add redirect URIs (e.g., `http://localhost:80`).

### Step 6: Configure Roles and Users

1. Go to **Roles** and click **Add Role** to create roles (e.g., `VISITOR`, `ADMIN`).
2. Go to **Users** and click **Add User** to create users.
3. Assign roles to users in the **Role Mappings** tab.

### Step 7: Test Token Generation

To test token generation using Postman:

- **Method:** POST
- **URL:** `http://localhost:8080/auth/realms/test/protocol/openid-connect/token`
- **Body (x-www-form-urlencoded):**

```plaintext
grant_type: password
client_id: test_client
client_secret: <your_client_secret>
username: <your_username>
password: <your_password>
```

### Step 8: Export and Import Realm Configuration

To avoid manual steps in future setups, export your realm:

1. Stop the Keycloak container.
2. Update the `docker-compose.yaml` to include a volume for realm export.
3. Start Keycloak again and run the export command in the container:

```bash
docker exec -it keycloak /opt/jboss/keycloak/bin/standalone.sh \
-Dkeycloak.migration.action=export \
-Dkeycloak.migration.provider=singleFile \
-Dkeycloak.migration.realmName=test \
-Dkeycloak.migration.file=/tmp/realm-test.json
```

4. Update the `docker-compose.yaml` to include the import configuration.

### Conclusion

You've successfully set up Keycloak with PostgreSQL, created a realm, clients, and users, and tested token generation. You can now streamline your setup process by exporting and importing realm configurations.

---

This summary should help you quickly reference the main points without losing any critical details. If you have any more questions or need further assistance, feel free to ask!
