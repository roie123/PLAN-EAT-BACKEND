package com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.Day;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.DayService;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.User;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.UserService;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository familyRepository;
    private final DayService dayService;

    private final UserService userService;


    public Family addObject(Family family) throws Exception {
        if (family.getId() != null && familyRepository.existsById(family.getId())) {
            throw new GeneralExceptions("FAMILY ALREADY EXIST ");
        }


        return familyRepository.save(family);
    }


    public Family updateObject(Family family, Long objectId) throws Exception {
        if (familyRepository.existsById(objectId)) {
            return familyRepository.save(family);

        }
        throw new GeneralExceptions("NOT FOUND BY ID ");
    }

    public List<Family> getAll() throws Exception {
        return familyRepository.findAll();
    }

    public List<Family> getAllActive() throws Exception {
        return familyRepository.getAllByisActiveIsTrue();
    }

    public Family disableObject(Long objectId) throws Exception {
        if (familyRepository.existsById(objectId)) {
            Family family = familyRepository.findById(objectId).get();
            family.setActive(false);
            return familyRepository.saveAndFlush(family);

        }
        throw new GeneralExceptions("NOT FOUND BY ID ");

    }

    public void deleteObject(Long objectId) throws Exception {
        if (familyRepository.existsById(objectId)) {
            familyRepository.deleteById(objectId);
        }
        throw new GeneralExceptions("NOT FOUND BY ID ");

    }

    public Family getById(Long id) throws GeneralExceptions {
        if (familyRepository.existsById(id)) {
            return familyRepository.findById(id).get();
        }
        throw new GeneralExceptions("ID NOT FOUND");
    }

    public Family addNewWeek(Long familyId, List<Day> days) throws Exception {
        if (familyRepository.existsById(familyId)) {
            Family family = familyRepository.findById(familyId).get();
            family.addWeek(days);
            return updateObject(family, family.getId());
        }
        throw new GeneralExceptions("ID NOT FOUND ");


    }

    @Transactional
    public User addFamilyMember(Long familyId, User user) throws Exception {
        checkFamilyId(familyId);
        if (user != null) {
            Family family = familyRepository.findById(familyId).get();
            family.addToFamily(user);
            updateObject(family, family.getId());
        }
        throw new GeneralExceptions("USER CANNOT BE NULL ");


    }


    public void checkFamilyId(Long id) throws GeneralExceptions {
        if (!familyRepository.existsById(id)) {
            throw new GeneralExceptions("ID NOT FOUND ");
        }
    }

    @Transactional
    public Family getFullFamilyById(Long id) throws GeneralExceptions {
        checkFamilyId(id);
        System.out.println("111111111111111111111111");
        Family family = familyRepository.findById(id).get();
        System.out.println(dayService.getDaysByFamily(family));
        family.setFamilyMembers(userService.getUsersByFamily(family));
        System.out.println(family);
        return family;

    }


    @Transactional
    public void addToFamily(User user ,Long familyId) throws GeneralExceptions {
        System.out.println(familyId);
        if (familyRepository.existsById(familyId)){
            Family familyFromDB = familyRepository.findById(familyId).get();
            List<User> newUsersList = familyFromDB.getFamilyMembers();
            user.setFamily(familyFromDB);
            newUsersList.add(user);
            familyRepository.save(familyFromDB);
            return;
        }throw new GeneralExceptions("NOT FOUND BY ID ");
    }
}
