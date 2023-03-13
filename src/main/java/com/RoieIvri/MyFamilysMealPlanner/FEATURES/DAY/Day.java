package com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.MEAL.Meal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
//@ToString
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private DayOfWeek dayOfWeek;

    private boolean isActive = true;

    private LocalDate localDate;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Meal> mealList = new ArrayList<>();

    @ManyToOne()
    @JsonIgnore
    private Family family;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addMeal(Meal meal) {
        this.mealList.add(meal);

    }


    public void setDayByInt(int dayInInteger) {
        switch (dayInInteger) {
            case 0: {
                this.dayOfWeek = DayOfWeek.SUNDAY;
                break;
            }

            case 1:
                this.dayOfWeek = DayOfWeek.MONDAY;
                break;
            case 2:
                this.dayOfWeek = DayOfWeek.TUESDAY;
                break;
            case 3:
                this.dayOfWeek = DayOfWeek.WEDNESDAY;
                break;
            case 4:
                this.dayOfWeek = DayOfWeek.THURSDAY;
                break;
            case 5:
                this.dayOfWeek = DayOfWeek.FRIDAY;
                break;
            case 6:
                this.dayOfWeek = DayOfWeek.SATURDAY;
                break;
        }
    }

}
