package com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART.CART_ITEM.CartItem;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.Ingredient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@NonNull
@Entity
@Getter
@Setter
@ToString
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate createdDate = LocalDate.now();


//    @OneToMany()
//    private List<CartItem> items = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Ingredient> items = new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "family_id")
    private Family family;



}
