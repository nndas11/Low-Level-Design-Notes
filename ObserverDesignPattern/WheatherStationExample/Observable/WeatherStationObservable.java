package BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observable;

import BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observer.WeatherStationObserverInterface;

public interface WeatherStationObservable {
    void add(WeatherStationObserverInterface weatherStationObserverInterface);
    void remove(WeatherStationObserverInterface weatherStationObserverInterface);

    void notifyObserver();

    void setTemperature(int temperature);

    int getTemperature();

}
