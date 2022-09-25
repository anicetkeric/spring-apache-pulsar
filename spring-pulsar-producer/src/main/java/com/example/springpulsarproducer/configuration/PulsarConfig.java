package com.example.springpulsarproducer.configuration;


import com.example.springpulsarproducer.dto.Notification;
import lombok.SneakyThrows;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PulsarConfig {

    private final ProducerProperties producerProperties;

    public PulsarConfig(ProducerProperties producerProperties) {
        this.producerProperties = producerProperties;
    }

    @SneakyThrows(PulsarClientException.class)
    @Bean
    public PulsarClient buildClient() {
        return PulsarClient.builder()
                .serviceUrl(producerProperties.getUrl())
                .build();
    }

    @Bean
    public Producer<Notification> producer(PulsarClient client) throws PulsarClientException {
        return client.newProducer(Schema.AVRO(Notification.class))
                .topic(producerProperties.getTopic())
                .producerName(producerProperties.getProducerName())
                .create();
    }

}