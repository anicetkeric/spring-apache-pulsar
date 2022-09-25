package com.example.springpulsarconsumer.listener;


import com.example.springpulsarconsumer.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationMessageListener implements MessageListener<Notification> {
    @Override
    public void received(Consumer<Notification> consumer, Message<Notification> msg) {
        try {
            log.info("Topic Name: {}", msg.getTopicName());
            log.info("Message Id: {}", msg.getMessageId());
            log.info("Producer Name: {}", msg.getProducerName());
            log.info("Publish Time: {}", msg.getPublishTime());

            //log.info("Message received: {}", new String(msg.getData()));
            Notification notification = msg.getValue();
            log.info("Message received => Username: {}, Email: {}, Subject: {}, content: {}", notification.getRecipientName(),
                    notification.getRecipientEmail(), notification.getSubject(), StringUtils.abbreviate(notification.getContent(), 100));

            log.info("####################################################################################");
            consumer.acknowledge(msg);
        } catch (Exception e) {
            consumer.negativeAcknowledge(msg);
        }
    }
}