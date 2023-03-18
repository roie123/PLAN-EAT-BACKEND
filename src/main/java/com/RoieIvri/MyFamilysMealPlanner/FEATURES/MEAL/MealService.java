package com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL;


import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DTO.AddToMealDTO.MealAddOnRequestDTO;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DTO.AddToMealDTO.MealAddOnRequestService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.FamilyService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.RecipeService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.User;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.UserService;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidator;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealService  {
    @Autowired
    private final MealRepoitory mealRepoitory;
    private final RecipeService recipeService;
    private  final FamilyService familyService;
    private final UserService userService;

    private final MealAddOnRequestService mealAddOnRequestService;

    public Meal addObject(Meal meal,Long familyId) throws Exception {
        if (FormatValidator.isInvalidMeal(meal)) {
            throw new GeneralExceptions("FORMAT VALIDATION EXCEPTION");
        } else {
            Family family =familyService.getById(familyId);
            meal.setFamily(family);
            return mealRepoitory.save(meal);
        }
    }


    public Meal addRecipeToApprove(Recipe recipe , Long mealId , Long userId) throws Exception {
        Meal meal = mealRepoitory.findById(mealId).orElseThrow();
        User user = userService.getSingle(userId);

        List<Recipe> recipes = meal.getPendingRecipes();
        recipes.add(recipe);

        meal.setApprovedRecipes(recipes);
       return updateObject(meal,mealId);

    }

    public Meal updateObject(Meal meal, Long objectId) throws Exception {
        if (FormatValidator.isInvalidMeal(meal)) {
            throw new GeneralExceptions("FORMAT VALIDATION EXCEPTION");
        } else {
            Meal mealFromDB = mealRepoitory.findById(objectId).orElseThrow();
                mealFromDB.setMealTime(meal.getMealTime());
                mealFromDB.setNumberOfEaters(mealFromDB.getNumberOfEaters());
                mealFromDB.setTimeToMakeInMinutes(meal.getTimeToMakeInMinutes());
                mealFromDB.setApprovedRecipes(meal.getApprovedRecipes());
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

    @Transactional
    public void addRecipesToApprove(List<Recipe> recipes, Long mealId, Long userId) throws Exception {
        Meal meal = mealRepoitory.findById(mealId).orElseThrow();

        //The user id has to have validation because the user has control  over it
        User user = userService.getSingle(userId);

        List<Recipe> recipesFromDB = new ArrayList<>();

        for (Recipe re:
             recipes) {
            recipesFromDB.add(recipeService.getSingleRecipe(re.getId()));
            System.out.println(re);
        }

//        for (Recipe r : recipes
//             ) {
//            r.setRequestCreator(user);
//            user.getRequestedRecipesToAdd().add(r);
//        }
//
//        List<Recipe> mealPendingRecipes = meal.getPendingRecipes();
//        System.out.println(mealPendingRecipes);
//        mealPendingRecipes.addAll(recipes);
//
//        meal.setPendingRecipes(recipes);
//        System.out.println(meal.getPendingRecipes());
//        return updateObject(meal,mealId);

        MealAddOnRequestDTO mealAddOnRequestDTO = mealAddOnRequestService.addObject(new MealAddOnRequestDTO());
        mealAddOnRequestDTO.setMeal(meal);
//        meal.getMealAddOnRequestDTOList().add(mealAddOnRequestDTO);
        mealAddOnRequestDTO.setRequestedRecipes(recipes);

        mealAddOnRequestDTO.setUserName(user.getName());
        mealAddOnRequestDTO.setUserImgUrl(user.getImgUrl());
//        mealAddOnRequestService.updateObject(mealAddOnRequestDTO,mealAddOnRequestDTO.getId());






    }



    @Transactional
    public Meal approveMealAddOnRequest(Long mealId, Long mealAddOnRequestId,Recipe recipe) throws Exception {
        Meal mealFromDB = mealRepoitory.findById(mealId).orElseThrow();
        MealAddOnRequestDTO mealAddOnRequestDTO = mealFromDB.getMealAddOnRequestDTOList().stream().filter(new Predicate<MealAddOnRequestDTO>() {

            @Override
            public boolean test(MealAddOnRequestDTO mealAddOnRequestDTO) {
                return mealAddOnRequestDTO.getId().longValue()==mealAddOnRequestId.longValue();
            }
        }).toList().get(0);
        List<Recipe> recipeList = mealAddOnRequestDTO.getRequestedRecipes().stream().filter(new Predicate<Recipe>() {
            int counter =1;
            @Override
            public boolean test(Recipe r) {
                if (r.getId().longValue() !=recipe.getId().longValue()){
                    return true;
                }else if (counter>0){
                    counter--;
                    return false;
                }
                return true;

            }
        }).toList();


            Recipe recipeFromDB = recipeService.getSingleRecipe(recipe.getId());
        System.out.println(recipeFromDB.getIngredients());
        mealAddOnRequestDTO.setRequestedRecipes(recipeList);

        mealFromDB.getApprovedRecipes().add(recipeFromDB);
        System.out.println(recipeFromDB);



return mealFromDB;



    }

}
