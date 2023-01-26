package com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY;

import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/day")
@RequiredArgsConstructor
public class DayController implements GodController<Day> {

    @Autowired
    private final DayService dayService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Day addObject(@RequestBody Day day) throws Exception {
        return dayService.addObject(day);
    }

    @Override
    @PutMapping("/{objectId}")
    @ResponseStatus(HttpStatus.OK)
    public Day updateObject(@RequestBody Day day, @PathVariable Long objectId) throws Exception {

        return dayService.updateObject(day, objectId);


    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Day> getAll() throws Exception {
        return dayService.getAll();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Day> getAllActive() throws Exception {
        return dayService.getAllActive();
    }


    @PutMapping("/disable/{objectId}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Day disableObject(@PathVariable Long objectId) throws Exception {
        return dayService.disableObject(objectId);
    }

    @DeleteMapping("/{objectId}")
    @Override
    public void deleteObject(@PathVariable Long objectId) throws Exception {
        dayService.deleteObject(objectId);

    }


}
