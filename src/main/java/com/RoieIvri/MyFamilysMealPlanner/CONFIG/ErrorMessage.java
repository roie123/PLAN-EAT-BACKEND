package com.RoieIvri.MyFamilysMealPlanner.CONFIG;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private String key;
    private String value;
}
