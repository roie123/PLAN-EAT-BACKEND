package com.RoieIvri.MyFamilysMealPlanner.FEATURES.DTO.AddToMealDTO;

import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealAddOnRequestService {



    private final MealAddOnRequestRepository mealAddOnRequestRepository;
    public MealAddOnRequestDTO addObject(MealAddOnRequestDTO mealAddOnRequestDTO) throws Exception {
        return mealAddOnRequestRepository.save(mealAddOnRequestDTO);
    }

    public MealAddOnRequestDTO getSingle(Long mealAddOnRequestId){
        return mealAddOnRequestRepository.findById(mealAddOnRequestId).orElseThrow();
    }
    public MealAddOnRequestDTO updateObject(MealAddOnRequestDTO mealAddOnRequestDTO, Long objectId) throws Exception {

        if (mealAddOnRequestRepository.existsById(objectId)){
            mealAddOnRequestDTO.setId(objectId);
            return mealAddOnRequestRepository.save(mealAddOnRequestDTO);
        }

        throw new GeneralExceptions("REQUEST NOT FOUND BY ID ");



    }

    public List<MealAddOnRequestDTO> getAll() throws Exception {
        return null;
    }

    public List<MealAddOnRequestDTO> getAllActive() throws Exception {
        return null;
    }

    public MealAddOnRequestDTO disableObject(Long objectId) throws Exception {
        return null;
    }

    public void deleteObject(Long objectId) throws Exception {
        mealAddOnRequestRepository.deleteById(objectId);

    }
}
