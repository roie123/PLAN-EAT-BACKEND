package com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamilyRepository extends JpaRepository<Family, Long> {

    List<Family> getAllByisActiveIsTrue();


}
