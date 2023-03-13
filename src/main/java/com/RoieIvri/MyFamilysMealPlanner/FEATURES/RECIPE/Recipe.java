package com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.INGRIDIENT.Ingredient;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL.Meal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private boolean isRecommended = false;
    private double estimatedPrice;
    private boolean isActive = true;
    private String imgUrl;
    private int timeToMake;
    @ManyToMany()
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToMany()
    @JsonIgnore
    private List<Meal> meals;

    @JsonIgnore
    @ManyToOne
    private Family family;

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isRecommended=" + isRecommended +
                ", estimatedPrice=" + estimatedPrice +
                ", isActive=" + isActive +
                ", imgUrl='" + imgUrl + '\'' ;
//                ", ingredients=" + ingredients +
//                ", meal=" + meals;
//                ", family=" + family +

    }


    public Recipe(Recipe other) {
//        this.meals=other.getMeals();
        this.family=other.getFamily();
        this.name=other.getName();
        this.estimatedPrice= other.estimatedPrice;
        this.imgUrl=other.getImgUrl();
        this.timeToMake=other.timeToMake;
        this.isRecommended= other.isRecommended;
        this.ingredients=other.getIngredients();
        this.isActive= other.isActive;

    }

}
