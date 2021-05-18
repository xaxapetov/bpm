package org.regression.restaurant.bpm.repository;

import org.regression.restaurant.bpm.model.PredictedRestaurantTrafficEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictedRestaurantTrafficRepository extends JpaRepository<PredictedRestaurantTrafficEntity, Integer> {

}
