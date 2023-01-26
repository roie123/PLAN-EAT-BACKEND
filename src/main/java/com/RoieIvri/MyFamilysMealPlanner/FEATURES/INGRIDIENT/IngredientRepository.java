package com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {


    List<Ingredient> getAllByisActiveIsTrue();

    List<Ingredient> getByPriceCategory(PriceCategory priceCategory);
    List<Ingredient> getByIngredientType(IngredientType ingredientType);
}
