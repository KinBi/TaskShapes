package com.monkeybusiness.training.task.model.service;

import com.monkeybusiness.training.task.exception.ServiceException;
import com.monkeybusiness.training.task.model.entity.CustomSphere;

public interface SphereService {
  double calculateVolume(CustomSphere customSphere) throws ServiceException;

  double calculateSurfaceArea(CustomSphere customSphere) throws ServiceException;

  boolean isBaseOnCoordinatePlane(CustomSphere customSphere) throws ServiceException;
}
