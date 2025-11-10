package com.example.springpulsarproducer.entities;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * JPA entity class for "Newsletter"
 *
 * @author aek
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="newsletter", schema="public" )
public class Newsletter implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="title", nullable=false)
    private String title ;

    @Column(name="content", columnDefinition="TEXT")
    private String content ;

    @Column(name="channel")
    private String channel ;

    @Column(name="type")
    private String type ;

    @Column(name="published_at")
    private LocalDateTime publishedAt ;

    @Column(name="created_at")
    private LocalDateTime createdAt ;

}
