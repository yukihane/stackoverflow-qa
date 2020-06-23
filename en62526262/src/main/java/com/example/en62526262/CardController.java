package com.example.en62526262;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/{id}")
    public ResponseEntity<Card> read(@PathVariable("id") final UUID id) {
        final Card foundCard = cardService.findById(id);
        if (foundCard == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundCard);
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody final Card card) {
        cardService.save(card);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@RequestBody final Card card, @PathVariable final UUID id) {
        final Card updatedCard = cardService.update(id, card);
        if (updatedCard == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedCard);
        }
    }

}