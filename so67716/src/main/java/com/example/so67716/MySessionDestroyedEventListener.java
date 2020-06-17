package com.example.so67716;

import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MySessionDestroyedEventListener implements ApplicationListener<SessionDestroyedEvent> {

    private final GitHubService gitHubService;

    @Override
    public void onApplicationEvent(final SessionDestroyedEvent event) {
        // getSecurityContexts() の javadoc に
        // Usually there will be only one security context per session.
        // とあるので通常は1つになるはず
        final Stream<String> users = event
            .getSecurityContexts()
            .stream()
            .map(SecurityContext::getAuthentication)
            .filter(OAuth2AuthenticationToken.class::isInstance)
            .map(OAuth2AuthenticationToken.class::cast)
            .map(OAuth2AuthenticationToken::getPrincipal)
            .map(OAuth2User::getName)
            .distinct();

        users.forEach(gitHubService::revoke);
    }

}
