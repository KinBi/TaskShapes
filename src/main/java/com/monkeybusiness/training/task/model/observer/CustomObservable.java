package com.monkeybusiness.training.task.model.observer;

import com.monkeybusiness.training.task.exception.ObserverException;

public interface CustomObservable {
  void attach(CustomObserver observer);
  void detach(CustomObserver observer);
  void notifyObservers() throws ObserverException;
}
