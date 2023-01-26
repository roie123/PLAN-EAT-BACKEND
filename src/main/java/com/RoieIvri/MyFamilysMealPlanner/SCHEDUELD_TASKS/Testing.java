package com.RoieIvri.MyFamilysMealPlanner.SCHEDUELD_TASKS;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.Day;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.DayService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Testing {

private final DayService dayService ;



    @Scheduled(cron = "0 0 12 * * *")
    @Transactional
    public  void sendMessage() throws Exception {
        List<Day> days = dayService.getAllActive();

        days.forEach(day->{
            if (day.getLocalDate().isBefore(LocalDate.now())){
                try {
                    dayService.disableObject(day.getId());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }


        });
    }
}
