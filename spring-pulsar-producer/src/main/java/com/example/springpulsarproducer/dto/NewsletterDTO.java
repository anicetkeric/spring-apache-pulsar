package com.example.springpulsarproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsletterDTO {

    @NotNull
    private String title;
    @NotNull
    private String type ;
    @NotNull
    private String content;
}
