package com.RoieIvri.MyFamilysMealPlanner.TOOLS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public  interface GodController <T> {
public T addObject(T t) throws Exception;

public T updateObject(T t , Long objectId) throws Exception;

public List<T> getAll() throws Exception;
public List<T> getAllActive() throws Exception;

public T disableObject(Long objectId) throws Exception;

public void deleteObject(Long objectId) throws Exception;


}
