package com.monkeybusiness.training.task.reader;

import com.monkeybusiness.training.task.exception.ReaderException;
import com.monkeybusiness.training.task.validator.CustomFileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PointReader {
  private static final Logger logger = LogManager.getLogger();

  public static final String DEFAULT_PATH = "data/points.txt";

  public List<String> readData(String fileName) throws ReaderException {
    Path path;
    if (CustomFileValidator.isFileValidOrNotEmpty(fileName)) {
      path = Paths.get(fileName);
    } else {
      path = Paths.get(DEFAULT_PATH);
    }

    List<String> lines;
    try (Stream<String> lineStream = Files.lines(path)){
      lines = lineStream.collect(Collectors.toList());
    } catch (IOException e) {
      logger.log(Level.ERROR, e);
      throw new ReaderException(e);
    }

    return lines;
  }
}
