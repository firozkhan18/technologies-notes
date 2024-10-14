Here's a guide for setting up Apache Kafka on Windows using the KRaft mode and ZooKeeper, along with creating a topic, writing and reading events, and using Kafka Connect:

### Step 1: Get Kafka

1. **Download Kafka**:
   - Go to the [Apache Kafka downloads page](https://kafka.apache.org/downloads) and download the latest release (e.g., `kafka_2.13-3.8.0.tgz`).
   
2. **Extract Kafka**:
   - Use a tool like 7-Zip or WinRAR to extract the downloaded file into a directory of your choice.

### Step 2: Start the Kafka Environment

**Note**: Make sure you have Java 8 or higher installed on your system. You can verify the installation by running `java -version` in Command Prompt.

#### Kafka with KRaft Mode

1. **Open Command Prompt** and navigate to the Kafka directory:
   ```cmd
   cd path\to\kafka_2.13-3.8.0
   ```

2. **Generate a Cluster UUID**:
   ```cmd
   set KAFKA_CLUSTER_ID=bin\kafka-storage.bat random-uuid
   ```

3. **Format Log Directories**:
   ```cmd
   bin\kafka-storage.bat format -t %KAFKA_CLUSTER_ID% -c config\kraft\server.properties
   ```

4. **Start the Kafka Server**:
   ```cmd
   bin\kafka-server-start.bat config\kraft\server.properties
   ```

#### Kafka with ZooKeeper

1. **Start ZooKeeper**:
   Open a new Command Prompt and navigate to the Kafka directory, then run:
   ```cmd
   bin\zookeeper-server-start.bat config\zookeeper.properties
   ```
**D:\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties**

```
Microsoft Windows [Version 10.0.19045.5011]
(c) Microsoft Corporation. All rights reserved.

D:\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
[2024-10-13 13:48:21,071] INFO Reading configuration from: .\config\zookeeper.properties (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2024-10-13 13:48:21,182] INFO clientPortAddress is 0.0.0.0:2181 (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2024-10-13 13:48:21,183] INFO secureClientPort is not set (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2024-10-13 13:48:21,183] INFO observerMasterPort is not set (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2024-10-13 13:48:21,183] INFO metricsProvider.className is org.apache.zookeeper.metrics.impl.DefaultMetricsProvider (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2024-10-13 13:48:21,190] INFO autopurge.snapRetainCount set to 3 (org.apache.zookeeper.server.DatadirCleanupManager)
[2024-10-13 13:48:21,190] INFO autopurge.purgeInterval set to 0 (org.apache.zookeeper.server.DatadirCleanupManager)
[2024-10-13 13:48:21,190] INFO Purge task is not scheduled. (org.apache.zookeeper.server.DatadirCleanupManager)
[2024-10-13 13:48:21,190] WARN Either no config or no quorum defined in config, running in standalone mode (org.apache.zookeeper.server.quorum.QuorumPeerMain)
[2024-10-13 13:48:21,196] INFO Log4j 1.2 jmx support not found; jmx disabled. (org.apache.zookeeper.jmx.ManagedUtil)
[2024-10-13 13:48:21,197] INFO Reading configuration from: .\config\zookeeper.properties (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2024-10-13 13:48:21,198] INFO clientPortAddress is 0.0.0.0:2181 (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2024-10-13 13:48:21,198] INFO secureClientPort is not set (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2024-10-13 13:48:21,198] INFO observerMasterPort is not set (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2024-10-13 13:48:21,199] INFO metricsProvider.className is org.apache.zookeeper.metrics.impl.DefaultMetricsProvider (org.apache.zookeeper.server.quorum.QuorumPeerConfig)
[2024-10-13 13:48:21,199] INFO Starting server (org.apache.zookeeper.server.ZooKeeperServerMain)
[2024-10-13 13:48:21,228] INFO ServerMetrics initialized with provider org.apache.zookeeper.metrics.impl.DefaultMetricsProvider@1d119efb (org.apache.zookeeper.server.ServerMetrics)
[2024-10-13 13:48:21,232] INFO ACL digest algorithm is: SHA1 (org.apache.zookeeper.server.auth.DigestAuthenticationProvider)
[2024-10-13 13:48:21,233] INFO zookeeper.DigestAuthenticationProvider.enabled = true (org.apache.zookeeper.server.auth.DigestAuthenticationProvider)
[2024-10-13 13:48:21,238] INFO zookeeper.snapshot.trust.empty : false (org.apache.zookeeper.server.persistence.FileTxnSnapLog)
[2024-10-13 13:48:21,262] INFO  (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,263] INFO   ______                  _                                           (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,264] INFO  |___  /                 | |                                          (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,268] INFO     / /    ___     ___   | | __   ___    ___   _ __     ___   _ __    (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,269] INFO    / /    / _ \   / _ \  | |/ /  / _ \  / _ \ | '_ \   / _ \ | '__| (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,269] INFO   / /__  | (_) | | (_) | |   <  |  __/ |  __/ | |_) | |  __/ | |     (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,271] INFO  /_____|  \___/   \___/  |_|\_\  \___|  \___| | .__/   \___| |_| (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,271] INFO                                               | |                      (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,272] INFO                                               |_|                      (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,273] INFO  (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,282] INFO Server environment:zookeeper.version=3.8.4-9316c2a7a97e1666d8f4593f34dd6fc36ecc436c, built on 2024-02-12 22:16 UTC (org.apache.zookeeper.server.ZooKeeperServer)
[2024-10-13 13:48:21,283] INFO Server environment:host.name=LAPTOP-EJNI8C5H.mshome.net (org.apache.zookeeper.server.ZooKeeperServer)
```
2. **Start Kafka Broker**:
   Open another Command Prompt and run:
   ```cmd
   bin\kafka-server-start.bat config\server.properties
   ```
**D:\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties**
```
Microsoft Windows [Version 10.0.19045.5011]
(c) Microsoft Corporation. All rights reserved.

D:\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties
[2024-10-13 13:55:26,736] INFO Registered kafka:type=kafka.Log4jController MBean (kafka.utils.Log4jControllerRegistration$)
[2024-10-13 13:55:27,439] INFO Setting -D jdk.tls.rejectClientInitiatedRenegotiation=true to disable client-initiated TLS renegotiation (org.apache.zookeeper.common.X509Util)
```

### Step 3: Create a Topic

1. Open another Command Prompt and run:
   ```cmd
   bin\kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092

   Or

   D:\kafka>.\bin\windows\kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092
   ```


2. To describe the topic:
   ```cmd
   bin\kafka-topics.bat --describe --topic quickstart-events --bootstrap-server localhost:9092

   Or

   D:\kafka>.\bin\windows\kafka-topics.bat --describe --topic quickstart-events --bootstrap-server localhost:9092
   ```

### Step 4: Write Events into the Topic

1. Open another Command Prompt and run:
   ```cmd
   bin\kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092

   Or

  D:\kafka>.\bin\windows\kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092

   ```

2. Type in some events:
   ```
   This is my first event
   This is my second event
   ```

   Stop the producer client with `Ctrl+C`.

### Step 5: Read the Events

1. Open another Command Prompt and run:
   ```cmd
   bin\kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092

Or

  D:\kafka>.\bin\windows\kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
   ```

### Step 6: Import/Export Data with Kafka Connect

1. **Edit the Configuration**:
   Open `config\connect-standalone.properties` in a text editor and add:
   ```properties
   plugin.path=libs\connect-file-3.8.0.jar
   ```

2. **Create Test Data**:
   Create a file `test.txt` with:
   ```cmd
   echo foo > test.txt
   echo bar >> test.txt
   ```

3. **Run Kafka Connect**:
   Run the following command in the Command Prompt:
   ```cmd
   bin\connect-standalone.bat config\connect-standalone.properties config\connect-file-source.properties config\connect-file-sink.properties

   Or

   D:\kafka>.\bin\windows\connect-standalone.bat config\connect-standalone.properties config\connect-file-source.properties config\connect-file-sink.properties
   ```

4. **Check the Output**:
   You can check the output file `test.sink.txt`:
   ```cmd
   more test.sink.txt
   ```

### Step 7: Process Events with Kafka Streams

You can write your Kafka Streams applications in Java/Scala. Here’s a simple example for a WordCount application:

```java
KStream<String, String> textLines = builder.stream("quickstart-events");

KTable<String, Long> wordCounts = textLines
        .flatMapValues(line -> Arrays.asList(line.toLowerCase().split(" ")))
        .groupBy((keyIgnored, word) -> word)
        .count();

wordCounts.toStream().to("output-topic", Produced.with(Serdes.String(), Serdes.Long()));
```

### Step 8: Terminate the Kafka Environment

1. Stop the producer and consumer clients with `Ctrl+C`.
2. Stop the Kafka broker with `Ctrl+C`.
3. If using ZooKeeper, stop the ZooKeeper server with `Ctrl+C`.

To clean up any data:
```cmd
rd /s /q C:\path\to\kafka_2.13-3.8.0\tmp\kafka-logs
rd /s /q C:\path\to\kafka_2.13-3.8.0\tmp\zookeeper
```

### Congratulations!

You have successfully completed the Apache Kafka quickstart on Windows. To learn more, explore the [Kafka documentation](https://kafka.apache.org/documentation/) and consider joining local Kafka meetups or watching Kafka Summit talks.


The error messages you're seeing indicate that your application is trying to connect to a Kafka broker at `127.0.0.1:9092`, but it cannot establish a connection. Here are some steps to troubleshoot this issue:

### 1. Check Kafka Broker Status
Make sure that your Kafka broker is running. You can check the status using:

```bash
# If using systemd
systemctl status kafka

# If running Kafka manually, check your terminal for logs
```

### 2. Verify Configuration
Ensure that your Kafka broker is configured to listen on `127.0.0.1:9092`. Check the `server.properties` file, typically located in the `config` directory of your Kafka installation:

```properties
listeners=PLAINTEXT://127.0.0.1:9092
```

### 3. Check for Multiple Kafka Instances
If you have multiple Kafka brokers or instances running, ensure you're connecting to the correct one. You may also need to verify that the advertised listeners are set up correctly:

```properties
advertised.listeners=PLAINTEXT://127.0.0.1:9092
```

### 4. Firewall and Network Issues
If your Kafka broker is running on a different machine or container, ensure that network settings or firewalls aren't blocking access to port 9092.

### 5. Review Logs
Check the logs of your Kafka broker for any errors or warnings that might provide more context on why the connection is failing. Logs are typically found in the `logs` directory of your Kafka installation.

### 6. Test Connection Manually
You can use a tool like `telnet` or `nc` to check if you can reach the Kafka broker on port 9092:

```bash
telnet 127.0.0.1 9092
```

### 7. Client Configuration
Double-check your application's Kafka client configuration to ensure it's pointing to the correct broker. If you have set up a different configuration for development or production, ensure you're using the right profile.

### 8. Restart Kafka
Sometimes, simply restarting the Kafka broker can resolve transient issues:

```bash
# If using systemd
sudo systemctl restart kafka

# If running manually, stop and then start the broker
```

The Kafka Connect Debezium Driver for PostgreSQL is a tool that captures changes from a PostgreSQL database and streams them into Kafka topics. This allows applications to react to changes in the database in real-time, enabling event-driven architectures.

### Key Features of Debezium PostgreSQL Connector

1. **Change Data Capture (CDC)**: It tracks changes to database rows (inserts, updates, deletes) and publishes them as events to Kafka topics.

2. **Logical Replication**: Debezium uses PostgreSQL's logical decoding feature to capture changes. Ensure that your PostgreSQL database has logical replication enabled.

3. **Configuration Options**: Offers various configuration options for tuning performance, filtering specific tables, and setting up snapshotting of existing data.

4. **Data Format**: Debezium formats the change events in a standard JSON format, making it easier for consumers to process the data.

### Setting Up Debezium PostgreSQL Connector

1. **Install the Connector**:
   - Download the Debezium PostgreSQL connector from the [Debezium website](https://debezium.io/releases/).
   - Unzip it into the Kafka Connect plugins directory (e.g., `/kafka/plugins`).

2. **Configure PostgreSQL**:
   - Enable logical replication in your PostgreSQL instance. You may need to modify the `postgresql.conf` and `pg_hba.conf` files.
   - Create a replication slot for Debezium.

   Example settings in `postgresql.conf`:
   ```plaintext
   wal_level = logical
   max_replication_slots = 1
   max_wal_senders = 1
   ```

3. **Create the Connector Configuration**:
   - Use the following JSON configuration for the connector:

   ```json
   {
     "name": "postgres-connector",
     "config": {
       "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
       "tasks.max": "1",
       "database.hostname": "localhost",
       "database.port": "5432",
       "database.user": "your_username",
       "database.password": "your_password",
       "database.dbname": "your_database",
       "database.server.name": "your_server_name",
       "table.include.list": "schema_name.table_name",
       "plugin.name": "pgoutput",
       "slot.name": "your_slot_name"
     }
   }
   ```

4. **Deploy the Connector**:
   - Use the Kafka Connect REST API to deploy the connector. You can do this with a command like:

   ```bash
   curl -X POST -H "Content-Type: application/json" --data @connector-config.json http://localhost:8083/connectors
   ```

5. **Monitor the Connector**:
   - Use the Kafka Connect REST API to monitor the status of your connector:

   ```bash
   curl http://localhost:8083/connectors/postgres-connector/status
   ```

### Troubleshooting

- **Logs**: Check the Kafka Connect logs for any error messages that can help identify issues during setup.
- **PostgreSQL Logs**: Look at PostgreSQL logs to ensure that logical replication is set up correctly and that no errors are occurring on the database side.
- **Schema Changes**: Be mindful of schema changes in your PostgreSQL database, as they may affect the connector's ability to capture changes.

### Resources

- [Debezium Documentation](https://debezium.io/documentation/)
- [PostgreSQL Logical Replication](https://www.postgresql.org/docs/current/logical-replication.html)

To set up the Debezium PostgreSQL connector, you'll need to determine the Kafka Connect plugins directory in your setup. Here’s how to find or set it up:

1. **Default Location**: The plugins directory is often specified in the `connect-distributed.properties` configuration file. You can typically find this file in the `config` directory of your Kafka installation (e.g., `D:\kafka\config\connect-distributed.properties`).

2. **Edit the Configuration**:
   - Open the `connect-distributed.properties` file.
   - Look for the line that starts with `plugin.path=`. If it’s not present, you can add it.
   - Set the path to your plugins directory, for example:
     ```properties
     plugin.path=D:/kafka/plugins
     ```

3. **Create the Plugins Directory**:
   - If you don’t already have a `plugins` directory, you can create one. For example, create `D:\kafka\plugins`.

4. **Install the Connector**:
   - Download the Debezium PostgreSQL connector from the [Debezium website](https://debezium.io/download/).
   - Unzip the connector files into the `D:\kafka\plugins` directory.

5. **Restart Kafka Connect**: After installing the connector, restart the Kafka Connect service for it to recognize the new plugin.

### Example Directory Structure
After installing, your plugins directory might look something like this:
```
D:\kafka\plugins\
    └── debezium-connector-postgresql
        ├── debezium-connector-postgresql-x.y.z.jar
        ├── other-dependencies.jar
        └── ...
```

### Verifying the Installation
You can verify the installation by checking the Kafka Connect REST API to see if the connector is recognized:
```bash
curl http://localhost:8083/connector-plugins
```


To restart Kafka Connect, follow these steps based on your environment (Windows or Linux). Here’s how you can do it:

### On Windows

1. **Stop Kafka Connect**:
   - If you started Kafka Connect using a command prompt, simply close that command prompt window. If it's running as a service, use the following command:
     ```bash
     kafka-stop.bat
     ```
   - If you don't have a script to stop it, you can manually terminate the process using the Task Manager.

2. **Start Kafka Connect**:
   - Open a new command prompt window.
   - Navigate to your Kafka installation directory:
     ```bash
     cd D:\kafka
     ```
   - Start Kafka Connect with the following command:
     ```bash
     D:\kafka>.\bin\windows\connect-distributed.bat .\config\connect-distributed.properties
     ```
```
D:\kafka>.\bin\windows\connect-distributed.bat .\config\connect-distributed.properties
[2024-10-14 05:43:16,434] INFO Kafka Connect worker initializing ... (org.apache.kafka.connect.cli.AbstractConnectCli:114)
[2024-10-14 05:43:16,446] INFO WorkerInfo values:
        jvm.args = -Xmx256M, -XX:+UseG1GC, -XX:MaxGCPauseMillis=20, -XX:InitiatingHeapOccupancyPercent=35, -XX:+ExplicitGCInvokesConcurrent, -Djava.awt.headless=true, -Dcom.sun.management.jmxremote, -Dcom.sun.management.jmxremote.authenticate=false, -Dcom.sun.management.jmxremote.ssl=false, -Dkafka.logs.dir=D:\kafka/logs, -Dlog4j.configuration=file:D:\kafka/config/connect-log4j.properties
        jvm.spec = Oracle Corporation, Java HotSpot(TM) 64-Bit Server VM, 22.0.2, 22.0.2+9-70
```
### On Linux

1. **Stop Kafka Connect**:
   - If you started Kafka Connect in a terminal session, use `Ctrl+C` to stop it.
   - If it’s running as a service, use the following command:
     ```bash
     systemctl stop kafka-connect
     ```

2. **Start Kafka Connect**:
   - Open a terminal and navigate to your Kafka installation directory:
     ```bash
     cd /path/to/kafka
     ```
   - Start Kafka Connect using:
     ```bash
     bin/connect-distributed.sh config/connect-distributed.properties
     ```

### Verify the Restart

After restarting, you can verify that Kafka Connect is running and recognizing the new connector by checking the status:

```bash
curl http://localhost:8083/connector-plugins
```

Your configuration for the Debezium PostgreSQL connector looks mostly good, but here are a few things to ensure it works properly:

### 1. Connector URL
Make sure the `kafka.connect.url` is correct:
```plaintext
kafka.connect.url=http://localhost:8083/connectors/
```
This URL is where the Kafka Connect REST API will be available.

### 2. PostgreSQL Connection Details
Double-check the PostgreSQL connection details:
- **Host**: Ensure PostgreSQL is running on `localhost`.
- **Port**: Confirm that the port `5433` is correct for your PostgreSQL instance.
- **User**: The user `postgres` should have the necessary permissions to access the database.
- **Password**: Ensure that the password is correct.

### 3. Database and Server Name
Verify that the database `ms_cache_272` and server name `ms_cache` are correctly configured.

### 4. Include List
Make sure the table `ms_schema.products_m` exists in your PostgreSQL database and is accessible by the configured user.

### 5. Slot Name
The `kafka.connect.slot.name` must match a logical replication slot in PostgreSQL. You can create it using SQL:
```sql
SELECT * FROM pg_create_logical_replication_slot('ms_272_slot', 'pgoutput');
```
Make sure the slot is created before starting the connector.

### Starting the Connector
After ensuring all configurations are correct, you can create the connector using a POST request to the Kafka Connect REST API. Here’s an example of how to do that using `curl`:

```bash
curl -X POST -H "Content-Type: application/json" --data '{
  "name": "postgres-connector",
  "config": {
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
    "tasks.max": "1",
    "database.hostname": "'"$kafka.connect.db.host"'",
    "database.port": "'"$kafka.connect.db.port"'",
    "database.user": "'"$kafka.connect.db.user"'",
    "database.password": "'"$kafka.connect.db.password"'",
    "database.dbname": "'"$kafka.connect.db.name"'",
    "database.server.name": "'"$kafka.connect.db.server.name"'",
    "table.include.list": "'"$kafka.connect.table.include.list"'",
    "plugin.name": "pgoutput",
    "slot.name": "'"$kafka.connect.slot.name"'"
  }
}' http://localhost:8083/connectors/
```

Make sure to replace the placeholders with your actual configuration.

### Checking Status
After creating the connector, you can check its status with:
```bash
curl -X GET http://localhost:8083/connectors/postgres-connector/status
```
The error message indicates several issues with the connector configuration. Here’s how to resolve them:

### 1. Use Actual Values
You need to replace the environment variable placeholders (e.g., `$kafka.connect.db.host`) with actual values in your JSON configuration. Here’s an updated example:

```json
{
  "name": "postgres-connector",
  "config": {
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
    "tasks.max": "1",
    "database.hostname": "localhost",  // Replace with your DB host
    "database.port": "5433",            // Replace with your DB port
    "database.user": "postgres",        // Replace with your DB user
    "database.password": "2023.Sigma",  // Replace with your DB password
    "database.dbname": "ms_cache_272",  // Replace with your DB name
    "database.server.name": "ms_cache",  // Replace with your server name
    "table.include.list": "ms_schema.products_m",  // Replace with your table
    "plugin.name": "pgoutput",
    "slot.name": "ms_272_slot",  // Ensure this matches your logical slot name
    "topic.prefix": "ms_cache_272"  // Add a topic prefix
  }
}
```

### 2. Key Issues Addressed
- **Topic Prefix**: You need to add a `topic.prefix` field. This is required for naming the topics that will be created.
- **Database Port**: Ensure that the database port is an integer (in quotes as a string).
- **Database Hostname**: Use a valid hostname; avoid using variable syntax in the JSON.
- **Slot Name**: Make sure the slot name follows the naming conventions (only lowercase letters, digits, and underscores).

### 3. Send the POST Request
After updating the configuration with actual values, send the POST request to create the connector:

```bash
curl -X POST -H "Content-Type: application/json" --data '{
  "name": "postgres-connector",
  "config": {
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
    "tasks.max": "1",
    "database.hostname": "localhost",
    "database.port": "5432",
    "database.user": "postgres",
    "database.password": "postgres",
    "database.dbname": "ms_cache_272",
    "database.server.name": "ms_cache",
    "table.include.list": "ms_schema.products_m",
    "plugin.name": "pgoutput",
    "slot.name": "ms_272_slot",
    "topic.prefix": "ms_cache_272"
  }
}' http://localhost:8083/connectors/
```

### 4. Validate Configuration
You can also validate your configuration before sending it by using:
```bash
curl -X POST -H "Content-Type: application/json" --data '{
  "config": {
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
    "tasks.max": "1",
    "database.hostname": "localhost",
    "database.port": "5432",
    "database.user": "postgres",
    "database.password": "postgres",
    "database.dbname": "ms_cache_272",
    "database.server.name": "ms_cache",
    "table.include.list": "ms_schema.products_m",
    "plugin.name": "pgoutput",
    "slot.name": "ms_272_slot",
    "topic.prefix": "ms_cache_272"
  }
}' http://localhost:8083/connector-plugins/io.debezium.connector.postgresql.PostgresConnector/config/validate
```
The "Connection refused" error indicates that the PostgreSQL server is not currently running on port 5433 or is not accepting connections on that port. Here are some steps you can take to troubleshoot this issue:

### 1. Check PostgreSQL Server Status
Make sure the PostgreSQL server is running. You can do this via the Services app in Windows:

- Press `Win + R`, type `services.msc`, and hit Enter.
- Look for the PostgreSQL service (it may be named something like `postgresql-x64-16`).
- Ensure the service is running. If not, start it.

### 2. Verify PostgreSQL Configuration
Check your PostgreSQL configuration files (`postgresql.conf` and `pg_hba.conf`):

- **postgresql.conf**:
  - Locate the `port` setting and ensure it is set to `5433`.
  - Ensure that the `listen_addresses` setting is set to `localhost` or `*` to accept connections.

- **pg_hba.conf**:
  - Ensure it has an entry allowing connections from your user and database. For example:

    ```plaintext
    host    ms_cache_272    postgres    127.0.0.1/32    md5
    host    ms_cache_272    postgres    ::1/128         md5
    ```

### 3. Restart PostgreSQL
After making any changes, restart the PostgreSQL service again.

### 4. Test Connectivity
Once the service is confirmed running, attempt the connection command again:

```bash
"C:\Program Files\PostgreSQL\16\bin\psql.exe" -h localhost -p 5433 -U postgres -d ms_cache_272
```

### 5. Check for Multiple PostgreSQL Instances
If you have multiple versions of PostgreSQL installed, ensure you’re connecting to the correct instance. Check if another version is running on the default port (5432).

### 6. Check Firewall Settings
Ensure that your firewall settings allow traffic through port 5433.

If you don’t have the `ms_cache_272` database yet, you can create it using the following steps:

1. **Connect to PostgreSQL**:
   First, connect to the default database (usually `postgres`):
   ```bash
   "C:\Program Files\PostgreSQL\16\bin\psql.exe" -h localhost -p 5432 -U postgres
   ```

2. **Create the Database**:
   Once you’re in the PostgreSQL prompt, create the `ms_cache_272` database by running:
   ```sql
   CREATE DATABASE ms_cache_272;
   ```

3. **Verify Creation**:
   You can list all databases to confirm it was created:
   ```sql
   \l
   ```

4. **Connect to Your New Database**:
   After creating the database, connect to it:
   ```bash
   "C:\Program Files\PostgreSQL\16\bin\psql.exe" -h localhost -p 5432 -U postgres -d ms_cache_272
   ```


```
Microsoft Windows [Version 10.0.19045.5011]
(c) Microsoft Corporation. All rights reserved.

C:\Program Files\PostgreSQL\16\pgAdmin 4\runtime>"
C:\Program Files\PostgreSQL\16\pgAdmin 4\runtime\p
sql.exe" "host=localhost port=5432 dbname=postgres
 user=postgres sslmode=prefer connect_timeout=10"
2>>&1
psql (16.3)
WARNING: Console code page (437) differs from Wind
ows code page (1252)
         8-bit characters might not work correctly
. See psql reference
         page "Notes for Windows users" for detail
s.
Type "help" for help.

postgres=# CREATE DATABASE ms_cache_272;
CREATE DATABASE
postgres=#
```

You should execute that command in the Command Prompt on your Windows machine. Here’s how to do it:

1. **Open Command Prompt**:
   - Press `Win + R`, type `cmd`, and hit `Enter`. This opens the Command Prompt.

2. **Run the psql Command**:
   - In the Command Prompt window, paste the following command:
     ```bash
     "C:\Program Files\PostgreSQL\16\bin\psql.exe" -h localhost -p 5432 -U postgres -d ms_cache_272
     ```
   - Press `Enter`.

3. **Enter Password**:
   - If prompted, enter the password for the `postgres` user.
```
Microsoft Windows [Version 10.0.19045.5011]
(c) Microsoft Corporation. All rights reserved.

C:\Users\HP>"C:\Program Files\PostgreSQL\16\bin\psql.exe" -h localhost -p 5432 -U postgres -d ms_cache_272
Password for user postgres:
psql (16.3)
WARNING: Console code page (437) differs from Windows code page (1252)
         8-bit characters might not work correctly. See psql reference
         page "Notes for Windows users" for details.
Type "help" for help.

ms_cache_272=#

```

The JSON configuration you provided for the PostgreSQL Debezium connector looks mostly correct. Here’s a breakdown of the key settings and some recommendations for making sure it works smoothly:

### Configuration Breakdown
- **name**: The name of the connector, which you've set to `"postgres-connector"`.
- **connector.class**: This specifies the Debezium PostgreSQL connector.
- **tasks.max**: The maximum number of tasks to run for this connector. You have set it to `1`.
- **database.hostname**: Set to `"localhost"`, which is correct if PostgreSQL is running on the same machine.
- **database.port**: Set to `"5432"`, which should match the PostgreSQL configuration.
- **database.user**: The user to connect to the database; ensure the user exists.
- **database.password**: The password for the database user.
- **database.dbname**: The name of the database you're trying to connect to (`ms_cache_272`).
- **database.server.name**: A logical name for the database server that will be used in Kafka topics.
- **table.include.list**: Specifies which tables to include in the change data capture.
- **plugin.name**: This should be set to `"pgoutput"` for the logical replication.
- **slot.name**: The name of the replication slot, which should comply with naming conventions.
- **topic.prefix**: This prefix will be added to the topic names.

### Recommendations
1. **Replication Slot**: Ensure that the replication slot named `"ms_272_slot"` is created in PostgreSQL. You can create it using the following command:
   ```sql
   SELECT pg_create_logical_replication_slot('ms_272_slot', 'pgoutput');
   ```

2. **Testing Connection**: Before trying to start the connector, ensure you can connect to the database with the provided user and password:
   ```bash
   "C:\Program Files\PostgreSQL\16\bin\psql.exe" -h localhost -p 5432 -U postgres -d ms_cache_272
   ```

3. **Send the POST Request**: You can use `curl` to send the configuration to Kafka Connect. Ensure you're using the correct URL:
   ```bash
   curl -X POST -H "Content-Type: application/json" --data '{
       "name": "postgres-connector",
       "config": {
           "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
           "tasks.max": "1",
           "database.hostname": "localhost",
           "database.port": "5432",
           "database.user": "postgres",
           "database.password": "postgres",
           "database.dbname": "ms_cache_272",
           "database.server.name": "ms_cache",
           "table.include.list": "ms_schema.products_m",
           "plugin.name": "pgoutput",
           "slot.name": "ms_272_slot",
           "topic.prefix": "ms_cache_272"
       }
   }' http://localhost:8083/connectors/
   ```

4. **Monitor Logs**: After submitting the request, check the Kafka Connect logs for any errors or confirmation that the connector was created successfully.
```
[2024-10-14 06:19:02,289] INFO [0:0:0:0:0:0:0:1] - - [14/Oct/2024:00:49:02 +0000] "POST /connector-plugins/io.debezium.connector.postgresql.PostgresConnector/config/validate HTTP/1.1" 405 58 "-" "PostmanRuntime/7.42.0" 5 (org.apache.kafka.connect.runtime.rest.RestServer:62)
[2024-10-14 06:23:23,366] INFO [AdminClient clientId=connect-cluster-shared-admin] Node 0 disconnected. (org.apache.kafka.clients.NetworkClient:1017)
[2024-10-14 06:28:23,490] INFO [AdminClient clientId=connect-cluster-shared-admin] Node 0 disconnected. (org.apache.kafka.clients.NetworkClient:1017)
```
5. **Validate Configuration**: If you still face issues, use the validation endpoint to ensure the configuration is correct:
   ```bash
   curl -X POST -H "Content-Type: application/json" --data '{
       "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
       "tasks.max": "1",
       "database.hostname": "localhost",
       "database.port": "5432",
       "database.user": "postgres",
       "database.password": "postgres",
       "database.dbname": "ms_cache_272",
       "database.server.name": "ms_cache",
       "table.include.list": "ms_schema.products_m",
       "plugin.name": "pgoutput",
       "slot.name": "ms_272_slot",
       "topic.prefix": "ms_cache_272"
   }' http://localhost:8083/connectors/validate
   ```
```
[2024-10-14 06:19:02,289] INFO [0:0:0:0:0:0:0:1] - - [14/Oct/2024:00:49:02 +0000] "POST /connector-plugins/io.debezium.connector.postgresql.PostgresConnector/config/validate HTTP/1.1" 405 58 "-" "PostmanRuntime/7.42.0" 5 (org.apache.kafka.connect.runtime.rest.RestServer:62)
[2024-10-14 06:23:23,366] INFO [AdminClient clientId=connect-cluster-shared-admin] Node 0 disconnected. (org.apache.kafka.clients.NetworkClient:1017)
[2024-10-14 06:28:23,490] INFO [AdminClient clientId=connect-cluster-shared-admin] Node 0 disconnected. (org.apache.kafka.clients.NetworkClient:1017)

[2024-10-14 06:32:17,694] INFO Successfully tested connection for jdbc:postgresql://localhost:5432/ms_cache_272 with user 'postgres' (io.debezium.connector.postgresql.PostgresConnector:147)
[2024-10-14 06:32:17,713] INFO Connection gracefully closed (io.debezium.jdbc.JdbcConnection:952)
[2024-10-14 06:32:17,714] INFO AbstractConfig values:
 (org.apache.kafka.common.config.AbstractConfig:372)
[2024-10-14 06:32:17,722] INFO [0:0:0:0:0:0:0:1] - - [14/Oct/2024:01:02:15 +0000] "POST /connectors/ HTTP/1.1" 409 74 "-" "PostmanRuntime/7.42.0" 2141 (org.apache.kafka.connect.runtime.rest.RestServer:62)
After making these checks and adjustments, try sending the POST request again to create the connector.

