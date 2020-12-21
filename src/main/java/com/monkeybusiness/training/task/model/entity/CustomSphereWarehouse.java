package com.monkeybusiness.training.task.model.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomSphereWarehouse {
  private static final Logger logger = LogManager.getLogger();

  private static CustomSphereWarehouse instance;
  private final Map<Long, CustomSphereProperties> storage;

  private CustomSphereWarehouse() {
    storage = new HashMap<>();
    logger.log(Level.DEBUG, "CustomSphereWarehouse has been created");
  }

  public static CustomSphereWarehouse getInstance() {
    if (instance == null) {
      instance = new CustomSphereWarehouse();
    }
    return instance;
  }

  public int size() {
    return storage.size();
  }

  public boolean isEmpty() {
    return storage.isEmpty();
  }

  public boolean contains(Long id) {
    return storage.containsKey(id);
  }

  public boolean contains(CustomSphereProperties properties) {
    return storage.containsValue(properties);
  }

  public CustomSphereProperties get(Long id) {
    return storage.get(id);
  }

  public CustomSphereProperties put(Long key, CustomSphereProperties value) {
    logger.log(Level.DEBUG, "CustomSphereProperties has been put");
    return storage.put(key, value);
  }

  public CustomSphereProperties remove(Long id) {
    if (storage.containsKey(id)) {
      logger.log(Level.DEBUG, "CustomSphereProperties has been removed");
    } else {
      logger.log(Level.WARN, "CustomSphereProperties has not been removed: does not contain");
    }
    return storage.remove(id);
  }
}
