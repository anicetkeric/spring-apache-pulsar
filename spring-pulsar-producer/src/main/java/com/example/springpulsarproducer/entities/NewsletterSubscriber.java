package com.example.springpulsarproducer.entities;

import lombok.*;

import java.io.Serializable;
import javax.persistence.*;

/**
 * JPA entity class for "NewsletterSubscriber"
 *
 * @author aek
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="newsletter_subscriber", schema="public" )
public class NewsletterSubscriber implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    //--- ENTITY DATA FIELDS 
    @Column(name="email", nullable=false)
    private String email;

    @Column(name="name")
    private String name ;

}
