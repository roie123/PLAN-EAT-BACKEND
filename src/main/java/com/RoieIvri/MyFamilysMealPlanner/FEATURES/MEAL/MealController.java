package com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal")
@RequiredArgsConstructor
@CrossOrigin
public class MealController  {

    @Autowired
    private final MealService mealService;

    @PostMapping("/{familyId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Meal addObject(@RequestBody Meal meal,@PathVariable Long familyId) throws Exception {

        return mealService.addObject(meal,familyId);

    }

    @PutMapping("/{objectId}")
    @ResponseStatus(HttpStatus.OK)
    public Meal updateObject(@RequestBody Meal meal, @PathVariable Long objectId) throws Exception {
        return mealService.updateObject(meal, objectId);
    }

    @GetMapping("/all")
    public List<Meal> getAll() throws Exception {
        return mealService.getAll();
    }

    @GetMapping
    public List<Meal> getAllActive() throws Exception {
        return mealService.getAllActive();
    }

    @PutMapping("/disable/{objectId}")
    public Meal disableObject(@PathVariable Long objectId) throws Exception {
        return mealService.disableObject(objectId);

    }

    @PutMapping("/approveRequest/")
    public void approveMealAddOnRequest(){//TODO Implement the approval from the main user
//        mealService.approveMealAddOnRequest();
    }


    @PutMapping("/addPendingRecipe/{mealId}/{userId}")
    public Meal addPendingRecipe(@RequestBody Recipe recipe,@PathVariable Long mealId,@PathVariable Long userId) throws Exception {
       return mealService.addRecipeToApprove(recipe,mealId,userId);
    }
    @PutMapping("/addPendingRecipes/{mealId}/{userId}")
    public void addPendingRecipe(@RequestBody List<Recipe> recipes,@PathVariable Long mealId,@PathVariable Long userId) throws Exception {
         mealService.addRecipesToApprove(recipes,mealId,userId);
    }

    @DeleteMapping("/{objectId}")
    public void deleteObject(@PathVariable Long objectId) throws Exception {
        mealService.deleteObject(objectId);

    }
}
