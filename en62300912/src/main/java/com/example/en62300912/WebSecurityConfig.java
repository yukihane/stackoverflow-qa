package com.example.en62300912;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyUtils;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
            .httpBasic().and()
            .authorizeRequests().antMatchers("/**/foo/**").hasAuthority("foo").and()
            .authorizeRequests().antMatchers("/**/moo/**").hasAuthority("moo")
            .and()
            .authorizeRequests().antMatchers("/**").hasAuthority("admin");
    }

    @Bean
    RoleHierarchyVoter roleVoter(final RoleHierarchy roleHierarchy) {
        return new RoleHierarchyVoter(roleHierarchy);
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        final Map<String, List<String>> hierarchyMap = new HashMap<>();
        hierarchyMap.put("admin", List.of("foo", "moo"));
        final String roleHierarchy = RoleHierarchyUtils.roleHierarchyFromMap(hierarchyMap);

        final RoleHierarchyImpl ret = new RoleHierarchyImpl();
        ret.setHierarchy(roleHierarchy);
        return ret;
    }

    @Bean
    public UserDetailsService myUserDetailsService() {
        final UserDetails foo = User
            .withDefaultPasswordEncoder()
            .username("foo")
            .password("foo")
            .authorities(new SimpleGrantedAuthority("foo"))
            .build();

        final UserDetails moo = User
            .withDefaultPasswordEncoder()
            .username("moo")
            .password("moo")
            .authorities(new SimpleGrantedAuthority("moo"))
            .build();

        final UserDetails admin = User
            .withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .authorities(new SimpleGrantedAuthority("admin"))
            .build();

        return new InMemoryUserDetailsManager(foo, moo, admin);
    }
}
