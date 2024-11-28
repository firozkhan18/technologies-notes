To develop a Jira plugin for Atlassian, you'll need to follow specific steps to set up your development environment, configure the plugin, and use the correct commands to create and manage it. Here's a general guide for Jira plugin development:

### 1. **Set up the Development Environment**

Before creating a Jira plugin, you'll need the following:

- **JDK**: Atlassian plugins typically require Java Development Kit (JDK) 8 or higher.
- **Atlassian SDK**: The Atlassian SDK is essential for creating and testing plugins.

To install the Atlassian SDK:

1. Download the Atlassian SDK from [Atlassian SDK Downloads](https://developer.atlassian.com/server/framework/atlassian-sdk/).
2. Install it following the instructions for your operating system.

### 2. **Create a Jira Plugin Project**

Once you have the SDK installed, you can create a new Jira plugin project. Use the following Maven commands to create your project.

#### Command to create a Jira plugin:

```bash
atlas-create-jira-plugin
```

This command will prompt you for the following details:

- **Group ID**: A unique identifier for your project.
- **Artifact ID**: A unique name for the plugin.
- **Version**: The version of the plugin.
- **Package**: The Java package that will contain your plugin code.

Example:
```bash
atlas-create-jira-plugin
```

It will guide you through the project creation process. After this, the directory structure will be created for you, including sample code and configuration files.

### 3. **Configure the Plugin**

After creating the plugin, you’ll need to configure it by modifying `atlassian-plugin.xml` inside the `src/main/resources` directory. This is the main configuration file that defines the components of your plugin, such as:

- **Modules**: Define your plugin's features like web panels, custom fields, and more.
- **Dependencies**: If your plugin depends on other modules or plugins, list them here.

For example:
```xml
<atlassian-plugin key="com.example.myplugin">
    <plugin-info>
        <name>My Jira Plugin</name>
        <description>Example Jira plugin</description>
        <version>1.0.0</version>
        <vendor name="Your Company" url="http://example.com"/>
    </plugin-info>

    <!-- Example of a web panel module -->
    <web-panel key="example-web-panel" name="Example Web Panel" location="atl.jira.view.issue.right.context" weight="100">
        <description>This is an example web panel</description>
        <resource type="velocity" name="view.vm" />
    </web-panel>
</atlassian-plugin>
```

### 4. **Develop the Plugin**

Now you can start adding the functionality for your plugin. Here are some common modules to use:

- **Web Panel**: Display custom information on the Jira issue page.
- **Custom Field**: Create custom fields for issues in Jira.
- **Listeners**: Implement event listeners for Jira events (like issue creation).
- **REST APIs**: Create custom REST APIs for your plugin.

### 5. **Build the Plugin**

To build the plugin, use the following command:

```bash
atlas-package
```

This will compile the plugin and create a `.jar` file in the `target/` directory of your project.

### 6. **Run Jira with Your Plugin**

To test your plugin locally, you can run a Jira instance with your plugin installed by using:

```bash
atlas-run
```

This command starts a Jira instance with your plugin installed in development mode. You can access Jira at `http://localhost:2990/jira` (default port) and see your plugin in action.

### 7. **Deploy the Plugin**

Once you're happy with the plugin, you can deploy it to your Jira instance or share it with others. To deploy your plugin to a live Jira instance, use the `.jar` file generated from the build step.

To install the plugin in a Jira instance, go to:

- Jira Administration → Manage Apps → Upload App → Choose the `.jar` file.

### 8. **Useful Commands**

- **Create Plugin**: `atlas-create-jira-plugin`
- **Build Plugin**: `atlas-package`
- **Run Jira with the Plugin**: `atlas-run`
- **Deploy Plugin to Atlassian Marketplace**: You’ll need to package the plugin and follow the steps for uploading it to the Atlassian Marketplace.

### 9. **Additional Resources**

- **Atlassian Developer Documentation**: [https://developer.atlassian.com/server/jira/platform/](https://developer.atlassian.com/server/jira/platform/)
- **Atlassian Plugin SDK Documentation**: [https://developer.atlassian.com/server/framework/atlassian-sdk/](https://developer.atlassian.com/server/framework/atlassian-sdk/)

With this setup, you're ready to develop, test, and deploy Jira plugins effectively!

Here's a table summarizing common **Atlassian Jira Plugin Development Commands** and a list of **Jira Plugin Components** with their descriptions:

### 1. **Atlassian Jira Plugin Development Commands**

| Command                         | Description                                                                                         |
|----------------------------------|-----------------------------------------------------------------------------------------------------|
| `atlas-create-jira-plugin`       | Creates a new Jira plugin project with required directory structure and configuration files.       |
| `atlas-run`                      | Starts a local Jira instance with your plugin installed in development mode.                        |
| `atlas-package`                  | Packages the plugin into a `.jar` file that can be installed in Jira.                               |
| `atlas-debug`                    | Runs Jira in debug mode, allowing you to step through the plugin code for debugging.               |
| `atlas-mvn clean install`        | Compiles and installs your plugin into the local Maven repository.                                  |
| `atlas-install-plugin`           | Installs your plugin into a running Jira instance (useful after building your plugin).              |
| `atlas-deploy`                   | Deploys your plugin to an Atlassian product (Jira, Confluence, etc.) after creating a packaged JAR. |
| `atlas-help`                     | Displays a list of available commands and additional help information for the Atlassian SDK.       |

---

### 2. **Jira Plugin Components**

| Component                  | Description                                                                                                     |
|----------------------------|-----------------------------------------------------------------------------------------------------------------|
| **Web Panel**               | Adds custom panels to Jira pages (e.g., issue view, dashboards). You can use Velocity templates for rendering.  |
| **Web Item**                | Adds custom menu items (links) to Jira's user interface (e.g., top navigation, context menus).                  |
| **Custom Field**            | Defines custom fields to be used in Jira issues, which can store specialized data types.                       |
| **Listener**                | Listens for Jira events (e.g., issue created, issue updated) and executes actions in response.                  |
| **Condition**               | Defines conditions that must be met for certain actions or workflows to be executed (e.g., permission checks).   |
| **Validator**               | Validates input or conditions before performing a specific action (e.g., before transitioning an issue).         |
| **Transition Postfunction** | Adds actions to be executed after a workflow transition, such as updating fields or sending notifications.       |
| **REST API**                | Provides custom REST endpoints to expose additional functionality or data outside of Jira.                      |
| **Servlet**                 | Adds custom servlets to handle HTTP requests (e.g., creating a custom page or API endpoint).                     |
| **Active Objects**          | A lightweight database abstraction layer for persistent storage in Jira, typically used for managing data models. |
| **Job**                     | Creates background jobs that run periodically or in response to specific triggers.                             |
| **Conditions (Workflow)**   | Defines whether a transition in a workflow should be available, based on specific conditions like user roles.    |
| **Security Level**          | Specifies who can view a particular issue or project based on security level configurations.                   |
| **Notification Scheme**     | Defines the rules for sending notifications when specific Jira events occur (e.g., issue creation).             |
| **Event**                   | Defines custom Jira events that can be triggered for actions like issue updates, state transitions, etc.         |
| **Message Customization**   | Modifies messages or emails sent by Jira to users based on certain actions or events.                         |
| **Scheduler**               | Schedules periodic tasks that can run background processes or maintenance scripts within Jira.                 |

These components are used in various modules to build custom Jira functionality and integrations, and can be defined in the `atlassian-plugin.xml` file to map the components to their respective actions within Jira.

Here are the answers to the **Atlassian Jira Plugin Development interview questions** I previously listed:

---

### **Technical Questions on Jira Plugin Development**

| **Question**                                                                                                   | **Answer**                                                                                                                |
|---------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| **What is Atlassian SDK and how do you use it for plugin development?**                                          | The **Atlassian SDK** is a set of tools provided by Atlassian to facilitate plugin development. It includes commands like `atlas-create-jira-plugin`, `atlas-run`, `atlas-package`, etc., to quickly set up, develop, and test plugins. |
| **What are the key modules in an Atlassian Jira plugin?**                                                       | Common modules include **Web Panels** (UI customization), **Web Items** (menu links), **Custom Fields** (custom data fields), **Listeners** (event handlers), **REST APIs** (custom endpoints), **Validators/Postfunctions** (workflow enhancements). |
| **Explain the structure of a Jira plugin project.**                                                             | A typical Jira plugin project has a `src/main/resources` folder for configuration files (like `atlassian-plugin.xml`), `src/main/java` for Java code, and `target/` where the compiled `.jar` is stored. |
| **How would you create a custom field in Jira?**                                                                | You would define a custom field module in the `atlassian-plugin.xml` file, specify its type, label, and data type, then implement the logic in Java to handle its behavior. |
| **What is a Web Panel in Jira? Can you give an example of its use?**                                            | A **Web Panel** is a UI component that can be placed on Jira pages (e.g., issue view, dashboards). For example, adding a Web Panel on the issue view to display additional information like custom comments. |
| **What are the different types of listeners you can create in Jira? How do you handle events in Jira?**         | **Listeners** can respond to events like **Issue Created**, **Issue Updated**, **Issue Transitioned**, etc. You can implement the listener interface and use methods like `onIssueCreated` or `onIssueUpdated` to handle specific events. |
| **Explain the difference between a Web Panel and a Web Item in Jira.**                                          | A **Web Panel** is used to display content in Jira's UI (e.g., sidebar or issue view), while a **Web Item** creates a clickable link or button in the UI (e.g., in the top navigation bar or issue context menu). |
| **How do you add custom REST endpoints to a Jira plugin?**                                                      | You can add custom REST endpoints by creating a **Rest Module** in the `atlassian-plugin.xml` file, and implementing a resource class using Atlassian's REST API framework to handle the endpoints. |
| **Can you explain how Atlassian's Active Objects work in Jira?**                                                | **Active Objects** is an Object-Relational Mapping (ORM) framework used in Jira plugins to store data persistently in a lightweight database. It simplifies database interactions without needing a full-fledged ORM framework like Hibernate. |
| **How would you deploy a Jira plugin to a live Jira instance?**                                                 | After packaging the plugin using `atlas-package`, you can deploy it by going to **Jira Administration** → **Manage Apps** → **Upload App** and selecting the `.jar` file generated. |
| **What are Validators and Post-functions in Jira workflows? How do they work?**                                | **Validators** check if specific conditions are met before allowing a transition (e.g., checking if a field is filled). **Post-functions** execute additional actions after a transition, like updating fields or sending notifications. |
| **How do you handle Jira plugin versioning and compatibility with different Jira versions?**                  | When developing a Jira plugin, ensure you set the correct version in `atlassian-plugin.xml` and test it with various Jira versions. Use `pom.xml` dependencies for version control and manage backward compatibility. |
| **Explain the `atlassian-plugin.xml` file and its role in a Jira plugin.**                                       | The `atlassian-plugin.xml` is the configuration file for a Jira plugin. It registers modules (Web Panels, Listeners, etc.), defines metadata (name, description), and specifies dependencies. |
| **How can you implement internationalization (i18n) in a Jira plugin?**                                         | Use resource bundles (`*.properties` files) to define strings in multiple languages and reference them in your Java code or UI components to allow the plugin to adapt to different locales. |
| **What is the lifecycle of a Jira plugin?**                                                                     | The lifecycle of a Jira plugin includes initialization, activation, deactivation, and uninstallation. You can define lifecycle methods in the plugin code using hooks like `@Plugin` annotations. |
---

### **Conceptual Questions**

| **Question**                                                                                                   | **Answer**                                                                                                                |
|---------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| **How do you ensure a Jira plugin is scalable and maintainable?**                                                | By following best practices such as modularizing code, using interfaces, writing unit tests, and keeping the plugin's configuration flexible. Regular refactoring and following code standards also help maintainability. |
| **What are the challenges you might face while developing a Jira plugin and how would you overcome them?**        | Challenges include API changes between Jira versions, performance issues with complex queries, and backward compatibility. These can be overcome by using Atlassian's SDK tools, extensive testing, and handling exceptions gracefully. |
| **How do you troubleshoot issues or errors that occur in a Jira plugin?**                                        | Troubleshooting can be done by checking logs (`logs/atlassian-jira.log`), using `atlas-debug` to run Jira in debug mode, inspecting error messages, and isolating the problematic module. |
| **What would be your approach for writing automated tests for a Jira plugin?**                                   | Use testing frameworks like **JUnit** or **Mockito** to write unit and integration tests for your plugin's Java classes. Also, use **Selenium** or **Cucumber** for UI and behavior-driven testing if applicable. |
| **What is the purpose of the `plugin-info` tag in the `atlassian-plugin.xml` file?**                                | The `plugin-info` tag contains metadata about the plugin, such as its name, version, description, vendor, and other details that describe the plugin to Jira administrators. |
| **What are some security considerations when developing Jira plugins?**                                          | Ensure safe input validation, proper authentication and authorization (e.g., using Jira's security modules), avoid exposing sensitive data, and protect against common vulnerabilities like XSS and SQL injection. |
| **How do you ensure your Jira plugin doesn't negatively impact Jira performance?**                               | Minimize heavy queries, reduce API calls, use caching where possible, and avoid blocking operations in event listeners or background tasks. Regularly profiling and testing the plugin's performance is crucial. |
| **What is the purpose of the `maven-dependency-plugin` in Atlassian plugin development?**                         | The **maven-dependency-plugin** is used to manage dependencies in the Maven build process. It helps in resolving and downloading necessary dependencies for the plugin, ensuring the plugin builds correctly. |
---

### **Practical Problem-Solving Questions**

| **Question**                                                                                                   | **Answer**                                                                                                                |
|---------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| **You need to add a custom field to Jira's issue page that stores a numeric value. How would you do this?**      | You would create a custom field module in `atlassian-plugin.xml`, specify the field type (e.g., `NumberField`), and implement Java code to handle its behavior, like validation or rendering. |
| **Write a sample Jira listener to send an email whenever an issue is transitioned to "Done".**                   | Implement a listener for the `IssueTransitionedEvent`. In the listener, check if the new status is "Done", and then use Jira's email service to send an email notification. |
| **You need to create a plugin that allows users to add a custom comment to Jira issues, triggered by a button.**  | Use a **Web Item** to create a button in the issue view. When clicked, it calls a Java method that adds the custom comment to the issue via Jira's `CommentService`. |
| **How would you create a REST endpoint that returns a list of issues assigned to the current user in Jira?**      | Define a new **Rest Module** in `atlassian-plugin.xml`, create a resource class with a method that queries the Jira database for issues assigned to the current user using Jira's **IssueService** and return the result as JSON. |
---

### **Soft Skills / Project Management Questions**

| **Question**                                                                                                   | **Answer**                                                                                                                |
|---------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| **Have you worked with teams to integrate Jira plugins into larger systems? How do you ensure smooth integration?**| Yes, collaboration is key. I communicate requirements clearly, use version control (e.g., Git), perform integration testing, and ensure compatibility with other plugins or systems through proper versioning. |
| **How do you approach project deadlines when working on a Jira plugin?**                                        | I prioritize features based on business impact, break down tasks into smaller achievable parts, and ensure continuous testing and feedback throughout the development cycle to meet deadlines. |
| **Tell us about a challenging plugin you developed and how you overcame the challenge.**                         | One challenge was optimizing a plugin that fetched large datasets from Jira. I used caching, optimized queries, and tested for performance to ensure the plugin did not degrade Jira's performance. |

In Atlassian Jira, you can create various types of modules using the Atlassian SDK command `atlas-create-jira-plugin`. Below are the common **types of modules** you can create with this command, along with an explanation and examples for each.

### **1. Web Panel**
A **Web Panel** allows you to add custom content (HTML, JavaScript, etc.) to a specific location on the Jira UI, such as issue views or dashboards.

- **Example**: Adding a custom panel to the issue view to display additional data.
  
  **Steps**:
  - Command: `atlas-create-jira-plugin`
  - Select **Web Panel** when prompted.
  
  **Code Example (`atlassian-plugin.xml`)**:
  ```xml
  <web-panel key="my-web-panel" location="atl.jira.view.issue.right.context" weight="100">
      <label>My Custom Web Panel</label>
      <description>Displays custom information on the issue view</description>
      <resource type="velocity" name="view" location="/templates/issue/web-panel.vm"/>
  </web-panel>
  ```
  In this example, the web panel is added to the **right context** of the issue view.

---

### **2. Web Item**
A **Web Item** is used to add custom links or buttons to Jira's UI, like top navigation or context menus.

- **Example**: Adding a custom link in the Jira issue context menu.
  
  **Steps**:
  - Command: `atlas-create-jira-plugin`
  - Select **Web Item** when prompted.
  
  **Code Example (`atlassian-plugin.xml`)**:
  ```xml
  <web-item key="my-web-item" section="system.top.navigation.bar" weight="100">
      <label>My Custom Link</label>
      <link>/secure/CustomPage.jspa</link>
      <description>Click to view custom page</description>
  </web-item>
  ```
  This example adds a custom link to the **top navigation bar** in Jira.

---

### **3. Custom Field**
A **Custom Field** allows you to create fields that can store and display specific types of data on Jira issues.

- **Example**: Creating a custom field that stores a numeric value.
  
  **Steps**:
  - Command: `atlas-create-jira-plugin`
  - Select **Custom Field** when prompted.
  
  **Code Example (`atlassian-plugin.xml`)**:
  ```xml
  <custom-field key="my-custom-field" name="My Custom Field" type="com.atlassian.jira.plugin.system.customfieldtypes:float">
      <description>Stores a numeric value</description>
  </custom-field>
  ```
  This creates a custom field that stores floating-point numeric values.

---

### **4. Listener**
A **Listener** reacts to events occurring within Jira, such as issue creation, updates, or transitions.

- **Example**: A listener that sends an email when an issue is transitioned to a specific status.
  
  **Steps**:
  - Command: `atlas-create-jira-plugin`
  - Select **Listener** when prompted.
  
  **Code Example (`atlassian-plugin.xml`)**:
  ```xml
  <listener key="my-listener" class="com.example.MyListener">
      <event>com.atlassian.jira.event.issue.IssueTransitionedEvent</event>
  </listener>
  ```
  In this example, the listener will react to the **Issue Transitioned** event.

  The listener's class (`com.example.MyListener`) might look like this:
  ```java
  public class MyListener implements EventListener {
      public void onEvent(Event event) {
          if (event instanceof IssueTransitionedEvent) {
              // Send an email or perform some action
          }
      }
  }
  ```

---

### **5. Validator**
A **Validator** checks whether a specific condition is met during a workflow transition before the transition is allowed to proceed.

- **Example**: A validator that checks if a custom field is filled before transitioning an issue.
  
  **Steps**:
  - Command: `atlas-create-jira-plugin`
  - Select **Validator** when prompted.
  
  **Code Example (`atlassian-plugin.xml`)**:
  ```xml
  <validator key="my-validator" class="com.example.MyValidator">
      <description>Checks if custom field is filled</description>
  </validator>
  ```
  In the validator class, you would implement logic to check if the required field is filled:
  ```java
  public class MyValidator implements Validator {
      public void validate(WorkflowContext context, Issue issue) {
          if (issue.getCustomFieldValue(customField) == null) {
              throw new ValidatorException("Custom field must be filled!");
          }
      }
  }
  ```

---

### **6. Transition Postfunction**
A **Postfunction** executes an action after a workflow transition (e.g., updating a field, sending a notification).

- **Example**: A post-function that updates a custom field after an issue is transitioned to "Done".
  
  **Steps**:
  - Command: `atlas-create-jira-plugin`
  - Select **Transition Postfunction** when prompted.
  
  **Code Example (`atlassian-plugin.xml`)**:
  ```xml
  <post-function key="my-post-function" class="com.example.MyPostFunction">
      <description>Updates custom field after issue transition</description>
  </post-function>
  ```
  The class would implement the logic to update the custom field:
  ```java
  public class MyPostFunction implements PostFunction {
      public void execute(MutableIssue issue) {
          issue.setCustomFieldValue(customField, "Completed");
      }
  }
  ```

---

### **7. REST API**
A **REST API** allows you to expose custom endpoints so that Jira data can be accessed programmatically.

- **Example**: Creating a REST endpoint that returns a list of issues assigned to the current user.
  
  **Steps**:
  - Command: `atlas-create-jira-plugin`
  - Select **REST API** when prompted.
  
  **Code Example (`atlassian-plugin.xml`)**:
  ```xml
  <rest key="my-rest-api" path="/issues" version="1.0">
      <description>Returns list of issues assigned to the current user</description>
      <resource class="com.example.MyRestResource"/>
  </rest>
  ```
  The REST resource class (`MyRestResource`) might look like this:
  ```java
  @Path("/issues")
  public class MyRestResource {
      @GET
      @Produces("application/json")
      public Response getIssuesForCurrentUser() {
          // Code to fetch and return issues assigned to the current user
      }
  }
  ```

---

### **8. Scheduled Job**
A **Scheduled Job** is used to run background tasks at specified intervals.

- **Example**: A job that runs every hour and checks if there are any issues that need attention.
  
  **Steps**:
  - Command: `atlas-create-jira-plugin`
  - Select **Scheduled Job** when prompted.
  
  **Code Example (`atlassian-plugin.xml`)**:
  ```xml
  <job key="my-scheduled-job" class="com.example.MyScheduledJob">
      <schedule>0 0 * * * ?</schedule> <!-- Every hour -->
      <description>Checks for issues that need attention</description>
  </job>
  ```
  The job class (`MyScheduledJob`) would implement the logic to perform the task:
  ```java
  public class MyScheduledJob implements Job {
      public void execute(JobExecutionContext context) {
          // Code to check issues and take actions
      }
  }
  ```

---

### **9. Condition (Workflow)**
A **Condition** in Jira Workflow determines whether a transition can proceed based on specific criteria.

- **Example**: A condition that checks if the user has a certain permission before they can transition an issue.
  
  **Steps**:
  - Command: `atlas-create-jira-plugin`
  - Select **Condition** when prompted.
  
  **Code Example (`atlassian-plugin.xml`)**:
  ```xml
  <condition key="my-condition" class="com.example.MyCondition">
      <description>Checks if user has permission to transition the issue</description>
  </condition>
  ```
  The condition class would implement logic to check user permissions:
  ```java
  public class MyCondition implements Condition {
      public boolean passesCondition(WorkflowContext context) {
          // Check if the user has the required permission
          return userHasPermission(context.getUser());
      }
  }
  ```

---

### **10. Security Level**
A **Security Level** controls who can view a particular issue based on specific conditions.

- **Example**: Defining a custom security level to restrict issue visibility to certain groups.
  
  **Steps**:
  - Command: `atlas-create-jira-plugin`
  - Select **Security Level** when prompted.
  
  **Code Example (`atlassian-plugin.xml`)**:
  ```xml
  <security-level key="my-security-level" name="Sensitive Issues" description="Only specific teams can view">
      <scheme>com.atlassian.jira.security:issueSecurityScheme</scheme>
      <group name="team1"/>
  </security-level>
  ```

---

### Conclusion
The **Atlassian Jira Plugin SDK** allows you to create various types of modules using predefined templates such as Web Panels, Web Items, Custom Fields, Listeners, Validators, and many others. These modules can be created by using the `atlas-create-jira-plugin` command and selecting the appropriate module type. Each module has its own configuration and implementation details, which can be customized according to the requirements of your plugin.
