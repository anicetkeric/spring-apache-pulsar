package com.example.springpulsarconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Notification {

    @NotNull
    @JsonProperty("recipientEmail")
    private String recipientEmail;
    @NotNull
    @JsonProperty("recipientName")
    private String recipientName;
    @NotNull
    @JsonProperty("subject")
    private String subject;
    @NotNull
    @JsonProperty("channel")
    private String channel ;
    @NotNull
    @JsonProperty("content")
    private String content;
}
