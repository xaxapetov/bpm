package org.regression.restaurant.bpm.controller;

import lombok.RequiredArgsConstructor;
import org.regression.restaurant.bpm.model.PredictedRestaurantTrafficEntity;
import org.regression.restaurant.bpm.service.ProcedureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("agent")
@RequiredArgsConstructor
public class TestDataController {
  PredictedRestaurantTrafficEntity predictedRestaurantTrafficEntity;
  ProcedureService procedureService;
  Map<String, Date> employers = new HashMap<>();


  @PostMapping("start")
  public ResponseEntity<String> startRegression() {
    procedureService.startPredictedProcess("Regrassion", employers);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("visitors")
  public ResponseEntity<String> getVisitorsData() {
    procedureService.getVisitorsData();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("predicted")
  public ResponseEntity<String> getPredictedData() {
    procedureService.startPredictedProcess("Regrassion", employers);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
