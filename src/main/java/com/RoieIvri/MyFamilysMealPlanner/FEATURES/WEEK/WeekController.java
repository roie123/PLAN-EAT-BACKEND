//package com.RoieIvri.MyFamilysMealPlanner.FEATURES.WEEK;
//
//import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodController;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/week")
//@RequiredArgsConstructor
//public class WeekController implements GodController<Week> {
//
//    @Autowired
//    private final WeekService weekService;
//
//
//    @Override
//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
//    public Week addObject(@RequestBody Week week) throws Exception {
//        return weekService.addObject(week);
//    }
//
//    @Override
//    @PutMapping("/{objectId}")
//    @ResponseStatus(HttpStatus.OK)
//    public Week updateObject(@RequestBody Week week, @PathVariable Long objectId) throws Exception {
//        return weekService.updateObject(week, objectId);
//    }
//
//    @Override
//    @GetMapping("/all")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Week> getAll() throws Exception {
//        return weekService.getAll();
//    }
//
//    @Override
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Week> getAllActive() throws Exception {
//        return weekService.getAllActive();
//    }
//
//    @Override
//    @PutMapping("/disable/{objectId}")
//    public Week disableObject(@PathVariable Long objectId) throws Exception {
//        return weekService.disableObject(objectId);
//    }
//
//    @Override
//    @DeleteMapping
//    public void deleteObject(Long objectId) throws Exception {
//        weekService.deleteObject(objectId);
//    }
//}
