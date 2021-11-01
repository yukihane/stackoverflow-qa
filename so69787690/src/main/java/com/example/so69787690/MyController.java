package com.example.so69787690;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping
    public Ingredient index() {
        Ingredient obj = ingredientRepository.findById(101L).get();
        System.out.println("id: "+obj.getId());
        System.out.println("child size: " + obj.getIngrSubIngredients().size());
        String children = obj.getIngrSubIngredients().stream().map(e->e.getEmbId().toString()).collect(Collectors.joining(":"));
        System.out.println("children: " + children);
        
        return obj;
    }
}
