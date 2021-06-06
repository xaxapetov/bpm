package org.regression.restaurant.bpm.service;

import org.regression.restaurant.bpm.dto.Employee;
import org.regression.restaurant.bpm.dto.EmployeesTable;
import org.regression.restaurant.bpm.dto.VisitorsDto;

import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WorkingSchedule {
    List<EmployeesTable> calculateTimetable(Integer year, Month month, Integer dayOfTheMonth,
                                            Integer startWorkDay, Integer endWorkDay,
                                            List<Employee> employees, List<VisitorsDto> visitorsPredicted);
}
