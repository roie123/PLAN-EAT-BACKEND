package com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE;

import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/recipe")
@RequiredArgsConstructor
@CrossOrigin
public class RecipeController {

    @Autowired
    private final RecipeService recipeService;

//    @Override
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//public Recipe addObject(@RequestBody Recipe recipe) throws Exception {
//        return recipeService.addObject(recipe);
//    }

    @PutMapping("/{objectId}")
    public Recipe updateObject(@RequestBody Recipe recipe, @PathVariable Long objectId) throws Exception {
        return recipeService.updateObject(recipe, objectId);
    }

//    @Override
//    @GetMapping("/all")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Recipe> getAll() throws Exception {
//        return recipeService.getAll();
//    }
//
//    @Override
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Recipe> getAllActive() throws Exception {
//
//        return recipeService.getAllActive();
//    }

    @PutMapping("/disable/{objectId}")
    public Recipe disableObject(@PathVariable Long objectId) throws Exception {
        return recipeService.disableObject(objectId);
    }

    @DeleteMapping("/{objectId}/{familyId}")
    public void deleteObject(@PathVariable Long objectId, @PathVariable Long familyId) throws Exception {
        recipeService.deleteObject(objectId, familyId);

    }

    @PostMapping("/addToFamily/{familyId}")
    public Recipe addTOFamily(@PathVariable Long familyId, @RequestBody Recipe recipe) throws GeneralExceptions {
        return recipeService.addToFamily(recipe, familyId);
    }


}
