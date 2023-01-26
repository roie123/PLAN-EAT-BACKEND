package com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    List<Day> getAllByisActiveIsTrue();

    List<Day> getAllByFamily(Family family);

}
