package com.monkeybusiness.training.task.model.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomSphereProperties {
  private static final Logger logger = LogManager.getLogger();

  private double volume;
  private double surfaceArea;
  private boolean onCoordinatePlane;

  public CustomSphereProperties() {
    logger.log(Level.DEBUG, "CustomSphereProperties has been created");
  }

  public double getVolume() {
    return volume;
  }

  public void setVolume(double volume) {
    this.volume = volume;
    logger.log(Level.DEBUG, "Volume has been setted");
  }

  public double getSurfaceArea() {
    return surfaceArea;
  }

  public void setSurfaceArea(double surfaceArea) {
    this.surfaceArea = surfaceArea;
    logger.log(Level.DEBUG, "SurfaceArea has been setted");
  }

  public boolean isOnCoordinatePlane() {
    return onCoordinatePlane;
  }

  public void setOnCoordinatePlane(boolean onCoordinatePlane) {
    this.onCoordinatePlane = onCoordinatePlane;
    logger.log(Level.DEBUG, "onCoordinatePane has been setted");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CustomSphereProperties that = (CustomSphereProperties) o;

    if (Double.compare(that.volume, volume) != 0) return false;
    if (Double.compare(that.surfaceArea, surfaceArea) != 0) return false;
    return onCoordinatePlane == that.onCoordinatePlane;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(volume);
    result = (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(surfaceArea);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (onCoordinatePlane ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CustomSphereProperties{");
    sb.append("volume=").append(volume);
    sb.append(", surfaceArea=").append(surfaceArea);
    sb.append(", onCoordinatePlane=").append(onCoordinatePlane);
    sb.append('}');
    return sb.toString();
  }
}
