package com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART.CART_ITEM;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART.CartRepository;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.spec.ECField;
import java.util.List;

@Service
@AllArgsConstructor
public class CartItemService  {

    private final CartItemRepository cartItemRepository;

    public CartItem addObject(CartItem cartItem) throws Exception {
//        cartItem.setAmount(cartItem.getAmount()+1);
        return cartItemRepository.save(cartItem);
    }

    public void removeCartItem(CartItem cartItem) throws Exception{
//        if (cartItem.getAmount()==1){
//            deleteObject(cartItem.getId());
//            return;
//        }
//        cartItem.setAmount(cartItem.getAmount()-1);
        updateObject(cartItem, cartItem.getId());


    }

    public void updateObject(CartItem cartItem, Long objectId) throws Exception {
        if (cartItemRepository.existsById(cartItem.getId())){
            cartItemRepository.save(cartItem);
        }
        throw new GeneralExceptions("CART ITEM NOT FOUND BY ID");
    }

    public List<CartItem> getAll() throws Exception {
        return null;
    }

    public List<CartItem> getAllActive() throws Exception {
        return null;
    }

    public CartItem disableObject(Long objectId) throws Exception {
        return null;
    }

    public void deleteObject(Long objectId) throws Exception {

    }
}
