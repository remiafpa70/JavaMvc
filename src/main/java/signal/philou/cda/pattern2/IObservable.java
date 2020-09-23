package com.philou.cda.pattern2;

/**
 *
 * @author philou
 */
public interface IObservable {
    
    void addObserver(IObserver obs);
    void removeObserver(IObserver obs);
    void notifier();
}
