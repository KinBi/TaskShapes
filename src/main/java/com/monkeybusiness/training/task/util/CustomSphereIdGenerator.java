package com.monkeybusiness.training.task.util;

public class CustomSphereIdGenerator {
  private static long id;

  {
    id = 1;
  }

  public static long getId() {
    return id++;
  }
}
