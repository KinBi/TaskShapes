package com.monkeybusiness.training.task.model.service.impl;

import com.monkeybusiness.training.task.exception.ServiceException;
import com.monkeybusiness.training.task.model.entity.CustomPoint;
import com.monkeybusiness.training.task.model.entity.CustomSphere;
import com.monkeybusiness.training.task.model.service.SphereService;

public class CustomSphereService implements SphereService {

  @Override
  public double calculateVolume(CustomSphere customSphere) throws ServiceException {
    CustomPoint centerPoint = customSphere.getCenterPoint();
    CustomPoint surfacePoint = customSphere.getSurfacePoint();
    double radius = calculateDistance(centerPoint, surfacePoint);
    double volume = 4/3 * Math.PI * Math.pow(radius, 3);
    return volume;
  }

  @Override
  public double calculateSurfaceArea(CustomSphere customSphere) throws ServiceException {
    CustomPoint centerPoint = customSphere.getCenterPoint();
    CustomPoint surfacePoint = customSphere.getSurfacePoint();
    double radius = calculateDistance(centerPoint, surfacePoint);
    double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
    return surfaceArea;
  }

  @Override
  public boolean isBaseOnCoordinatePlane(CustomSphere customSphere) throws ServiceException {
    CustomPoint centerPoint = customSphere.getCenterPoint();
    double x = centerPoint.getX();
    double y = centerPoint.getY();
    double z = centerPoint.getZ();
    boolean result = false;
    if (x == 0) {
      result = true;
    } else if (y == 0) {
      result = true;
    } else if (z == 0) {
      result = true;
    }

    return result;
  }

  public double calculateDistance(CustomPoint point1, CustomPoint point2) {
    double x1 = point1.getX();
    double y1 = point1.getY();
    double z1 = point1.getZ();
    double x2 = point2.getX();
    double y2 = point2.getY();
    double z2 = point2.getZ();

    double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(z2 - z1, 2) + Math.pow(z2 - z1, 2));
    return distance;
  }
}
