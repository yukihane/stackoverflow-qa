package com.example.so69787690;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class IngrSubIngredient {
    
    
    @EmbeddedId
    private SubIngredientKey embId = new SubIngredientKey();
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("ingredientId")
    private Ingredient ingredient;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("subIngredientId")
    private Ingredient subIngredient;
    
    private double quantity;
    
//omitted code
//getters and setters.....
}