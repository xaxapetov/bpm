package org.regression.restaurant.bpm.service;

import org.regression.restaurant.bpm.dto.VisitorsDto;

import java.util.Date;
import java.util.Map;

public interface ProcedureService {
    VisitorsDto startPredictedProcess(String regrassionName, Map<String, Date> Employers);
    VisitorsDto getVisitorsData();
}
