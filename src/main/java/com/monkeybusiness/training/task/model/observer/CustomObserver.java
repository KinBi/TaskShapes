package com.monkeybusiness.training.task.model.observer;

import com.monkeybusiness.training.task.exception.ObserverException;

public interface CustomObserver {
  void handleEvent() throws ObserverException;
}
