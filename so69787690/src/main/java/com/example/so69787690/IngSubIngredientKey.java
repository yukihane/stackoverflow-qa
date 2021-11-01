package com.example.so69787690;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class IngSubIngredientKey implements Serializable{

   
    private Long ingredientId;

    private Long subIngredientId;
    /**
     * @return the ingredientId
     */
    
     public IngSubIngredientKey () {}
     
     public IngSubIngredientKey (
                Long ingredientId,
                Long subIngredientId) {
                this.ingredientId = ingredientId;
                this.subIngredientId = subIngredientId;
    }
//omitted code
}
