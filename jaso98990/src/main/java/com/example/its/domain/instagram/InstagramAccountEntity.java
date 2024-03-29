package com.example.its.domain.instagram;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InstagramAccountEntity(BusinessDiscovery businessDiscovery, String id) {
}
