package com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {


    private final CartService cartService;


    @PutMapping("/{cartId}")
    public Cart updateCart(@RequestBody Cart cart , @PathVariable Long cartId) throws Exception {

        return cartService.updateCart(cart,cartId);
    }




}
