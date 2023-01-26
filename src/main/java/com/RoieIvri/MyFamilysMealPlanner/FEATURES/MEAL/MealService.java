package com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL;


import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidator;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService implements GodService<Meal> {
    @Autowired
    private final MealRepoitory mealRepoitory;

    @Override
    public Meal addObject(Meal meal) throws Exception {
        if (FormatValidator.isInvalidMeal(meal)) {
            throw new GeneralExceptions("FORMAT VALIDATION EXCEPTION");
        } else {
            return mealRepoitory.save(meal);
        }
    }

    @Override
    public Meal updateObject(Meal meal, Long objectId) throws Exception {
        if (FormatValidator.isInvalidMeal(meal)) {
            throw new GeneralExceptions("FORMAT VALIDATION EXCEPTION");
        } else {
            meal.setId(objectId);
            return mealRepoitory.saveAndFlush(meal);

        }
    }

    @Override
    public List<Meal> getAll() throws Exception {
        return mealRepoitory.findAll();
    }

    @Override
    public List<Meal> getAllActive() throws Exception {
        return mealRepoitory.getAllByisActiveIsTrue();
    }

    @Override
    public Meal disableObject(Long objectId) throws Exception {
        if (mealRepoitory.existsById(objectId)) {
            Meal meal = mealRepoitory.findById(objectId).get();
            meal.setActive(false);
            return mealRepoitory.saveAndFlush(meal);

        } else throw new GeneralExceptions("MEAL NOT FOUND BY ID");
    }

    @Override
    public void deleteObject(Long objectId) throws Exception {
        mealRepoitory.deleteById(objectId);
    }
}
