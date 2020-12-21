package com.monkeybusiness.training.task.model.creator.impl;

import com.monkeybusiness.training.task.exception.ObserverException;
import com.monkeybusiness.training.task.exception.ServiceException;
import com.monkeybusiness.training.task.model.creator.CustomSphereCreator;
import com.monkeybusiness.training.task.model.entity.CustomPoint;
import com.monkeybusiness.training.task.model.entity.CustomSphere;
import com.monkeybusiness.training.task.model.entity.CustomSphereProperties;
import com.monkeybusiness.training.task.model.entity.CustomSphereWarehouse;
import com.monkeybusiness.training.task.model.observer.impl.CustomSphereObserver;
import com.monkeybusiness.training.task.model.repository.CustomSphereRepository;
import com.monkeybusiness.training.task.validator.CustomSphereValidator;

import java.util.List;
import java.util.Optional;

public class CustomSphereCreatorImpl implements CustomSphereCreator {
  @Override
  public Optional<CustomSphere> createSphere(List<CustomPoint> customPoints) throws ObserverException, ServiceException {
    Optional<CustomSphere> result = Optional.empty();
    if (CustomSphereValidator.isSphere(customPoints)) {
      CustomSphereRepository repository = new CustomSphereRepository();
      CustomSphereWarehouse warehouse = CustomSphereWarehouse.getInstance();
      CustomSphereProperties properties = new CustomSphereProperties();

      CustomPoint centerPoint = customPoints.get(0);
      CustomPoint surfacePoint = customPoints.get(1);
      CustomSphere sphere = new CustomSphere(centerPoint, surfacePoint);
      warehouse.put(sphere.getSphereId(), properties);
      repository.add(sphere);
      new CustomSphereObserver(sphere);
      sphere.notifyObservers();
      result = Optional.of(sphere);
    }

    return result;
  }
}
