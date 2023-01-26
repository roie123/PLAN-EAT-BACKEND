package com.RoieIvri.MyFamilysMealPlanner.TOOLS;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface GodService<T> {

public T addObject(T t) throws Exception;

public T updateObject(T t , Long objectId) throws Exception;

public List<T> getAll() throws Exception;
public List<T> getAllActive() throws Exception;

public T disableObject(Long objectId) throws Exception;

public void deleteObject(Long objectId) throws Exception;



}
