package com.example.its;

import com.example.its.domain.instagram.InstagramAccountEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class ItsApplication {
	public static final Logger log = LoggerFactory.getLogger(ItsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ItsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString("https://graph.facebook.com/v19.0/[ビジネスアカウント情報]")
					.queryParam("fields", "business_discovery.username(bluebottle){followers_count,media_count}")
					.queryParam("access_token", "[アクセストークン]");
			String url = uriComponentsBuilder.toUriString();

			InstagramAccountEntity instagramAccountEntity = restTemplate.getForObject(url, InstagramAccountEntity.class);
			log.info(instagramAccountEntity.toString());
		};
	}
}
