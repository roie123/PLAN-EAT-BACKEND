package com.RoieIvri.MyFamilysMealPlanner.TOOLS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomPics {

    public  static   String[] recipePics =new String[]{
      "https://ms1.ostium.cz/instance/web-recepty/jKLR58ir/h276w407t.jpg",
            "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chorizo-mozarella-gnocchi-bake-cropped-9ab73a3.jpg?quality=90&resize=768,574",
            "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8NXx8fGVufDB8fHx8&w=1000&q=80",
            "https://images.immediate.co.uk/production/volatile/sites/30/2022/08/Corndogs-7832ef6.jpg",
            "https://i0.wp.com/post.healthline.com/wp-content/uploads/2022/09/frozen-dinner-meal-meatloaf-mashed-potatoes-vegetables-1296x728-header.jpg?w=1155&h=1528",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8ZwZ2tuTvWJXRIRDBjpHM--O-J6sULrMbJA&usqp=CAU",
            "http://cdn.cnn.com/cnnnext/dam/assets/140430115517-06-comfort-foods.jpg",
            "https://www.finedininglovers.com/sites/g/files/xknfdk626/files/2021-06/halal-food%C2%A9iStock.jpg",
            "https://restaurantclicks.com/wp-content/uploads/2022/04/chinese-food-dishes.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmU2nMtbnJafGHEyCeom0a5cPwoOMcuDKENAG_ZVQ7kDNBkq41lq7lURuqF4lN-TLz-Y4&usqp=CAU",
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/delish-202104-birriatacos-058-1619806492.jpg"
    };


    public static String getRandomFoodPic(){
        Random random = new Random();
        return recipePics[random.nextInt(0,recipePics.length)];
    }
}
