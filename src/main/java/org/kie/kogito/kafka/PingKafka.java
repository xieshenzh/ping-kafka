package org.kie.kogito.kafka;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;

public class PingKafka {

    public static void main(String[] args) {
        String bootstrapServer = System.getenv("BOOTSTRAP_SERVERS");

        if (bootstrapServer != null && bootstrapServer.length() > 0) {
            Properties config = new Properties();
            config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);

            AdminClient adminClient = AdminClient.create(config);

            try {
                Set<String> topics = adminClient.listTopics().names().get();
                topics.forEach(topic -> System.out.println("Name: " + topic));
                System.out.println("Finished.");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
