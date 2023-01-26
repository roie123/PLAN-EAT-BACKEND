package com.RoieIvri.MyFamilysMealPlanner.TOOLS;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public enum MealTime {
    Breakfast,
    Lunch,
    Dinner;



    public static MealTime getRandom(){
        Random random= new Random();
        return MealTime.values()[random.nextInt(0,MealTime.values().length) ];
    }







}
