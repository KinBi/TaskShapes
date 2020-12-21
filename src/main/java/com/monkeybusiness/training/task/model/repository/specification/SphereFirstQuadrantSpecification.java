package com.monkeybusiness.training.task.model.repository.specification;

import com.monkeybusiness.training.task.model.entity.CustomPoint;
import com.monkeybusiness.training.task.model.entity.CustomSphere;

import java.util.function.Predicate;

public class SphereFirstQuadrantSpecification implements Predicate<CustomSphere> {
  @Override
  public boolean test(CustomSphere customSphere) {
    CustomPoint centerPoint = customSphere.getCenterPoint();
    CustomPoint surfacePoint = customSphere.getSurfacePoint();
    double centerY = centerPoint.getY();
    double surfaceY = surfacePoint.getY();
    return centerY > 0 && surfaceY > 0;
    }
}
