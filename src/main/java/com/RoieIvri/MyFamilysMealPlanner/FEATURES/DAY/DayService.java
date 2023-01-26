package com.RoieIvri.MyFamilysMealPlanner.FEATURES.DAY;

import com.RoieIvri.MyFamilysMealPlanner.FEATURES.FAMILY.Family;

import com.RoieIvri.MyFamilysMealPlanner.TOOLS.FormatValidatorException;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GeneralExceptions;
import com.RoieIvri.MyFamilysMealPlanner.TOOLS.GodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DayService implements GodService<Day> {

    @Autowired
    private final DayRepository dayRepository;


    @Override
    public Day addObject(Day day) throws Exception {
        if (day.getLocalDate().isBefore(LocalDate.now())) {
            throw new FormatValidatorException("NEW DAY CANNOT BE BEFORE CURRENT DATE ");
        }
        if (day != null) {
            return dayRepository.save(day);

        } else throw new GeneralExceptions("DAY CANNOT BE NULL");
    }


    @Override
    public Day updateObject(Day day, Long objectId) throws Exception {
        if (dayRepository.findById(objectId).isPresent()) {
            day.setId(objectId);
            return dayRepository.saveAndFlush(day);

        } else throw new GeneralExceptions("DAY NOT FOUND BY ID");

    }

    @Override
    public List<Day> getAll() throws Exception {
        return dayRepository.findAll();
    }

    @Override
    public List<Day> getAllActive() throws Exception {
        return dayRepository.getAllByisActiveIsTrue();
    }

    @Override
    public Day disableObject(Long objectId) throws Exception {
        if (dayRepository.existsById(objectId)) {
            Day day = dayRepository.findById(objectId).get();
            day.setActive(false);
            return dayRepository.save(day);
        }
        throw new GeneralExceptions("DAY NOT FOUND BY ID ");
    }

    @Override
    public void deleteObject(Long objectId) throws Exception {
        dayRepository.deleteById(objectId);
    }


    public List<Day> getDaysByFamily(Family family) {
        List<Day> days = dayRepository.getAllByFamily(family);
        days = days.stream().sorted(new Comparator<Day>() {
            @Override
            public int compare(Day o1, Day o2) {
                return o1.getLocalDate().compareTo(o2.getLocalDate());
            }
        }).toList();
        return days;
    }


}
