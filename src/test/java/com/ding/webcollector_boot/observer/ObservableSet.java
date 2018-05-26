package com.ding.webcollector_boot.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author ding
 * @Description
 * @date 2018/05/26-13:09
 */
public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set s) {
        super(s);
    }
    private final List<SetObserver> observers = new ArrayList<>();

    public void addObserver(SetObserver observer){
        synchronized (observers){
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver observer){
        synchronized (observers){
            return  observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element){
        synchronized (observers){
            for (SetObserver observer : observers) {
                observer.added(this,element);
            }
        }
    }

    @Override
    public boolean add(E element){
        boolean added = super.add(element);
        if(added)
            notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c){
        boolean result = false;
        for (E e : c) {
            result |= add(e);
        }
        return result;
    }





}
