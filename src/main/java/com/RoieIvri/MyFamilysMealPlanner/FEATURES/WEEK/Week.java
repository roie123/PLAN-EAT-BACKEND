//package com.RoieIvri.MyFamilysMealPlanner.FEATURES.WEEK;
//
//import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.Day;
//import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.User;
//import com.RoieIvri.MyFamilysMealPlanner.TOOLS.Model;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
//public class Week {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//    private LocalDate createdDate= LocalDate.now();
//
//    private boolean isActive= true;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Day sunday;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Day monday;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Day tuesday;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Day wednesday;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Day thursday;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Day friday;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private Day saturday;
//
//    @ManyToOne
//    private User user;
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setDaYByInteger(int dayInNumber, Day day){
//        switch (dayInNumber){
//            case 1: this.setSunday(day);
//            case 2: this.setMonday(day);
//            case 3: this.setTuesday(day);
//            case 4: this.setWednesday(day);
//            case 5: this.setThursday(day);
//            case 6: this.setFriday(day);
//            case 7: this.setSaturday(day);
//        }
//    }
//
//}
