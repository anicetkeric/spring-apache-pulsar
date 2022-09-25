package com.example.springpulsarproducer.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * JPA entity class for "Newsletter"
 *
 * @author aek
 *
 */
@Data
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
