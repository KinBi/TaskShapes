package com.monkeybusiness.training.task.parser;

import com.monkeybusiness.training.task.model.entity.CustomPoint;
import com.monkeybusiness.training.task.validator.CustomPointValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PointParser {
  private static final Logger logger = LogManager.getLogger();

  public static final String SPLIT_POINT_REGEX = " ";

  public List<Double> parsePoints(String line) {
    List<Double> customPointData = new ArrayList<>();

    if (CustomPointValidator.arePointsValid(line)) {
      String[] points = line.trim().split(SPLIT_POINT_REGEX);

      double x = Double.parseDouble(points[0]);
      double y = Double.parseDouble(points[1]);
      double z = Double.parseDouble(points[2]);

      customPointData.add(x);
      customPointData.add(y);
      customPointData.add(z);
    } else {
      logger.log(Level.ERROR, "Invalid input");
    }

    return customPointData;
  }

}
