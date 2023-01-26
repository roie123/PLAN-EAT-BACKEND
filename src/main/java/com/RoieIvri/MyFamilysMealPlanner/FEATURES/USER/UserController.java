package com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.Day;
import com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY.DayService;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidatorException;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController implements GodController<User>{
    @Autowired
    private final UserService userService;


    private final DayService dayService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addObject(@RequestBody User user) throws Exception {
        return userService.addObject(user);
    }


    @Override
    @PutMapping("/{objectId}")
    @ResponseStatus(HttpStatus.OK)
    public User updateObject(@RequestBody User user,@PathVariable Long objectId) throws Exception {
        return userService.updateObject(user,objectId);
    }

//    @PutMapping("/addToFamily/{userId}/{familyMemberId}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<User> addToFamily(@PathVariable Long userId , @PathVariable Long familyMemberId) throws GeneralExceptions {
//        return userService.addToFamily(userId,familyMemberId);
//    }


    @Override
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() throws Exception {

        return userService.getAll();
    }



    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllActive() throws Exception {
        return userService.getAllActive();
    }

    @Override
    @PutMapping("/disable/{objectId}")
    public User disableObject(@PathVariable Long objectId) throws Exception {
        return userService.disableObject(objectId);
    }

    @Override
    @DeleteMapping("/{objectId}")
    public void deleteObject(@PathVariable Long objectId) throws Exception {
        userService.deleteObject(objectId);
    }





}
