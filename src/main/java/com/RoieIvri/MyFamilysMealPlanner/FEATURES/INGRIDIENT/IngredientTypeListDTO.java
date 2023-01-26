package com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT;

import lombok.Data;

import java.util.List;

@Data
public class IngredientTypeListDTO {

    private List<Ingredient> ingredients;
    private IngredientType ingredientType;

    private double avgPrice;



}
