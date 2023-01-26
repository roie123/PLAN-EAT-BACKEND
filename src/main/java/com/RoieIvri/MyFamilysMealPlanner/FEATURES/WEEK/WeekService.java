//package com.RoieIvri.MyFamilysMealPlanner.FEATURES.WEEK;
//
//import com.RoieIvri.MyFamilysMealPlanner.FEATURES.USER.UserRepository;
//import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidator;
//import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
//import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class WeekService implements GodService<Week> {
//
//    @Autowired
//    private final WeekRepositoy weekRepositoy;
//    private final UserRepository userRepository;
//
//    @Override
//    public Week addObject(Week week) throws Exception {
//        if (FormatValidator.isWeekInvalid(week)){
//            throw new GeneralExceptions("FORMAT EXCEPTION");
//        }
//
//    return weekRepositoy.save(week);
//    }
//
//    @Override
//    public Week updateObject(Week week, Long objectId) throws Exception {
//        if (FormatValidator.isWeekInvalid(week)){
//            throw new GeneralExceptions("FORMAT EXCEPTION");
//        }
//        if (weekRepositoy.existsById(objectId)){
//            week.setId(objectId);
//            return weekRepositoy.saveAndFlush(week);
//        }else {
//            throw new GeneralExceptions("WEEK NOT FOUND BY ID EXCEPTION");
//        }
//    }
//
//    @Override
//    public List<Week> getAll() throws Exception {
//        return weekRepositoy.findAll();
//    }
//
//    @Override
//    public List<Week> getAllActive() throws Exception {
//        return weekRepositoy.getAllByisActiveIsTrue();
//    }
//
//    @Override
//    public Week disableObject(Long objectId) throws Exception {
//        if (weekRepositoy.existsById(objectId)){
//            Week week= weekRepositoy.findById(objectId).get();
//            week.setActive(false);
//            return weekRepositoy.saveAndFlush(week);
//
//        }
//        else {
//            throw new GeneralExceptions("WEEK NOT FOUND BY ID ");
//        }
//    }
//
//    @Override
//    public void deleteObject(Long objectId) throws Exception {
//        weekRepositoy.deleteById(objectId);
//    }
//}
