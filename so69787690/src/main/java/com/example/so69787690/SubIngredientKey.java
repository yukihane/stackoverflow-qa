package com.example.so69787690;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class SubIngredientKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ingredientId;
}
