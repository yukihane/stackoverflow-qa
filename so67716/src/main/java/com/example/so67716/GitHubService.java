package com.example.so67716;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GitHubService {

    private final OAuth2AuthorizedClientService authorizedClientService;

    public void revoke(final String id) {

        final OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient("github", id);

        // 認可サーバへのrevoke要求
        requestRevoationToAuthorizationServer(authorizedClient);

        // クライアントが管理しているトークンを破棄する
        authorizedClientService.removeAuthorizedClient("github", id);
    }

    /**
     * @see <a href=
     * "https://developer.github.com/v3/apps/oauth_applications/#delete-an-app-token">
     * Delete an app token</a>
     */
    private void requestRevoationToAuthorizationServer(final OAuth2AuthorizedClient authorizedClient) {
        try {
            final String clientId = authorizedClient.getClientRegistration().getClientId();
            final String secret = authorizedClient.getClientRegistration().getClientSecret();

            /*
             * 今回はRestTemplateを利用していますが、リファレンスにはWebClientを利用する例が
             * 書かれています:
             * https://docs.spring.io/spring-security/site/docs/current/reference/html5/#oauth2Client-webclient-servlet
             */
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
