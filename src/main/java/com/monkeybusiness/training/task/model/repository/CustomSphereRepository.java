package com.monkeybusiness.training.task.model.repository;

import com.monkeybusiness.training.task.model.entity.CustomSphere;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomSphereRepository {
  private List<CustomSphere> customSphere;

  public CustomSphere get(int index) {
    return customSphere.get(index);
  }

  public CustomSphere set(int index, CustomSphere element) {
    return customSphere.set(index, element);
  }

  public void add(CustomSphere element) {
    customSphere.add(element);
  }

  public CustomSphere remove(int index) {
    return customSphere.remove(index);
  }

  public List<CustomSphere> query(Predicate<CustomSphere> predicate) {
    List<CustomSphere> result = customSphere.stream().filter(predicate :: test).collect(Collectors.toList());
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Repository{");
    sb.append("customSphere=").append(customSphere);
    sb.append('}');
    return sb.toString();
  }
}
