package com.example.springpulsarconsumer.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "pulsar.consumer")
public class ConsumerProperties {
    private String topic;
    private String url;
    private String subscriptionName;
}
