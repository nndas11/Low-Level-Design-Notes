package BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample;

import BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observable.WeatherStationObservable;
import BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observable.WeatherStationObservableImpl;
import BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observer.MobileDisplay;
import BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observer.TvDisplay;
import BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observer.WeatherStationObserverInterface;

public class WheatherStation {
    public static void main(String[] args) {
        WeatherStationObservable observable = new WeatherStationObservableImpl();

        WeatherStationObserverInterface mobileDisplay = new MobileDisplay(observable);
        WeatherStationObserverInterface tvDisplay = new TvDisplay(observable);

        observable.add(mobileDisplay);
        observable.add(tvDisplay);

        observable.setTemperature(100);
    }
}
