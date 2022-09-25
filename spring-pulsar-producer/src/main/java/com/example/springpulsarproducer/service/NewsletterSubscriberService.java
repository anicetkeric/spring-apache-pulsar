package com.example.springpulsarproducer.service;

import com.example.springpulsarproducer.entities.NewsletterSubscriber;

import java.util.List;

/**
 * Service Interface for managing {@link NewsletterSubscriber}.
*  @author aek
 */
public interface NewsletterSubscriberService  {

    /**
     * Get all entities
     *
     * @return list of entities List<NewsletterSubscriber>
     */
    List<NewsletterSubscriber> getAll();

}
