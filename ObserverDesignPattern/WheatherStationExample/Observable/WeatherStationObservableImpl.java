package BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observable;

import BehaviouralDesignPatterns.ObserverDesignPattern.WheatherStationExample.Observer.WeatherStationObserverInterface;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationObservableImpl implements WeatherStationObservable{

    List<WeatherStationObserverInterface> observerList = new ArrayList<>();
    int temperature;

    @Override
    public void add(WeatherStationObserverInterface weatherStationObserverInterface) {
        observerList.add(weatherStationObserverInterface);
    }

    @Override
    public void remove(WeatherStationObserverInterface weatherStationObserverInterface) {
        observerList.remove(weatherStationObserverInterface);
    }

    @Override
    public void notifyObserver() {
        for(WeatherStationObserverInterface obj: observerList ){
            obj.update();
        }
    }

    @Override
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObserver();
    }

    @Override
    public int getTemperature() {
        return this.temperature;
    }
}
