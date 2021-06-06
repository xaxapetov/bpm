package org.regression.restaurant.bpm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;

    private Integer visitorsInHour;

    private Integer workingTime;
}
