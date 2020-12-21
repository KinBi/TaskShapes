package com.monkeybusiness.training.task.model.service.impl;

import com.monkeybusiness.training.task.exception.ServiceException;
import com.monkeybusiness.training.task.model.entity.CustomPoint;
import com.monkeybusiness.training.task.model.entity.CustomSphere;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class CustomSphereServiceTest {
  CustomSphereService service;
  CustomPoint point1;
  CustomPoint point2;
  CustomSphere sphere;

  @BeforeClass
  public void setUp() {
    service = new CustomSphereService();
    point1 = new CustomPoint(0.0, 2.0, 2.0);
    point2 = new CustomPoint(3.0, 2.0, 2.0);
    sphere = new CustomSphere(point1, point2);
  }

  @Test
  public void testCalculateVolume() {
    try {
      double actual = service.calculateVolume(sphere);
      double expected = 4/3 * Math.PI * 27;
      assertEquals(actual, expected);
    } catch (ServiceException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testCalculateSurfaceArea() {
    try {
      double actual = service.calculateSurfaceArea(sphere);
      double expected = 4 * Math.PI * 9;
      assertEquals(actual, expected);
    } catch (ServiceException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testIsBaseOnCoordinatePlane() {
    try {
      boolean actual = service.isBaseOnCoordinatePlane(sphere);
      assertTrue(actual);
    } catch (ServiceException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testCalculateDistance() {
    double actual = service.calculateDistance(point1, point2);
    double expected = 3;
    assertEquals(actual, expected);
  }
}