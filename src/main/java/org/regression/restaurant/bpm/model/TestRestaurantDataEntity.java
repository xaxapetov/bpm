package org.regression.restaurant.bpm.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.Month;

@Data
@Entity
@Table(name = TestRestaurantDataEntity.TABLE_NAME)
public class TestRestaurantDataEntity implements Serializable {
    public static final String TABLE_NAME = "test_restaurant_data";

    @Id
    Integer id;

    @Column(name = "year")
    Integer year;

    @Column(name = "month")
    @Enumerated(EnumType.STRING)
    Month month;

    @Column(name = "day_of_the_month")
    Integer dayOfTheMonth;

    @Column(name = "day_of_the_week")
    @Enumerated(EnumType.STRING)
    DayOfWeek dayOfTheWeek;

    @Column(name = "visitors")
    Double visitors;
}
