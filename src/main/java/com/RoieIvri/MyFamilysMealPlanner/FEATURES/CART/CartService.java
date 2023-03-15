package com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.FamilyService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.Ingredient;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.IngredientService;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {


    private final CartRepository cartRepository;
    private final FamilyService familyService;
    private final IngredientService ingredientService;

    public Cart addCart(Cart cart){
     return    cartRepository.save(cart);

    }

public Cart createNewCart(Long familyId) throws GeneralExceptions {
        Family family = familyService.getById(familyId);
        Cart cart = new Cart();
        cart.setFamily(family);
         return cartRepository.save(cart);


}
//@Transactional
//    public void addToCart(Long cartId, Ingredient ingredient) throws CartException {
//        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartException("NOT FOUND"));
//        cart.getItems().add(ingredient);
//        cartRepository.save(cart);
//
//    }
@Transactional
public Cart generateCart(Long familyId) throws Exception {//TODO MAKE IT WORK
        Family family = familyService.getFullFamilyById(familyId);
        Cart cart = family.getCart();
        if (cart==null){
            Cart cart1 = new Cart();
            cart1.setFamily(family);
            List<Ingredient> list =new ArrayList<>();
            family.getDayList().forEach(day -> day.getMealList().forEach(meal -> meal.getApprovedRecipes().forEach(recipe -> list.addAll(recipe.getIngredients()))));

            for (Ingredient ing :
                    list) {
                Ingredient ingredient = Ingredient.builder().
                        imgUrl(ing.getImgUrl()).
                        ingredientType(ing.getIngredientType()).
                        name(ing.getName()).
                        price(ing.getPrice()).
                        priceCategory(ing.getPriceCategory())
                        .build();

//            ingredient.setCart(cart);

//            ingredient = ingredientService.addObject(ingredient);
                cart1.getItems().add(ing);
            }

            family.setCart(cart1);
            return cartRepository.save(cart1);
        }
        List<Ingredient> list =new ArrayList<>();
        family.getDayList().forEach(day -> day.getMealList().forEach(meal -> meal.getApprovedRecipes().forEach(recipe -> list.addAll(recipe.getIngredients()))));
    for (Ingredient ing :
            list) {
        Ingredient ingredient = Ingredient.builder().
                imgUrl(ing.getImgUrl()).
                ingredientType(ing.getIngredientType()).
                name(ing.getName()).
                price(ing.getPrice()).
                priceCategory(ing.getPriceCategory())
                .build();

//            ingredient.setCart(cart);

//            ingredient = ingredientService.addObject(ingredient);
            cart.getItems().add(ing);
    }
        cart.setFamily(family);
    family.setCart(cart);
        return cartRepository.save(cart);


}
public Cart updateCart(Cart cart , Long cartId) throws Exception {
        Cart cartFromDB = cartRepository.findById(cartId).orElseThrow();
        cartFromDB.setItems(new ArrayList<>());
        List<Ingredient>ingredients = cart.getItems();
//    for (Ingredient ing :
//            ingredients) {
//        Ingredient ingredient = Ingredient.builder().
//                imgUrl(ing.getImgUrl()).
//                ingredientType(ing.getIngredientType()).
//                name(ing.getName()).
//                price(ing.getPrice()).
//                priceCategory(ing.getPriceCategory())
//                .build();
//
////            ingredient.setCart(cart);
//
//         ingredient = ingredientService.addObject(ingredient);
//        cartFromDB.getItems().add(ingredient);
//    }

    cartFromDB.setItems(cart.getItems());

      return   cartRepository.save(cartFromDB);
}
}
