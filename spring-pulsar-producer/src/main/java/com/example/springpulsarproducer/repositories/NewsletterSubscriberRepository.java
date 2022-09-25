
package com.example.springpulsarproducer.repositories;

import com.example.springpulsarproducer.entities.NewsletterSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h2>NewsletterSubscriberRepository</h2>
 * <p>
 * Description: Spring Data repository for the {@link NewsletterSubscriber} entity.
 * 
 * @author aek
 */
@Repository
public interface NewsletterSubscriberRepository  extends JpaRepository<NewsletterSubscriber, Long> {

}
