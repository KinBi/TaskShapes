package com.monkeybusiness.training.task.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomPointValidator {
  public static final String DATA_SPHERE_REGEX = "\\-?\\d+(\\.\\d+)?";

  public static boolean arePointsValid(String coordinate) {
    Pattern pattern = Pattern.compile(DATA_SPHERE_REGEX);
    Matcher matcher = pattern.matcher(coordinate);
    return matcher.matches();
  }
}
