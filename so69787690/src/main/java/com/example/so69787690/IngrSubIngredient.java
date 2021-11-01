package com.example.so69787690;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class IngrSubIngredient {
    
    
    @EmbeddedId
    private SubIngredientKey embId = new SubIngredientKey();
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("ingredientId")
    @JsonBackReference
    private Ingredient ingredient;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("subIngredientId")
    @JsonBackReference
    private Ingredient subIngredient;
    
    private double quantity;
    
//omitted code
//getters and setters.....
}