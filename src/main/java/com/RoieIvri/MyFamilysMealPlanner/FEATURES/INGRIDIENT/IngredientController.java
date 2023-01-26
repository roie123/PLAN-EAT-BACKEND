package com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT;

import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodController;
import jakarta.servlet.annotation.HandlesTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/ingredients")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class IngredientController implements GodController<Ingredient>{
    @Autowired
    private final IngredientService ingredientService;


@GetMapping("/orderByPriceCategory")
public List<Ingredient> getOrderedByPriceCategory(){
    return ingredientService.getOrderedByPriceCatagory();
}


@GetMapping("/getByPriceCategory/{PriceCategory}")
public List<Ingredient> getyAllByPriceCategory(@PathVariable PriceCategory priceCategory) {
    return ingredientService.getAllByPriceCatagory(priceCategory);
}

@GetMapping("/getByType/{type}")
public List<Ingredient> getByType(@PathVariable IngredientType ingredientType){
    return ingredientService.getAllByType(ingredientType);

}

    @GetMapping("/getTypes")
    public List<IngredientType> getByType(){
        return ingredientService.getAllTypes();

    }





@GetMapping("/getIngListDto/{ingType}")
public IngredientTypeListDTO getIngTypeListDto(@PathVariable IngredientType ingType ){
    return ingredientService.getIngredeintDTOByIngredientType(ingType);
}

@GetMapping("/filterByIngredientTypePattern/{searchPattern}")
public List<Ingredient> getByIngredientTypePattern(@PathVariable String searchPattern ){
    return  ingredientService.getByIngredeintTypePattern(searchPattern);
}








    /**
     *those are the regular Controller methods
     *
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public Ingredient addObject(@RequestBody Ingredient ingredient) throws Exception {
        return ingredientService.addObject(ingredient);

    }

    @PutMapping("/{objectId}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Ingredient updateObject(@RequestBody Ingredient ingredient, @PathVariable Long objectId) throws Exception {
        System.out.println(ingredient);
        return ingredientService.updateObject(ingredient,objectId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Ingredient> getAll() throws Exception {
        return ingredientService.getAll();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Ingredient> getAllActive() throws Exception {
        return ingredientService.getAllActive();
    }

    @PutMapping("/disable/{objectId}")
    @Override
    public Ingredient disableObject(@PathVariable Long objectId) throws Exception {
        return ingredientService.disableObject(objectId);
    }

    @DeleteMapping("/{objectId}")
    @Override
    public void deleteObject(@PathVariable Long objectId) throws Exception {
    ingredientService.deleteObject(objectId);
    }
}
