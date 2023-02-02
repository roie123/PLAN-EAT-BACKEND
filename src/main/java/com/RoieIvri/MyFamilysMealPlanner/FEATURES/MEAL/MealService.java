package com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL;


import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.FamilyService;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidator;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService  {
    @Autowired
    private final MealRepoitory mealRepoitory;

    private  final FamilyService familyService;

    public Meal addObject(Meal meal) throws Exception {
        if (FormatValidator.isInvalidMeal(meal)) {
            throw new GeneralExceptions("FORMAT VALIDATION EXCEPTION");
        } else {
            return mealRepoitory.save(meal);
        }
    }

    public Meal updateObject(Meal meal, Long objectId) throws Exception {
        if (FormatValidator.isInvalidMeal(meal)) {
            throw new GeneralExceptions("FORMAT VALIDATION EXCEPTION");
        } else {

            if (mealRepoitory.existsById(objectId)){
                Meal mealFromDB = mealRepoitory.findById(objectId).get();
                mealFromDB.setMealTime(meal.getMealTime());
                mealFromDB.setNumberOfEaters(mealFromDB.getNumberOfEaters());
                mealFromDB.setTimeToMakeInMinutes(meal.getTimeToMakeInMinutes());
                mealFromDB.setRecipeList(meal.getRecipeList());
                mealRepoitory.saveAndFlush(mealFromDB);

            }
            return null;

        }
    }

    public List<Meal> getAll() throws Exception {
        return mealRepoitory.findAll();
    }

    public List<Meal> getAllActive() throws Exception {
        return mealRepoitory.getAllByisActiveIsTrue();
    }

    public Meal disableObject(Long objectId) throws Exception {
        if (mealRepoitory.existsById(objectId)) {
            Meal meal = mealRepoitory.findById(objectId).get();
            meal.setActive(false);
            return mealRepoitory.saveAndFlush(meal);

        } else throw new GeneralExceptions("MEAL NOT FOUND BY ID");
    }

    public void deleteObject(Long objectId) throws Exception {
        mealRepoitory.deleteById(objectId);
    }
}
