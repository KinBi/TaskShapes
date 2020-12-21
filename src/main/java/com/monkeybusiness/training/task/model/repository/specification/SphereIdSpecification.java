package com.monkeybusiness.training.task.model.repository.specification;

import com.monkeybusiness.training.task.model.entity.CustomSphere;

import java.util.function.Predicate;

public class SphereIdSpecification implements Predicate<CustomSphere> {
  private final int id;

  public SphereIdSpecification(int id) {
    this.id = id;
  }

  @Override
  public boolean test(CustomSphere sphere) {
    return (sphere.getSphereId() == id);
  }
}
