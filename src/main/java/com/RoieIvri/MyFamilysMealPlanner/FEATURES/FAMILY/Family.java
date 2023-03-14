package com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.CART.Cart;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.Day;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.User;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidatorException;
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
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private boolean isActive = true;
    private String imgUrl;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "family")
    private List<User> familyMembers = new ArrayList<>();


    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "family")
    private List<Day> dayList = new ArrayList<>();

    @ManyToMany( cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Recipe> favoriteRecipes = new ArrayList<>();

    @OneToOne(mappedBy = "family" )
    private Cart cart ;

    private String email;
    private String password;

    public void addToFamily(User user) {
        this.familyMembers.add(user);
    }

    public void addAllToFamily(List<User> users) {
        this.familyMembers.addAll(users);
    }

    public void addToFavoriteRecipes(Recipe recipe) {
        this.favoriteRecipes.add(recipe);
    }

    public void addToFavoriteRecipes(List<Recipe> recipes) {
        this.favoriteRecipes.addAll(recipes);
    }



    public void addWeek(List<Day> days) throws FormatValidatorException {

        if (days.size() % 7 != 0) {
            throw new FormatValidatorException("CAN ONLY ADD AN ENTIRE WEEK OR WEEKS ");
        }
        this.dayList.addAll(days);
    }

    public void addDay(Day day) {
        this.dayList.add(day);
    }


    @Override
    public String toString() {
        return "Family{" +
                "id=" + id + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", isActive=" + isActive + "\n" +
                ", familyMembers=" + familyMembers + "\n" +
                ", dayList=" + dayList + "\n" +
                ", favoriteRecipes=" + favoriteRecipes + "\n" +
                ", email='" + email + '\'' + "\n" +
                ", password='" + password + '\'' + "\n" +
                '}';
    }
}
