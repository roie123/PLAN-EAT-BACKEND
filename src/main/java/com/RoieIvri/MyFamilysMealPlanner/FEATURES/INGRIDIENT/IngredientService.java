package com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT;

import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidator;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientService implements GodService<Ingredient> {

    @Autowired
    private final IngredientRepository ingredientRepository;


    public List<Ingredient> getAllByType(IngredientType ingredientType) {
        return ingredientRepository.getByIngredientType(ingredientType);
    }

    public List<Ingredient> getOrderedByPriceCatagory() {
        List<Ingredient> list = ingredientRepository.getAllByisActiveIsTrue();
        return list.stream().sorted().collect(Collectors.toList());

    }


    public List<Ingredient> getAllByPriceCatagory(PriceCategory priceCategory) {
        return ingredientRepository.getByPriceCategory(priceCategory);
    }


    public List<IngredientType> getAllTypes() {
        List<IngredientType> list = Arrays.stream(IngredientType.values()).toList();
        return list;
    }


    /**
     * Methods for The Ingredient Type Selection using the IngredientTypeDto
     */
    public IngredientTypeListDTO getIngredeintDTOByIngredientType(IngredientType ingredientType){
        IngredientTypeListDTO ingredientTypeListDTO = new IngredientTypeListDTO();
        List<Ingredient> list = ingredientRepository.getByIngredientType(ingredientType);
        ingredientTypeListDTO.setAvgPrice(getAvgCostOfIngredeientList(list));
        ingredientTypeListDTO.setIngredientType(ingredientType);
        ingredientTypeListDTO.setIngredients(list);
        return ingredientTypeListDTO;

    }


    /**
     * this method is responsible to get a valure from the controller a nreturn a List of ingredients that contains this pattern in there ingredientType att
     * @return
     */
    public List<Ingredient> getByIngredeintTypePattern(String patternToSearch){
        patternToSearch = "%"+patternToSearch+"%";
        return ingredientRepository.searchByPatternInIngredientType(patternToSearch);
    }


    public double getAvgCostOfIngredeientList(List<Ingredient>ingredients){
        double sum = 0;
        for (Ingredient ing: ingredients) {
            sum+=ing.getPrice();
        }
        return (sum/ingredients.size());
    }


    /**
     * Those are the regular Service Layer methods
     */
    @Override
    public Ingredient addObject(Ingredient ingredient) throws Exception {
        if (FormatValidator.isInvalidIngredient(ingredient)) {
            return ingredientRepository.save(ingredient);

        }
        return null;
    }

    @Override
    public Ingredient updateObject(Ingredient ingredient, Long objectId) throws Exception {
        if (FormatValidator.isInvalidIngredient(ingredient)) {
            return null;
        }
        if (ingredientRepository.existsById(objectId)) {
            ingredient.setId(objectId);
            return ingredientRepository.saveAndFlush(ingredient);

        }
        throw new GeneralExceptions("INGREDIENT NOT FOUND BY ID");
    }

    @Override
    public List<Ingredient> getAll() throws Exception {
        return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> getAllActive() throws Exception {
        return ingredientRepository.getAllByisActiveIsTrue();
    }

    @Override
    public Ingredient disableObject(Long objectId) throws Exception {
        if (ingredientRepository.existsById(objectId)) {
            Ingredient ingredient = ingredientRepository.findById(objectId).get();
            ingredient.setActive(false);
            return ingredientRepository.saveAndFlush(ingredient);
        } else throw new GeneralExceptions("INGREDIENT NOT FOUND BY ID ");
    }

    @Override
    public void deleteObject(Long objectId) throws Exception {
        ingredientRepository.deleteById(objectId);
    }


}
