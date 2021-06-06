package org.regression.restaurant.bpm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.Month;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitorsDto {

    Integer id;

    Integer year;

    Month month;

    Integer dayOfTheMonth;

    DayOfWeek dayOfTheWeek;

    Integer hour;

    Double visitors;

}
