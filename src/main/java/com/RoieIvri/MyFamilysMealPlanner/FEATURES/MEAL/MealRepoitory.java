package com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Locale;

public interface MealRepoitory extends JpaRepository<Meal, Long> {

    public List<Meal> getAllByisActiveIsTrue();


}
