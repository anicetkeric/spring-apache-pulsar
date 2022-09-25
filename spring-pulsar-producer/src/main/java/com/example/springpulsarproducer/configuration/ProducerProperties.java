package com.example.springpulsarproducer.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "pulsar.producer")
public class ProducerProperties {
    private String url;
    private String topic;
    private String producerName;
}
