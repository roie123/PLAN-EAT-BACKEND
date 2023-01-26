package com.RoieIvri.MyFamilysMealPlanner.TOOLS.MockDataTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IngredientNames {


    public final  static List<String> INGREDIENT_NAMES =new ArrayList<>(List.of(
            "steak",
            "Cappuccino Latte",
            "macaroni",
            "raw sugar",
            "baking powder",
            "pink beans",
            "pancetta",
            "snap peas",
            "pumpkins",
            "panko bread crumbs",
            "almonds",
            "lima beans",
            "lettuce",
            "raspberries",
            "tonic water",
            "mint",
            "grits",
            "cucumbers"




    ));


    public static  String getRandom(){
        Random random = new Random();
        return INGREDIENT_NAMES.get(random.nextInt(0, INGREDIENT_NAMES.size()));
    }

}
