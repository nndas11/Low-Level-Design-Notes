package BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observer;

import BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observable.WeatherStationObservable;

public class TvDisplay implements WeatherStationObserverInterface{

    WeatherStationObservable weatherStationObservable;

    public TvDisplay(WeatherStationObservable weatherStationObservable) {
        this.weatherStationObservable = weatherStationObservable;
    }

    @Override
    public void update() {
        System.out.println("TV Display: Current temperature is: " + weatherStationObservable.getTemperature());
    }
}
