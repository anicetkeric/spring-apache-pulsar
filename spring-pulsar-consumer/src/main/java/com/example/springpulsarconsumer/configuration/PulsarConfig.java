package com.example.springpulsarconsumer.configuration;


import com.example.springpulsarconsumer.model.Notification;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class PulsarConfig {
    private final ConsumerProperties consumerProperties;

    public PulsarConfig(ConsumerProperties consumerProperties) {
        this.consumerProperties = consumerProperties;
    }

    @SneakyThrows(PulsarClientException.class)
    @Bean
    public PulsarClient buildClient() {
        return PulsarClient.builder()
                .serviceUrl(consumerProperties.getUrl())
                .build();
    }

    @Bean
    public Consumer<Notification> consumer(PulsarClient client,
                                          MessageListener<Notification> notificationMessageListener) throws PulsarClientException {
        return client.newConsumer(Schema.AVRO(Notification.class))
                .topic(consumerProperties.getTopic())
                .subscriptionName(consumerProperties.getSubscriptionName())
                .messageListener(notificationMessageListener)
                .subscribe();
    }
}