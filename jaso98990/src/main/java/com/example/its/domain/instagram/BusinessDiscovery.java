package com.example.its.domain.instagram;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BusinessDiscovery(Long followers_count, Long media_count, String id) {
}
