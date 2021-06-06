package org.regression.restaurant.bpm.service;

import lombok.extern.log4j.Log4j2;
import org.regression.restaurant.bpm.dto.Employee;
import org.regression.restaurant.bpm.dto.EmployeesTable;
import org.regression.restaurant.bpm.dto.VisitorsDto;

import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j2
public class WorkingScheduleImpl implements WorkingSchedule {

    @Override
    public List<EmployeesTable> calculateTimetable(Integer year, Month month, Integer dayOfTheMonth,
                                                Integer startWorkDay, Integer endWorkDay,
                                                List<Employee> employees, List<VisitorsDto> visitorsPredicted) {

        List<EmployeesTable> table = new ArrayList<>();

        if (startWorkDay >= endWorkDay) {
            throw new RuntimeException("Время окончания рабочего дня раньше времени начала");
        }

        Map<Integer, Integer> visitorsInOneDay = visitorsPredicted.stream().filter(x -> x.getMonth().equals(month)
                && x.getDayOfTheMonth().equals(dayOfTheMonth)
                && x.getYear().equals(year))
                .collect(Collectors.toMap(VisitorsDto::getHour, x2 -> (int) Math.floor(x2.getVisitors() + 0.5)));


        for (int i = startWorkDay; i <= endWorkDay; ) {
            int minHour = 0;
            Employee employeeFromValue = null;
            if(employees.isEmpty()){
                log.info("Не хватает работников");
            }
            for (Employee employee : employees) {
                int finalI = i;
                int minHourForEmployer = visitorsInOneDay.entrySet().stream().filter(x-> x.getKey() >= finalI)
                        .min(Comparator.comparingInt(x -> Math.abs(x.getValue() - employee.getVisitorsInHour())))
                        .orElseThrow(() -> new RuntimeException("Минимальное значение по модулю не найдено")).getValue();

                if (minHour > minHourForEmployer && (employee.getWorkingTime() > (minHourForEmployer - finalI))) {
                    minHour = minHourForEmployer;
                    employeeFromValue = employee;
                }
            }
            for (int j = i; ; ) {
                assert employeeFromValue != null;
                int workingTime = 0;
                if (j + employeeFromValue.getWorkingTime() > endWorkDay) {
                    j--;
                    continue;
                }
                visitorsInOneDay.put(j, visitorsInOneDay.get(j) - employeeFromValue.getVisitorsInHour());
                j++;
                workingTime++;
                if (workingTime == employeeFromValue.getWorkingTime()) {
                    i = j;
                    table.add(EmployeesTable.builder()
                            .name(employeeFromValue.getName())
                            .startWorking(i)
                            .endWorking(j).build());
                    employees.remove(employeeFromValue);
                    break;
                }
            }
        }



        for (Employee employee : employees) {
            Map.Entry<Integer, Integer> entry = visitorsInOneDay.entrySet().stream()
                    .max(Comparator.comparingInt(Map.Entry::getValue))
                    .orElseThrow(() -> new RuntimeException("Максимальное значение не найдено"));
            int startHourNextEmployee = entry.getKey();
            int endHourNextEmployee = startHourNextEmployee + employee.getWorkingTime();
            if((startHourNextEmployee + employee.getWorkingTime()) > endWorkDay){
                startHourNextEmployee = endHourNextEmployee - endWorkDay;
            }
            table.add(EmployeesTable.builder()
                    .name(employee.getName())
                    .startWorking(startHourNextEmployee)
                    .endWorking(startHourNextEmployee + employee.getWorkingTime()).build());

            while(startHourNextEmployee <= endHourNextEmployee){
                visitorsInOneDay.put(startHourNextEmployee, visitorsInOneDay.
                        get(startHourNextEmployee) - employee.getVisitorsInHour());
                startHourNextEmployee++;
            }

            employees.remove(employee);
        }

        return table;
    }


}
