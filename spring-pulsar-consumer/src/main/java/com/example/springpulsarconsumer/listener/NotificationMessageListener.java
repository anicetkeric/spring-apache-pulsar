package com.example.springpulsarconsumer.listener;


import com.example.springpulsarconsumer.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.pulsar.listener.AckMode;
import org.springframework.pulsar.listener.Acknowledgement;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationMessageListener{

    @PulsarListener(
            ackMode = AckMode.MANUAL,
            subscriptionType = SubscriptionType.Shared)
    public void received(Message<Notification> msg, Acknowledgement ack) {
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
            ack.acknowledge(msg.getMessageId());
        } catch (Exception e) {
            ack.nack();
        }
    }

}