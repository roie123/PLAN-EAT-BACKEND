package com.RoieIvri.MyFamilysMealPlanner.CONFIG;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleCompanyError(Exception e) {
        return new ErrorMessage("Error From Service", e.getMessage());

    }

}
