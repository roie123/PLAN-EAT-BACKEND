package com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART.CART_ITEM;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository  extends JpaRepository<CartItem,Long> {


}
