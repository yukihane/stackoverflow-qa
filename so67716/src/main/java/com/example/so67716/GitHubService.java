package com.example.so67716;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {

    /**
     * @see <a href=
     * "https://developer.github.com/v3/apps/oauth_applications/#delete-an-app-token">
     * Delete an app token</a>
     */
    public void revoke(final OAuth2AuthorizedClient authorizedClient) {

        assert "github".equals(authorizedClient.getClientRegistration().getRegistrationId());

        try {
            final String clientId = authorizedClient.getClientRegistration().getClientId();
            final String secret = authorizedClient.getClientRegistration().getClientSecret();

            final RestTemplate rt = new RestTemplateBuilder()
                .basicAuthentication(clientId, secret)
                .build();
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            final JSONObject body = new JSONObject();
            body.put("access_token", authorizedClient.getAccessToken().getTokenValue());
            final HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);

            final String url = "https://api.github.com/applications/" + clientId + "/token";

            rt.exchange(url, HttpMethod.DELETE, entity, String.class);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

}
