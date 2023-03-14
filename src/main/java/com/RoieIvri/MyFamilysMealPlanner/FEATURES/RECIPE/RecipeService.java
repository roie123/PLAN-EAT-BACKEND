package com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.FamilyService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.IngredientService;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidator;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {


    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private final IngredientService ingredientService;

    private final FamilyService familyService;


    public Recipe addObject(Recipe recipe) throws Exception {
        if (FormatValidator.isRecipeInValid(recipe)) {
            throw new GeneralExceptions("FORMAT EXCEPTION");

        } else {

            return recipeRepository.save(recipe);
        }


    }
@Transactional
    public Recipe updateObject(Recipe recipe, Long objectId) throws Exception {
        if (FormatValidator.isRecipeInValid(recipe)) {
            throw new GeneralExceptions("FORMAT EXCEPTION");

        } else {
            if (recipeRepository.existsById(objectId)) {
                Recipe prevRecipe = recipeRepository.findById(objectId).get();
                prevRecipe.setName(recipe.getName());
                prevRecipe.setEstimatedPrice(recipe.getEstimatedPrice());
                prevRecipe.setRecommended(recipe.isRecommended());
                prevRecipe.setImgUrl(recipe.getImgUrl());
                prevRecipe.setActive(recipe.isActive());
                prevRecipe.setIngredients(recipe.getIngredients());
//                recipe.setId(objectId);
                return recipeRepository.saveAndFlush(prevRecipe);

            } else {
                throw new GeneralExceptions("CANNOT FIND RECIPE BY GIVEN ID ");
            }
        }
    }

    public List<Recipe> getAll() throws Exception {
        return recipeRepository.findAll();
    }

    public List<Recipe> getAllActive() throws Exception {
        return recipeRepository.getAllByisActiveIsTrue();
    }

    public Recipe disableObject(Long objectId) throws Exception {
        if (recipeRepository.existsById(objectId)) {
            Recipe recipe = recipeRepository.findById(objectId).get();
            recipe.setActive(false);
            return recipeRepository.saveAndFlush(recipe);
        } else throw new GeneralExceptions("CANNOT FIND RECIPE BY ID TO DISABLE ");
    }

    /**
     * Its a child Entity , so i have to disconnect the link to the parent and than delete it
     */
    @Transactional
    public void deleteObject(Long objectId, Long familyId) throws Exception {
        Family family = familyService.getById(familyId);
        family.setFavoriteRecipes(family.getFavoriteRecipes().stream().filter(new Predicate<Recipe>() {
            @Override
            public boolean test(Recipe recipe) {
                if (recipe.getId().longValue()==objectId.longValue()){
                    return false;
                }
                return true;
            }
        }).collect(Collectors.toList()));
//recipeRepository.deleteById(objectId);

    }

    @Transactional
    public Recipe addToFamily(Recipe recipe, Long familyId) throws GeneralExceptions {
        System.out.println(familyId);
        familyService.checkFamilyId(familyId);
        Family family = familyService.getById(familyId);
        recipe.setFamily(family);
        return recipeRepository.save(recipe);

    }
}
