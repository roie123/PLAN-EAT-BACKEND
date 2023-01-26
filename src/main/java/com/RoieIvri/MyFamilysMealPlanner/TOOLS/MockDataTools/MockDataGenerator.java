package com.RoieIvri.MyFamilysMealPlanner.TOOLS.MockDataTools;

import com.RoieIvri.MyFamilysMealPlanner.CONFIG.GlobalConfig;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.Day;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.DayService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.FamilyRepository;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.FamilyService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.Ingredient;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.IngredientService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.IngredientType;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.PriceCategory;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL.Meal;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL.MealService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.RecipeService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.User;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.UserService;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.MealTime;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.RandomPics;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MockDataGenerator implements InitializingBean {

    @Autowired
    private DayService dayService;

    @Autowired
    private MealService mealService;
    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private UserService userService;
    @Autowired
    private RecipeService recipeService;

    private  final FamilyService familyService;
    private final FamilyRepository familyRepository;

    @Transactional
    public void getMockData() throws Exception {
        Random random = new Random();


     Family family = new Family();
     family.setName("Rosen");
     family.setEmail("mayaRosen@gmail.com");
     family.setPassword("123456");

        User user = new User();
        user.setName("Maya Rosen");
        user.setFamily(family);
        user.setImgUrl("https://images.pexels.com/photos/733872/pexels-photo-733872.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");


        User user1 = new User();
        user1.setName("Amit Rosen");
        user1.setFamily(family);
        user1.setImgUrl("https://cdn.xxl.thumbs.canstockphoto.com/teen-boy-portrait-close-up-emotional-portrait-of-caucasian-teen-boy-handsome-smiling-guy-funny-cut-stock-image_csp57927261.jpg");


        User user2 = new User();
        user2.setName("Noa Rosen");
        user2.setFamily(family);
        user2.setImgUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQupqeq_09mdLAy8wyA7SC5AEYMdAphunoK8Q&usqp=CAU");


        family.addAllToFamily(List.of(user,user1,user2));

        LocalDate localDate ;
        //adding days
        for (int i = 0; i < 7; i++) {
            Day day = new Day();
            day.setDayOfWeek(LocalDate.now().getDayOfWeek().plus(i));
            day.setLocalDate(LocalDate.now().plusDays(i));

            for (int j = 0; j < 3; j++) {
                Meal meal = new Meal();
                meal.setMealTime(MealTime.values()[j]);
                meal.setNumberOfEaters(random.nextInt(1,4));
                meal.setTimeToMakeInMinutes(random.nextInt(2,7));
                for (int k = 0; k < 2; k++) {
                    Recipe recipe =new Recipe();
                    recipe.setImgUrl(RandomPics.getRandomFoodPic());
                    recipe.setRecommended(random.nextBoolean());
                    recipe.setEstimatedPrice(random.nextDouble(1,50));
                    recipe.setName(RecipeNames.getRandomRecipe());
                    for (int l = 0; l < 3; l++) {
                        Ingredient ingredient = new Ingredient();
                        ingredient.setPrice(random.nextDouble(1,30));
                        ingredient.setName(IngredientNames.getRandom());
                        ingredient.setPriceCategory(PriceCategory.getRandom());
                        ingredient.setIngredientType(IngredientType.getRandom());



                        recipe.addIngredient(ingredient);
                    }//END OF ING

//                    recipe.setFamily(family);
                    meal.addRecipe(recipe);
                }//END OF RECIPE


                day.addMeal(meal);
            }//END OF MEAL
            day.setFamily(family);
            family.addDay(day);
        }//END OF DAYS

//        favorite Recipes
        for (int i = 0; i < 7; i++) {
            Recipe recipe = new Recipe();
            recipe.setName(RecipeNames.getRandomRecipe());
            recipe.setEstimatedPrice(random.nextDouble(3,15));
            recipe.setRecommended(random.nextBoolean());
            recipe.setImgUrl(RandomPics.getRandomFoodPic());
            family.addToFavoriteRecipes(recipe);
            recipe.setFamily(family);
        }


        System.out.println(familyService.addObject(family));
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if (GlobalConfig.toAddMockData) {
            System.out.println("*********************************ADDING MOCK DATA *******************************************");
            getMockData();
        }
    }

}
