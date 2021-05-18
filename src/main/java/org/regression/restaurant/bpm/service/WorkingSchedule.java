package org.regression.restaurant.bpm.service;

import org.regression.restaurant.bpm.dto.VisitorsDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WorkingSchedule {
    Map<String, Date>  calculateTimetable(Integer startWorkDay, Integer endWorkDay, Map<String, Integer> employee, List<VisitorsDto> visitorsPredicted);
}
