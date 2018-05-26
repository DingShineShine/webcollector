package com.ding.webcollector_boot.observer;

public interface SetObserver<E> {
    void added(ObservableSet<E> set,E element);
}
