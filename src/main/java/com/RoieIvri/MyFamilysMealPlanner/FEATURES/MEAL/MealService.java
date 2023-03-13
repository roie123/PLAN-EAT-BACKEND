package com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL;


import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.FamilyService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.RecipeService;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidator;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MealService  {
    @Autowired
    private final MealRepoitory mealRepoitory;
    private final RecipeService recipeService;
    private  final FamilyService familyService;

    public Meal addObject(Meal meal,Long familyId) throws Exception {
        if (FormatValidator.isInvalidMeal(meal)) {
            throw new GeneralExceptions("FORMAT VALIDATION EXCEPTION");
        } else {
            Family family =familyService.getById(familyId);
            meal.setFamily(family);
            return mealRepoitory.save(meal);
        }
    }

    public Meal updateObject(Meal meal, Long objectId) throws Exception {
        if (FormatValidator.isInvalidMeal(meal)) {
            throw new GeneralExceptions("FORMAT VALIDATION EXCEPTION");
        } else {
            Meal mealFromDB = mealRepoitory.findById(objectId).orElseThrow();
                mealFromDB.setMealTime(meal.getMealTime());
                mealFromDB.setNumberOfEaters(mealFromDB.getNumberOfEaters());
                mealFromDB.setTimeToMakeInMinutes(meal.getTimeToMakeInMinutes());
                mealFromDB.setRecipeList(meal.getRecipeList());
              return   mealRepoitory.saveAndFlush(mealFromDB);

//            List<Recipe> recipesToAdd = meal.getRecipeList().stream().filter(recipe -> recipe.getId()==0).toList();
//            List<Recipe> initializedRecipes = new ArrayList<>();
//            for (Recipe recipe :
//                 recipesToAdd) {
//
//                 initializedRecipes.add(recipeService.addObject(recipe));
//            }
////        recipeList = Stream.concat(recipeList.stream(),recipesToAdd.stream()).collect(Collectors.toList());
//            if (mealRepoitory.existsById(objectId)){
//                Meal mealFromDB = mealRepoitory.findById(objectId).get();
//                mealFromDB.setMealTime(meal.getMealTime());
//                mealFromDB.setNumberOfEaters(mealFromDB.getNumberOfEaters());
//                mealFromDB.setTimeToMakeInMinutes(meal.getTimeToMakeInMinutes());
//                System.out.println(initializedRecipes);
//                mealFromDB.getRecipeList().addAll(initializedRecipes);
//                mealRepoitory.saveAndFlush(mealFromDB);
//
//            }
//
        }
    }

    public List<Meal> getAll() throws Exception {
        return mealRepoitory.findAll();
    }

    public List<Meal> getAllActive() throws Exception {
        return mealRepoitory.getAllByisActiveIsTrue();
    }

    public Meal disableObject(Long objectId) throws Exception {
        if (mealRepoitory.existsById(objectId)) {
            Meal meal = mealRepoitory.findById(objectId).get();
            meal.setActive(false);
            return mealRepoitory.saveAndFlush(meal);

        } else throw new GeneralExceptions("MEAL NOT FOUND BY ID");
    }

    public void deleteObject(Long objectId) throws Exception {
        mealRepoitory.deleteById(objectId);
    }
}
