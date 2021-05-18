package org.regression.restaurant.bpm.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = RestaurantTrafficEntity.TABLE_NAME)
public class RestaurantTrafficEntity implements Serializable {
    public static final String TABLE_NAME = "restaurant_traffic";

    @Id
    Integer id;
}
