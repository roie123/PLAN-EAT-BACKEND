package com.RoieIvri.MyFamilysMealPlanner.FEATURES.DTO.AddToMealDTO;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL.Meal;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter@Builder
public class MealAddOnRequestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String userImgUrl;
    private String userName;



    @ManyToMany
    private List<Recipe> requestedRecipes;



    @ManyToOne
    @JsonIgnore
    private Meal meal;


}
