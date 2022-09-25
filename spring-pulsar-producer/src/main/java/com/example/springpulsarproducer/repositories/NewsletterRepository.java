package com.example.springpulsarproducer.repositories;

import com.example.springpulsarproducer.entities.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h2>NewsletterRepository</h2>
 * <p>
 * Description: Spring Data repository for the {@link Newsletter} entity.
 * 
 * @author aek
 */
@Repository
public interface NewsletterRepository  extends JpaRepository<Newsletter, Long> {

}
