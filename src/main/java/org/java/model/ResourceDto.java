package org.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto {
    private List<String> listOfMaleNames;
    private List<String> listOfFemaleNames;
}
