package com.example.so69796060;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class So69796060Application implements CommandLineRunner {

	public static void main(final String[] args) {
		SpringApplication.run(So69796060Application.class, args);
	}

    @Value("#{new java.text.SimpleDateFormat('dd-MM-yyyy').parse('${param.date}')}")
    private Date date;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println(date);
    }
}
