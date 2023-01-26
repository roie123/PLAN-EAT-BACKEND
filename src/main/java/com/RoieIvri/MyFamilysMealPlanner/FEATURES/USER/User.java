package com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.Day;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
//@ToString
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private boolean isActive= true;
    private String name;
    private String imgUrl;


    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Recipe> favoriteRecipes=new ArrayList<>();



@JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE} ,fetch = FetchType.EAGER)
    private Family family;














}
