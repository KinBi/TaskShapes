package com.monkeybusiness.training.task.model.repository.specification;

import com.monkeybusiness.training.task.model.entity.CustomSphere;
import com.monkeybusiness.training.task.model.entity.CustomSphereProperties;
import com.monkeybusiness.training.task.model.entity.CustomSphereWarehouse;

import java.util.function.Predicate;

public class SphereSurfaceAreaSpecification implements Predicate<CustomSphere> {
  private final double minValue;
  private final double maxValue;

  public SphereSurfaceAreaSpecification(double minValue, double maxValue) {
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  @Override
  public boolean test(CustomSphere sphere) {
    long sphereId = sphere.getSphereId();
    CustomSphereWarehouse warehouse = CustomSphereWarehouse.getInstance();
    CustomSphereProperties properties = warehouse.get(sphereId);
    double surfaceArea = properties.getSurfaceArea();
    return surfaceArea >= minValue && surfaceArea <= maxValue;
  }
}
