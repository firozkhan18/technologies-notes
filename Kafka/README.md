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

After checking these items, try running your application again. If you continue to face issues, feel free to share any additional logs or configurations!
