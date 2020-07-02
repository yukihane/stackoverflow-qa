package com.example.en62678427;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class En62678427Application implements CommandLineRunner {

    private final FleetRepository repository;

	public static void main(final String[] args) {
		SpringApplication.run(En62678427Application.class, args);
	}

    @Override
    public void run(final String... args) throws Exception {

        final Fleet fleet = new Fleet();
        fleet.setFleetName("fleet-name");
        final FleetSerialNo no = new FleetSerialNo();
        no.setSerialNoBody("body");

        fleet.setFleetSerialNo(Arrays.asList(no));
        no.setFleet(fleet);

        repository.save(fleet);
    }

}
