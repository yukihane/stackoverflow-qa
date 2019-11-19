package com.example.passwordencodersample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootApplication
public class PasswordEncoderSampleApplication implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void run(final String... args) throws Exception {

        // パスワードのハッシュ化
        final String password = passwordEncoder.encode("mypassword");
        log.info("Encoded Password: {}", password);

        final String name = "myname";

        jdbcTemplate.update("insert into user_table (name,password) values (?, ?)", name, password);

        final String dbpw = (String) jdbcTemplate
            .queryForList("select password from user_table where name = ?", "myname")
            .get(0).values().iterator().next();
        log.info("Pwssword from DB: {}", dbpw);

        // ハッシュ化したパスワードとの照合
        final boolean match = passwordEncoder.matches("mypassword", dbpw);
        log.info("Password is match?: {}", match);
    }

    public static void main(final String[] args) {
        SpringApplication.run(PasswordEncoderSampleApplication.class, args);
    }

}
