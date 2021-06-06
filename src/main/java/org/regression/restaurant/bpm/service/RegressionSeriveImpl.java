package org.regression.restaurant.bpm.service;

import lombok.extern.log4j.Log4j2;
import org.regression.restaurant.bpm.dto.VisitorsDto;
import org.springframework.stereotype.Service;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.evaluation.Prediction;
import weka.classifiers.functions.SMOreg;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class RegressionSeriveImpl implements RegressionService {

    private static final String DATATRAIN = "src/main/resources/dataset/datatrain.arff";
    private static final String DATATEST = "src/main/resources/dataset/datatest.arff";


    @PostConstruct
    public void init() throws Exception {

    }


    @Override
    public List<VisitorsDto> averageValues(List<VisitorsDto> visitorsTrain, List<VisitorsDto> visitorsTest) {

        List<VisitorsDto> predictedVisitors = new ArrayList<>(visitorsTest);

        predictedVisitors.forEach(x -> {
            Double sumVisitors = 0d;
            int index = 0;
            for (VisitorsDto predicted : visitorsTrain) {
                if (x.getDayOfTheMonth().equals(predicted.getDayOfTheMonth())
                        && x.getDayOfTheWeek().equals(predicted.getDayOfTheWeek())
                        && x.getMonth().equals(predicted.getMonth())) {
                    sumVisitors += x.getVisitors();
                    index++;
                }
            }
            x.setVisitors((index != 0) ? sumVisitors / index : 0.0);
        });

        return predictedVisitors;
    }


    public List<VisitorsDto> RandomForest(String classDataSet, List<VisitorsDto> visitorsTest) throws Exception {

        Instances trainDataSet = getData(DATATRAIN);
        Instances testDataSet = getData(DATATEST);

        trainDataSet.setClass(trainDataSet.attribute(classDataSet));
        testDataSet.setClass(trainDataSet.attribute(classDataSet));

        RandomForest forest = new RandomForest();
        forest.setNumIterations(100);

        forest.buildClassifier(trainDataSet);

        Evaluation eval = new Evaluation(trainDataSet);
        eval.evaluateModel(forest, testDataSet);

        return setVisitorsToDto(eval, visitorsTest);
    }

    @Override
    public List<VisitorsDto> smoRegression(String classDataSet, List<VisitorsDto> visitorsTest) throws Exception {

        Instances trainDataSet = getData(DATATRAIN);
        Instances testDataSet = getData(DATATEST);

        trainDataSet.setClass(trainDataSet.attribute(classDataSet));
        testDataSet.setClass(trainDataSet.attribute(classDataSet));

        SMOreg smoRegression = new SMOreg();

        smoRegression.buildClassifier(trainDataSet);

        Evaluation eval = new Evaluation(trainDataSet);
        eval.evaluateModel(smoRegression, testDataSet);

        return setVisitorsToDto(eval, visitorsTest);
    }

    private List<VisitorsDto> setVisitorsToDto(Evaluation eval, List<VisitorsDto> visitorsTest){
        List<VisitorsDto> predictedVisitors = new ArrayList<>(visitorsTest);
        List<Prediction> prediction = eval.predictions();
        List<Double> visitorsList = prediction.stream().map(Prediction::predicted).collect(Collectors.toList());
        for(int i = 0; i < predictedVisitors.size();i++){
            predictedVisitors.get(i).setVisitors(visitorsList.get(i));
        }
        return predictedVisitors;
    }


    private Instances getData(String location) {
        Instances data = null;
        try {
            DataSource dataSource = new DataSource(location);
            data = dataSource.getDataSet();
        } catch (Exception ex) {
            log.warn(ex.getMessage());
        }
        return data;
    }
}
