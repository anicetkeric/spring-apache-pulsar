package com.example.springpulsarproducer.web;


import com.example.springpulsarproducer.dto.NewsletterDTO;
import com.example.springpulsarproducer.entities.Newsletter;
import com.example.springpulsarproducer.service.NewsletterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * REST controller for managing {@link Newsletter}.
 *
 * @author @aek
 */
@RestController
@RequestMapping("/api/newsletter")
public class NewsletterController {

    private final Logger log = LoggerFactory.getLogger(NewsletterController.class);
	
    private final NewsletterService entityService;

 	public NewsletterController (NewsletterService entityService) {
		this.entityService = entityService;
	}

    /**
     * {@code POST  /newsletter} : Create a new newsletter.
     *
     * @param newsletter the newsletter to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new newsletter.
     */
	@PostMapping()
	public ResponseEntity<Newsletter> createNewsletter(@RequestBody @Valid NewsletterDTO newsletter) {
         log.debug("REST request to save Newsletter : {}", newsletter);
         return new ResponseEntity<>(entityService.sendNewsletter(newsletter), HttpStatus.CREATED);
    }

}
