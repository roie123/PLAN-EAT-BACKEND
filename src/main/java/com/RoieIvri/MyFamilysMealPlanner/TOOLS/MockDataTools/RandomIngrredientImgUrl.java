package com.RoieIvri.MyFamilysMealPlanner.TOOLS.MockDataTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomIngrredientImgUrl {


    public  static List<String> ingredientImageUrl =new ArrayList<>(Arrays.asList
            ("https://www.shutterstock.com/image-photo/lettuce-vegetable-isolated-on-white-260nw-497810764.jpg",
                    "https://us.123rf.com/450wm/svetlanak/svetlanak1907/svetlanak190700028/SvetlanaK190700028.jpg?ver=6",
                    "https://www.finedininglovers.com/sites/g/files/xknfdk626/files/2022-06/Type%20of%20cucumber.jpg",
                    "https://www.macmillandictionary.com/external/slideshow/full/135967_full.jpg",
                    "https://houseofnasheats.com/wp-content/uploads/2022/02/French-Bread-1.jpg",
                    "https://images.pexels.com/photos/3023237/pexels-photo-3023237.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7J_bn4kLNxhp935XB69TIW8Oo_ghIyNn7ag&usqp=CAU",
                    "https://cdnimg.webstaurantstore.com/images/products/large/87984/1978250.jpg",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpiFQoCialK6kCeovJ-BqH-EeXmPPYribISg&usqp=CAU",
                    "https://img.freepik.com/free-photo/one-fresh-red-tomato-isolated-white_1205-548.jpg?1",
                    "https://www.thespruceeats.com/thmb/DUZbt7vxtQuZmeUO-F_4BXapNX4=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/how-to-make-farmers-cheese-591547-hero-01-e3bc693977ce46e4a57aac820d963668.jpg")



    );
    public static  String getRandom(){
        Random random = new Random();
        return RandomIngrredientImgUrl.ingredientImageUrl.get(random.nextInt(0, ingredientImageUrl.size()));
    }


}
