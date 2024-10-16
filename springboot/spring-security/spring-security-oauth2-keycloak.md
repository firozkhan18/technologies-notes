Spring Security OAuth2 Keycloak Demo
This repository contains source code to demonstrate OAuth2 features using Spring Security and KeyCloak Authorization Server

After you checked out the project, run the following command:

mvn clean verify

This project contains examples for 3 OAuth2 Grant Types

Authorization Code Flow (oauth2-authorization-code-demo)

PKCE Authorization Code Flow (oauth2-pkce-demo)

Client Credentials Flow (oauth2-client-credentials-demo)

Run Keycloak
Download Keycloak from https://www.keycloak.org/downloads
If you are using standalone version, run the following command, by making sure you are inside the bin directory standalone.bat -Djboss.http.port=<port>, you can provide whatever port number you like.
Importing Realm
Instead of creating the realm, you can make use of the realm-export.json file to import all the realm details into your Keycloak instance.
About
This repository contains source code to demonstrate OAuth2 features using Spring Security and KeyCloak Authorization Server


=======================================================================================

### Create and configure Keycloak OAuth 2.0 authorization server

If you want to know how to set up and configure Keycloak as an authorization server (for OAuth 2.0 framework) with Docker this article is for you.

A target project will consists of three pieces:

authorization server (Keycloak) — an application which is used to issue access and identity tokens,
protected resource (Java, Spring Boot, backend application) — an application that serves information using REST API, but requires a valid access token for security reasons,
client (Angular, frontend application) — a website, which requires user to be logged in order to be able to get access token and query the backend app.
In this article I’ll focus on the authorization server, how to create a basic docker-compose.yaml file and then configure a Keycloak instance.

### Running Keycloak instance
Before adding any project-specific configuration I’ve configured my OS’s hosts file, so that I’ll have a convenient URL address for testing. The location of this file depends on the OS:

- Linux (Ubuntu)
- Windows 10
- Mac
Once you found it add following line:
```
127.0.0.1	keycloak
```
After that instead of http://localhost we will be able to use the http://keycloak URL. Be mindful, that it's not necessary step, you can skip it and use the localhost instead of keycloak as I will thru this blog post.

Having it we can move the setting up Keycloak. First thing to do is to create a Docker Compose file where will be included entire Keycloak configuration. Looking into the documentation on Docker Hub we can find out that jboss/keycloak Docker image supports multiple databases, like H2, MySQL, PostgreSQL, MariaDB, Oracle or Microsoft SQL Server.

I’ve decided to go with PostgreSQL, therefore here is a simple definition of postgres component in docker-compose.yaml.
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
volumes:
  postgres:
```
Apart from a standard definition, like an image, container_name or ports mapping I've decided to set up a user and password to the database as postgres using the environment variable, which is documented on Docker Hub for postgres image.

Next thing worth to mention here is that I’ve added a volume, first one is just to persist container data on my local machine and the latter is for adding initial sql script, so it will be executed during first start up and it'll create a database and a user which will be used by Keycloak.
```db
CREATE USER keycloak WITH ENCRYPTED PASSWORD 'keycloak';
CREATE DATABASE keycloak;
GRANT ALL PRIVILEGES ON DATABASE keycloak TO keycloak;
```
This script is located in the .infra/postgres folder on a host machine and it's mapped to a directory inside postgres Docker container /docker-entrypoint-initdb.d.

After that we can move on to defining Keycloak component.
```yaml
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
```
Again there is no rocket science here. Apart from the standard image definition, container_name and ports mapping we can see only environemnt variables that are used to tune Keycloak to be connected to the postgres database and to set a default username and password for an admin user.

The resulting docker-compose.yaml file looks as follows.
```yaml
version: "3.8"
services:
  
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
volumes:
  postgres:
```
Now go to terminal, navigate to a folder where your docker-compose.yaml file is located and run following command:
```
> docker-compose up -d keycloak
    Creating volume "keycloak-security-example_postgres" with default driver
    Creating volume "keycloak-security-example_prometheus" with default driver
    Pulling postgres (postgres:13.0-alpine)...
    13.0-alpine: Pulling from library/postgres
    188c0c94c7c5: Pull complete
    56f1d1b70e7f: Pull complete
    9b4f01476d2b: Pull complete
    16419214bc02: Pull complete
    4886fc567835: Pull complete
    9026d4fbeafa: Pull complete
    001c336294eb: Pull complete
    8abc6d154e9f: Pull complete
    Digest: sha256:d26ddee3648a324a9747b3257236322141920d5f9a82ca703def6bff1cca7067
    Status: Downloaded newer image for postgres:13.0-alpine
    Pulling keycloak (jboss/keycloak:11.0.2)...
    11.0.2: Pulling from jboss/keycloak
    0fd3b5213a9b: Pull complete
    aebb8c556853: Pull complete
    ed3ae09abceb: Pull complete
    85e3448ea914: Pull complete
    9f0e9c75b3b9: Pull complete
    Digest: sha256:8cdd41cb4a0b210ed3f07df5d18306762e1755bb8d6c1ffc5e083c080528783d
    Status: Downloaded newer image for jboss/keycloak:11.0.2
    Creating postgres ... done
    Creating keycloak ... done
```
With above command we have pulled (downloaded) both Docker images and started new containers.

To check if everything is all right run another Docker command to see running containers:
```
> docker ps
CONTAINER ID  IMAGE                 STATUS            NAMES
f9a67e3b9756  jboss/keycloak:11.0.2  Up 33 seconds    keycloak
5d781b2b8d6f  postgres:13.0-alpine   Up 34 seconds    postgres
```
The status is Up so everything look fine :). If for some reasons it's not the case for you, check if you do not have any kind of a typo.

### Adding realm, client, roles and users
As we have a confirmation that Keycloak is running, let’s login to it. Therefore, in your browser go to http://keycloak:8080, it will lead you to a home page.

![Desktop Screenshot](images/keyclock-1.png)

Select Administration Console, it will redirect you to the login page, where you need to provide an admin credentials which are (same as they were definited in docker-compose.yaml file):
```
username: admin
passowrd: admin
```
After login you should now be inside of Keycloak’s Master realm.

![Desktop Screenshot](images/keyclock-2.png)

But what is realm? It’s purely a Keycloak thing and it’s used to for grouping resources like users, clients etc. Realms are isolated from each other so users from one realm will not be visible in another one, so these realms could be treated as separte instances of authorization servers.

To create a new realm click on the dropdown list located in the top left corner on the name of a current realm Master. Then click a button **Add Realm**.

![Desktop Screenshot](images/keyclock-3.png)

Next page is fairly simple, only thing to do is to provide a realm name here. I’m going with a name **test**.

![Desktop Screenshot](images/keyclock-4.png)

After hitting Create button a new realm is successfully created.

### Create a client credentials
Because we’re building an authentication & authorization based on OAuth 2.0 and OpenID we’ll have two different applications — protected resource that is a backend application that servers some data and a client application, a frontend that will want to access data from protected resource. To do that frontend application will need to have an access token. And to obtain that a client needs to be registered (has client id and client secret) on the authorization server side, Keycloak in our case.

Creation of a client for a frontend app I’ll cover in relevant article. Right now I’ll create a client just for testing Keycloak setup.

Therefore go to the Clients page (it’s located in the left menu) and click Create button located on a right.

![Desktop Screenshot](images/keyclock-5.png)

In a new view we need to provide only a client name, which will be test_client.

![Desktop Screenshot](images/keyclock-6.png)

After hitting the Save button a detailed page for newly created client will show up. To finish configurating frontend client we need first set an Access Type to confidential and then switch on Service Accounts Enabled and Authorization Enabled. And finally we need to provide a Redirect URI which in our case will be http://localhost:80, http://localhost:4200 which are base URL of frontend application (will be build in upcoming article).

![Desktop Screenshot](images/keyclock-7.png)

Let’s now test if we’re be able to receive tokens using using client_credentials OAuth 2.0 grant type. In short, this grant type is used when there is no resource owner (person, user), but a client application needs to get to the protected resource using an access token. In this flow a client application is providing only its credentials and scope to the authorization server and as a result it returns valid tokens.

To test it I’m using Postman, but if you prefer different tool, like curl, go ahead with your favourite tool.

In Postman create a request tab and provide following information:
```
Method: POST
Url: http://keycloak:8080/auth/realms/test/protocol/openid-connect/token
```
The token Url is a standard Keycloak one. If you name your realm differently than me, you will need to replace test in above path to your name.

Then in a Body tab select x-www-form-urlencoded option and in a table provide following data.
```
grant_type: client_credentials
scope: openid
client_id: test_client
client_secret: 8ac27a39-fa84-46b9-8c30-b485056e0cea
```
If you’re set up your own Keycloak instance a client_secret might be different for you. To check it out go back to the test_client client page in Keycloak and select Credentials tab. There you should find your secret.

![Desktop Screenshot](images/keyclock-8.png)

And finally, after clicking Send button you should get a following response with access, identity and refresh token:

![Desktop Screenshot](images/keyclock-9.png)

```json
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJXYmdnRkNBNzJ4UG5KYWNUZTRHMzdEN1NDWFpJOW8wQVZMTWd0d0tfamhRIn0.eyJleHAiOjE2MTM2Mjc1NzYsImlhdCI6MTYxMzYyNzI3NiwianRpIjoiZjkzODVlMDMtYzRjOC00NzY0LWIyMDgtYzBhYWFiMjIyODEyIiwiaXNzIjoiaHR0cDovL2tleWNsb2FrOjgwODAvYXV0aC9yZWFsbXMvdGVzdCIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIwODhjNTdiMy1mNGJlLTQwOTQtOGQzNC00Y2UyNWQ1OGUzY2IiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJ0ZXN0X2NsaWVudCIsInNlc3Npb25fc3RhdGUiOiJlMTYxMTNjZi0wZGI5LTRlZDMtOGJjMC0yNWRmNDY4MDU2NjkiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJ0ZXN0X2NsaWVudCI6eyJyb2xlcyI6WyJ1bWFfcHJvdGVjdGlvbiJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiY2xpZW50SWQiOiJ0ZXN0X2NsaWVudCIsImNsaWVudEhvc3QiOiIxNzIuMTguMC4xIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LXRlc3RfY2xpZW50IiwiY2xpZW50QWRkcmVzcyI6IjE3Mi4xOC4wLjEifQ.ihCQGFWRdr1NR7el7zsnnXZFwonOpFgEE_MHBlYSq07s2JhjsLJauvQ9erTM5YV_gmY-Q-QpmpRI-qq4miF9hem8qxXzxBkei7cXyYYQeiz44MwkusUW75VChfsYljgRNUSJM5G4_O636xWQNc2ET5v8508CPpgVIvl4QFKYQui3J2BADH8AyDihgaOcF5hfrutuEpH6AINvBmUebUKOLG3ZyST81Q3GjmSZmBaL7RK29uTm94i1HVqfXgRLIuf5zxLucq_gU4KM8c3mB5d8ZfJOMl8nOnYDbEbiGVEP_coz9x3iF2Lf3Fp8K2zez59w4yvGTy39Whns-KhtX02yAQ",
    "expires_in": 300,
    "refresh_expires_in": 1800,
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJjZGQ0ZTczOC0zMDU1LTQ5YjAtOTM2Mi00NjAyNTZiNTdkNTQifQ.eyJleHAiOjE2MTM2MjkwNzYsImlhdCI6MTYxMzYyNzI3NiwianRpIjoiMDhmZjgyYjktNTZhZS00MjQ0LTg4MWEtYjY2MmU5NDU2YWFiIiwiaXNzIjoiaHR0cDovL2tleWNsb2FrOjgwODAvYXV0aC9yZWFsbXMvdGVzdCIsImF1ZCI6Imh0dHA6Ly9rZXljbG9hazo4MDgwL2F1dGgvcmVhbG1zL3Rlc3QiLCJzdWIiOiIwODhjNTdiMy1mNGJlLTQwOTQtOGQzNC00Y2UyNWQ1OGUzY2IiLCJ0eXAiOiJSZWZyZXNoIiwiYXpwIjoidGVzdF9jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiZTE2MTEzY2YtMGRiOS00ZWQzLThiYzAtMjVkZjQ2ODA1NjY5Iiwic2NvcGUiOiJvcGVuaWQgZW1haWwgcHJvZmlsZSJ9._aclvBR9ij5B6Zq1EO7g_5RoZA6pK6SqvMlj1Sb5ero",
    "token_type": "bearer",
    "id_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJXYmdnRkNBNzJ4UG5KYWNUZTRHMzdEN1NDWFpJOW8wQVZMTWd0d0tfamhRIn0.eyJleHAiOjE2MTM2Mjc1NzYsImlhdCI6MTYxMzYyNzI3NiwiYXV0aF90aW1lIjowLCJqdGkiOiI4ODNiMzM2YS01YTU3LTQzOTItODY2YS1kOGU5ZDI4ZDQwNTAiLCJpc3MiOiJodHRwOi8va2V5Y2xvYWs6ODA4MC9hdXRoL3JlYWxtcy90ZXN0IiwiYXVkIjoidGVzdF9jbGllbnQiLCJzdWIiOiIwODhjNTdiMy1mNGJlLTQwOTQtOGQzNC00Y2UyNWQ1OGUzY2IiLCJ0eXAiOiJJRCIsImF6cCI6InRlc3RfY2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6ImUxNjExM2NmLTBkYjktNGVkMy04YmMwLTI1ZGY0NjgwNTY2OSIsImF0X2hhc2giOiJxaDJmQ25ISXBMYWV3LVRPYTZOWGdRIiwiYWNyIjoiMSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiY2xpZW50SWQiOiJ0ZXN0X2NsaWVudCIsImNsaWVudEhvc3QiOiIxNzIuMTguMC4xIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LXRlc3RfY2xpZW50IiwiY2xpZW50QWRkcmVzcyI6IjE3Mi4xOC4wLjEifQ.TzbQRhk_z0YqfUnDi2T4iYHtw0flKTWh4MNcsAX3gqDV3GbxS2I0h45Z56ZurtPHf1idFKLo44mK-vopR3pt0WSzZx4U9_kQWPOK8BvoUIlft4lGNzgEU_wVIKG3B7RBCq82DVfC6b6g8yGI9D8xXkPCApwqxPoGVs1eTizCWubuRjddQzZTZ5Ida4vvPLXhRwVMNYMEb7h_4Oy8GC2zGNulBCUMpUDmLkqfSaOzKHwn8gOBJABIdmAqB5GbVDtfwpPdjk4exAohU8Gd6YcMSo2H94ZGJtEWZyZw_hOUbF1g5t9rxNnWCDuRkzZBFmVOeqzUZ3n-YQjnYJrpyQG8tg",
    "not-before-policy": 0,
    "session_state": "e16113cf-0db9-4ed3-8bc0-25df46805669",
    "scope": "openid email profile"
}
```
Awesome! 🤟 If you want, you can all these tokens on JWT.io website, to find out what data all these tokens holds.

### Create a user and roles
Once we registered a client in Keycloak, we need to create users (resource owners) and give them different roles to differentiate what actions on protected resource they can perform.

First step would be to define two roles — VISITOR & ADMIN. Their naming and actual meaning is not that important, at least for this demo project.

Therefore to define a VISITOR open Keycloak realm page and go to Roles available on the left panel. Then click Add Role button. On a new screen provide the Role Name and some Description and hit Save.

![Desktop Screenshot](images/keyclock-10.png)

For the ADMIN role do the same.

![Desktop Screenshot](images/keyclock-11.png)

Now we move to registering a new user. Therefore click on the Users button available on the left panel and then click the Add User button. On a first page we need to provide some basic information about the user, like username, email etc.

![Desktop Screenshot](images/keyclock-12.png)

After hiting the Save button luke's detailed page will appear. To assign just created role we need to go the Role Mappings tab, select the role (in my case VISITOR) and then click the Add selected button.

![Desktop Screenshot](images/keyclock-13.png)

And finally we need to set up a password for this user, so go to the Credentials tab and provide it (in my case its password). Make sure that Temporary toggle is switched off.

![Desktop Screenshot](images/keyclock-14.png)

If you want, you can create a second user which will be assigned to a second role.

To test if everything is set up correctly again I’ll use Postman. As it was previously I would like to get tokens, but this time with different OAuth 2.0 grant type. This time I’ll use the password grant type, in which we are asked to provide both client and resource owner credentials.

The HTTP method and Url does not change and they are:
```
Method: POST
Url: http://keycloak:8080/auth/realms/test/protocol/openid-connect/token
Also the content type remain the same — x-www-form-urlencoded. What is different is the body of the request (but not entirely):

grant_type: password
scope: openid
client_id: test_client
client_secret: 8ac27a39-fa84-46b9-8c30-b485056e0cea
username: luke
password: password
```

![Desktop Screenshot](images/keyclock-16.png)

As a result again, we get set of tokens. If we then copy-paste an access token to the JWT.io to decode it we can see that it holds basic information about the user and assigned roles.

![Desktop Screenshot](images/keyclock-18.png)

Great! We’ve got a fully operation authorization server!

### Single-click set up
It’s awesome that we’ve got authorization up and running, but here is the problem — how to avoid these manual steps in future? Nothing more simple, we can export realm that we have just created!

One remark, before making hands dirty — please be aware that this approach is very good for development purposes, but I would advice not to use it for production, chiefly because we will export information about users and its credentials, which is not secure.

If you have still running Keycloak instance, stop it. Then go to the docker-compose.yaml file and add a new volume for keycloak service - ./:/temp (I'm ignoring the env variable to keep it tight).
```yaml
keycloak:
    image: jboss/keycloak:11.0.2
    container_name: keycloak
    ports:
      - 8080:8080
    volumes:
      - ./:/temp
    depends_on:
      - postgres
```
Now run again Keycloak with docker-compose up -d keycloak command. Having it running we can now run the export commnad inside running Docker container using a console (based on solution described here):
```
> docker exec -it keycloak /opt/jboss/keycloak/bin/standalone.sh
   -Djboss.socket.binding.port-offset=100 
   -Dkeycloak.migration.action=export 
   -Dkeycloak.migration.provider=singleFile 
   -Dkeycloak.migration.realmName=test 
   -Dkeycloak.migration.usersExportStrategy=REALM_FILE 
   -Dkeycloak.migration.file=/temp/realm-test.json
```
As a result we’ll get the realm-test.json file in root directory of the project. Great, now let’s set up importing this JSON file.

Go back now to the docker-compose.yaml file where we need to change a temporary volume, add additional command and new environment variable:
```yaml
keycloak:
    image: jboss/keycloak:11.0.2
    container_name: keycloak
    ports:
      - 8080:8080
    environment:
      - KEYCLOAK_IMPORT=/tmp/realm-test.json
    volumes:
      - ./infra/keycloak/realm-test.json:/tmp/realm-test.json
    command: ["-Dkeycloak.profile.feature.upload_scripts=enabled"]
    depends_on:
      - postgres
```
Next we need to copy realm-test.json to a new folder /infra/keycloak (or wherever you would like to put it).

Now if you remove all Docker containers and volumes and start Keycloak again you will see the same data that you have provided before!



What is OAuth 2.0? Understanding OAuth Terminology What is OIDC ? Keycloak Authorization Code Flow Demo Implement Authorization Code Flow What is PKCE Authorization Code Flow PKCE Authorization Code Flow Demo Implement PKCE Authorization Code Flow What is Client Credentials Flow Client Credentials Demo Implement Client Credentials Flow Introduction to Token Relay What is Refresh Token Flow Refresh Token Flow Demo What is Password Grant Flow Password Grant Flow Demo What is Single Sign-On Single Sign-On Demo Implement Single Sign-On using Github


OAuth 2.0 is an open standard for access delegation, commonly used as a way for Internet users to grant websites or applications access to their information on other websites without sharing their login credentials. It provides a secure and standardized way for authentication and authorization processes.

OIDC, or OpenID Connect, is an authentication layer built on top of OAuth 2.0. It allows clients to verify the identity of the end-user based on the authentication performed by an authorization server, as well as to obtain basic profile information about the end-user in an interoperable and REST-like manner.

Keycloak is an open-source identity and access management solution that supports OAuth 2.0 and OIDC protocols, providing centralized authentication, authorization, and user management for applications and services.

Authorization Code Flow is a secure way to obtain access tokens from an authorization server by exchanging an authorization code. It is commonly used in web applications where the client can securely store the client secret.

PKCE, or Proof Key for Code Exchange, is an extension to the Authorization Code Flow that helps mitigate the security risks of handling authorization codes in mobile and native applications.

Client Credentials Flow is a simplified OAuth 2.0 flow where the client application authenticates directly with the authorization server using its client credentials to obtain an access token.

Token Relay is a method where a client application forwards an access token obtained through OAuth 2.0 to another application to access protected resources on behalf of the end-user.

Refresh Token Flow is a way to obtain a new access token when the current access token expires without requiring the end-user to re-enter their credentials.

Password Grant Flow is a way for clients to exchange a user's username and password for an access token directly with the authorization server. It is considered less secure than other OAuth 2.0 flows, as it requires the client to handle user credentials.

Single Sign-On (SSO) is a mechanism that allows users to access multiple applications or services with a single set of login credentials. It simplifies the user experience and improves security by centralizing authentication.

Implementing Single Sign-On using Github involves integrating Github as an identity provider to authenticate users across multiple applications using OAuth 2.0 or OIDC. This allows users to log in with their Github account and access different services without having to log in again.
