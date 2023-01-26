package com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {


    List<Ingredient> getAllByisActiveIsTrue();

    List<Ingredient> getByPriceCategory(PriceCategory priceCategory);
    List<Ingredient> getByIngredientType(IngredientType ingredientType);




    List<Ingredient> findAllByIngredientTypeContains(String patternToSearch);

    @Query(value = "select * from myfamilymealplanner.ingredient where ingredient_type like  ? " , nativeQuery = true)
    List<Ingredient> searchByPatternInIngredientType(@Param("pattern") String searchPattern);

    @Query(value = "select * from myfamilymealplanner.ingredient where ingredient_type like  ?  or  name like ? " , nativeQuery = true)
    List<Ingredient> searchForIngredientByTypeOrName(String searchPattern , String searchPattern2 );
}
