package com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> getAllByisActiveIsTrue();


    List<User> getAllByFamily(Family family);
}
