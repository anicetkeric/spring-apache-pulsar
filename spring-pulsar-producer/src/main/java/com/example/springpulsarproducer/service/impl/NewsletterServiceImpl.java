package com.example.springpulsarproducer.service.impl;


import com.example.springpulsarproducer.dto.NewsletterDTO;
import com.example.springpulsarproducer.dto.Notification;
import com.example.springpulsarproducer.entities.Newsletter;
import com.example.springpulsarproducer.entities.NewsletterSubscriber;
import com.example.springpulsarproducer.repositories.NewsletterRepository;
import com.example.springpulsarproducer.service.NewsletterService;
import com.example.springpulsarproducer.service.NewsletterSubscriberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.shade.org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service Implementation for managing {@link Newsletter}.
 * @author aek
 */
@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class NewsletterServiceImpl implements NewsletterService {

    private final NewsletterRepository repository;
    private final NewsletterSubscriberService newsletterSubscriberService;
    private final Producer<Notification> producer;

    /**
     * {@inheritDoc}
     */
    @Override
    public Newsletter sendNewsletter(NewsletterDTO newsletterDTO) {

        Newsletter newsletter = Newsletter.builder()
                .channel("EMAIL").content(newsletterDTO.getContent())
                .title(newsletterDTO.getTitle()).createdAt(LocalDateTime.now())
                .publishedAt(LocalDateTime.now()).type(newsletterDTO.getType())
                .build();

        Newsletter newsletterSaved = repository.save(newsletter);
        if (ObjectUtils.isNotEmpty(newsletterSaved)) {
            sendToSubscriber(newsletterSaved);
        }

        return newsletterSaved;
    }

    private void sendToSubscriber(Newsletter newsletterSaved) {

            // get all suscribers
            List<NewsletterSubscriber> newsletterSubscribers = newsletterSubscriberService.getAll();

            if(!newsletterSubscribers.isEmpty()){
                // send email notification
                newsletterSubscribers.forEach(newsletterSubscriber -> {
                    Notification notification = Notification.builder()
                            .channel(newsletterSaved.getChannel()).content(newsletterSaved.getContent())
                            .recipientEmail(newsletterSubscriber.getEmail()).recipientName(newsletterSubscriber.getName())
                            .subject(newsletterSaved.getTitle())
                            .build();

                    sendMsgAsync(notification);
                });
        }
    }

    /**
     * Pulsar publish messages asynchronously using the Java client
     */
    private void sendMsgAsync(Notification notification) {
        producer.sendAsync(notification).thenAccept(msgId -> log.info("Notification message with ID {} successfully sent", msgId));
    }
}
