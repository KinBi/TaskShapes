package com.monkeybusiness.training.task.validator;

import com.monkeybusiness.training.task.model.entity.CustomPoint;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomSphereValidator {
  private static final Logger logger = LogManager.getLogger();

  public static final int SUPPORTED_POINTS_COUNT = 2;

  public static boolean isSphere(List<CustomPoint> points) {
    if (points.size() != SUPPORTED_POINTS_COUNT) {
      logger.log(Level.DEBUG, "Not supported points count");
      return false;
    }

    boolean result = true;
    for (int i = 0; i < points.size() - 1; i++) {
      for (int j = i + 1; j < points.size(); j++) {
        if (points.get(i).equals(points.get(j))) {
          result = false;
          logger.log(Level.DEBUG, "Points are equal");
          break;
        }
      }
    }
    return result;
  }
}
