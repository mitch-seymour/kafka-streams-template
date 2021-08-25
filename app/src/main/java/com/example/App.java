package com.example;

import java.util.Properties;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.Topology;

class App {
  public static void main(String[] args) {
    // instantiate the topology
    Topology topology = MyTopology.build();

    // load the Kafka Streams configuration
    Properties config = AppConfig.getKafkaStreamsConfig();

    // build the topology and start streaming!
    KafkaStreams streams = new KafkaStreams(topology, config);

    // close the Kafka Streams threads on shutdown
    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    System.out.println("Starting Kafka Streams application");
    streams.start();
  }
}
