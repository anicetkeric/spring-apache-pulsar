package com.example.springpulsarproducer.service.impl;


import com.example.springpulsarproducer.entities.NewsletterSubscriber;
import com.example.springpulsarproducer.repositories.NewsletterSubscriberRepository;
import com.example.springpulsarproducer.service.NewsletterSubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Service Implementation for managing {@link NewsletterSubscriber}.
 * @author aek
 */
@RequiredArgsConstructor
@Service
@Transactional
public class NewsletterSubscriberServiceImpl implements NewsletterSubscriberService {

    private final NewsletterSubscriberRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<NewsletterSubscriber> getAll() {
        try {
            return repository.findAll();

        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }
}
