package com.monkeybusiness.training.task.model.observer.impl;

import com.monkeybusiness.training.task.exception.ObserverException;
import com.monkeybusiness.training.task.exception.ServiceException;
import com.monkeybusiness.training.task.model.entity.CustomSphere;
import com.monkeybusiness.training.task.model.entity.CustomSphereProperties;
import com.monkeybusiness.training.task.model.entity.CustomSphereWarehouse;
import com.monkeybusiness.training.task.model.observer.CustomObserver;
import com.monkeybusiness.training.task.model.service.impl.CustomSphereService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomSphereObserver implements CustomObserver {
  private static final Logger logger = LogManager.getLogger();

  private final CustomSphere sphere;

  public CustomSphereObserver(CustomSphere sphere) {
    this.sphere = sphere;
    logger.log(Level.DEBUG, "CustomSphereObserver has been created");
    sphere.attach(this);
  }

  @Override
  public void handleEvent() throws ObserverException {
    CustomSphereService service = new CustomSphereService();
    CustomSphereWarehouse warehouse = CustomSphereWarehouse.getInstance();
    long sphereId = sphere.getSphereId();
    CustomSphereProperties properties = warehouse.get(sphereId);
    try {
      double newVolume = service.calculateVolume(sphere);
      double newSurfaceArea = service.calculateSurfaceArea(sphere);
      boolean onCoordinatePlane = service.isBaseOnCoordinatePlane(sphere);
      properties.setVolume(newVolume);
      properties.setSurfaceArea(newSurfaceArea);
      properties.setOnCoordinatePlane(onCoordinatePlane);
    } catch (ServiceException e) {
      throw new ObserverException(e);
    }
    logger.log(Level.DEBUG, "CustomSphereObserver has handled an event");
  }
}
