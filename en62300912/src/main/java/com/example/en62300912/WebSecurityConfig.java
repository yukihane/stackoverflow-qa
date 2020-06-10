package com.example.en62300912;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
            .authorizeRequests().antMatchers("/**/foo/**").hasAnyAuthority("admin", "foo").and()
            .authorizeRequests().antMatchers("/**/moo/**").hasAnyAuthority("admin", "moo").and()
            .authorizeRequests().antMatchers("/**").hasAuthority("admin");
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
