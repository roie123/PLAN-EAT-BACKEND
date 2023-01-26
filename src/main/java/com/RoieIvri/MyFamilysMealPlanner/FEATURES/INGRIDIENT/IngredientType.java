package com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT;

import java.util.Random;

public enum IngredientType {
    Eggs,
    Milk,
    Oil,
    Ketchup,
    pomegranate,
    Cider,
    Walnut,
    Olive,
    Red_Chile_Powder,
    Garlic,
    Pumpkin,
    Wheat,
    Pastry,
    Guacamole,
    Pasta,
    Syrup,
    Bran,
    Coleslaw,
    Yam,
    Jam,
    Fennel,
    Cherry,
    Cornstarch,
    Crouton,
    Buckwheat,
    Strudel,
    Saffron,
    Hummus,
    Pineapple,
    Berry;

    public static IngredientType getRandom(){
        Random random = new Random();
        return IngredientType.values()[random.nextInt(0,IngredientType.values().length-1)];
    }
}
