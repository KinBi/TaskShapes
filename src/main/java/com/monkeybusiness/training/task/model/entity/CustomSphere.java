package com.monkeybusiness.training.task.model.entity;

import com.monkeybusiness.training.task.exception.ObserverException;
import com.monkeybusiness.training.task.model.observer.CustomObservable;
import com.monkeybusiness.training.task.model.observer.CustomObserver;
import com.monkeybusiness.training.task.util.CustomSphereIdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomSphere implements CustomObservable {
  private static final Logger logger = LogManager.getLogger();

  private long sphereId;
  private CustomPoint centerPoint;
  private CustomPoint surfacePoint;
  private List<CustomObserver> observers = new ArrayList<>();

  public CustomSphere(CustomPoint centerPoint, CustomPoint surfacePoint) {
    this.sphereId = CustomSphereIdGenerator.getId();
    this.centerPoint = centerPoint;
    this.surfacePoint = surfacePoint;
  }

  public long getSphereId() {
    return sphereId;
  }

  public void setSphereId(long sphereId) {
    this.sphereId = sphereId;
  }

  public CustomPoint getCenterPoint() {
    return centerPoint;
  }

  public void setCenterPoint(CustomPoint centerPoint) {
    this.centerPoint = centerPoint;
  }

  public CustomPoint getSurfacePoint() {
    return surfacePoint;
  }

  public void setSurfacePoint(CustomPoint surfacePoint) {
    this.surfacePoint = surfacePoint;
  }

  @Override
  public void attach(CustomObserver observer) {
    observers.add(observer);
    logger.log(Level.DEBUG, "Observer has been attached");
  }

  @Override
  public void detach(CustomObserver observer) {
    observers.remove(observer);
    logger.log(Level.DEBUG, "Observer has been detached");
  }

  @Override
  public void notifyObservers() throws ObserverException {
    logger.log(Level.DEBUG, "Observers have been notified");
    for (CustomObserver observer : observers) {
      observer.handleEvent();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CustomSphere that = (CustomSphere) o;

    if (sphereId != that.sphereId) return false;
    if (centerPoint != null ? !centerPoint.equals(that.centerPoint) : that.centerPoint != null) return false;
    return surfacePoint != null ? surfacePoint.equals(that.surfacePoint) : that.surfacePoint == null;
  }

  @Override
  public int hashCode() {
    int result = (int) (sphereId ^ (sphereId >>> 32));
    result = 31 * result + (centerPoint != null ? centerPoint.hashCode() : 0);
    result = 31 * result + (surfacePoint != null ? surfacePoint.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CustomSphere{");
    sb.append("sphereId=").append(sphereId);
    sb.append(", centerPoint=").append(centerPoint);
    sb.append(", surfacePoint=").append(surfacePoint);
    sb.append('}');
    return sb.toString();
  }
}
