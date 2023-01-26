package com.RoieIvri.MyFamilysMealPlanner.TOOLS.MockDataTools;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class RecipeNames {



public final static List<String> MEAL_NAMES = new ArrayList<>(List.of(
        "Beetroot and onion pie",
        "Turkey and sausage spaghetti",
        "Beef and black pepper korma",
        "Pickled onion and pecorino salad",
        "Chicken and lamb korma",
        "Polenta and rhubarb crumble",
        "Salmon and duck salad",
        "Nectarine and chilli dumplings",
        "Sweetcorn and rosemary dumplings",
        "Squash and bean casserole",
        "Grapefruit and egg toastie",
        "Spinach and peppercorn gyoza",
        "Banana and quorn madras",
        "Rye and ham salad",
        "Parsnip and ginger stir fry",
        "Pork and turkey pie",
        "Brie and grapefruit panini"

)

);


public static  String getRandomRecipe(){
    Random random = new Random();
    return MEAL_NAMES.get(random.nextInt(0, MEAL_NAMES.size()));
}



}
