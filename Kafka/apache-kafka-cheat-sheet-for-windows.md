# Apache Kafka Cheat sheet for windows

### Table of Contents
#### How to turn on Apache Kafka
#### Kafka Topic Management:
#### Creating a Topic:
#### Listing Topics:
#### Describing a Topic:
#### Deleting a Topic:
#### Altering Partition Count:
#### Monitoring Topic Health:
#### Producer Operations:
#### Starting a Producer:
#### Configuring Acknowledgement:
#### Consumer Operations:
#### Starting a Consumer:
#### Setting Consumer Properties:
#### Consumer Group Management:
#### Creating a Consumer Group:
#### Listing Consumer Groups:
#### Describing a Consumer Group:
#### Viewing Group Members:
#### Checking Group State:
#### Partition Reassignment:
#### Preparation:
#### Executing Reassignment:
#### Viewing Partition Data:
#### Conclusion

### How to turn on Apache Kafka
The first step is to start the zookeeper server
```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
![Setting the Scheme](IMAGES/k1.png)

### The second step is to start the kafka server
```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
![Setting the Scheme](IMAGES/k2.png)

### Kafka Topic Management:
#### Creating a Topic:
The first command is suitable for quick and simple topic creation when default settings are acceptable.
```
kafka-topics.bat --create --bootstrap-server localhost:9092 --topic test
```
![Setting the Scheme](IMAGES/k3-1.png)

The second command is suitable when you need to define specific configurations for the topic, such as partition count and replication factor.
```
kafka-topics --bootstrap-server localhost:9092 --topic test --create --partitions 3 --replication-factor 3 --if-not-exists
```
![Setting the Scheme](IMAGES/k4.png)

#### Listing Topics:
``` kafka-topics --bootstrap-server localhost:9092 --list ```

![Setting the Scheme](IMAGES/k5.png)

#### Describing a Topic:
``` kafka-topics --bootstrap-server localhost:9092 --topic test --describe ```

![Setting the Scheme](IMAGES/k6.png)

#### Deleting a Topic:
``` kafka-topics --bootstrap-server localhost:9092 --topic test --delete ```

![Setting the Scheme](IMAGES/k1-1.png)

#### Altering Partition Count:
``` kafka-topics --bootstrap-server localhost:9092 --alter --topic test --partitions 7 ```

![Setting the Scheme](IMAGES/k2-1.png)

#### Monitoring Topic Health:

``` kafka-topics --bootstrap-server localhost:9092 --describe --under-replicated-partitions ```

``` kafka-topics --bootstrap-server localhost:9092 --describe --unavailable-partitions ```

![Setting the Scheme](IMAGES/k3-2.png)

Note- There is no output showing while running these it means that there are no under-replicated partitions or unavailable partitions in your Kafka cluster at the moment.

### Producer Operations:
#### Starting a Producer:
``` kafka-console-producer.bat --broker-list localhost:9092 --topic test ```

![Setting the Scheme](IMAGES/k7-2.png)

#### Configuring Acknowledgement:
There are three types of acknowledgment in Kafka

- No acknowledgment (acks=0):
- Leader acknowledgment (acks=1)
- All acknowledgment (acks=all)
  
``` kafka-console-producer.bat --broker-list localhost:9092 --topic test --producer-property acks=all ```

![Setting the Scheme](IMAGES/k4-1.png)

### Consumer Operations:
#### Starting a Consumer:
``` kafka-console-consumer.bat --topic test --bootstrap-server localhost:9092 --from-beginning ```

![Setting the Scheme](IMAGES/k7-1.png)

#### Setting Consumer Properties:
``` kafka-console-consumer.bat --topic test --bootstrap-server localhost:9092 --from-beginning --group my-group --property print.key=true --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer ```

![Setting the Scheme](IMAGES/k5-1.png)

#### Consumer Group Management:
Creating a Consumer Group:
``` kafka-console-consumer --bootstrap-server localhost:9092 --topic test --group app1 ```

![Setting the Scheme](IMAGES/k6-1.png)

#### Listing Consumer Groups:
``` kafka-consumer-groups --bootstrap-server localhost:9092 --list ```

![Setting the Scheme](IMAGES/k7.png)

#### Describing a Consumer Group:
``` kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group app1 ```

![Setting the Scheme](IMAGES/k8.png)

#### Viewing Group Members:
``` kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group app1 --members ```

![Setting the Scheme](IMAGES/k9.png)

#### Checking Group State:
``` kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group app1 --state ```

![Setting the Scheme](IMAGES/k10.png)

### Partition Reassignment:
#### Preparation:
Create a JSON file (e.g., topics.json) specifying topics for reassignment.
```json
{
  "topics": [{ "topic": "test" }],
  "version": 1
}
```
#### Executing Reassignment:
``` kafka-reassign-partitions --bootstrap-server localhost:9092 --generate --topics-to-move-json-file topics.json --broker-list 3,2,1 ```

``` kafka-reassign-partitions --bootstrap-server localhost:9092 --execute --reassignment-json-file plan.json ```

``` kafka-reassign-partitions --bootstrap-server localhost:9092 --verify --reassignment-json-file plan.json ```
#### Viewing Partition Data:
``` kafka-run-class kafka.tools.DumpLogSegments --print-data-log --files <kafka-data-dir>/<partition-dir>/00000000000000000000.log ```
