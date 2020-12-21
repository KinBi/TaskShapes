package com.monkeybusiness.training.task.validator;

import java.io.File;

public class CustomFileValidator {
  public static boolean isFileValidOrNotEmpty(String filePath) {
    if (filePath == null) {
      return false;
    }
    File file = new File(filePath);
    return file.isFile() || file.length() != 0;
  }
}
