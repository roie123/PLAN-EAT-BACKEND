package com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    @Procedure("getFamilyCart")
    Cart getFamilyCart(Long familyId);
}
