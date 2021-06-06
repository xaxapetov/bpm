package org.regression.restaurant.bpm.repository;

import org.regression.restaurant.bpm.model.TestRestaurantDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRestaurantDataRepository extends JpaRepository<TestRestaurantDataEntity, Integer> {

}
