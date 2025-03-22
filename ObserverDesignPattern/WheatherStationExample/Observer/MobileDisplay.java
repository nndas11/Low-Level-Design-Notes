package BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observer;

import BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observable.WeatherStationObservable;

public class MobileDisplay implements WeatherStationObserverInterface{

    WeatherStationObservable weatherStationObservable;

    public MobileDisplay(WeatherStationObservable weatherStationObservable) {
        this.weatherStationObservable = weatherStationObservable;
    }

    @Override
    public void update() {
        System.out.println("Mobile Display: Current temperature is: " + weatherStationObservable.getTemperature());
    }
}
