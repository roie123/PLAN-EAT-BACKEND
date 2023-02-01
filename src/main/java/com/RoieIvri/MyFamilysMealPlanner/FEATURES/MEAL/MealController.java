package com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL;

import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal")
@RequiredArgsConstructor
@CrossOrigin
public class MealController implements GodController<Meal> {

    @Autowired
    private final MealService mealService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public Meal addObject(@RequestBody Meal meal) throws Exception {

        return mealService.addObject(meal);

    }

    @PutMapping("/{objectId}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Meal updateObject(@RequestBody Meal meal, @PathVariable Long objectId) throws Exception {
        return mealService.updateObject(meal, objectId);
    }

    @GetMapping("/all")
    @Override
    public List<Meal> getAll() throws Exception {
        return mealService.getAll();
    }

    @GetMapping
    @Override
    public List<Meal> getAllActive() throws Exception {
        return mealService.getAllActive();
    }

    @PutMapping("/disable/{objectId}")
    @Override
    public Meal disableObject(@PathVariable Long objectId) throws Exception {
        return mealService.disableObject(objectId);

    }

    @DeleteMapping("/{objectId}")
    @Override
    public void deleteObject(@PathVariable Long objectId) throws Exception {
        mealService.deleteObject(objectId);

    }
}
