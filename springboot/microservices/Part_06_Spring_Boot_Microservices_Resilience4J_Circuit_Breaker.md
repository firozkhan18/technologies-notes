## [<<PREV](Part_05_Spring_Boot_Microservices_Security.md) - MICROSERVICE Resilience4J CircuitBreaker - [NEXT>>](Part_07_Spring_Boot_Microservices_Distributed_Tracing.md)

Here's the content you provided, converted into a Markdown format:

```markdown
## [<<PREV](Part_04_Spring_Boot_Microservices_API_Gateway.md) - MICROSERVICE SECURITY - [NEXT>>](Part_06_Spring_Boot_Microservices_Resilience4J_Circuit_Breaker.md)

## Docker
Get started with Keycloak on Docker.

### Before you start
Make sure your machine or container platform can provide sufficient memory and CPU for your desired usage of Keycloak. See Concepts for sizing CPU and memory resources for more on how to get started with production sizing.

Make sure you have Docker installed.

### Start Keycloak
From a terminal, enter the following command to start Keycloak:

```bash
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:25.0.1 start-dev
```

This command starts Keycloak exposed on the local port 8080 and creates an initial admin user with the username `admin` and password `admin`.

### Log in to the Admin Console
Go to the Keycloak Admin Console.

Log in with the username and password you created earlier.

### Create a realm
A realm in Keycloak is equivalent to a tenant. Each realm allows an administrator to create isolated groups of applications and users. Initially, Keycloak includes a single realm called `master`. Use this realm only for managing Keycloak and not for managing any applications.

Use these steps to create the first realm:

1. Open the Keycloak Admin Console.
2. Click Keycloak next to the master realm, then click Create Realm.
3. Enter `myrealm` in the Realm name field.
4. Click Create.

![Desktop Screenshot](images/add-realm.png)

### Create a user
Initially, the realm has no users. Use these steps to create a user:

1. Verify that you are still in the `myrealm` realm, which is shown above the word Manage.
2. Click Users in the left-hand menu.
3. Click Add user.
4. Fill in the form with the following values:
   - Username: `myuser`
   - First name: any first name
   - Last name: any last name
5. Click Create.

![Desktop Screenshot](images/add-user.png)

This user needs a password to log in. To set the initial password:

1. Click Credentials at the top of the page.
2. Fill in the Set password form with a password.
3. Toggle Temporary to Off so that the user does not need to update this password at the first login.

![Desktop Screenshot](images/set-password.png)

### Log in to the Account Console
You can now log in to the Account Console to verify this user is configured correctly.

1. Open the Keycloak Account Console.
2. Log in with `myuser` and the password you created earlier.

As a user in the Account Console, you can manage your account, including modifying your profile, adding two-factor authentication, and including identity provider accounts.

![Desktop Screenshot](images/account-console.png)

### Secure the first application
To secure the first application, you start by registering the application with your Keycloak instance:

1. Open the Keycloak Admin Console.
2. Click the word master in the top-left corner, then click `myrealm`.
3. Click Clients.
4. Click Create client.
5. Fill in the form with the following values:
   - Client type: OpenID Connect
   - Client ID: `myclient`

![Desktop Screenshot](images/add-client-1.png)

6. Click Next.
7. Confirm that Standard flow is enabled.
8. Click Next.
9. Make these changes under Login settings:
   - Set Valid redirect URIs to `https://www.keycloak.org/app/*`
   - Set Web origins to `https://www.keycloak.org`
10. Click Save.

![Desktop Screenshot](images/add-client-2.png)

To confirm the client was created successfully, you can use the SPA testing application on the Keycloak website.

1. Open `https://www.keycloak.org/app/`.
2. Click Save to use the default configuration.
3. Click Sign in to authenticate to this application using the Keycloak server you started earlier.

### Taking the next step
Before you run Keycloak in production, consider the following actions:

- Switch to a production-ready database such as PostgreSQL.
- Configure SSL with your own certificates.
- Switch the admin password to a more secure password.

For more information, see the server guides.
```

Feel free to copy this Markdown content into your Markdown editor or viewer!
