package org.regression.restaurant.bpm.repository;

import org.regression.restaurant.bpm.model.RestaurantTrafficEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTrafficRepository extends JpaRepository<RestaurantTrafficEntity, Integer> {

}
