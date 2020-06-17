package com.example.so67716;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizedClientRepository;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyLogoutHandler implements LogoutHandler {

    private static final String ATTR_NAME = HttpSessionOAuth2AuthorizedClientRepository.class.getName()
        + ".AUTHORIZED_CLIENTS";

    private final GitHubService gitHubService;

    @Override
    public void logout(final HttpServletRequest request, final HttpServletResponse response,
        final Authentication authentication) {
        // https://stackoverflow.com/a/56845244/4506703
        // org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizedClientRepository
        final Map<String, OAuth2AuthorizedClient> authorizedClients = (Map<String, OAuth2AuthorizedClient>) request
            .getSession().getAttribute(ATTR_NAME);
        final OAuth2AuthorizedClient client = authorizedClients.get("github");
        gitHubService.revoke(client);
    }

}
