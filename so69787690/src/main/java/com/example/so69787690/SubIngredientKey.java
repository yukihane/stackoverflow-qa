package com.example.so69787690;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Setter
@Getter
@ToString
public class SubIngredientKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long ingredientId;

    private Long subIngredientId;
    /**
     * @return the ingredientId
     */
    
     public SubIngredientKey () {}
     
     public SubIngredientKey (
                Long ingredientId,
                Long subIngredientId) {
                this.ingredientId = ingredientId;
                this.subIngredientId = subIngredientId;
    }
//omitted code

}
