package com.example.en62488475;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class En62488475Application implements CommandLineRunner {

    private final EntityOneRepository entityOneRepository;
    private final EntityTwoRepository entityTwoRepository;

    @PersistenceContext
    private EntityManager entityManager;

	public static void main(final String[] args) {
		SpringApplication.run(En62488475Application.class, args);
	}

    @Override
    public void run(final String... args) throws Exception {

        first();
        final Long id = second();

        final Optional<EntityTwo> e2 = entityTwoRepository.findById(id);
        System.out.println(e2.get().getEntityOne().getId());
    }

    private void first() {
        final EntityTwo entityTwo = new EntityTwo();
        entityTwoRepository.save(entityTwo);
    }

    private Long second() {
        final EntityOne e1 = new EntityOne();

        final EntityOne entityOne = entityOneRepository.save(e1);
        System.out.println(entityOne.getId());
        final EntityTwo entityTwo = new EntityTwo();
        entityTwo.setEntityOne(entityOne);
        final EntityTwo saved = entityTwoRepository.save(entityTwo);
        entityManager.detach(saved);
        return saved.getId();
    }

}
