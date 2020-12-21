package com.monkeybusiness.training.task.model.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomPoint {
  private static final Logger logger = LogManager.getLogger();

  private double x;
  private double y;
  private double z;

  public CustomPoint(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
    logger.log(Level.DEBUG, "Coordinate x has been changed");
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
    logger.log(Level.DEBUG, "Coordinate x has been changed");
  }

  public double getZ() {
    return z;
  }

  public void setZ(double z) {
    this.z = z;
    logger.log(Level.DEBUG, "Coordinate x has been changed");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CustomPoint that = (CustomPoint) o;

    if (Double.compare(that.x, x) != 0) return false;
    if (Double.compare(that.y, y) != 0) return false;
    return Double.compare(that.z, z) == 0;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(x);
    result = (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(y);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(z);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CustomPoint{");
    sb.append("x=").append(x);
    sb.append(", y=").append(y);
    sb.append(", z=").append(z);
    sb.append('}');
    return sb.toString();
  }
}
