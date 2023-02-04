package com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.Day;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.FamilyService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.RECIPE.RecipeRepository;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidator;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements GodService<User> {

    @Autowired
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;



    @Override
    public User addObject(User user) throws Exception {
        if (FormatValidator.isUserInvalid(user)){
            throw new GeneralExceptions("FORMAT EXCEPTION");

        }
//        user.setFamily(List.of());
        return userRepository.save(user);
    }

    @Override
    public User updateObject(User user, Long objectId) throws Exception {
        if (FormatValidator.isUserInvalid(user)){
            throw new GeneralExceptions("FORMAT EXCEPTION");
        }

        if (userRepository.existsById(objectId)){
            User userFromDB = userRepository.findById(objectId).get();
            userFromDB.setName(user.getName());
            userFromDB.setImgUrl(user.getImgUrl());

            return userRepository.saveAndFlush(userFromDB);

        }
        else {
            throw new GeneralExceptions("USER NOT FOUND BY ID EXCEPTION ");
        }
    }

    @Override
    public List<User> getAll() throws Exception {

        return userRepository.findAll();
    }

    @Override
    public List<User> getAllActive() throws Exception {
        return userRepository.getAllByisActiveIsTrue();
    }

    @Override
    public User disableObject(Long objectId) throws Exception {
        if (recipeRepository.existsById(objectId)){
            User u = userRepository.findById(objectId).get();
            u.setActive(false);
            return userRepository.saveAndFlush(u);
        }else {
            throw new GeneralExceptions("USER NOT FOUND BY ID EXCEPTION ");
        }
    }

    @Override
    public void deleteObject(Long objectId) throws Exception {
        if (userRepository.existsById(objectId)){
            User user = userRepository.findById(objectId).get();
            user.setFamily(null);
            userRepository.save(user);
            return;
        }throw new GeneralExceptions("ID NOT FOUND");

    }




//    @Transactional
//    public List<User> addToFamily(Long userId , Long newFamilyMemberId) throws GeneralExceptions {
//        if (userRepository.existsById(userId) && userRepository.existsById(newFamilyMemberId)){
//            User u = userRepository.findById(userId).get();
//            User u2 = userRepository.findById(newFamilyMemberId).get();
//            u.addToFamily(u2);
//            u2.addToFamily(u);
//           return userRepository.saveAll(List.of(u,u2));
//
//
//
//        }
//        throw new GeneralExceptions("USER NOT FOUND EXCEPTION");
//    }

public List<User> getUsersByFamily(Family family ){
        return userRepository.getAllByFamily(family);
}

}
