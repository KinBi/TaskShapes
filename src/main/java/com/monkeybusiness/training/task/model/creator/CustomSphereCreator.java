package com.monkeybusiness.training.task.model.creator;

import com.monkeybusiness.training.task.exception.ObserverException;
import com.monkeybusiness.training.task.exception.ServiceException;
import com.monkeybusiness.training.task.model.entity.CustomPoint;
import com.monkeybusiness.training.task.model.entity.CustomSphere;

import java.util.List;
import java.util.Optional;

public interface CustomSphereCreator {
  Optional<CustomSphere> createSphere(List<CustomPoint> customPoints) throws ObserverException, ServiceException;
}
