package com.example.so69745344;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class ItemConfig {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Value("${STORE.ENV:test}")
    private String env;

    @Bean
    CommandLineRunner itemRunner(ItemRepository itemRepository) {
        return args -> {

            System.out.println("true");
            Category cueCategory = new Category
                    ("Cues",
                     "This category contains all items relating to billiard cues. This includes yada, yadada, and yada."
                    );
            categoryRepository.save(cueCategory);

            Item item = new Item("Test Cue", 700, cueCategory);
            itemRepository.save(item);
        };
    }
}
