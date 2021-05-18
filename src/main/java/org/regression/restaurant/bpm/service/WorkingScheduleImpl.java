package org.regression.restaurant.bpm.service;

import org.regression.restaurant.bpm.dto.VisitorsDto;

import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkingScheduleImpl implements WorkingSchedule {

    @Override
    public Map<String, Date> calculateTimetable(Integer year, Month month, Integer dayOfTheMonth, Integer startWorkDay, Integer endWorkDay,
                                                Map<String, Integer> employee, List<VisitorsDto> visitorsPredicted) {

        if (startWorkDay >= endWorkDay) {
            throw new RuntimeException("Время окончания рабочего дня раньше времени начала");
        }

        Map<Integer, Double> visitorsInOneDay = visitorsPredicted.stream().filter(x -> x.getMonth().equals(month)
                && x.getDayOfTheMonth().equals(dayOfTheMonth)
                && x.getYear().equals(year)).collect(Collectors.toMap(VisitorsDto::getHour, VisitorsDto::getVisitors));

        for(int i = startWorkDay; i < endWorkDay; i++){
            if(visitorsInOneDay.get(i) > 0){
                employee.
            }
        }

        return null;
    }
}
