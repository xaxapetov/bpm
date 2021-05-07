package org.regression.restaurant.bpm.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;


import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
@Log4j2
public class RegressionSeriveImpl {

    @PostConstruct
    public void init() {
        startRegression();
    }

    public void startRegression() {
        Instances data = null;
        try {
            DataSource dataSource = new DataSource("src/main/resources/dataset/air_reserve.csv");
            data = dataSource.getDataSet();
        } catch (Exception ex) {
            log.warn(ex.getMessage());
        }
        if (data != null) {
            log.info(data.toString());
        }

        RandomForest forest = new RandomForest();
        forest.setNumIterations(30);//TODO разобраться с количеством итераций (деревьев)


    }
}
