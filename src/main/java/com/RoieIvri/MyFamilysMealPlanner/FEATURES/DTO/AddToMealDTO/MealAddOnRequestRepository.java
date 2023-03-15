package com.RoieIvri.MyFamilysMealPlanner.FEATURES.DTO.AddToMealDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealAddOnRequestRepository extends JpaRepository<MealAddOnRequestDTO,Long> {
}
