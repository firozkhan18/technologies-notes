
- [How to Install Apache Kafka on Windows](https://www.youtube.com/watch?v=EUzH9khPYgs)
- [Simple Kafka Consumer example | Spring Boot | Spring Kafka](https://www.youtube.com/watch?v=80ngRl7RhCw)
- [Simple Kafka Producer example | Spring Boot | Spring Kafka](https://www.youtube.com/watch?v=wBGT7u_R-tw&t=0s)
https://www.youtube.com/watch?v=wBGT7u_R-tw&t=0s
https://www.youtube.com/watch?v=wBGT7u_R-tw
- [How to install Kafka using Docker & Docker Compose in any Operating System | Windows | MacOS | Linux]
(https://www.youtube.com/watch?v=2pBxoal7DY4)
- [Kafka installation using Docker and Docker Compose | Kafka | Docker | Docker Compose](https://www.youtube.com/watch?v=WnlX7w4lHvM)


**############################# config\zookeeper.properties #############################**
- the port at which the clients will connect
clientPort=2181
- disable the per-ip limit on the number of connections since this is a non-production config
maxClientCnxns=0
- Disable the adminserver by default to avoid port conflicts.
- Set the port to something non-conflicting if choosing to enable this
admin.enableServer=false
- admin.serverPort=8080

**############################# config\server.properties Log Basics #############################**

### A comma separated list of directories under which to store log files
log.dirs=D:/kafka/kafka-logs

### Satrt Zookeeper Server
**D:\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties**

```
[2024-09-18 23:11:58,314] INFO binding to port 0.0.0.0/0.0.0.0:2181 (org.apache.zookeeper.server.NIOServerCnxnFactory)
[2024-09-18 23:11:58,349] INFO Using org.apache.zookeeper.server.watch.WatchManager as watch manager (org.apache.zookeeper.server.watch.WatchManagerFactory)
[2024-09-18 23:11:58,350] INFO Using org.apache.zookeeper.server.watch.WatchManager as watch manager (org.apache.zookeeper.server.watch.WatchManagerFactory)
[2024-09-18 23:11:58,352] INFO zookeeper.snapshotSizeFactor = 0.33 (org.apache.zookeeper.server.ZKDatabase)
[2024-09-18 23:11:58,353] INFO zookeeper.commitLogCount=500 (org.apache.zookeeper.server.ZKDatabase)
[2024-09-18 23:11:58,367] INFO zookeeper.snapshot.compression.method = CHECKED (org.apache.zookeeper.server.persistence.SnapStream)
[2024-09-18 23:11:58,367] INFO Snapshotting: 0x0 to D:\kafka\zookeeper-data\version-2\snapshot.0 (org.apache.zookeeper.server.persistence.FileTxnSnapLog)
[2024-09-18 23:11:58,389] INFO Snapshot loaded in 33 ms, highest zxid is 0x0, digest is 1371985504 (org.apache.zookeeper.server.ZKDatabase)
[2024-09-18 23:11:58,392] INFO Snapshotting: 0x0 to D:\kafka\zookeeper-data\version-2\snapshot.0 (org.apache.zookeeper.server.persistence.FileTxnSnapLog)
[2024-09-18 23:11:58,394] INFO Snapshot taken in 3 ms (org.apache.zookeeper.server.ZooKeeperServer)
[2024-09-18 23:11:58,414] INFO PrepRequestProcessor (sid:0) started, reconfigEnabled=false (org.apache.zookeeper.server.PrepRequestProcessor)
[2024-09-18 23:11:58,415] INFO zookeeper.request_throttler.shutdownTimeout = 10000 ms (org.apache.zookeeper.server.RequestThrottler)
[2024-09-18 23:11:58,440] INFO Using checkIntervalMs=60000 maxPerMinute=10000 maxNeverUsedIntervalMs=0 (org.apache.zookeeper.server.ContainerManager)
[2024-09-18 23:11:58,443] INFO ZooKeeper audit is disabled. (org.apache.zookeeper.audit.ZKAuditProvider)
```
### Satrt Kafka Server

**D:\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties**

```
[2024-09-18 23:15:35,128] INFO [ExpirationReaper-0-topic]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2024-09-18 23:15:35,146] INFO [ExpirationReaper-0-Heartbeat]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2024-09-18 23:15:35,148] INFO [ExpirationReaper-0-Rebalance]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2024-09-18 23:15:35,172] INFO Successfully created /controller_epoch with initial epoch 0 (kafka.zk.KafkaZkClient)
[2024-09-18 23:15:35,219] INFO [GroupCoordinator 0]: Starting up. (kafka.coordinator.group.GroupCoordinator)
[2024-09-18 23:15:35,255] INFO Feature ZK node created at path: /feature (kafka.server.FinalizedFeatureChangeListener)
[2024-09-18 23:15:35,264] INFO [GroupCoordinator 0]: Startup complete. (kafka.coordinator.group.GroupCoordinator)
[2024-09-18 23:15:35,307] INFO [TransactionCoordinator id=0] Starting up. (kafka.coordinator.transaction.TransactionCoordinator)
[2024-09-18 23:15:35,317] INFO [TransactionCoordinator id=0] Startup complete. (kafka.coordinator.transaction.TransactionCoordinator)
[2024-09-18 23:15:35,317] INFO [TxnMarkerSenderThread-0]: Starting (kafka.coordinator.transaction.TransactionMarkerChannelManager)
[2024-09-18 23:15:35,330] INFO [MetadataCache brokerId=0] Updated cache from existing None to latest Features(metadataVersion=3.8-IV0, finalizedFeatures={}, finalizedFeaturesEpoch=0). (kafka.server.metadata.ZkMetadataCache)
[2024-09-18 23:15:35,444] INFO [ExpirationReaper-0-AlterAcls]: Starting (kafka.server.DelayedOperationPurgatory$ExpiredOperationReaper)
[2024-09-18 23:15:35,511] INFO [/config/changes-event-process-thread]: Starting (kafka.common.ZkNodeChangeNotificationListener$ChangeEventProcessThread)
[2024-09-18 23:15:35,558] INFO [SocketServer listenerType=ZK_BROKER, nodeId=0] Enabling request processing. (kafka.network.SocketServer)
[2024-09-18 23:15:35,568] INFO Awaiting socket connections on 0.0.0.0:9092. (kafka.network.DataPlaneAcceptor)
[2024-09-18 23:15:35,601] INFO [KafkaServer id=0] Start processing authorizer futures (kafka.server.KafkaServer)
[2024-09-18 23:15:35,602] INFO [KafkaServer id=0] End processing authorizer futures (kafka.server.KafkaServer)
[2024-09-18 23:15:35,603] INFO [KafkaServer id=0] Start processing enable request processing future (kafka.server.KafkaServer)
[2024-09-18 23:15:35,606] INFO [KafkaServer id=0] End processing enable request processing future (kafka.server.KafkaServer)
[2024-09-18 23:15:35,609] INFO Kafka version: 3.8.0 (org.apache.kafka.common.utils.AppInfoParser)
[2024-09-18 23:15:35,609] INFO Kafka commitId: 771b9576b00ecf5b (org.apache.kafka.common.utils.AppInfoParser)
[2024-09-18 23:15:35,610] INFO Kafka startTimeMs: 1726681535606 (org.apache.kafka.common.utils.AppInfoParser)
[2024-09-18 23:15:35,614] INFO [KafkaServer id=0] started (kafka.server.KafkaServer)
[2024-09-18 23:15:36,145] INFO [zk-broker-0-to-controller-alter-partition-channel-manager]: Recorded new ZK controller, from now on will use node LAPTOP-EJNI8C5H:9092 (id: 0 rack: null) (kafka.server.NodeToControllerRequestThread)
[2024-09-18 23:15:36,145] INFO [zk-broker-0-to-controller-forwarding-channel-manager]: Recorded new ZK controller, from now on will use node LAPTOP-EJNI8C5H:9092 (id: 0 rack: null) (kafka.server.NodeToControllerRequestThread)
```
**Kafka cheat sheet**
Streaming data platforms help implement applications that require real-time data processing. Real-time event processing applications rely on the durable storage of events, unlike traditional applications that depend only on eventual state storage. Such an architecture helps ensure that application components are decoupled and independently scalable.

Apache Kafka® is an open-source distributed streaming platform. Like any distributed system, Kafka uses a complex architecture and can be overwhelming for a new developer to get started with. Setting it up means dealing with a formidable command line interface and extensive configurations. This article details architectural concepts and frequently used commands that are required for a developer to get started with Kafka.

### Key Kafka commands
The Kafka CLI is a powerful tool. However, the user experience can be challenging if you don’t already know the exact command needed for your task. 

The table below shows commonly used CLI commands to interact with Kafka.

### Create topics

bin/kafka-topics.sh --bootstrap-server <URL> --create --replication-factor 3 --partitions 4 --topic topic-name

**D:\kafka>.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 3 --partitions 4 --topic topic-name**

```
zookeeper is not a recognized option
joptsimple.UnrecognizedOptionException: zookeeper is not a recognized option
        at joptsimple.OptionException.unrecognizedOption(OptionException.java:108)
        at joptsimple.OptionParser.handleLongOptionToken(OptionParser.java:510)
        at joptsimple.OptionParserState$2.handleArgument(OptionParserState.java:56)
        at joptsimple.OptionParser.parse(OptionParser.java:396)
        at org.apache.kafka.tools.TopicCommand$TopicCommandOptions.<init>(TopicCommand.java:828)
        at org.apache.kafka.tools.TopicCommand.execute(TopicCommand.java:98)
        at org.apache.kafka.tools.TopicCommand.mainNoExit(TopicCommand.java:88)
        at org.apache.kafka.tools.TopicCommand.main(TopicCommand.java:83)
```
**D:\kafka>.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 3 --partitions 4 --topic TestTopic**
```
Error while executing topic command : Replication factor: 3 larger than available brokers: 1.
[2024-09-18 23:27:05,228] ERROR org.apache.kafka.common.errors.InvalidReplicationFactorException: Replication factor: 3 larger than available brokers: 1.
 (org.apache.kafka.tools.TopicCommand)
```
**.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic TestTopic**
```
D:\kafka>.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic TestTopic
Created topic TestTopic.
```
**.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic TestTopic**
```
D:\kafka>.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic NewTopic
Created topic NewTopic.
```
### List all topics

bin/kafka-topics.sh --bootstrap-server <URL> --list

**D:\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:2181 --list**

```
D:\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list
NewTopic
TestTopic
```

### Add a topic partition

bin/kafka-topics.sh --bootstrap-server <URL> --alter --topic <topic-name> --partitions 16

**D:\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:2181 --alter --topic NewTopic --partitions 16**


### Run a producer

bin/kafka-console-producer.sh --topic <topic-name> --broker-list <URL>

### Run a consumer

bin/kafka-console-consumer.sh --bootstrap-server <URL> --topic <topic-name>

### Consume messages from the beginning

bin/kafka-console-consumer.sh --topic <topic-name> --bootstrap-server <URL> --group <group-name>--from-beginning

### Get information on a specific consumer group

bin/kafka-consumer-groups.sh --bootstrap-server <URL> --describe --group <group-name>

### Delete a consumer group

/bin/kafka-consumer-groups.sh --bootstrap-server <URL> --delete --group my-group --group <group-name>

### Reset the offset of a topic

bin/kafka-consumer-groups.sh --bootstrap-server <URL> --reset-offsets --group <group-name> --topic <topic-name> --to-earliest

### Understanding Kafka
Kafka can be used as a message broker, a publish-subscribe mechanism, or a stream processing platform. A message broker sits between applications that interact using different protocols and helps in implementing decoupled solutions. A publish-subscribe mechanism helps applications broadcast messages to multiple target applications at the same time asynchronously. Kafka’s stream processing features enable developers to process high-velocity data in an orderly fashion and generate real-time insights.

Kafka is a distributed platform that works based on servers and clients. Organizations can use bare metal hardware, virtual machines, containers, on-premises instances, or cloud instances to deploy Kafka. A Kafka server is a cluster of nodes that can span multiple geographies or data centers. Some of the nodes work as a storage layer, and others work as Kafka Connect instances, which are responsible for managing connections from client applications.

Kafka’s working model contains four key elements:

Messages are events that get dropped into Kafka for processing.

Topics are logical groups of messages that signify a specific purpose.

Producers are client applications that create messages.

Consumers are client applications that listen to messages in topics and act according to the messages.


### Kafka partition, offset, and consumer group architecture
A topic in Kafka is divided into multiple partitions, each of which holds a subset of data. Partitions for the same topic are located in different brokers to ensure distributed data placement. Kafka uses the concept of partitions to provide fault tolerance and scalability for topics.

Kafka topics are logical groups of events or messages intended for a specific purpose that can be from application logs, user activity, device data, etc., depending upon the specific use case. For example, in IoT applications, all messages generated by a specific type of sensor can be sent to a single topic.

Kafka guarantees the preservation of the order of messages within a partition, and scaling client applications is done by using the concept of consumer groups. Kafka ensures that consumers within the same consumer group are not receiving duplicate data through an intelligent assignment of partitions to individual consumers. When an existing consumer leaves a topic or a new consumer joins the topic, Kafka automatically rebalances the partition assignment to ensure a mutually exclusive set of partitions within a consumer group.

Kafka maintains information about the already consumed messages in a partition through the concept of consumer offsets. A consumer offset is simply the count of messages consumed until then by a consumer in a consumer group. Maintaining offsets helps Kafka ensure that consumers can restart at exactly the position where they left off after an unexpected shutdown or rebalance operation.

When to choose Redpanda over Apache Kafka

### Kafka CLI cheat sheet
The Kafka CLI is an interactive shell environment that lets users manage a Kafka installation and build applications with it. It helps developers manage the running of Kafka topics, connectors, consumers, and producers. This article assumes that you already have a working Kafka installation; if you need to start by installing, Kafka’s official installation page is a good place to begin.

In a nutshell, this CLI is a set of shell scripts that can be used for managing the basic functions of Kafka. The script or command named kafka-topics manages activities related to topics, while the script name kafka-config helps developers configure runtime parameters. Kafka also provides a simple consumer client and producer client.

### Creating topics
Developers can create a Kafka topic using a command like the one below.

$KAFKA_HOME/bin/kafka-topics.sh --create --topic topic-name --bootstrap-server <URL> --partitions 3 --replication-factor 1
This command mentions the count of partitions and the replication factor while creating the topic.

Kafka uses the message’s key to decide which partition should be responsible for storing it. If messages do not have a key, they are routed in a round-robin fashion so that all partitions take on a uniform load.

The replication factor in Kafka represents the number of duplicate copies of partitions that are kept among different nodes. Replication in Kafka is done at the partition level, and Kafka recommends keeping the replication factor above 1 to ensure high availability.

### Listing topics
You can use a command like this one to list the topics that already exist in the Kafka server:

$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server URL --list
If you are using a version of Kafka with Zookeeper, you can pass the parameter –zookeeper and your ZooKeeper URL to get the list.

### Describing topics
Kafka lets developers access the details of the topic through the describe command, as follows:

$KAFKA_HOME/bin/kafka-topics.sh --describe --bootstrap-server <URL> --topic topic-name
The topic description provides information on the number of partitions, replication factor, leader parameter value, replicas, and in-sync replicas. The number of partitions and replication factors are self-explanatory. The value of the leader parameter represents the node that acts as the leader for that topic. The replicas parameter value shows the nodes that hold duplicates of the partitions. The in-sync replica or ISR represents the nodes that are caught up with the leader and hold an exact duplicate of the data in the leader node. This is the minimum number of replicas that Kafka must ensure to mark a transaction as committed.

Redpanda: a powerful Kafka alternative
Fully Kafka API compatible. 6x faster. 100% easier to use.


### Adding partitions to a topic
Developers often need to scale Kafka topics after they are created. Kafka provides the alter command to add more partitions to existing topics:

$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server URL --alter --topic topic-name --partitions 10
### Changing the retention period for a topic
By default, Kafka retains all messages for seven days. Depending on the requirements, developers may want to increase or decrease this value. Increasing the retention period helps with keeping more history in memory at the cost of storage. Changing the retention period can be done as follows:

$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server URL --alter --topic topic-name config retention.ms=360000*
### Deleting a Kafka topic
Deleting a topic in Kafka is not an immediate process: Once the delete command is issued, the console output will show that the topic is marked for deletion. The timing of the actual deletion will depend upon many factors, including the availability of a leader node for that topic, configured retention policies, etc. The deletion operation can be triggered using a command like this one:

$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic topic-name
### Publishing events to a topic
Kafka producers publish events to the durable queue provided by Kafka. Kafka producers can control the partitions to which data is written and the level of acknowledgment required to mark a write as successful. This example uses the console producer that comes built-in with Kafka to publish messages to a topic:

$KAFKA_HOME/bin/kafka-console-producer.sh --topic topic-name --bootstrap-server URL
The command above provides a prompt where you can enter the messages for publishing. After typing the message, you can press the Enter key to submit it and type the message.

Kafka producers provide numerous configurations that can control the durability and throughput of published messages. The acks parameter that controls the level of acknowledgment is an important one. Each Kafka partition has a leader node and a replica node; when the value of acks is 1, only the acknowledgment from the leader node is sufficient to mark a write as successful. If the value is set to all, acknowledgment from all the nodes marked as in-syn-replicas is necessary.

### Consuming messages from topics
Kafka consumers are client applications that listen to the Kafka server and act on the messages. The simplest Kafka consumer is the console consumer that comes built-in with Kafka, which prints the received messages in the console. It can be used as shown below.

$KAFKA_HOME/bin/kafka-console-consumer.sh --topic topic-name --from-beginning --bootstrap-server URL
Kafka uses the concept of consumer groups to scale message consumption. Consumers belonging to the same consumer group are assigned to different partitions by default. This ensures that messages already consumed by a consumer are not assigned to another one, which would lead to duplicates.

Kafka consumers often execute high-latency tasks like database writes or complex message transformations. A single consumer may not always be able to keep up with the rate at which producers publish data; consumer groups help avoid this situation.

### Consuming messages from the beginning
By default, Kafka consumers start from the last offset when they are restarted. There are cases where developers may want to start from the beginning upon restarting a consumer, which can be achieved using the command below:

$KAFKA_HOME/bin/kafka-console-consumer.sh --topic <topic-name> --bootstrap-server <URL> --group <group-name>--from-beginning
### Listing consumer groups
To list all the consumer groups in a server, use a command like this one:

$KAFKA_HOME/bin/kafka-consumer-groups.sh --bootstrap-server <URL> --list
### Describing consumer groups
Describing consumer groups helps developers get information on partitions, the current offset in each partition, etc. This information is helpful for debugging Kafka issues and deciding whether to reset the offsets. Developers can use the command below to describe consumer groups:

$KAFKA_HOME/bin/kafka-consumer-groups.sh --bootstrap-server <URL> --describe --group <group-name>
### Deleting a consumer group
Manually deleting a consumer group can be done using this command:

$KAFKA_HOME/bin/kafka-consumer-groups.sh --bootstrap-server <URL> --delete --group my-group --group <group-name>
### Resetting offsets for topics
Offsets help Kafka manage consumer failures and restarts. Offsets are simply the count of the messages consumed until a specific point. Keeping offsets helps consumers restart consumption gracefully without duplicates. At times, developers may want a consumer group to process the whole partition irrespective of consumption status, which can be done by resetting the offset. The command for resetting the offset and starting from the earliest message is as shown below:

$KAFKA_HOME/bin/kafka-consumer-groups.sh --bootstrap-server <URL> --reset-offsets --group <group-name> --topic <topic-name> --to-earliest
### Have questions about Kafka or streaming data?
Join a global community and chat with the experts on Slack.
