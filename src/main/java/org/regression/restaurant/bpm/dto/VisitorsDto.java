package org.regression.restaurant.bpm.dto;

import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.Month;

@Data
@Builder
public class VisitorsDto {

    Integer id;

    Integer year;

    Month month;

    Integer dayOfTheMonth;

    DayOfWeek dayOfTheWeek;

    Integer hour;

    Double visitors;

}
