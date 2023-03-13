package com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART.CART_ITEM;


import com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART.Cart;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.Ingredient;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
@ToString@Builder
public class CartItem {


    @ManyToMany
   private List<Ingredient> ingredient ;

    @ManyToOne
    private Cart cart;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public CartItem(Ingredient ingredient, Cart cart) {
        this.cart = cart;
    }

    private int amount;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
