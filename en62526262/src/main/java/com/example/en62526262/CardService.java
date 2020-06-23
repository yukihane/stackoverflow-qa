package com.example.en62526262;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    public Card findById(final UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Card save(final Card card) {
        return repository.save(card);
    }

    public Card update(final UUID id, final Card card) {
        return save(card);
    }

}
