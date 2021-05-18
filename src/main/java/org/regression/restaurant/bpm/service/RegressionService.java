package org.regression.restaurant.bpm.service;

import org.regression.restaurant.bpm.dto.VisitorsDto;

import java.util.List;

public interface RegressionService {

    List<VisitorsDto> averageValues(List<VisitorsDto> visitorsTrain, List<VisitorsDto> visitorsTest);
    List<VisitorsDto> RandomForest(String classDataSet, List<VisitorsDto> visitorsTest) throws Exception;
    List<VisitorsDto> smoRegression(String classDataSet, List<VisitorsDto> visitorsTest) throws Exception;
}
