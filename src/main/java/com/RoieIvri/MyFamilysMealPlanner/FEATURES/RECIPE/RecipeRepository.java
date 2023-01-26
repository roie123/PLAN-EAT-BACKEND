package com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    public List<Recipe> getAllByisActiveIsTrue();
}
