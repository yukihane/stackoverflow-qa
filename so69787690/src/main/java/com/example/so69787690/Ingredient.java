package com.example.so69787690;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ingredient {
    @Id
    private Long id;

//omitted code
  @OneToMany(mappedBy = "embId.ingredientId", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IngrSubIngredient> ingrSubIngredients =  new HashSet<IngrSubIngredient>();
//omitted code
//getters and setters.....
}
