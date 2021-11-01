package com.example.so69787690;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final IngredientRepository ingredientRepository;

    @PutMapping("/ingredients")
    public void updateIngredient(@Valid @RequestBody Ingredient ingredient) {
        this.ingredientRepository.save(ingredient);
    }
}
