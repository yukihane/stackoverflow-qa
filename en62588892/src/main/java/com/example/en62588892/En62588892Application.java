package com.example.en62588892;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@RequiredArgsConstructor
public class En62588892Application implements CommandLineRunner {

    private final ApplicationContext context;

    public static void main(final String[] args) {
        SpringApplication.run(En62588892Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        final someOtherClass obj = new someOtherClass();
        obj.setText("Hello, world!");
        final someClass bean = (someClass) context.getBean("method", obj);
        System.out.println(bean.getText());

        System.exit(0);
    }

}
