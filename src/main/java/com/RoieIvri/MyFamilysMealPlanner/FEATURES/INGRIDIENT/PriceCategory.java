package com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT;


import java.util.Random;


public enum PriceCategory {
    Cheap,
    Moderate,
    Expensive;



    public static PriceCategory getRandom(){
        Random random = new Random();
        return PriceCategory.values()[random.nextInt(0,PriceCategory.values().length-1)];
    }
}
