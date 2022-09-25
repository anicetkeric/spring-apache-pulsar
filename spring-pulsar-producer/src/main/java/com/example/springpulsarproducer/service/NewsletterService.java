package com.example.springpulsarproducer.service;

import com.example.springpulsarproducer.dto.NewsletterDTO;
import com.example.springpulsarproducer.entities.Newsletter;

import java.util.List;

/**
 * Service Interface for managing {@link Newsletter}.
*  @author aek
 */
public interface NewsletterService  {
   
    /**
     * create new newsletter and send notification
     *
     * @param newsletterDTO input newsletter dto
     * @return persisted entity Newsletter
     */
    Newsletter sendNewsletter(NewsletterDTO newsletterDTO);

}
