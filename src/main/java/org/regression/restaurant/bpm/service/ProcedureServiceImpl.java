package org.regression.restaurant.bpm.service;

import lombok.RequiredArgsConstructor;
import org.regression.restaurant.bpm.dto.VisitorsDto;
import org.regression.restaurant.bpm.model.PredictedRestaurantTrafficEntity;
import org.regression.restaurant.bpm.model.RestaurantTrafficEntity;
import org.regression.restaurant.bpm.model.TestRestaurantDataEntity;
import org.regression.restaurant.bpm.repository.PredictedRestaurantTrafficRepository;
import org.regression.restaurant.bpm.repository.RestaurantTrafficRepository;
import org.regression.restaurant.bpm.repository.TestRestaurantDataRepository;

import java.util.Date;
import java.util.Map;

@RequiredArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {

    PredictedRestaurantTrafficRepository predictedRestaurantTrafficRepository;
    RestaurantTrafficRepository restaurantTrafficRepository;
    TestRestaurantDataRepository testRestaurantDataRepository;
    WorkingSchedule workingSchedule;
    RegressionService regressionService;

    private RestaurantTrafficEntity getRestaurantTraffic(){
        RestaurantTrafficEntity restaurantTrafficEntity = restaurantTrafficRepository.getFirstById(1);
        return null;
    }

    private PredictedRestaurantTrafficEntity getPredictedRestaurantTraffic(){
        return null;
    }

    private TestRestaurantDataEntity getTestRestaurantData(){
        return null;
    }

    @Override
    public VisitorsDto startPredictedProcess(String regrassionName, Map<String, Date> Employers){
        return null;
    }

    @Override
    public VisitorsDto getVisitorsData() {
        return null;
    }
}
