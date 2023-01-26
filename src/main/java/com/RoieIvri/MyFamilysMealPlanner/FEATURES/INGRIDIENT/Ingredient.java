package com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
public class Ingredient implements Comparable<Ingredient> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private String name;
    @Enumerated(EnumType.STRING)
    private IngredientType ingredientType;
    @Enumerated(EnumType.STRING)
    private PriceCategory priceCategory;
    private double price;
    private boolean isActive = true;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude
    private List<Recipe> recipeList = new ArrayList<>();


    @Override
    public int compareTo(Ingredient o) {
        if (this.priceCategory.equals(o.getPriceCategory())) {
            return 0;
        }
        if (this.priceCategory.equals(PriceCategory.Cheap)) {
            return -1;
        }
        if (this.priceCategory.equals(PriceCategory.Expensive)) {
            return 1;
        }
        return 0;
    }
}
