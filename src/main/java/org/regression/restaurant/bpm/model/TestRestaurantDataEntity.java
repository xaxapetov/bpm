package org.regression.restaurant.bpm.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = TestRestaurantDataEntity.TABLE_NAME)
public class TestRestaurantDataEntity implements Serializable {
    public static final String TABLE_NAME = "test_restaurant_data";

    @Id
    Integer id;
}
