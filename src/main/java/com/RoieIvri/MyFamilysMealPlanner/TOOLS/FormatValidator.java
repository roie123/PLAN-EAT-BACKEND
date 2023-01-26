package com.RoieIvri.MyFamilysMealPlanner.TOOLS;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.Ingredient;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL.Meal;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL.MealService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.User;

import java.time.LocalDate;

public class FormatValidator {

    public static boolean isInvalidIngredient(Ingredient ingredient) throws FormatValidatorException {
        if (ingredient.getName().length()<2){
            throw new FormatValidatorException("INGREDIENT NAME CANNOT BE LESS THEN THREE LETTERS ");
        }
        if (ingredient.getPrice()<0){
            throw new FormatValidatorException("INGREDIENT CANNOT COST LESS THEN 1");
        }
        return false;
    }








    public static boolean isInvalidMeal(Meal meal) throws FormatValidatorException {
        if (meal.getNumberOfEaters()<=0 || meal.getNumberOfEaters()>15){
            throw new FormatValidatorException("NUMBER OF PEOPLE EATING CANNOT BE UNDER 1 OR MORE THEN 15");

        }
        if (meal.getTimeToMakeInMinutes()<1 ||meal.getTimeToMakeInMinutes()>300){
            throw new FormatValidatorException("TIME TO MAKE CANNOT BE UNDER 1 MINUTE OR MORE THEN 300 MINUTES");
        }
        return false;
    }




    public static boolean isRecipeInValid(Recipe recipe) throws FormatValidatorException {
        if (recipe==null){
            throw new FormatValidatorException("RECIPE CANNOT BE NULL");
        }
        if (recipe.getEstimatedPrice()<0 || recipe.getEstimatedPrice()>690_000){
            throw new FormatValidatorException("ESTIMATED PRICE CANNOT BE UNDER 0 OR MORE THEN 690,000");
        }
//        if (recipe.getIngredients().size()<1){
//            throw new FormatValidatorException("RECIPE SHOULD HAVE AT LEAST 1 INGREDIENT");
//        }
        return false;
    }

    public static boolean isUserInvalid(User user) throws FormatValidatorException {

//        if (user.getFamily()!=null &&user.getFamily().size()>20 ){
//            throw new FormatValidatorException("USER'S FAMILY CANNOT BE MORE THEN 20 USERS ");
//        }
        if (user.getName().isBlank() || user.getName().length()<2 || user.getName().isEmpty()){
            throw new FormatValidatorException("USER NAME NOT VALID ");
        }
        if (user.getFavoriteRecipes().size()>30){
            throw new FormatValidatorException("CANNOT HAVE MORE THEN 30 FAVORITE RECIPES");
        }
//        if (user.getUserDays()!=null && user.getUserDays().size()>0){
//            user.getUserDays().forEach(day -> {
//                if (day.getLocalDate().isBefore(LocalDate.now())){
//                    try {
//                        throw new FormatValidatorException("A DAY CANNOT BE TODAY OR BEFORE THAT ");
//                    } catch (FormatValidatorException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            });
//        }
        return false;
    }







}

