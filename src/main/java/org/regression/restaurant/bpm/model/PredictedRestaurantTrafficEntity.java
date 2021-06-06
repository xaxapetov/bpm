package org.regression.restaurant.bpm.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.Month;


@Data
@Entity
@Table(name = PredictedRestaurantTrafficEntity.TABLE_NAME)
public class PredictedRestaurantTrafficEntity implements Serializable {
    public static final String TABLE_NAME = "predicted_traffic";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
